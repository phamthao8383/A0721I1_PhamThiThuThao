package ss15_xu_li_ngoai_le_debug.thuc_hanh.su_dung_lop_numberformatexception;

import java.util.Scanner;

public class CalculationExample {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter x: ");
        int x = input.nextInt();
        System.out.println("enter y: ");
        int y = input.nextInt();
        CalculationExample calculator = new CalculationExample();
        calculator.calculate(x,y);

    }

    private static void calculate(int x, int y) {
        try {
            int sum = x + y;
            int product = x * y;
            int quotient = x / y;
            int difference = x - y;
            System.out.println("sum is " + sum);
            System.out.println("prodcut is " + product);
            System.out.println("quotient is " + quotient);
            System.out.println("difference is " + difference);

        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("\n");
            e.printStackTrace();
            System.out.println("\n");
            System.out.println(e.toString());
            System.out.println("\n");
            StackTraceElement[] elements = e.getStackTrace();
            for (int i = 0; i < elements.length; i ++) {
                System.out.println(elements[i].getClassName());
                System.out.println(elements[i].getLineNumber());
                System.out.println(elements[i].getMethodName());
                System.out.println(elements[i].getFileName());
            }
        }
    }
    }

