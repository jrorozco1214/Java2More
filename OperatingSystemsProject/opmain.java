import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class opmain {


    enum Status {READY, RUNNING, WAITING, TERMINATED};
    enum Resource {CPU, DISK, TTY};

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
        private int cpu, disk, tty, deadline, processorNumber, processorArrivalTime;
        private int cpuTimeRemaining, startTime, finishTime, duration;
        private Status s;
        private Queue<Resource> resources;
        private Resource label;

        public void setProcessNames(String processNames){
            this.processNames = processNames;
        }

        public void setProcessorNumber(int processorNumber){
            this.processorNumber = processorNumber;
        }

        public void setProcessorArrivalTime(int processorArrivalTime){
            this.processorArrivalTime = processorArrivalTime;
        }

        public void setCpu(int cpu){
            this.cpu = cpu;
        }

        public void setDisk(int disk){
            this.disk = disk;
        }

        public void setTTY(int tty){
            this.tty = tty;
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

    public static void main(String[] args) throws FileNotFoundException {
        
        File f1 = new File("C:\\Users\\jerem\\Documents\\GitHub\\Java2More\\OperatingSystemsProject\\test1.txt");

        Scanner read1 = new Scanner(f1);

        String content1 = read1.next();

        int tracker = 0;

        Queue<Processes> queues = new PriorityQueue<>();

        int numberOfProcesses = 0;

        while(read1.hasNext()){
            if(content1.equals("INTERACTIVE") || content1.equals("REAL-TIME")){
                numberOfProcesses++;
            }
            System.out.println(content1);
            content1 = read1.next();
        }

        Scanner read2 = new Scanner(f1);

        String content2 = read2.next();

        for(int i = 0; i < numberOfProcesses; i++){
                if(content2.equals("INTERACTIVE") || content2.equals("REAL-TIME")){
                    Processes p = new Processes();

                    p.setProcessNames(content2);
                    content2 = read2.nextLine().trim();

                    p.setProcessorArrivalTime(Integer.parseInt(content2));
                    p.setProcessorNumber(++tracker);

                    while(read2.hasNextLine()){

                        content2 = read2.next();

                        int value = Integer.parseInt(read2.nextLine().trim());

                        switch (content2) {
                            case "CPU":
                                p.setCpu(value);
                                continue;
                        
                            case "DISK":
                                p.setDisk(value);
                                continue;
                        
                            case "TTY":
                                p.setTTY(value);
                                continue;
                        
                            case "DEADLINE":
                                p.setDeadLine(value);
                                continue;
                    }
                }
                queues.add(p);
            }
        }
        read1.close();
        read2.close();
    }

    public static void cpuSimulation(int numberOfProcesses, Queue<Processes> queues){

        int size = numberOfProcesses;
        int timeLapsed = 0;

        HashSet<Processes> p = new HashSet<>();

        while(p.size() < size){

            for(Processes a: queues){

                if(a.processorArrivalTime == timeLapsed){
                    if(a.getProcessNames() == "REAL-TIME"){
                        realtimeQueues.add(a);
                    } else {
                        interactiveQueue.add(a);
                    }
                }
            }

                if(cpu_process != null && !realtimeQueues.isEmpty() && cpu_process.processNames == "INTERACTIVE"){
                    cpu_process.cpuTimeRemaining -= 1;

                    if(cpu_process.cpuTimeRemaining > 0){
                        interactiveQueue.add(cpu_process);
                    }

                    cpu_process = null;
                }

                if(cpu_process == null){
                    if(!realtimeQueues.isEmpty()){
                        beginCpu(realtimeQueues.peek(), queues);
                        realtimeQueues.remove();
                    } else if(!interactiveQueue.isEmpty()){
                        beginCpu(interactiveQueue.peek(), queues);
                        interactiveQueue.remove();
                    }
                }

                if(cpu_process != null){
                    cpu_process.cpuTimeRemaining--;
                    cpuBusyTime++;

                    if(cpu_process.cpuTimeRemaining == 0){
                        cpu_process.resources.remove();

                       if(!cpu_process.resources.isEmpty()){
                        Processes next = cpu_process.resources.peek();

                        if(next.resourceLabel == DISK){
                            diskQueues.add(next);
                        } else if(next.resourceLabel == TTY){
                            cpu_process.s = WAITING;
                        } else{
                            realtimeQueues.add(cpu_process);
                        }
                       } else {
                        cpu_process.s = TERMINATED;
                        cpu_process.finishTime = timeLapsed;

                        System.out.println("Process" + cpu_process.processorNumber + "(" + cpu_process.resources + ") terminates at " + timeLapsed);
                        p.add(cpu_process);
                       }
                       cpu_process = null;
                    }
                }

                if(diskProcess == null && !diskQueues.isEmpty()){

                    diskProcess.resources.peek().duration--;
                    diskBusyTime++;

                    if(diskBusyTime.resources.peek().duration == 0){
                        diskProcess.resources.remove();

                        if(!diskProcess.resources.isEmpty() && diskProcess.resources.peek().r == CPU){
                            if(diskProcess.s == "REAL-TIME"){
                                realtimeQueues.add(diskProcess);
                            } else {
                                interactiveQueue.add(diskProcess);
                            }
                        }
                        diskProcess = null;
                    }
                }

                timeLapsed++;
            }

            int completedReal = 0;
            int missedReal = 0;
            int completedInteractive = 0;
            for(Processes a: queues){

                if(a.processorArrivalTime == timeLapsed){
                    if(a.getProcessNames() == "REAL-TIME"){
                        completedReal++;

                        if(a.deadline != -1 && a.finishTime > a.deadline){
                            missedReal++;
                        }
                    } else {
                        completedInteractive++;
                    } 
                }
            }

            System.out.println("REPORT");
            System.out.println("Real-time processes completed: " + completedReal);
            System.out.printf("Percentage of real-time missed deadline %f ", (missedReal*100.0)/completedReal);
            System.out.println("Interactive processes completed: " + completedInteractive);
            System.out.println("Total disk accesses: " + totalDisks);
            System.out.println("Total time elapsed: " + timePassed);
            System.out.printf("CPU Utilization: %f", (cpuBusyTime*100.0)/timePassed);
            System.out.printf("DISK Utilization %f", (diskBusyTime*100.0)/timePassed);
    }

    public static void beginCpu(Processes p, Queue<Processes> queues){
        p.r.setRequest(RUNNING);
        cpu_process = p;

        if(cpu_process.cpuTimeRemaining == -1){

            p.cpuTimeRemaining = queues.peek().duration;
        }

        System.out.println("Process: " + p.processorNumber + "(" + p.processNames + ") starts DISK at " + timePassed);
    }

    public static void beginDisk(Processes p){
        p.s = WAITING;
        diskProcess = p;
        totalDisks++;
        System.out.println("Process" + p.processorNumber + " (" + p.label + ") disk started at " + timePassed);
    }
}
