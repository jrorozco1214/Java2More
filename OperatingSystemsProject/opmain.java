/*
Jeremy Orozco
Operating Systems Spring 2026
Due Date: March 6, 2026
In this program we look at the simulation of CPU scheduling utliziling real-time and interactitve processes,
along with various types of data structures such as HashMap, HashSet, LinkedLists and Queues. 
This program was kept all in one java file through the use of static classes.

IMPORTANT
The user has to manually put in the file path on line 100 by right clicking on the .txt file and copying the file path
and adding an extra \ for each \
Also the user has to manually type in the file path on 360 on where he or she wants it to outputed to here is an example C:\\Users\\jerem\\Documents\\GitHub\\Java2More\\OperatingSystemsProject\\output.txt 
HOWEVER, if you click the link you do not have to put in the file paths
*/
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class opmain {
    static final int NO_DEADLINE = -1; //global variable used for a process in which does not ahve a deadline
    static final int NOT_STARTED = -1; //global variable used for a process that has not used the CPU yet

    enum Status {READY, RUNNING, WAITING, TERMINATED};
    enum Resource {CPU, DISK, TTY};

    static Queue<Processes> interactiveQueue = new PriorityQueue<>(); //global used for tracking interactive processes
    static Queue<Processes> realtimeQueues = new PriorityQueue<>(); //global varibale used for tracking real-time processes
    static Queue<Processes> diskQueues = new PriorityQueue<>(); //global variable used for tracking disk

    static int timePassed = 0; //keep track of the current simulation time
    static int cpuBusy = 0; //the work time done by the CPU
    static int diskBusy = 0; //the work time done by the disk
    static int totalDisksWait = 0; //the total time waiting and using the disk
    static int diskCount = 0; //number of total disk accesses
    static int diskTotalDur = 0; //determines the duration for each disk apperation needed for the average

    static Processes cpuProcess = null; //current CPU
    static Processes diskProcess = null; //current disk

    //this class is hold a single resource request such asc CPU 100 or DISK 50 read from the input
    public static class Request {
        private Resource type;
        private int duration;

        public Request(Resource type, int duration){
            this.type = type;
            this.duration = duration;
        }
    }

    //creation of the object proccesses
    public static class Processes implements Comparable<Processes>{
        private String pName; //Name of Process: REAL-TIME or INTERACTIVE
        private int pNumber; //Process number 1 2 3 etc
        private int pTime; //the time the process first comes in
        private int startTime; //the time the process first ran
        private int finishTime; // the time the process finished
        private int deadline = NOT_STARTED; //only done with real-time processes
        private int cpuTimeRemaining = NOT_STARTED; //the amount of CPU time that that is remaining in the current burst
        private Status s = Status.READY; //default status given to processes
        private Queue<Request> requests = new LinkedList<>(); //the list of resource requests in order done with Queue Linked List


        //setters for each processes and a required compareTo method due to the use of Priority Queue
        public void setProcessNames(String processNames){
            this.pName = processNames;
        }

        public void setProcessorNumber(int processorNumber){
            this.pNumber = processorNumber;
        }

        public void setProcessorArrivalTime(int processorArrivalTime){
            this.pTime = processorArrivalTime;
        }

        public void setDeadLine(int deadline){
            this.deadline = deadline;
        }

        public String getProcessNames(){
            return this.pName;
        }

        public void setRequest(Status s){
            this.s = s;
        }

        @Override
        public int compareTo(opmain.Processes o) {
            return Integer.compare(this.pNumber, o.pNumber);
        }
    }

    //Where the input file is read and the start of the simulation
    public static void main(String[] args) throws FileNotFoundException {
        // ** IMPORTANT **
        // ** FILE PATH THAT THE USER NEEDS TO ENTER **
        File f1 = new File("");

        //First Scanner done with the use of a while loop in order to determine the number of processes
        Scanner r1 = new Scanner(f1);
        int numberOfProcesses = 0;

        while(r1.hasNext()){
            String content1 = r1.next();
            if(content1.equals("INTERACTIVE") || content1.equals("REAL-TIME")){
                numberOfProcesses++;
            }
        }

        r1.close();

        //Second Scanner done in order to create the object processors with the input
        Scanner r2 = new Scanner(f1);
        int tracker = 0;
        Queue<Processes> mainQueue = new PriorityQueue<>();

        Processes p = null;

        //While loop in which reads the input and classify the token accoridng to whether it's INTERACTIVE OR REAL-TIME
        while(r2.hasNext()){
            String token = r2.next();

            if(token.equals("INTERACTIVE") || token.equals("REAL-TIME")){
                if(p != null){
                    mainQueue.add(p);
                }
                p = new Processes();
                p.setProcessNames(token);
                p.setProcessorArrivalTime(Integer.parseInt(r2.nextLine().trim()));
                p.setProcessorNumber(++tracker);

            } else if(p != null){
                int value = Integer.parseInt(r2.nextLine().trim());

                if(token.equals("CPU")){
                    p.requests.add(new Request(Resource.CPU, value));
                } else if(token.equals("DISK")){
                    p.requests.add(new Request(Resource.DISK, value));
                } else if(token.equals("TTY")){
                    p.requests.add(new Request(Resource.TTY, value));
                } else if(token.equals("DEADLINE")){
                    p.setDeadLine(value);
                }
            }
        }

        if(p != null){
            mainQueue.add(p);
        }
        r2.close();
        cpuSim(numberOfProcesses, mainQueue); //the call to the CPU simulation Method
    }

    /*
    CPU Sim Method
    The cpuSim purpose is to handle process arrival, CPU Scheduling, disk I/O, and TTY waits.
    Overall this method will provide a simulation of the OS scheduler
    At the end of the method it will output a Summary Report to a .txt file.
    The parameters that are passed are the total numberProcesses in which was found in Main() and the main Queue in which
    has all the processes in it
    */
    public static void cpuSim(int numberOfProcesses, Queue<Processes> queues) throws FileNotFoundException{

        int size = numberOfProcesses;
        int timeLapsed = 0;

        HashMap<Processes, Integer> diskEntryTime = new HashMap<>(); //will keep track of each process that joins the disk queue
        HashSet<Processes> finished = new HashSet<>(); //will keep track of which processses has been terminated

        //The purpose of this while loop is that it's the main loop in which will run through processes till they have been all terminated
        while(finished.size() < size){
            
            //the purpose of this for loop is that it will see if any processes have arrivated and determine if they are ready to be put into the REAL-TIME or INTERACTIVE queue
            for(Processes a: queues){
                if(a.pTime <= timeLapsed && a.s == Status.READY){
                    a.s = Status.RUNNING; 
                    if(a.getProcessNames().equals("REAL-TIME")){ 
                        realtimeQueues.add(a);
                    } else {
                        interactiveQueue.add(a);
                    }
                }
            }

            //This conditional will check to see if a REAL-TIME process is ready to run and stop the interactive process
            if(cpuProcess != null && !realtimeQueues.isEmpty() && cpuProcess.pName.equals("INTERACTIVE")){
                cpuProcess.cpuTimeRemaining -= 1;


                //The purpose of this conditional is if the cpuTimeRemaining from the decrementation were to be 0 then this would result in a normal burst completetion
                //this is done because this will not result the process to requeue and causes an infinite loop
                if(cpuProcess.cpuTimeRemaining == 0){
                    cpuProcess.requests.remove();

                    if(!cpuProcess.requests.isEmpty()){
                        Request nextRequest = cpuProcess.requests.peek();

                        if(nextRequest.type == Resource.DISK){
                            cpuProcess.s = Status.WAITING;
                            diskEntryTime.put(cpuProcess, timeLapsed);
                            diskQueues.add(cpuProcess);
                        } else if(nextRequest.type == Resource.TTY){
                            cpuProcess.s = Status.READY;
                            cpuProcess.pTime = timeLapsed + nextRequest.duration;
                            cpuProcess.requests.remove();
                            cpuProcess.cpuTimeRemaining = NOT_STARTED;
                        } else {
                            //if the request type were not to be either DISK or TTY then this will put teh process status into RUNNING 
                            //the purpose of this is to avoid being pick up by the loop again
                            cpuProcess.s = Status.RUNNING;
                            cpuProcess.cpuTimeRemaining = NOT_STARTED;
                            interactiveQueue.add(cpuProcess);
                        }
                    } else {
                        cpuProcess.s = Status.TERMINATED;
                        cpuProcess.finishTime = timeLapsed;
                        System.out.println("Process: " + cpuProcess.pNumber + " (" + cpuProcess.pName + ") terminates at " + timeLapsed);
                        finished.add(cpuProcess);
                    }
                } else {
                    //Again, here the process is set to RUNNING in order ot avoid being pick up again by the loop
                    cpuProcess.s = Status.RUNNING;
                    interactiveQueue.add(cpuProcess);
                }

                cpuProcess = null;
            }

            //This conditional will provide a new process to the cpu if it is not currently being used
            if(cpuProcess == null){
                if(!realtimeQueues.isEmpty()){
                    cpuStart(realtimeQueues.peek(), timeLapsed);
                    realtimeQueues.remove();

                } else if(!interactiveQueue.isEmpty()){
                    cpuStart(interactiveQueue.peek(), timeLapsed);
                    interactiveQueue.remove();
                }
            }

            //This conditional will move the current CPU process forward by one tick
            if(cpuProcess != null){
                cpuProcess.cpuTimeRemaining--;
                cpuBusy++; //track the CPU use 

                if(cpuProcess.cpuTimeRemaining == 0){
                    cpuProcess.requests.remove(); //removal of the completed CPU request

                   if(!cpuProcess.requests.isEmpty()){
                    Request nextRequest = cpuProcess.requests.peek(); //getting the next request in the process's queue

                    //these conditionals below will check to the see if the next resource request is DISK OR TTY
                    //else next resource request is s CPU burst and result in the requeue of the process
                    if(nextRequest.type == Resource.DISK){
                        cpuProcess.s = Status.WAITING;
                        diskEntryTime.put(cpuProcess, timeLapsed);
                        diskQueues.add(cpuProcess);

                    } else if(nextRequest.type == Resource.TTY){
                        cpuProcess.s = Status.READY;
                        cpuProcess.pTime = timeLapsed + nextRequest.duration;
                        cpuProcess.requests.remove();
                        cpuProcess.cpuTimeRemaining = NOT_STARTED;
                    } else{
                        //Status will be set to running in order to be picked up by the loop again
                        cpuProcess.s = Status.RUNNING;
                        cpuProcess.cpuTimeRemaining = NOT_STARTED;
                        
                        if(cpuProcess.pName.equals("REAL-TIME")){
                            realtimeQueues.add(cpuProcess);
                        } else {
                            interactiveQueue.add(cpuProcess);
                        }
                    }
                   } else { 
                    //the process will be terminated and added to the finish set if no more requests take place
                    cpuProcess.s = Status.TERMINATED;
                    cpuProcess.finishTime = timeLapsed;

                    System.out.println("Process: " + cpuProcess.pNumber + " (" + cpuProcess.pName + ") terminates at " + timeLapsed);
                    finished.add(cpuProcess);
                   }
                   cpuProcess = null;
                }
            }
            //A processes will be added to the disk if it's not in use and the queue is not empty
            if(diskProcess == null && !diskQueues.isEmpty()){
                diskProcess = diskQueues.remove();
                diskStart(diskProcess, timeLapsed);
            }
            //allow the current disk process to move forward by one tick 
            if(diskProcess != null) {
                diskProcess.requests.peek().duration--;
                diskBusy++;

                //The disk operation has been completed
                if(diskProcess.requests.peek().duration == 0){
                    int enteredTime = diskEntryTime.getOrDefault(diskProcess, timeLapsed);
                    int diskDuration = timeLapsed - enteredTime + 1;
                    diskCount++;
                    diskTotalDur += diskDuration;

                    diskProcess.requests.remove(); //the completed disk request will be removed here

                    if(!diskProcess.requests.isEmpty()){
                        Request nextRequest = diskProcess.requests.peek();

                        if(nextRequest.type == Resource.CPU){
                            //Status will be set to running in order to be picked up by the loop again
                            diskProcess.s = Status.RUNNING; 
                            diskProcess.cpuTimeRemaining = NOT_STARTED;

                            if(diskProcess.pName.equals("REAL-TIME")){
                                realtimeQueues.add(diskProcess);
                            } else {
                                interactiveQueue.add(diskProcess);
                            }
                        }
                    } else { 
                        //the process will be terminated and added to the finish set if no more requests take place
                        diskProcess.s =Status.TERMINATED;
                        diskProcess.finishTime = timeLapsed;
                        System.out.println("Process: " + diskProcess.pNumber + " (" + diskProcess.pName + ") terminates at " + timeLapsed);
                        finished.add(diskProcess);
                    }
                    diskProcess = null;
                }
            }
            timeLapsed++; //will result in the incrementation of the simulation clock
        }

        timePassed = timeLapsed; //storing the simulation time needed for the calculations

        //Where the total number of completed and missed Real, and completed Interactive processes from the mainQueue
        int completedReal = 0; //number of REAL-TIME Processes finished
        int missedReal = 0; //number of REAl-TIME Processes missed
        int completedInteractive = 0; //number of INTERACTIVE Processes finished

        for(Processes a: queues){
            if(a.s == Status.TERMINATED){
                if(a.getProcessNames().equals("REAL-TIME")){
                    completedReal++;

                    if(a.deadline != NO_DEADLINE && a.finishTime > a.deadline){
                        missedReal++;
                    }
                } else {
                    completedInteractive++;
                } 
            }
        }

        //Where the summary report will be outputed to a file
        FileOutputStream output = new FileOutputStream("");
        PrintStream stream = new PrintStream(output);

        System.setOut(stream);
        System.out.printf("\nThe Summary Report\n");
        System.out.println("Real-time processes completed: " + completedReal);
        System.out.printf("Percentage of real-time missed deadline %.2f \n", (missedReal*100.0)/completedReal);
        System.out.println("Interactive processes completed: " + completedInteractive);
        System.out.println("Total disk accesses: " + diskCount);
        System.out.println("Average duration of disk accesses: " + (diskCount > 0 ? diskTotalDur / diskCount : 0) + " ms");
        System.out.println("Total time elapsed since first process start: " + timePassed + " ms");
        System.out.printf("CPU Utilization: %.4f \n", (cpuBusy*1.0)/timePassed);
        System.out.printf("DISK Utilization %.4f \n", (diskBusy*1.0)/timePassed);
        stream.close();
    }
    /*
    cpuStart Method
    The purpose of this method is to schedule the igven process on the CPU and prepare its CPU burst if it has not executed
    It will keep any non-CPU requests that are at the head of the queue
    IF there are no CPU request left then the process will terminate
    The parameters that are passed are the Process p in which is passed on line 213 or 217 along with the current time which is timeLapsed
    from the CPU simulation
    */
    public static void cpuStart(Processes p, int currentTime){
        cpuProcess = p;

        if(p.cpuTimeRemaining == NOT_STARTED){

            while(!p.requests.isEmpty() && p.requests.peek().type != Resource.CPU){
                p.requests.remove();
            }

            if(p.requests.isEmpty()){
                p.s = Status.TERMINATED;
                p.finishTime = currentTime;
                cpuProcess = null;
                return;
            }

            p.cpuTimeRemaining = p.requests.peek().duration;
            p.startTime = currentTime;
        }

        System.out.println("Process: " + p.pNumber + " (" + p.pName + ") starts CPU at " + currentTime);
    }

    /*
    diskStart Method
    The purpose of this method is attach the passed process to the disk device and log the event
    The parameters that are passed are the Process p in which is passed on 269 along with the current time which is timeLapsed
    from the CPU simulation 
    */
    public static void diskStart(Processes p, int currentTime){
        diskProcess = p;

        System.out.println("Process: " + p.pNumber + " (" + p.pName + ") disk started at " + currentTime);
    }
}
