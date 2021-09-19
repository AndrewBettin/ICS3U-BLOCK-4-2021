package week2;

public class StringExamples {
    public static void main(String[] args){
        String s1 = "Max"; //string literal
        String s2 = "Fred";//string literal
        String s3 = "Max";
        String s4 = new String ("Kyle"); //String object
        String s5 = new String ("Max"); //String object

        System.out.println(s1.length()); //length returns the number of characters in the string

        System.out.println(s1.equals(s5)); //true - same sequence of characters
        System.out.println(s1.equals("max")); // false - M and m are different characters

        System.out.println("Brad".indexOf("ra")); //index of ra in Brad is 1
        System.out.println(s2.indexOf("Red")); //index of Red is not in Fred so returns -1

        String x = "ABCDEF";

        System.out.println(x.substring(2));
        System.out.println(x.substring(2, 4));
        System.out.println("Friday".substring(1, "Friday".length()));
    }
}
