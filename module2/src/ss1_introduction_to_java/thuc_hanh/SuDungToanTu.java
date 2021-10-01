package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class SuDungToanTu {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập Width");
        width =scanner.nextFloat();
        System.out.println("Nhập Height");
        height =scanner.nextFloat();
        float area =width*height;
        System.out.println(" Area ="+ area);

    }
}
