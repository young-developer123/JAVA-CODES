import java.util.Scanner;
import java.text.DecimalFormat;


public class CylinderVolumeCalculate
{
    public static void main(String[] args)
    {

        double height,radius,vol,pie = 3.142;

        DecimalFormat dec = new DecimalFormat("#.###");
        Scanner sca = new Scanner(System.in);

        System.out.print("ENTER THE RADIUS OF YOUR CYLINDER: ");
        radius = sca.nextDouble();

        System.out.print("ENTER THE HEIGHT OF YOUR CYLINDER: ");
        height = sca.nextDouble();

        vol = pie*radius*radius*height;

        System.out.print("THE OUTPUT OF VOLUME IS: " + dec.format(vol));
    }
}