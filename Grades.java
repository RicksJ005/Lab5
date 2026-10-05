import java.util.Scanner;
import java.io.*;  //Note - Since we are using multiple classes from java.io, we can use the * wildcard vs listing each individually.  Any 2+, it is best to use *

/**
 * Program Description
 * 1) Fill in steps
 * 
 * @author Name, optional email
 * @version v1.0
 * @since date
 */
public class Grades{ 
    public static void main (String[] args) throws IOException{  //look how small main() is when we divide and conquer into (resusable) methods!  Only 4 lines!!!
        String inFile, outFile;
        inFile = getInFile();
        outFile = getOutFile();
        processFile(inFile, outFile);
        //String vars inFile, outFile for the file names
        //set inFile using getInFile()
        //set outFile using getOutFile()
        //call processFile() with inFile and outFile as arguments
    }//end main

    /**
     * Uses Scanner to get and return input file name
     * @return name of file from Scanner  
     */
    public static String getInFile(){
        String var1;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the name of the input file (ie input.txt): ");
        var1 = keyboard.nextLine();
        File var;
        File file = new File(var1);
        while (file.exists() != true) {
            System.out.print("Enter the name of the input file (ie input.txt): ");
            var1 = keyboard.nextLine();
            file = new File(var1);
        }
        //create String var
        //Create Scanner object tied to System.in (ie keyboard) and message to user like-Enter the name of the input file (ie input.txt).  
        //Assign to String var from above via keyboard.nextLine()
        //create File var
        //create a new File object with String var from above as argument and assign to File var from above
        //create a while loop pit to ensure that file .exists (remember if it exists, you don't need to be in the pit.  Think ! here
            //repeat message to user like-Enter the name of the input file (ie input.txt).  Assign to String var from above via .nextLine()
            //repeat create a new File object with temp as argument and assign to File var from above
        
        return var1;
        //return String var from above
    }
    /**
     * Uses Scanner to get and return the output file name
     * <@return name of file from Scanner
     */
    public static String getOutFile () {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the output file name: ");
        String outFile = keyboard.nextLine();
        return outFile;
    }//.... for getting output file name
    
    //create a method to generate and return a String for the output file name.  
    //Create a Scanner object tied to System.in (ie keyboard)
    //Message to user
    //return keyboard.nextLine() 
        
    /**
     * Takes an input file from the user using the scanner
     * Processes the grades counting the amount of As Bs Cs Ds Fs
     * Outputs the amount of Grades into a file and then calculate the average, and highest and lowest scores.
     * @param inFile the input file that contains grades to be processed
     * @param outFile the output file where the processed grades and data ges
     * 
     */    
    public static void processFile(String inFile, String outFile) throws IOException {
        int number, min, max, A, B, C, D, F, total, count = 0;
        int set = 1;
        double avg;
        File file = new File(inFile);
        Scanner inStream = new Scanner(file);
        PrintWriter outStream = new PrintWriter(outFile);
        
        while (inStream.hasNextLine() == true) {
            A = B = C = D = F = 0;
            avg = 0.0;
            number = inStream.nextInt();
            min = max = number;
            total = count = 0;
            while(number != -1) {
                if (number < min) {
                    min = number;
                }
                if (number > max) {
                    max = number;
                
                }
                total += number;
                if (number>=90) {
                    A++;
                }
                else if (number >=80) {
                    B++;
                }
                else if (number >= 70) {
                    C++;
                
                }
                else if (number >= 60) {
                    D++;
                }
                else{
                    F++;
                }
                number = inStream.nextInt();
                count++;
                
                
            
            }
            
            outStream.println("Set " + set + " of grades calculated");
            set++;
            if (count == 0) {
                outStream.println("No grades to average");
                outStream.println(" ");
            }
            else {
    
                outStream.println("Number of As: " + A);
                outStream.println("Number of Bs: " + B);
                outStream.println("Number of Cs: " + C);
                outStream.println("Number of Ds: " + D);
                outStream.println("Number of Fs: " + F);
                outStream.println("The high score was: " + max);
                outStream.println("The low score was: " + min);
                avg = (double) total / count;
                outStream.printf("The avg score is: %.1f%n", avg);
                outStream.println(" ");
            }    
        }
        System.out.println("Grade processing is completed");
        System.out.println("You can retrieve the output file at, " + outFile);
        inStream.close();
        outStream.close();
    }
}
        
        //.... for processing fil
            
        
    //create a void processFile method with 2 String parameters.  Since working with File, will need throws IOException
        ////vars section
        //int var number to assign from Scanner input
        //int var accumulators for As,Bs,Cs,Ds,Fs,min,max
        //int vars for total,count
        //double var for avg     
        //int var set for each line of grades with 1 assigned

        ////Scanner and PrintWriter streams section
        //create File object to create a file from inFileName param
        //create Scanner object with File object from above.  NOTE-You know this will work based on while pit in getInFile()
        //create PrintWriter object with inOutFile from method param.  NOTE-PrintWriter creates a new file or overwrites an 
        //    existing file if using FileWriter.

        //outer while loop to test if Scanner object .hasNextLine()
            //set As=Bs=Cs=Ds=Fs=count=0 since new line of scores to average
            //set average to 0.0 since new line of scores to average
            //set number var to Scanner object using nextInt()
            //set min=max=number
            //set total=count=0
            //inner while loop looking for sentinel (-1).  -1 will cause while loop to stop reading.  Think how you will use ! here
                //if(number<min)
                    //set min to number
                //repeat the same except for max this time 
                //increment count since you will use this as the denominator to calculate average
                //add number to the total accumulator.  Think += here

                //if-else if section to set increment the proper letter grade accumulators

                //else if (number>=?)
                    //increment Bs
                //account for all letter grades

                //need to read in the next number using Scanner object with .nextInt().  You are in a while pit to process each grade for each line
    //end while
            
            //Write to the PrintWriter object (ie outStream) like you would to the screen (ie .println("Set " + set + " of grades calculated")
            //set++;
            //if to determine whether a line with -1 only, if so, count is still 0
                //print to PrintWriter object, No grades to average
            //else{
                //print to PrintWriter object, Number of As: along with the value in the As accumulator
                //repeat above for Bs, Cs,Ds, and Fs
                //print to PrintWriter object, The high score was: along with the value in max
                //repeat above but for min
                //compute avg. NOTE-Both total and count are integers.  You will need to cast here (double).
                //print to PrintWriter object, The avg score is: nicely formatted to 1 decimal place
            //end else
        //message out to the console screen (System.out.println("Grade processing is completed");
        //Perhaps a message out to console screen, You can retrieve the output file at, <output file location>
        //close the inStream and outStream using the .close() for each
