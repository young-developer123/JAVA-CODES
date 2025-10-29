import java.util.Scanner;

public class TokenCAlculate
{
    public class Customer
    {
        Scanner in = new Scanner(System.in);

        int Amount;
        void read()
        {
            System.out.print("Enter amount you wish to spend: ");
            Amount = in.nextInt();

        }
    }

    class Meter extends Customer
    {
        int meterNumber;
        void capture()
        {
            read();
            System.out.print("Enter meter number: ");
            meterNumber = in.nextInt();
        }
    }

    class Receipt extends Meter
    {
        int TokensReceived;
        void view()
        {
            capture();
            TokensReceived =Amount/15;
            System.out.print("Token buyed are: "+ TokensReceived);
        }
    }
    public static void main(String[] args)
    {
        TokenCAlculate outer = new TokenCAlculate();
        TokenCAlculate.Receipt elijah = outer.new Receipt();
        elijah.view();



    }
}