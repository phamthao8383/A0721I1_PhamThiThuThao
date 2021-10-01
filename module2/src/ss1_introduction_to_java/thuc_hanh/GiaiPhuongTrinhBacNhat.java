package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class GiaiPhuongTrinhBacNhat {
    public static void main(String[] args) {
        double a,b,c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập a");
        a =scanner.nextDouble();
        System.out.println("Nhập b");
        b =scanner.nextDouble();
        System.out.println("Nhập c");
        c =scanner.nextDouble();
        if(a !=0){
            double answer= (c-b)/a;
            System.out.printf("Equation pass with x = %f!\n",answer);
        }
        else {
            if(b==c){
                System.out.println(" The solution is all x!");
            }else {
                System.out.println("No solution");
            }
        }
    }

}
