# Programming Assignemtn #1: Process Scheduling

The purpose of this project is to simulate CPU scheduling in Java through the use of various data structures and methods. 

## Description
This program simulates CPU scheduling by modeling two classes of processes: REAL-TIME and INTERACTIVE.

It reads from a provided input file that defines each process’s characteristics, such as arrival time, optional deadline, and resource requests (CPU bursts, disk I/O, and TTY terminal wait periods). The simulation progresses tick by tick and makes scheduling decisions at each time unit.

### Scheduling Policy:
The core of this simulation is a scheduler that implements a preemptive, priority-based algorithm.

REAL-TIME processes have higher priority over INTERACTIVE processes. If a REAL-TIME process arrives while an INTERACTIVE process is running, the INTERACTIVE process is preempted (halted), and the REAL-TIME process takes control of the CPU.

INTERACTIVE processes follow a First-Come, First-Served (FCFS) approach using a priority queue.

### Resource Management
Each process follows a sequence of resource requests in a specific order. A CPU burst runs for a specified number of ticks. Once the burst completes, the process will either:

* Move to the disk queue to wait for I/O,
* Enter a TTY wait state (simulating user input delay) and be rescheduled to return at a later tick, or
* Begin another CPU burst if one follows in its sequence.

The disk is modeled as a single device that handles one process at a time, with all remaining processes waiting in a queue behind it.

### Final Output
During the simulation, the program tracks several performance metrics. Once all processes have terminated, a Report Summary is printed to the console and exported to an output file.

The report includes:
* The number of completed REAL-TIME and INTERACTIVE processes
* The percentage of REAL-TIME processes that missed their deadlines
* The total number of disk accesses
* And many other statistics...

## Getting Started

### Dependencies (IMPORTANT)

* Before running the program, please update the input file path and the output file path (lines 104 and 335).
