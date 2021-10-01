package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class TinhSoNgayTrongThang {
    public static void main(String[] args) {
        Scanner ngay = new Scanner(System.in);
        System.out.println("Nhập số tháng");
        int so = Integer.parseInt(ngay.nextLine());
        switch (so) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.print("tháng " + so + "có 31 ngày");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.print("tháng " + so + "có 30 ngày");
                break;
            case 2:
                System.out.print("tháng " + so + "có 28 hoặc 29 ngày");
                break;
            default:
                System.out.print("nhập lại so thang");
                break;
        }
    }
}
