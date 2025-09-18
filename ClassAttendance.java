import java.util.Scanner;
import java.text.DecimalFormat;


public class ClassAttendance
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        DecimalFormat dec = new DecimalFormat("#.##");


        double total,num,average;
        System.out.print("ENTER SESSION ATTENDED: ");

        num= in.nextDouble();

        System.out.print("ENTER TOTAL NUMBER OF SESSION IN SEMESTER: ");

        total= in.nextDouble();
        average= num/total*100;
        System.out.print("ANSWER IS: " + dec.format(average));
    }
}