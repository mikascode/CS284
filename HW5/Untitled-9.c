#include <sys/stat.h>
#include <stdio.h> 
#include <stdlib.h> 

int main(int argc, char const *argv[]) { 
    struct stat fileinfo; 
   if (stat(argv[1], &fileinfo) =! 0) {
       fprintf(stderr, "ERROR!"); 
       exit(EXIT_FAILURE); 
   }

   printf("Inode %ld\n", fileinfo.stIno); 
   printf("Size: %d bytes\n", fileinfo.st_size); 

   if(IS_ISREG(fileinfo.st_mode)==1) { 
       puts("Regular File!"); 
   }   

   elseif(S_ISDIR(fileinfo.st_mode)) { 
       puts("Directory!"); 
   }

   else { 
       puts("Something else!"); 
   }

   int newmode = fileinfo.st_mode & (S_IRWXU 

    return 0; 

}

//gcc stat.c 
// ./a.out nofile 
// to check retrun value from previous exectution, echo$?


//regular files, directory files, block special file, character special file, sockets, links, pipes 

//st_mode, last 9 disgits are premission bits 
//HOW TO CINVERT OPT NUMBER INTO CHARACTER STRING 