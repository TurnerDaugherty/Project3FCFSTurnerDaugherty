import java.io.*;
public class Project3 {  //First Come First Serve by Turner Daugherty 11/12/2017
 public static void main(String args[]) throws IOException
 {
  BufferedReader input = new BufferedReader(new InputStreamReader(System.in));  //Asks and reads how many jobs you want
      int jobInput;
      System.out.println("Enter the number of Jobs: "); 
       jobInput = Integer.parseInt(input.readLine());
       int job[][] = new int[jobInput+1][4];
       for(int i=1;i<=jobInput;i++)
       {
      System.out.println("What is the burst time for Job " + i + "? ");  //Asks and reads the burst time for each job
      job[i][1] = Integer.parseInt(input.readLine());
     }
       System.out.println();
     int time = 0;
     for(int i=1;i<=jobInput;i++)
     {
      time += job[i][1];
     }
     int timeCalculation[] = new int[time];  
     int jobNumber = 1;
     for(int i = 0;i<time;i++)
     { 
      timeCalculation[i]=jobNumber;      
      job[jobNumber][1]--; 
      for(int j = 1; j<=jobInput;j++)
      {  if(job[j][1] != 0)
       {   job[j][3]++;         
        if(j != jobNumber)
         job[j][2]++;
       }
       else if(j==jobNumber)
        job[j][3]++;
      }
      if(i!=0)
      {
       if(jobNumber != timeCalculation[i - 1])
       {  System.out.print("Job" + jobNumber + "->");  //Printing the order of Jobs by FCFS
       }  }
      else	
      System.out.print("FCFS Start Here:" + "Job" + jobNumber + "->");
      if(i==time-1)  
      System.out.print("Total Time:" + (i + 1));  //Printing total time
      if(job[jobNumber][1] == 0)       
       jobNumber++;
     }
     float waitTime = 0;
     for(int i = 1; i <= jobInput; i++)
     {
     waitTime += job[i][2];    //Calculating Avg wait time
     }
     waitTime /= jobInput;
     System.out.println("\nThe Average wait time is: " + waitTime);   //Printing the average wait time 			
 }
}