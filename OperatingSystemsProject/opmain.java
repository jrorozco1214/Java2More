/*
Jeremy Orozco
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class opmain {
    static final int NO_DEADLINE = -1;
    static final int NOT_STARTED = -1;

    enum Status {READY, RUNNING, WAITING, TERMINATED};
    enum Resource {CPU, DISK, TTY};

    static Queue<Processes> interactiveQueue = new PriorityQueue<>();
    static Queue<Processes> realtimeQueues = new PriorityQueue<>();
    static Queue<Processes> diskQueues = new PriorityQueue<>();

    static int timePassed = 0;
    static int cpuBusyTime = 0;
    static int diskBusyTime = 0;
    static int totalDisks = 0;
    static int totalDisksWait = 0;

    static Processes cpu_process = null;
    static Processes diskProcess = null;

    public static class Request {
        private Resource type;
        private int duration;

        public Request(Resource type, int duration){
            this.type = type;
            this.duration = duration;
        }
    }

    public static class Processes implements Comparable<Processes>{
        private String processNames;
        private int processorNumber, processorArrivalTime, startTime, finishTime;
        private int deadline = NOT_STARTED;
        private int cpuTimeRemaining = NOT_STARTED;
        private Status s = Status.READY;
        private Queue<Request> resourceRequests = new LinkedList<>();


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

    public static void main(String[] args) throws FileNotFoundException {
        
        File f1 = new File("C:\\Users\\jerem\\Documents\\GitHub\\Java2More\\OperatingSystemsProject\\input.txt"); //

        Scanner read1 = new Scanner(f1);

        Queue<Processes> queues = new PriorityQueue<>();

        int numberOfProcesses = 0;

        while(read1.hasNext()){
            String content1 = read1.next();
            if(content1.equals("INTERACTIVE") || content1.equals("REAL-TIME")){
                numberOfProcesses++;
            }
        }

        read1.close();

        //Second Scanner
        Scanner read2 = new Scanner(f1);
        int tracker = 0;

        for(int i = 0; i < numberOfProcesses; i++){
            String content2 = read2.next();
                if(content2.equals("INTERACTIVE") || content2.equals("REAL-TIME")){
                    Processes p = new Processes();

                    p.setProcessNames(content2);
                    content2 = read2.nextLine().trim();

                    p.setProcessorArrivalTime(Integer.parseInt(content2));
                    p.setProcessorNumber(++tracker);

                    while(read2.hasNext()){

                        content2 = read2.next();

                        if(content2.equals("INTERACTIVE") || content2.equals("REAL-TIME")){
                            queues.add(p);
                            p = new Processes();
                            p.setProcessNames(content2);
                            p.setProcessorArrivalTime(Integer.parseInt(read2.nextLine().trim()));
                            p.setProcessorNumber(++tracker);
                            continue;
                        }

                        int value = Integer.parseInt(read2.nextLine().trim());

                        if(content2.equals("CPU")){
                            p.resourceRequests.add(new Request(Resource.CPU, value));
                        } else if(content2.equals("DISK")){
                            p.resourceRequests.add(new Request(Resource.DISK, value));
                        } else if(content2.equals("TTY")){
                            p.resourceRequests.add(new Request(Resource.TTY, value));
                        } else if(content2.equals("DEADLINE")){
                            p.setDeadLine(value);
                        }
                }
                queues.add(p);
                break;
            }
        }
        read2.close();
        cpuSimulation(numberOfProcesses, queues);
    }

    public static void cpuSimulation(int numberOfProcesses, Queue<Processes> queues){

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

                    if(cpu_process.cpuTimeRemaining > 0){
                        cpu_process.cpuTimeRemaining -= 1;
                        cpu_process.s = Status.READY;
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
                        cpu_process.resourceRequests.remove(); //.poll()

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
                            cpu_process.s = Status.READY;
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
                                diskProcess.s = Status.READY;
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

            /*
            if(totaldisk > 0){
                totalDiskWaitTime * 1.0 / totalDisks
            } else {
                totalDiskWaitTime = 0;
                }
            */

            System.out.printf("\nThe Summary Report\n");
            System.out.println("Real-time processes completed: " + completedReal);
            System.out.printf("Percentage of real-time missed deadline %.2f \n", (missedReal*100.0)/completedReal);
            System.out.println("Interactive processes completed: " + completedInteractive);
            System.out.println("Total disk accesses: " + totalDisks);
            System.out.println("Total time elapsed: " + timePassed);
            System.out.printf("CPU Utilization: %.2f \n", (cpuBusyTime*100.0)/timePassed);
            System.out.printf("DISK Utilization %.2f \n", (diskBusyTime*100.0)/timePassed);
    }

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

    public static void beginDisk(Processes p, int currentTime){
        diskProcess = p;
        totalDisks++;

        System.out.println("Process: " + p.processorNumber + " (" + p.processNames + ") disk started at " + currentTime);
    }
}
