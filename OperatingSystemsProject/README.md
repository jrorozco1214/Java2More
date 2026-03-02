# Programming Assignemtn #1: Process Scheduling

The purpose of this project is to simulate CPU scheduling in Java through the use of various data structures and methods. 

## Description
The program simulates CPU scheduling and looks at two classes of processes: REAL-TIME and INTERACTIVE.
It reads a provided input file which defines the process characteristics such as arrival time, optional deadline, and resource requests (CPU burst, disk I/O, and TTY, which are terminal wait periods). This simulation also tracks tick by tick and makes scheduling decisions at each time unit.

### Scheduling Policy:
The importance of this simulation is that the scheduler implements a preemptive priority-based algorithm. This means that REAL-TIME processes have higher priority over INTERACTIVE processes. If a REAL-TIME process arrives while an INTERACTIVE process is running, then the INTERACTIVE process will be halted and the REAL-TIME process will take over. The INTERACTIVE processes follow a first-come, first-served approach through the use of a priority queue.

### Resource Management
Each process follows a sequence of resource requests in a specific order. A CPU burst runs for a specific number of ticks, then the process will either move to the disk queue to wait for I/O, enter a TTY wait and be rescheduled to return at a later time, or begin another CPU burst if followed by one. The purpose of the disk is to manage a single device handling one process at a time, with remaining processes queued behind it.

### Final Output
When looking at the simulation, the program tracks various types of variables. When all processes have been terminated, a Report Summary will be printed to the console and exported to a file which details the number of completed REAL-TIME and INTERACTIVE processes, the percentage of real-time missed deadlines, total disk accesses, and many others.

## Getting Started

### Dependencies (IMPORTANT)

* Before running the program, please update the input file path and the output file path (lines 104, 335).
