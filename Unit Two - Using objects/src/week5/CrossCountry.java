package week5;



import java.util.Scanner;

public class CrossCountry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        processRunner(in);
        processRunner(in);
        processRunner(in);

        in.close();
    }

    private static void processRunner(Scanner in) {
        String firstName, lastName;
        String MileOne,mileTwo,finish;
        String splitTwo,splitThree;

        // get the first and last name of the runner

        // get the mileOne and the mileTwo and finish times for all runners

        System.out.print("Enter your first name: ");
        firstName = in.nextLine(); //goes to the next line
        System.out.print("Enter your last name: ");
        lastName = in.nextLine();
        System.out.print("Enter the time (minutes:seconds.millisecons) for mileOne: ");
        MileOne = in.nextLine();
        System.out.print("Enter the time (minutes:seconds.millisecons) for mileTwo: ");
        mileTwo = in.nextLine();
        System.out.print("Enter the time (minutes:seconds.millisecons) for mileThree: ");
        finish = in.nextLine();





        splitTwo = subtractTimes(mileTwo,MileOne);
        splitThree = subtractTimes(finish,mileTwo);

        //display a summary for the runner
        //name: first name last name
        //MileOne:sec
        //SplitTwo: sec
        //SplitThree: sec
        //Finish: 2:03.23

        System.out.println("Name: " + firstName + " " +lastName);
        System.out.println("Mile One: " + convertToTime(covertToSeconds(MileOne)));
        System.out.println("Split Two: " + splitTwo);
        System.out.println("Split Three: " + splitThree);
        System.out.println("Finish Time: " + convertToTime(covertToSeconds(finish)));

    }

    /**
     * 
     * @param endTime
     * @param startTime
     * @return 
     */

    private static String subtractTimes(String endTime, String startTime) { 
        double endTimeInSeconds = covertToSeconds(endTime);
        double startTimeInSeconds = covertToSeconds(startTime);

        double diffInSeconds = endTimeInSeconds-startTimeInSeconds;

        return convertToTime(diffInSeconds);

    }

    private static String convertToTime(double seconds) { 
        return String.format("%d:%06.3f", ((int) seconds/60), seconds%60); 

    }



    private static double covertToSeconds(String time) { 
        if (time.indexOf(":")==-1){
            return Double.parseDouble(time);
        }
        double minutes = Double.parseDouble(time.substring(0,time.indexOf(":")));
        return (minutes*60)+Double.parseDouble(time.substring(time.indexOf(":")+1));

    }
}