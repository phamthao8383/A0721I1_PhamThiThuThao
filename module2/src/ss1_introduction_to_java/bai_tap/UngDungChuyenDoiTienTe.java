package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tiền chuyển đổi USD :");
        int moneyUsd = Integer.parseInt(scanner.nextLine());
        int moneyVn = 23000*moneyUsd;
        System.out.print("VND ="+moneyVn);


    }
}
