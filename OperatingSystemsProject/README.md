# Programming Assignemtn #1: Process Scheduling

The purpose of this project is to simulate CPU scheduling in Java, through the use or various Data Structures and methods.  

## Description

The program simulates CPU scheduling in which looks at two classes of processes: REAL-TIME and INTERACTIVE.
It reads a provided input file in which defines the processes characteristiscs such as arrival time, optional deadline and resourse requests(CPU burst, disk I/O, and TTY which is terminal wait periods). This simulation alos track tick by tick, and makes schedling decisions at each time unit. 

### Scheduling Policy:
The importance of this simulation is the scheduler implemtsn a preemtive piority based algorithm. This means that 
REAL-TIME Processes having higher priority ove rthe INTERACTIVE Processes. If REAL-TIME Processs arrives while an INTERACTIVE is running then the INERACTIVE will be halted, and the REAL-TIME Process will take over. The INTERACTIVE
Processes follow a first come, first served apporach through the use of a prioirty queue.

### Resource Management
Each one of to hte process follows a sequence of resource requests in a specific order. A CPU bursts rusn for a specific amount of ticks then the rpocess will eitehr move to teh disk queue to wiat for I/O,followed by entering TTY wait and is will be rescheuled to return at a later time or it will begin a CPU burst if follwed by another. The purpose of the disk is to mangage a single deviece handling one process at a time, with remaining processes queues trailing it.

### Final Output
When looking at teh simulatino, the program tracks various types of of variables. When all processes have been terminated a Report Summary will be printed to the console and exported to a file in whcih details the number of compeleted REAL-TIME and INTERACTIVE processes, the percentage of real-time missed dealines, total disk accesses, and many others.

## Getting Started

### Dependencies (IMPORTANT)

* Please, before running the program to the input file path, and an output file path (lines 104, 335)
