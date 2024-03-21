#include <stdio.h>
#include <string.h>
#define MAX_TASKS 100

// Structure to represent a task
struct Task {
    int task_id;
    int arrival_time;
    int cpu_burst;
    int priority;
    int time_quantum; // New field for time quantum
};

int main() {
    FILE *file;
    char filename[] = "input.txt";
    struct Task tasks[MAX_TASKS];
    int num_tasks, task_id, arrival_time, cpu_burst, priority, time_quantum;

    // Open the file for reading
    file = fopen(filename, "r");
    if (file == NULL) {
        printf("Error opening file %s\n", filename);
        return 1;
    }

    // Read the scheduling algorithm name
    char algorithm_name[20];
    fscanf(file, "%s", algorithm_name);

    // Read the time quantum if the algorithm is RR, else set it to 0
    if (strcmp(algorithm_name, "RR") == 0) {
        fscanf(file, "%d", &time_quantum); // Read time quantum
    } else {
        time_quantum = 0; // Set time quantum to 0 for other algorithms
    }

    // Read the number of tasks
    fscanf(file, "%d", &num_tasks);

    // Read and store the tasks in the array
    for (int i = 0; i < num_tasks; i++) {
        fscanf(file, "%d %d %d %d", &task_id, &arrival_time, &cpu_burst, &priority);
        tasks[i].task_id = task_id;
        tasks[i].arrival_time = arrival_time;
        tasks[i].cpu_burst = cpu_burst;
        tasks[i].priority = priority;
        tasks[i].time_quantum = time_quantum; // Set time quantum
    }

    // Close the file
    fclose(file);

    // Print the tasks stored in the array
    printf("Task ID\t Arrival Time\t CPU Burst\t Priority\t Time Quantum\n");
    for (int i = 0; i < num_tasks; i++) {
        printf("%d\t %d\t\t %d\t\t %d\t\t %d\n", tasks[i].task_id, tasks[i].arrival_time, tasks[i].cpu_burst, tasks[i].priority, tasks[i].time_quantum);
    }

    return 0;
}
