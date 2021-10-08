package ss4_lop_va_doi_tuong_java.bai_tap;

import java.util.Scanner;

public class QuadraticEquation {
    double a, b, c;
    double delta;
    double r1, r2;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return delta = Math.pow(b, 2) - 4 * a * c;
    }

    public double getRoot1() {
        return r1 = (-b + Math.sqrt(delta)) / (2 * a);
    }

    public double getRoot2() {
        return r2 = (-b - Math.sqrt(delta)) / (2 * a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap a =");
        double a = scanner.nextDouble();
        System.out.print("Nhap b =");
        double b = scanner.nextDouble();
        System.out.print("Nhap c =");
        double c = scanner.nextDouble();
        QuadraticEquation bac = new QuadraticEquation(a, b, c);
        if (bac.getDiscriminant() > 0) {
            System.out.println("Nghiêm 1 =" + bac.getRoot1());
            System.out.println("Nghiêm 2 =" + bac.getRoot2());

        } else if (bac.getDiscriminant() == 0) {

            System.out.println("Có Nghiệm kép Nghiêm 1 = Nghiêm 2 =" + (-b / (2 * a)));

        } else {
            System.out.println("The equation has no roots");
        }
    }

}
