package grapher;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author wromero
 */
public class TwoDCartesianPlane {

    private int dimensionX;
    private int dimensionY;
    private ArrayList<Point> pointsList = new ArrayList<Point>();
    private Equation equation;

    public TwoDCartesianPlane() {
    }

    public TwoDCartesianPlane(int dimensionX, int dimensionY) {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
    }

    public TwoDCartesianPlane(int dimensionX, int dimensionY, Equation equation) {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.equation = equation;
    }

    public int getDimensionX() {
        return dimensionX;
    }

    public void setDimensionX(int dimensionX) {
        this.dimensionX = dimensionX;
    }

    public int getDimensionY() {
        return dimensionY;
    }

    public void setDimensionY(int dimensionY) {
        this.dimensionY = dimensionY;
    }

    public ArrayList<Point> getPointsList() {
        return pointsList;
    }

    public void setPointsList(ArrayList<Point> pointsList) {
        this.pointsList = pointsList;
    }

    public Equation getEquation() {
        return equation;
    }

    public void setEquation(Equation equation) {
        this.equation = equation;
    }

    public void addPoints() {
        int y;
        Point point;
        for (int i = -getDimensionX(); i <= getDimensionX(); i++) {
            y = (this.equation.getA() * (i * i) + (this.equation.getB() * i) + this.equation.getC());
            //System.out.println("(x;y) = (" + i + ";" + y + ").\n       F(x)= Y = " + this.equation.getA() + "*" + (i * i) + " + " + this.equation.getB() + "*" + i + "+" + this.equation.getC());
            point = new Point(i, y);
            this.pointsList.add(point);
        }
    }

    public void showPoints() {
        Iterator<Point> iterator = this.pointsList.iterator();
        do {
            Point point = iterator.next();
            System.out.println(point.toString());
        } while (iterator.hasNext());
    }

    public void showRoots() {
        this.equation.calcRoots();
        System.out.println("X1 = "+ this.equation.getRoots()[0]);
        System.out.println("X2 = "+ this.equation.getRoots()[1]);
    }

    public void showPointsMatched() {
        for (int i = getDimensionX(); i > -(getDimensionX() + 1); i--) { //iterando en el eje de las y
            for (int j = -getDimensionY(); j < getDimensionY() + 1; j++) { //itereando en el eje de las x
                if (this.pointsList.get(j + getDimensionY()).getPositionX() == j && this.pointsList.get(j + getDimensionY()).getPositionY() == i) {
                    System.out.println(this.pointsList.get(j + getDimensionY()));
                }
            }
        }
    }

    public void graphCartesianPlane() {
        String ansi_red = "\u001B[31m";
        for (int i = 0; i < getDimensionX() + 1; i++) {
            for (int j = 0; j < getDimensionY() + 1; j++) {
                if (j == ((getDimensionY() / 2))) {
                    System.out.print(ansi_red + "  |"); //color
                } else if (i == (getDimensionX() / 2)) {
                    System.out.print(ansi_red + "  -"); //color
                } else {
                    System.out.print("  .");
                }
            }
            System.out.println("");
        }
    }

    public void graphCartesianPlane2() {
        final String ANSI_RED = "\u001B[31m", ANSI_BLACK = "\u001B[30m";
        for (int i = getDimensionX(); i > -(getDimensionX() + 1); i--) {//itereando en el eje de las y
            for (int j = -getDimensionY(); j < getDimensionY() + 1; j++) {//itereando en el eje de las x
                if (this.pointsList.get(j + getDimensionY()).getPositionX() == j && this.pointsList.get(j + getDimensionY()).getPositionY() == i) {
                    System.out.print(ANSI_RED + "  *");
                } else if (j == 0) {
                    System.out.print(ANSI_BLACK + "  |");
                } else if (i == 0) {
                    System.out.print(ANSI_BLACK + "  -");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println("");
        }
    }
}
