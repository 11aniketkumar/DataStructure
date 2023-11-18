import java.util.Scanner;

public class BasicPatternDriver
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int x = s.nextInt();
        System.out.println("Enter another number: ");
        int y = s.nextInt();

        System.out.println();

        BasicPattern.FloydsTriangle(x);
        System.out.println();

        BasicPattern.HalfNumberPyramid(x);
        System.out.println();

        BasicPattern.HalfPyramid(x);
        System.out.println();

        BasicPattern.HollowRectangle(x, y);
        System.out.println();

        BasicPattern.InvertedHalfNumberPyramid(x);
        System.out.println();

        BasicPattern.InvertedHalfPyramid(x);
        System.out.println();

        BasicPattern.InvertedRotatedHalfPyramid(x);
        System.out.println();

        BasicPattern.RectangularBlock(x, y);
        System.out.println();

        BasicPattern.Triangle01(x);
        System.out.println();
    }
}