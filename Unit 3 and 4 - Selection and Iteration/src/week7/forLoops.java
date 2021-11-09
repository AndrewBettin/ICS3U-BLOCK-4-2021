package week7;

import java.util.Scanner;

public class forLoops {
    public static void main(String [] args){
        exampleOne();
        test();
    }

    private static void exampleOne() {
        for (int i = 0, j= 0; i <= 100; i += 2, j-=2){
            System.out.println(i + " " + j);
        }
    }

    private static void test(){
        Scanner in = new Scanner(System.in);
        boolean playAgain = true;

        while(playAgain){
            System.out.println("Game is playing...");
            System.out.println("Game is over");

            System.out.print("Do you want ot play again: ");
            playAgain = in.nextLine().equals("Yes");
        }
        System.out.println("bye");
    }
    
}
