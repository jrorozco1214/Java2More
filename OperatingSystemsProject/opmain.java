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
    static int cpuBusyTime = 0; //the work time done by the CPU
    static int diskBusyTime = 0; //the work time done by the disk
    static int totalDisks = 0; //number if titak dusj accesess that were made
    static int totalDisksWait = 0; //the total time waiting and using the disk

    static Processes cpu_process = null; //current CPU
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
        private String processNames; //Name of Process: REAL-TIME or INTERACTIVE
        private int processorNumber; //Process number 1 2 3 etc
        private int processorArrivalTime; //the time the process first comes in
        private int startTime; //the time the process first ran
        private int finishTime; // the time the process finished
        private int deadline = NOT_STARTED; //only done with real-time processes
        private int cpuTimeRemaining = NOT_STARTED; //the amount of CPU time that that is remaining in the current burst
        private Status s = Status.READY; //default status given to processes
        private Queue<Request> resourceRequests = new LinkedList<>(); //the list of resource requests in order done with Queue Linked List


        //setters for each processes and a required compareTo method due to the use of Priority Queue
        public void setProcessNames(String processNames){
            this.processNames = processNames;
        }

        public void setProcessorNumber(int processorNumber){
            this.processorNumber = processorNumber;
        }

        public void setProcessorArrivalTime(int processorArrivalTime){
            this.processorArrivalTime = processorArrivalTime;
        }

        public void setDeadLine(int deadline){
            this.deadline = deadline;
        }

        public String getProcessNames(){
            return this.processNames;
        }

        public void setRequest(Status s){
            this.s = s;
        }

        @Override
        public int compareTo(opmain.Processes o) {
            return -1;
        }
    }

    //Where the input file is read and the start of the simulation
    public static void main(String[] args) throws FileNotFoundException {
        // ** IMPORTANT **
        // ** FILE PATH THAT THE USER NEEDS TO ENTER **
        File f1 = new File("C:\\Users\\jerem\\Documents\\GitHub\\Java2More\\OperatingSystemsProject\\test1.txt");

        //First Scanner done with the use of a while loop in order to determine the number of processes
        Scanner read1 = new Scanner(f1);
        int numberOfProcesses = 0;

        while(read1.hasNext()){
            String content1 = read1.next();
            if(content1.equals("INTERACTIVE") || content1.equals("REAL-TIME")){
                numberOfProcesses++;
            }
        }

        read1.close();

        //Second Scanner done in order to create the object processors with the input
        Scanner read2 = new Scanner(f1);
        int tracker = 0;
        Queue<Processes> mainQueue = new PriorityQueue<>();

        Processes p = null;

        //While loop in which reads the input and classify the token accoridng to whether it's INTERACTIVE OR REAL-TIME
        while(read2.hasNext()){
            String token = read2.next();

            if(token.equals("INTERACTIVE") || token.equals("REAL-TIME")){
                if(p != null){
                    mainQueue.add(p);
                }
                p = new Processes();
                p.setProcessNames(token);
                p.setProcessorArrivalTime(Integer.parseInt(read2.nextLine().trim()));
                p.setProcessorNumber(++tracker);

            } else if(p != null){
                int value = Integer.parseInt(read2.nextLine().trim());

                if(token.equals("CPU")){
                    p.resourceRequests.add(new Request(Resource.CPU, value));
                } else if(token.equals("DISK")){
                    p.resourceRequests.add(new Request(Resource.DISK, value));
                } else if(token.equals("TTY")){
                    p.resourceRequests.add(new Request(Resource.TTY, value));
                } else if(token.equals("DEADLINE")){
                    p.setDeadLine(value);
                }
            }
        }

        if(p != null){
            mainQueue.add(p);
        }
        read2.close();
        cpuSimulation(numberOfProcesses, mainQueue); //the call to the CPU simulation Method
    }

    /*
    CPU Simluation Method
    The cpuSimulation purpose is to handle process arrival, CPU Scheduling, disk I/O, and TTY waits.
    Overall this method will simulatin of the OS scheduler
    At the end of the method it will output a Summary Report to a .txt file.
    The parameters that are passed are the total numberProcesses in which was found in Main() and the main Queue in which
    has all the processes in it
    */
    public static void cpuSimulation(int numberOfProcesses, Queue<Processes> queues) throws FileNotFoundException{

        int size = numberOfProcesses;
        int timeLapsed = 0;

        HashMap<Processes, Integer> diskEntryTime = new HashMap<>();
        HashSet<Processes> finished = new HashSet<>();

        while(finished.size() < size){
            for(Processes a: queues){
                if(a.processorArrivalTime <= timeLapsed && a.s == Status.READY){
                    a.s = Status.RUNNING; 
                    if(a.getProcessNames().equals("REAL-TIME")){ 
                        realtimeQueues.add(a);
                    } else {
                        interactiveQueue.add(a);
                    }
                }
            }

            if(cpu_process != null && !realtimeQueues.isEmpty() && cpu_process.processNames.equals("INTERACTIVE")){
                cpu_process.cpuTimeRemaining -= 1;

                // added a check here because if the preemption decrement brings cpuTimeRemaining
                // to 0 on the same tick the burst was finishing, we need to handle it like a normal
                // completion otherwise the process gets requeued with cpuTimeRemaining = 0 and
                // beginCpu never reloads it causing an infinite loop
                if(cpu_process.cpuTimeRemaining == 0){
                    cpu_process.resourceRequests.remove();

                    if(!cpu_process.resourceRequests.isEmpty()){
                        Request nextRequest = cpu_process.resourceRequests.peek();

                        if(nextRequest.type == Resource.DISK){
                            cpu_process.s = Status.WAITING;
                            diskEntryTime.put(cpu_process, timeLapsed);
                            diskQueues.add(cpu_process);
                        } else if(nextRequest.type == Resource.TTY){
                            cpu_process.s = Status.READY;
                            cpu_process.processorArrivalTime = timeLapsed + nextRequest.duration;
                            cpu_process.resourceRequests.remove();
                            cpu_process.cpuTimeRemaining = NOT_STARTED;
                        } else {
                            // RUNNING not READY so the arrival loop doesnt re-add this process
                            cpu_process.s = Status.RUNNING;
                            cpu_process.cpuTimeRemaining = NOT_STARTED;
                            interactiveQueue.add(cpu_process);
                        }
                    } else {
                        cpu_process.s = Status.TERMINATED;
                        cpu_process.finishTime = timeLapsed;
                        System.out.println("Process: " + cpu_process.processorNumber + " (" + cpu_process.processNames + ") terminates at " + timeLapsed);
                        finished.add(cpu_process);
                    }
                } else {
                    // RUNNING not READY so the arrival loop doesnt re-add this process
                    cpu_process.s = Status.RUNNING;
                    interactiveQueue.add(cpu_process);
                }

                cpu_process = null;
            }

            if(cpu_process == null){
                if(!realtimeQueues.isEmpty()){
                    beginCpu(realtimeQueues.peek(), timeLapsed);
                    realtimeQueues.remove();

                } else if(!interactiveQueue.isEmpty()){
                    beginCpu(interactiveQueue.peek(), timeLapsed);
                    interactiveQueue.remove();
                }
            }

            if(cpu_process != null){
                cpu_process.cpuTimeRemaining--;
                cpuBusyTime++;

                if(cpu_process.cpuTimeRemaining == 0){
                    cpu_process.resourceRequests.remove();

                   if(!cpu_process.resourceRequests.isEmpty()){
                    Request nextRequest = cpu_process.resourceRequests.peek();

                    if(nextRequest.type == Resource.DISK){
                        cpu_process.s = Status.WAITING;
                        diskEntryTime.put(cpu_process, timeLapsed);
                        diskQueues.add(cpu_process);

                    } else if(nextRequest.type == Resource.TTY){
                        cpu_process.s = Status.READY;
                        cpu_process.processorArrivalTime = timeLapsed + nextRequest.duration;
                        cpu_process.resourceRequests.remove();
                        cpu_process.cpuTimeRemaining = NOT_STARTED;
                    } else{
                        cpu_process.s = Status.RUNNING;
                        cpu_process.cpuTimeRemaining = NOT_STARTED;
                        
                        if(cpu_process.processNames.equals("REAL-TIME")){
                            realtimeQueues.add(cpu_process);
                        } else {
                            interactiveQueue.add(cpu_process);
                        }
                    }
                   } else {
                    cpu_process.s = Status.TERMINATED;
                    cpu_process.finishTime = timeLapsed;

                    System.out.println("Process: " + cpu_process.processorNumber + " (" + cpu_process.processNames + ") terminates at " + timeLapsed);
                    finished.add(cpu_process);
                   }
                   cpu_process = null;
                }
            }

            if(diskProcess == null && !diskQueues.isEmpty()){
                diskProcess = diskQueues.remove();
                beginDisk(diskProcess, timeLapsed);
            }
        
            if(diskProcess != null) {
                diskProcess.resourceRequests.peek().duration--;
                diskBusyTime++;

                if(diskProcess.resourceRequests.peek().duration == 0){
                    int enteredTime = diskEntryTime.getOrDefault(diskProcess, timeLapsed);
                    totalDisks += timeLapsed - enteredTime + 1;

                    diskProcess.resourceRequests.remove();

                    if(!diskProcess.resourceRequests.isEmpty()){
                        Request nextRequest = diskProcess.resourceRequests.peek();

                        if(nextRequest.type == Resource.CPU){
                            diskProcess.s = Status.RUNNING;
                            diskProcess.cpuTimeRemaining = NOT_STARTED;

                            if(diskProcess.processNames.equals("REAL-TIME")){
                                realtimeQueues.add(diskProcess);
                            } else {
                                interactiveQueue.add(diskProcess);
                            }
                        }
                    } else {
                        diskProcess.s =Status.TERMINATED;
                        diskProcess.finishTime = timeLapsed;
                        System.out.println("Process: " + diskProcess.processorNumber + " (" + diskProcess.processNames + ") terminates at " + timeLapsed);
                        finished.add(diskProcess);
                    }
                    diskProcess = null;
                }
            }
            timeLapsed++;
        }

        timePassed = timeLapsed;

        int completedReal = 0;
        int missedReal = 0;
        int completedInteractive = 0;

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

        FileOutputStream output = new FileOutputStream("C:\\Users\\jerem\\Documents\\GitHub\\Java2More\\OperatingSystemsProject\\output.txt");
        PrintStream stream = new PrintStream(output);

        System.setOut(stream);
        System.out.printf("\nThe Summary Report\n");
        System.out.println("Real-time processes completed: " + completedReal);
        System.out.printf("Percentage of real-time missed deadline %.2f \n", (missedReal*100.0)/completedReal);
        System.out.println("Interactive processes completed: " + completedInteractive);
        System.out.println("Total disk accesses: " + totalDisks);
        System.out.println("Total time elapsed: " + timePassed);
        System.out.printf("CPU Utilization: %.2f \n", (cpuBusyTime*100.0)/timePassed);
        System.out.printf("DISK Utilization %.2f \n", (diskBusyTime*100.0)/timePassed);
        stream.close();
    }
    /*
    beginCpu Method
    The purpose of this method is to schedule the igven process on the CPU and prepare its CPU burst if it has not executed
    It will keep any non-CPU requests that are at the head of the queue
    IF there are no CPU request left then the process will terminate
    The parameters that are passed are the Process p in which is passed on line 213 or 217 along with the current time which is timeLapsed
    from the CPU simulation
    */

    public static void beginCpu(Processes p, int currentTime){
        cpu_process = p;

        if(p.cpuTimeRemaining == NOT_STARTED){

            while(!p.resourceRequests.isEmpty() && p.resourceRequests.peek().type != Resource.CPU){
                p.resourceRequests.remove();
            }

            if(p.resourceRequests.isEmpty()){
                p.s = Status.TERMINATED;
                p.finishTime = currentTime;
                cpu_process = null;
                return;
            }

            p.cpuTimeRemaining = p.resourceRequests.peek().duration;
            p.startTime = currentTime;
        }

        System.out.println("Process: " + p.processorNumber + " (" + p.processNames + ") starts CPU at " + currentTime);
    }

    /*
    beginDisk Method
    The purpose of this method is attach the passed process to the disk device and log the event
    The parameters that are passed are the Process p in which is passed on 269 along with the current time which is timeLapsed
    from the CPU simulation 
    */
    public static void beginDisk(Processes p, int currentTime){
        diskProcess = p;

        System.out.println("Process: " + p.processorNumber + " (" + p.processNames + ") disk started at " + currentTime);
    }
}
