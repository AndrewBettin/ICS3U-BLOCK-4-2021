package week2;

public class ModulusExample {

    public static void main(String[] args){
        int num = 5672;
        int num1 = num / 1000;
        int num4 = num % 10;
        int num2 = num % 1000 / 100;
        num2 = num / 100 % 10;

        int num3 = num % 100 / 10;

        system.out.println(num1 + num2 + num3 + num4)
    }
    
}
