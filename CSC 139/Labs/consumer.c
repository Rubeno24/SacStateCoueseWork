#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/shm.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <string.h>
#include <unistd.h>

// Size of shared memory block
// Pass this to ftruncate and mmap
#define SHM_SIZE 4096

// Global pointer to the shared memory block
// This should receive the return value of mmap
// Don't change this pointer in any function
void* gShmPtr;

// You won't necessarily need all the functions below
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

int main()
{
    const char *name = "OS_HW1_RubenOrtega"; // Name of shared memory block to be passed to shm_open
    int bufSize; // Bounded buffer size
    int itemCnt; // Number of items to be consumed
    int in; // Index of next item to produce
    int out; // Index of next item to consume

    /* shared memory file descriptor */

     
     // Write code here to create a shared memory block and map it to gShmPtr
     // Use the above name
     // **Extremely Important: map the shared memory block for both reading and writing 
     // Use PROT_READ | PROT_WRITE

     /* create the shared memory object */
     int fd = shm_open(name,O_CREAT | O_RDWR,0666);

     /* memory map the shared memory object */
     gShmPtr =mmap(0, SHM_SIZE, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);

     // Write code here to read the four integers from the header of the shared memory block 
     // These are: bufSize, itemCnt, in, out
     // Just call the functions provided below like this:
     bufSize = GetBufSize();
     itemCnt = GetItemCnt();
     in = GetIn();
     out = GetOut();

        
     // Write code here to check that the consumer has read the right values: 
     printf("Consumer reading: bufSize = %d\n",bufSize);
     // Write code here to consume all the items produced by the producer
     // Use the functions provided below to get/set the values of shared variables in, out, bufSize
     // Use the provided function ReadAtBufIndex() to read from the bounded buffer      
     // **Extremely Important: Remember to set the value of any shared variable you change locally
     // Use the following print statement to report the consumption of an item:
     // printf("Consuming Item %d with value %d at Index %d\n", i, val, out);
     // where i is the item number, val is the item value, out is its index in the bounded buffer
     //in_index+=strlen(val);
     int i = 0;
     //while loops keeps going untill i is greater than item count
     while(i<itemCnt){
        in=GetIn();
        //if loops checks if there are items to be consumed
        if(in!=out){
                //reads the item with the current out index in the buffer and stores it into val
                int val= ReadAtBufIndex(out);
                //then prints it
                printf("Consuming Item %d with value %d at Index %d\n", i, val, out);
                //increments out by 1 and mods with bufsize to make sure it stays in the bounds of the buffer
                out=(out+1)%bufSize;
                //then we set out and increment i to keep the while loop going
                SetOut(out);
                i++;

        }

     }

     // remove the shared memory segment 
     if (shm_unlink(name) == -1) {
        printf("Error removing %s\n",name);
        exit(-1);
     }

     return 0;
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
{
        int val;
        void* ptr = gShmPtr + i*sizeof(int);
        memcpy(&val, ptr, sizeof(int));
        return val;
}

// Set the ith value in the header
void SetHeaderVal(int i, int val)
{
        //commented in producer
        void* ptr = gShmPtr + i*sizeof(int);
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
        //explained in the producer
        void* ptr = gShmPtr + 4*sizeof(int) + indx*sizeof(int);
        memcpy(ptr, &val, sizeof(int));
}

// Read the val at the given index in the bounded buffers
int ReadAtBufIndex(int indx)
{
    //explained in the producer
    int val;
    void* ptr = gShmPtr + 4*sizeof(int) + indx*sizeof(int);
    memcpy(&val, ptr, sizeof(int));
    return val;
}

int GetRand(int x, int y)
{
        int r = rand();
        r = x + r % (y-x+1);
        return r;
}
