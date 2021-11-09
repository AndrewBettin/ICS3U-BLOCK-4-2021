package week6;

public class whileLoop {
    public static void main(String [] args){
        //exampleOne();
        //exampleTwo();

        //System.out.println(exampleThree(10, 28));
        int numVowels = coutVowels("This is a sentence with vawols");
        System.out.println(numVowels);


    }

    private static int coutVowels(String str) {
        int numVowels = 0;
        int index = 0;

        String vowels = "AEIOUaeiou";
        while(index < str.length()){
            String nextChar = str.substring(index, index + 1);
            if(vowels.indexOf(nextChar) >= 0){
                numVowels ++;
            }
            index ++;
            
        }
        return numVowels;
    }

    private static int exampleThree(int start, int end) {
        int counter = start;
        int sum = 0;
        while(counter <= end){
            sum += counter;
            counter ++;
        }
        return sum;
    }

    private static void exampleOne() {
        int counter = 1;

        while(counter <= 100){
            System.out.println(counter);
            counter ++;
        }
    }

    private static void exampleTwo() {
        int counter = 1;
        int sum = 0;
        while(counter <= 100){
            sum += counter;
            counter ++;
        }
        System.out.println(sum);
    }
    
}
