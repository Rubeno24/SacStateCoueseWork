/*/*
CSC139 
Spring 2024
Ortega, Ruben
Section #07
OSs Tested on: Linux and Mac os
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <sys/shm.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <unistd.h>
#include <sys/types.h>

// Size of shared memory block
// Pass this to ftruncate and mmap
#define SHM_SIZE 4096

// Global pointer to the shared memory block
// This should receive the return value of mmap
// Don't change this pointer in any function
void* gShmPtr;

// You won't necessarily need all the functions below
void Producer(int, int, int);
void InitShm(int, int);
void SetBufSize(int);
void SetItemCnt(int);
void SetIn(int);
void SetOut(int);
void SetHeaderVal(int, int);
int GetBufSize();
int GetItemCnt();
int GetIn();
int GetOut();
int GetHeaderVal(int);
void WriteAtBufIndex(int, int);
int ReadAtBufIndex(int);
int GetRand(int, int);

int main(int argc, char* argv[])
{
        pid_t pid;
        int bufSize; // Bounded buffer size
        int itemCnt; // Number of items to be produced
        int randSeed; // Seed for the random number generator 

        if(argc != 4){
                printf("Invalid number of command-line arguments\n");
                exit(1);
        }
        bufSize = atoi(argv[1]);
        itemCnt = atoi(argv[2]);
        randSeed = atoi(argv[3]);
        
        // Write code to check the validity of the command-line arguments
        //checks that buffer size is from the range 2 to 600 using if statements
        //if not we print an error message and exit the program with the exit status
        //of 1 which ends the program
        if(bufSize>600){
                printf("The bounded buffer can not exceed 600");
                exit(1);
        }
        else if(bufSize<2){
                printf("The bounded buffer can not be less than 2");
                exit(1);
        }

        // Function that creates a shared memory segment and initializes its header
        InitShm(bufSize, itemCnt);        

        /* fork a child process */ 
        pid = fork();

        if (pid < 0) { /* error occurred */
                fprintf(stderr, "Fork Failed\n");
                exit(1);
        }
        else if (pid == 0) { /* child process */
                printf("Launching Consumer \n");
                execlp("./consumer","consumer",NULL);
        }
        else { /* parent process */
                /* parent will wait for the child to complete */
                printf("Starting Producer\n");
                
                // The function that actually implements the production
                Producer(bufSize, itemCnt, randSeed);
                
                printf("Producer done and waiting for consumer\n");
                wait(NULL);             
                printf("Consumer Completed\n");
        }
    
        return 0;
}

void InitShm(int bufSize, int itemCnt)
{
    int in = 0;
    int out = 0;
    const char *name = "OS_HW1_RubenOrtega"; // Name of shared memory object to be passed to shm_open


     // Write code here to create a shared memory block and map it to gShmPtr  
     // Use the above name.
     int fd = shm_open(name, O_CREAT | O_RDWR, 0666);
     
     // configure the size of the shared memory object
     //pass in buffer size
     ftruncate(fd,bufSize);

     // **Extremely Important: map the shared memory block for both reading and writing 
     // Use PROT_READ | PROT_WRITE
     //pass in buffer size
     //pointer to shared mem block
     gShmPtr=mmap(0, SHM_SIZE, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);
        
    // Write code here to set the values of the four integers in the header
    // Just call the functions provided below, like this
    SetBufSize(bufSize);        
    SetItemCnt(itemCnt);
    SetIn(in);
    SetOut(out);
       
           
}

