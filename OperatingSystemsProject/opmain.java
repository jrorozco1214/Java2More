import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class opmain {

    public static class Processes implements Comparable<Processes>{
        private String processNames;
        private int cpu, disk, tty, deadline, processorNumber, processorArrivalTime;

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

        @Override
        public int compareTo(opmain.Processes o) {
            return -1;
        }
    } 
    
    static Queue<Processes> interactiveQueue = new PriorityQueue<>();
    static Queue<Processes> realtimeQueues = new PriorityQueue<>();
    static Queue<Processes> diskQueues = new PriorityQueue<>();

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

    public static void cpuSimulation(int numberOfProcesses){

        int size = numberOfProcesses;

        HashSet<Processes> p = new HashSet<>();

        while(p.size() < size){

        }
    }
}
