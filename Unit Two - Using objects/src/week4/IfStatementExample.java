package week4;

public class IfStatementExample {
    public static void main(String[] args){
        exampleOne();
        String letterGrade = getLettterGrade(78);
        exampleThree();
    }

    private static void exampleThree() {
        /**
         * >
         * <
         * ==
         * >=
         * <=
         * !=       (not equal)
         * || OR (x>7) || (y>8)   EITHER ARE TRU TO BE TRUE
         * && AND (x>7) && (y>8) BOTH ARE TRUE TO BE TRUE
         * ! NOT  !(x>7) x<=7
         */
    }

    private static String getLettterGrade(int mark) {

        if(mark >= 90){
            return "A+";
        }
        else if(mark >= 80){
            return "A";
        }
        else if(mark >= 70){
            return "B";
        }
        else if(mark >= 60){
            return "C";
        }
        else if(mark >= 50){
            return "D";
        }
        else {
            return "F";
        }
    }

    private static void exampleOne() {
        int x = 7;

        if (x % 2 == 0){
            System.out.println(x + " is even.");
        }

        else {
            System.out.println(x + " is odd.");
        }

    }
    
}