void Producer(int bufSize, int itemCnt, int randSeed)
{
    int in = 0;
    int out = 0;
    //initialize a variable that will hold the current number generated
    int val = 0;        
    srand(randSeed);

    int i=0;

    // while loops keep going until i is greater than itemCount
    while(i<itemCnt){

        //we add 1 to in which is the current index and modulous that with the size of the buffer
        //that makes sure that the index wraps around when it reaches the end of the buffer then we 
        // make sure that it will not be equal to getOut() which is the index where numbers are being
        //read from.
        //simple terms the if statements makes it so the producer doesnt write into the buffer when its
        //full and it overwrites numbers in the buffer
        if(((in+1) % bufSize) != GetOut() ) {
                //val variable gets a random number from 0 to 3000
                val = GetRand(0,3000);
                
                //write at index in and the value saved in val
                WriteAtBufIndex(in,val);
                //print statement 
                printf("Producing Item %d with value %d at Index %d\n", i, val, in);
                //after writing to buffer, in is increased by 1 and set using SetIn and increment i by 1
                in = (in + 1) % bufSize;
                SetIn(in);
                i++;
        }
    }

    // Write code here to produce itemCnt integer values in the range [0-3000]
    // Use the functions provided below to get/set the values of shared variables "in" and "out"
    // Use the provided function WriteAtBufIndex() to write into the bounded buffer     
    // Use the provided function GetRand() to generate a random number in the specified range
    // **Extremely Important: Remember to set the value of any shared variable you change locally
    // Use the following print statement to report the production of an item:
    // printf("Producing Item %d with value %d at Index %d\n", i, val, in);
    // where i is the item number, val is the item value, in is its index in the bounded buffer
        
        
        
        
    
     printf("Producer Completed\n");
}

// Set the value of shared variable "bufSize"
void SetBufSize(int val)
{
        SetHeaderVal(0, val);
}

// Set the value of shared variable "itemCnt"
void SetItemCnt(int val)
{
        SetHeaderVal(1, val);
}

// Set the value of shared variable "in"
void SetIn(int val)
{
        SetHeaderVal(2, val);
}

// Set the value of shared variable "out"
void SetOut(int val)
{
        SetHeaderVal(3, val);
}

// Get the ith value in the header
int GetHeaderVal(int i)
{       //val will be used to store number from shared memory
        int val;
        //i*sizeof(int) calculates the offset in the shared memory block and is added to the
        //shared memeory block pointer to access that value in memory and that is stored in ptr
        void* ptr = gShmPtr + i*sizeof(int);
        //memeory copies the data stored in ptr mem location to the val memory location
        memcpy(&val, ptr, sizeof(int));
        return val;
}

// Set the ith value in the header
void SetHeaderVal(int i, int val)
{
    //pointer to shared memory location
    void* ptr = gShmPtr + i*sizeof(int);
    
    // Now we are copying the value of val to the memory location of ptr
    memcpy(ptr, &val, sizeof(int));

}

// Get the value of shared variable "bufSize"
int GetBufSize()
{       
        return GetHeaderVal(0);
}

// Get the value of shared variable "itemCnt"
int GetItemCnt()
{
        return GetHeaderVal(1);
}

// Get the value of shared variable "in"
int GetIn()
{
        return GetHeaderVal(2);
}

// Get the value of shared variable "out"
int GetOut()
{             
        return GetHeaderVal(3);
}

// Write the given val at the given index in the bounded buffer 
void WriteAtBufIndex(int indx, int val)
{
        // Skip the four-integer header and go to the given index 
        //pointer named ptr points to shared memory block, we add 4*sizeof(int) to skip the four integer
        //header values, then we add indx*sizeof(int) to calc the offset in the shared mem block
        //that esstianly takes us to the value of index in the shared memory

        void* ptr = gShmPtr + 4*sizeof(int) + indx*sizeof(int);
        // then we use memeory copy to what the val pointer is pointing to to the ptr memory locatiaon
        memcpy(ptr, &val, sizeof(int));
}

// Read the val at the given index in the bounded buffer
int ReadAtBufIndex(int indx)
{
   int val;

    //ptr store the location that we are goint to be accessing 
    void* ptr = gShmPtr + 4*sizeof(int) + indx*sizeof(int);
    
    // what ever is stored in ptr is pointing to will be copied over to what val is pointing to and returned
    memcpy(&val, ptr, sizeof(int));
    
    return val;
 
}

// Get a random number in the range [x, y]
int GetRand(int x, int y)
{
        int r = rand();
        r = x + r % (y-x+1);
        return r;
}
