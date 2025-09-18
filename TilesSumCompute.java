import java.util.Scanner;
import java.text.DecimalFormat;

public class TilesSumCompute
{
    public static void main(String[] args)
    {
        Scanner sca = new Scanner(System.in);
        DecimalFormat dec = new DecimalFormat("#.##");

        double len,wid,area,tilesnum;

        System.out.print("ENTER THE LENGTH OF THE ROOM TO HAVE TILES IN METERS: ");
        len = sca.nextDouble();

        System.out.print("ENTER THE WIDTH OF THE ROOM TO HAVE TILES IN METERS: ");
        wid = sca.nextDouble();

        area = len*wid;
        System.out.print("\n\nAREA OF THE ROOM IS: " + dec.format(area) + "M²");

        System.out.print("\nAREA OF ONE TILE IS 0.36M²");

        tilesnum = area/0.36;

        System.out.print("\nNUMBER OF TILES REQUIRED IS: " + dec.format(tilesnum));
    }
}