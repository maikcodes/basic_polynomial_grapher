package grapher;

public class Grapher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a = 1, b = 6, c = -5, dimesion = 120;
        TwoDCartesianPlane plane = new TwoDCartesianPlane(dimesion, dimesion, new Equation(a, b, c));
        System.out.println("polynomial: " + a + "x^2 + " + b + "x + " + c);
        System.out.println("\nShow Roots");
        plane.showRoots();
        plane.addPoints();
        System.out.println("\nPoints added\n");
        plane.showPoints();
        System.out.println("\nPoints that fit in the graphic\n");
        plane.showPointsMatched();
        System.out.println("\nGraphic\n");
        plane.graphCartesianPlane2();
    }
}
