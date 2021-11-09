package week3;

public class ExtraPractice {
    public static void main(String [] args) {
        exampleOne();
        exampleTwo();
        exampleThree();
        System.out.println(exampleFour(1,8));
        System.out.println(exampleFive("exampleFive"));
        System.out.println(exampleSix("exampleSix","Six"));
        System.out.println(exampleSeven("example", "seven"));
        System.out.println(exampleEight(4,6,8,13));
        System.out.println(exampleNine(10, 12));
        System.out.println(exampleTen("SmallerCat"));
        
    }
    public static void exampleOne(){
        int num = (int)(Math.random()*100) + 1;
        //(int)(Math.random() * numPossibilities) + start
        System.out.println(num);
    }
    public static void exampleTwo(){
        int num2 = (int)(Math.random()*100) - 50;
        System.out.println(num2);
    }
    public static void exampleThree(){
        int num3 = (int)(Math.random()*6)+1;
        System.out.println(num3);   

    }
    public static int exampleFour(int a, int b){
        //int num4 = (int)(Math.random()*(Math.abs(b-a)+1));
        /**if(a > b){
            num4 = num4 + b;
        }
        else{
            num4 = num4 + a;
        }
        */
       return (a > b) ? (int)(Math.random()*(Math.abs(b-a)+1)) + b : (int)(Math.random()*(Math.abs(b-a)+1)) + a;
        
    }
    public static String exampleFive(String str){
        //str = str.replaceFirst("e","");
        //String s1 = str.substring(0, str.indexOf("e"));
        //String s2 = str.substring(str.indexOf("e")+1, str.length());
        return str.substring(0, str.indexOf("e"))+ str.substring(str.indexOf("e")+1, str.length());
        //return s1+s2;
    }
    //Create a function that accepts a String and a substring and then
    //returns a String with the second string removed from the first String. 
    public static String exampleSix(String str, String subStr){
        //str = str.replace(subStr,"");
        //return str;
        int index = str.indexOf(subStr);
        String first = str.substring(0, index);
        String last = str.substring(index + subStr.length());
        return first + last;

    }
    //Create a function that accepts two Strings and returns the length of the two strings added together.
    public static int exampleSeven(String s1, String s2){
        return s1.length()+s2.length();
    }
    // Create a function that takes 4 integers (x1,y1, x2,y2) and obtains the slope
    // of the line connecting those two points.
    public static double exampleEight(int x1, int x2, int y1, int y2){
        return (y2-y1)/(x2-x1);
    }
    //Create a function that can be used to calculate the volume of a cylinder.
    //Radius and Height are the parameters for the function.
    //pi * r^2 * h
    public static double exampleNine(double r, double h){
        return Math.PI * Math.pow(r, 2) * h;
    }
    // Create a function that removes a random characters from a String and returns the new string.
    public static String exampleTen(String str){
        int rand = (int)(Math.random()*str.length());
        //System.out.println(rand);
        String s1 = str.substring(0, rand);
        String s2 = str.substring(rand + 1, str.length());
        //System.out.println(s1);
        //System.out.println(s2);
        return s1 + s2;   
    }   
}
