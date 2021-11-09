package week3;

public class WrapperExamples {
    public static void main(String[] args)
    Integer n = new Integer(7);
    Double d = new Double(3.4);
    
    Integer num = 7;
    int x = new Integer(7);

    int z = num.intValue();
    z = num;

    int f = d;
    f = d.doubleValue();

    System.out.println(Integer.MAX_VALUE);
    System.out.println(Integer.MIN_VALUE);

    /**
     * System.out.println(Long.MAX_VALUE); System.out.println(Long.MIN_VALUE);
     */
}
