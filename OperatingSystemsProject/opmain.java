import java.util.Queue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class opmain {

    public static class Processes {
        private int process = 0;
        private int cpu, disk, tty, deadlock, processorTime;

        // public Processes(int cpu, int disk, int tty, int deadlock){
        //     if(cpu == 0){
        //         this.cpu = 0;
        //     } else if(disk == 0){
        //         this.
        //     }
            
        //     this.cpu = cpu;
        //     this.disk = disk;
        //     this.tty = tty;
        //     this.deadlock = deadlock;
        //     process +=1;
        // }

        // public Processes(int cpu, int disk, int tty){
        //     this.cpu = cpu;
        //     this.disk = disk;
        //     this.tty = tty;
        //     process += 1;
        // }

        // public Processes(int cpu, int disk){
        //     this.cpu = cpu;
        //     this.disk = disk;
        //     process += 1;
        // }

        public void setProcessorTime(int processorTime){
            this.processorTime = processorTime;
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

        public void setDeadLock(int deadlock){
            this.deadlock = deadlock;
        }
    } 



    public static void main(String[] args) throws FileNotFoundException {

        Scanner read = new Scanner(new File("input.txt"));

        read.useDelimiter("\\n");

        String content = read.next();

        int tracker = 0;

        Queue<Processes> queues = null;

        int numberOfProcesses = 0;

        while(read.hasNext()){
            if(content == "INTERACTIVE" || content == "REAL-TIME"){
                numberOfProcesses++;
            }
        }

        for(int i = 0; i < numberOfProcesses; i++){
                if(content == "INTERACTIVE" || content == "REAL-TIME"){

                while(read.hasNext()){
                    String reading = read.next();
                    int value = read.nextInt();
                    Processes p = new Processes();

                    if(reading == "CPU" || reading == "DISK" || reading == "TTY" || reading == "DEADLOCK"){
                        p.setCpu(value);
                        p.setDisk(value);
                        p.setTTY(value);
                        p.setDeadLock(value);
                    } else if(reading == "INTERACTIVE" || reading == "REAL-TIME"){
                        tracker++;
                        p.setProcessorTime(tracker);
                        break;
                    }
                queues.add(p);
                }
            }
        }
    }
}
