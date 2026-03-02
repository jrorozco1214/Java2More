import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class opmain2 {

    enum Status { READY, RUNNING, WAITING, TERMINATED }
    enum Resource { CPU, DISK, TTY }

    // Mirrors C++ struct Request
    public static class Request {
        Resource type;
        int duration;

        public Request(Resource type, int duration) {
            this.type = type;
            this.duration = duration;
        }
    }

    public static class Processes implements Comparable<Processes> {
        String processNames;
        int deadline = -1;
        int processorNumber;
        int processorArrivalTime;
        int cpuTimeRemaining = -1; // -1 means not yet started (mirrors remaining_cpu_time)
        int startTime;
        int finishTime;
        Status s = Status.READY;
        Queue<Request> requests = new LinkedList<>(); // mirrors C++ queue<Request>

        public void setProcessNames(String processNames) {
            this.processNames = processNames;
        }

        public void setProcessorNumber(int processorNumber) {
            this.processorNumber = processorNumber;
        }

        public void setProcessorArrivalTime(int processorArrivalTime) {
            this.processorArrivalTime = processorArrivalTime;
        }

        public void setDeadLine(int deadline) {
            this.deadline = deadline;
        }

        public String getProcessNames() {
            return this.processNames;
        }

        @Override
        public int compareTo(Processes o) {
            return -1;
        }
    }

    static Queue<Processes> interactiveQueue = new PriorityQueue<>();
    static Queue<Processes> realtimeQueues = new PriorityQueue<>();
    static Queue<Processes> diskQueues = new LinkedList<>();

    static int timePassed = 0;
    static int cpuBusyTime = 0;
    static int diskBusyTime = 0;
    static int totalDisks = 0;
    static int totalDisksWait = 0;

    static Processes cpu_process = null;
    static Processes diskProcess = null;

    public static void main(String[] args) throws FileNotFoundException {

        File f1 = new File("C:\\Users\\jerem\\Documents\\GitHub\\Java2More\\OperatingSystemsProject\\input.txt");

        Scanner read1 = new Scanner(f1);

        String content1 = read1.next();

        int tracker = 0;

        Queue<Processes> queues = new PriorityQueue<>();

        int numberOfProcesses = 0;

        while (read1.hasNext()) {
            if (content1.equals("INTERACTIVE") || content1.equals("REAL-TIME")) {
                numberOfProcesses++;
            }
            System.out.println(content1);
            content1 = read1.next();
        }

        Scanner read2 = new Scanner(f1);

        String content2 = read2.next();

        for (int i = 0; i < numberOfProcesses; i++) {
            if (content2.equals("INTERACTIVE") || content2.equals("REAL-TIME")) {
                Processes p = new Processes();

                p.setProcessNames(content2);
                content2 = read2.nextLine().trim();

                p.setProcessorArrivalTime(Integer.parseInt(content2));
                p.setProcessorNumber(++tracker);

                while (read2.hasNextLine()) {

                    content2 = read2.next();

                    int value = Integer.parseInt(read2.nextLine().trim());

                    switch (content2) {
                        case "CPU":
                            p.requests.add(new Request(Resource.CPU, value));
                            continue;

                        case "DISK":
                            p.requests.add(new Request(Resource.DISK, value));
                            continue;

                        case "TTY":
                            p.requests.add(new Request(Resource.TTY, value));
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

    public static void cpuSimulation(int numberOfProcesses, Queue<Processes> queues) {

        int size = numberOfProcesses;
        int timeLapsed = 0;

        HashSet<Processes> finished = new HashSet<>();

        while (finished.size() < size) {

            // Add arriving processes to ready queues
            for (Processes a : queues) {
                if (a.processorArrivalTime == timeLapsed) {
                    if (a.getProcessNames().equals("REAL-TIME")) {
                        realtimeQueues.add(a);
                    } else {
                        interactiveQueue.add(a);
                    }
                }
            }

            // CPU preemption: if an interactive process is running and a real-time process arrives
            if (cpu_process != null && !realtimeQueues.isEmpty() && cpu_process.processNames.equals("INTERACTIVE")) {
                cpu_process.cpuTimeRemaining -= 1;
                if (cpu_process.cpuTimeRemaining > 0) {
                    interactiveQueue.add(cpu_process);
                }
                cpu_process = null;
            }

            // Assign CPU if free
            if (cpu_process == null) {
                if (!realtimeQueues.isEmpty()) {
                    beginCpu(realtimeQueues.peek());
                    realtimeQueues.remove();
                } else if (!interactiveQueue.isEmpty()) {
                    beginCpu(interactiveQueue.peek());
                    interactiveQueue.remove();
                }
            }

            // CPU execution tick
            if (cpu_process != null) {
                cpu_process.cpuTimeRemaining--;
                cpuBusyTime++;

                if (cpu_process.cpuTimeRemaining == 0) {
                    cpu_process.requests.remove(); // pop finished CPU burst

                    if (!cpu_process.requests.isEmpty()) {
                        Request next = cpu_process.requests.peek();

                        if (next.type == Resource.DISK) {
                            diskQueues.add(cpu_process);
                        } else if (next.type == Resource.TTY) {
                            cpu_process.s = Status.WAITING;
                        } else {
                            // Another CPU burst — re-queue
                            if (cpu_process.processNames.equals("REAL-TIME")) {
                                realtimeQueues.add(cpu_process);
                            } else {
                                interactiveQueue.add(cpu_process);
                            }
                        }
                    } else {
                        // Process finished
                        cpu_process.s = Status.TERMINATED;
                        cpu_process.finishTime = timeLapsed;
                        System.out.println("Process " + cpu_process.processorNumber
                                + " (" + cpu_process.processNames + ") terminates at " + timeLapsed);
                        finished.add(cpu_process);
                    }
                    cpu_process = null;
                }
            }

            // Disk scheduling (FCFS)
            if (diskProcess == null && !diskQueues.isEmpty()) {
                diskProcess = diskQueues.peek();
                diskQueues.remove();
                beginDisk(diskProcess);
            }

            if (diskProcess != null) {
                diskProcess.requests.peek().duration--;
                diskBusyTime++;

                if (diskProcess.requests.peek().duration == 0) {
                    diskProcess.requests.remove();

                    if (!diskProcess.requests.isEmpty() && diskProcess.requests.peek().type == Resource.CPU) {
                        if (diskProcess.processNames.equals("REAL-TIME")) {
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

        // Summary report
        int completedReal = 0;
        int missedReal = 0;
        int completedInteractive = 0;

        for (Processes a : queues) {
            if (a.getProcessNames().equals("REAL-TIME")) {
                completedReal++;
                if (a.deadline != -1 && a.finishTime > a.deadline) {
                    missedReal++;
                }
            } else {
                completedInteractive++;
            }
        }

        System.out.println("\nREPORT");
        System.out.println("Real-time processes completed: " + completedReal);
        System.out.printf("Percentage of real-time missed deadline: %.2f%%%n", (missedReal * 100.0) / completedReal);
        System.out.println("Interactive processes completed: " + completedInteractive);
        System.out.println("Total disk accesses: " + totalDisks);
        System.out.println("Total time elapsed: " + timeLapsed + " ms");
        System.out.printf("CPU Utilization: %.2f%%%n", (cpuBusyTime * 100.0) / timeLapsed);
        System.out.printf("DISK Utilization: %.2f%%%n", (diskBusyTime * 100.0) / timeLapsed);
    }

    // Mirrors C++ startCPU — sets process running and loads remaining CPU time on first use
    public static void beginCpu(Processes p) {
        p.s = Status.RUNNING;
        cpu_process = p;

        if (p.cpuTimeRemaining == -1) {
            // First time on CPU — load duration from the front request
            p.cpuTimeRemaining = p.requests.peek().duration;
        }

        System.out.println("Process " + p.processorNumber
                + " (" + p.processNames + ") starts CPU at " + timePassed);
    }

    // Mirrors C++ startDisk
    public static void beginDisk(Processes p) {
        p.s = Status.WAITING;
        diskProcess = p;
        totalDisks++;
        System.out.println("Process " + p.processorNumber
                + " (" + p.processNames + ") starts DISK at " + timePassed);
    }
}