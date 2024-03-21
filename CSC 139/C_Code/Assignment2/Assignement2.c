#include <stdio.h>
#include <string.h>

#define MAX_TASKS 100 // Maximum number of tasks

// Structure to represent a task
struct Task {
    int task_id;
    int arrival_time;
    int cpu_burst;
    int priority;
};

// Function prototypes
void RR_method(struct Task tasks[], int num_tasks);
void SJF_method(struct Task tasks[], int num_tasks);
void PR_noPREMP_method(struct Task tasks[], int num_tasks);
void PR_withPREMP_method(struct Task tasks[], int num_tasks);
void sort_by_cpu_burst(struct Task tasks[], int num_tasks);
float calculate_average_waiting_time(struct Task tasks[], int num_tasks);

int main() {
    FILE *file;
    char filename[] = "input.txt";
    struct Task tasks[MAX_TASKS]; // Array to store tasks
    int num_tasks, task_id, arrival_time, cpu_burst, priority;

    // Open the file for reading
    file = fopen(filename, "r");
    if (file == NULL) {
        printf("Error opening file %s\n", filename);
        return 1;
    }

    // Read the scheduling algorithm name
    char algorithm_name[20];
    fscanf(file, "%s", algorithm_name);

    // Read the number of tasks
    fscanf(file, "%d", &num_tasks);

    // Read and store the tasks in the array
    for (int i = 0; i < num_tasks; i++) {
        fscanf(file, "%d %d %d %d", &task_id, &arrival_time, &cpu_burst, &priority);
        tasks[i].task_id = task_id;
        tasks[i].arrival_time = arrival_time;
        tasks[i].cpu_burst = cpu_burst;
        tasks[i].priority = priority;
    }

    // Close the file
    fclose(file);

    printf("Algorithm Name: %s\n", algorithm_name);

    // Check the scheduling algorithm name and call the appropriate methods
    if (strcmp(algorithm_name, "RR") == 0) {
        // Call RR method
        RR_method(tasks, num_tasks);
    } else if (strcmp(algorithm_name, "SJF") == 0) {
        // Call SJF method
        SJF_method(tasks, num_tasks);
    } else if (strcmp(algorithm_name, "PR_noPREMP") == 0) {
        // Call PR_noPREMP method
        PR_noPREMP_method(tasks, num_tasks);
    } else if (strcmp(algorithm_name, "PR_withPREMP") == 0) {
        // Call PR_withPREMP method
        PR_withPREMP_method(tasks, num_tasks);
    } else {
        printf("Unsupported scheduling algorithm: %s\n", algorithm_name);
    }

    printf("Task ID\t Arrival Time\t CPU Burst\t Priority\n");
    for (int i = 0; i < num_tasks; i++) {
        printf("%d\t %d\t\t %d\t\t %d\n", tasks[i].task_id, tasks[i].arrival_time, tasks[i].cpu_burst, tasks[i].priority);
    }

    return 0;
}

// Define method implementations
void RR_method(struct Task tasks[], int num_tasks) {
    // Method implementation for Round Robin
    printf("Round Robin method called\n");
}

void SJF_method(struct Task tasks[], int num_tasks) {
    // Method implementation for Shortest Job First
    sort_by_cpu_burst(tasks, num_tasks);
    printf("Shortest Job First method called\n");
    float avg_waiting_time = calculate_average_waiting_time(tasks, num_tasks);
    printf("Average Waiting Time: %.2f\n", avg_waiting_time);
}

void PR_noPREMP_method(struct Task tasks[], int num_tasks) {
    // Method implementation for Priority Scheduling without Preemption
    printf("Priority Scheduling without Preemption method called\n");
}

void PR_withPREMP_method(struct Task tasks[], int num_tasks) {
    // Method implementation for Priority Scheduling with Preemption
    printf("Priority Scheduling with Preemption method called\n");
}

// Sorting tasks based on CPU burst (SJF)
void sort_by_cpu_burst(struct Task tasks[], int num_tasks) {
    struct Task temp;
    for (int i = 0; i < num_tasks - 1; i++) {
        for (int j = i + 1; j < num_tasks; j++) {
            if (tasks[i].cpu_burst > tasks[j].cpu_burst) {
                temp = tasks[i];
                tasks[i] = tasks[j];
                tasks[j] = temp;
            }
        }
    }
}

// Calculate average waiting time for SJF
float calculate_average_waiting_time(struct Task tasks[], int num_tasks) {
    int total_waiting_time = 0;
    int current_time = 0;
    
    // Calculate waiting time for each task
    for (int i = 0; i < num_tasks; i++) {
        int waiting_time = current_time - tasks[i].arrival_time;
        total_waiting_time += waiting_time;
        current_time += tasks[i].cpu_burst;
    }
    
    // Return average waiting time
    return (float)total_waiting_time / num_tasks;
}
