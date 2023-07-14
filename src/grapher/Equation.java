package grapher;

import java.util.*;

/**
 *
 * @author wromero
 */
public class Equation {

    private int a;
    private int b;
    private int c;
    private int x;
    private double[] roots = new double[2];

    public Equation() {
    }

    public Equation(int x) {
        this.x = x;
    }

    public Equation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double[] getRoots() {
        return roots;
    }

    public void setRoots(double[] roots) {
        this.roots = roots;
    }

    public int calcEcuation() {
        return (getA() * (getX() * getX()) + (getB() * getX()) + getC());
    }

    public void calcRoots() {
        this.roots[0] = (-getB() + Math.sqrt(Math.pow(getB(), 2) - 4 * (getA() * getC()))) / (2 * getA());
        this.roots[1] = (-getB() - Math.sqrt(Math.pow(getB(), 2) - 4 * (getA() * getC()))) / (2 * getA());
        setRoots(roots);
    }
}
