package week2;

public class HWq2 {

    public static void main(String[] args){

        /**
         * Create a program that obtains two integers
         * one for the amount a test is out of and another indicating what a student received.
         * Display what percentage the student received on the test.
         */

         int tTotal = 50;
         int sTotal = 47;
         double Total = (double)sTotal / tTotal * 100;
         System.out.println("the student received: " + Total);
    }
    
}
