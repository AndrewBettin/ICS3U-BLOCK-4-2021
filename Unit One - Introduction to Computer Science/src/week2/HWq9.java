package week2;
public class HWq9 {
    public static void main(String[] args){
        
        /**
         * Write a program that given the number of pennies, nickles, dimes, quarters, loonies and toonies
         * calculates how much money the user has.
         */
        double p = 0.01;
        double n = 0.05;
        double d = 0.10;
        double q = 0.25;
        int l = 1;  
        int t = 2;

        int pp = 10;
        int nn = 7;
        int dd = 16;
        int qq = 4;
        int ll = 6;
        int tt = 9;

        System.out.println("The user has " + pp + " pennies");
        System.out.println("The user has " + nn + " nickels");
        System.out.println("The user has " + dd + " dimes");
        System.out.println("The user has " + qq + " quarters");
        System.out.println("The user has " + ll + " loonies");
        System.out.println("The user has " + tt + " toonies");

        System.out.print("The user has ");
        System.out.print(p*pp + n*nn + d*dd + q*qq + l*ll + t*tt);
        System.out.print("$");
    }  
}


