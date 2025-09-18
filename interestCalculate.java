import java.util.Scanner;
import java.text.DecimalFormat;




public class interestCalculate
{
    public static void main(String[] args)
    {

        DecimalFormat dec = new DecimalFormat("#.##");
        Scanner sca = new Scanner(System.in);




        float principle,rate,time,interest;


        System.out.print("ENTER YOUR PRINCIPLE AMOUNT: ");
        principle = sca.nextFloat();

        System.out.print("ENTER YOUR TOTAL RATE: ");
        rate = sca.nextFloat();

        System.out.print("ENTER TOTAL TIME SPENT: ");
        time = sca.nextFloat();

        interest = (principle*rate*time)/100;

        System.out.print("**OUTPUT**\n");

        System.out.print("YOUR TOTAL INTEREST IS: " + dec.format(interest));
    }
}