import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class opmain {

    public static class Processes {
        private int process = 0;
        private int cpu, disk, tty, deadlock;

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


        public void setCpu(int cpu){
            if(cpu == 0){
                this.cpu = 0;
            } else {
                this.cpu = cpu;
            }
        }

        public void setDisk(int disk){
            this.disk = disk;
        }

        public void setTTY(int tty){
            this.tty = tty;
        }

        public void setDeadLock(int deadlock){

        }
    } 



    public static void main(String[] args) throws FileNotFoundException {

        Scanner read = new Scanner(new File("input.txt"));

        read.useDelimiter("\\n");

        while(read.hasNext()){
            if(String.valueOf(read) == "INERTACTIVE" || String.valueOf(read) == "REAL-TIME"){
                Processes p = new Processes();

                if(String.valueOf(read) == "CPU"){
                    
                }
            }
        }
    }
}
