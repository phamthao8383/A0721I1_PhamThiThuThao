package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class UngDungDocSoThanhChu {
    public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.print("Nhập vào một số có 3 chữ số: ");
            int n = input.nextInt();
            int tr = n / 100;
            int ch = (n % 100) / 10;
            int dv = ((n % 100) % 10);

            if ((tr == 1) && (ch == 0) && (dv == 0))
                System.out.print("Mot tram ");
            else if ((tr == 2) && (ch == 0) && (dv == 0))
                System.out.print("Hai tram ");
            else if ((tr == 3) && (ch == 0) && (dv == 0))
                System.out.print("Ba tram ");
            else if ((tr == 4) && (ch == 0) && (dv == 0))
                System.out.print("Bon tram ");
            else if ((tr == 5) && (ch == 0) && (dv == 0))
                System.out.print("Nam tram ");
            else if ((tr == 6) && (ch == 0) && (dv == 0))
                System.out.print("Sau tram ");
            else if ((tr == 7) && (ch == 0) && (dv == 0))
                System.out.print("Bay tram ");
            else if ((tr == 8) && (ch == 0) && (dv == 0))
                System.out.print("Tam tram ");
            else if ((tr == 9) && (ch == 0) && (dv == 0))
                System.out.print("Chin tram ");

            else if ((tr == 0) && (ch == 1) && (dv == 0))
                System.out.print(" Muoi ");
            else if ((tr == 0) && (ch == 2) && (dv == 0))
                System.out.print("Hai muoi ");
            else if ((tr == 0) && (ch == 3) && (dv == 0))
                System.out.print("Ba muoi ");
            else if ((tr == 0) && (ch == 4) && (dv == 0))
                System.out.print("Bon muoi ");
            else if ((tr == 0) && (ch == 5) && (dv == 0))
                System.out.print("Nam muoi ");
            else if ((tr == 0) && (ch == 6) && (dv == 0))
                System.out.print("Sau muoi ");
            else if ((tr == 0) && (ch == 7) && (dv == 0))
                System.out.print("Bay muoi ");
            else if ((tr == 0) && (ch == 8) && (dv == 0))
                System.out.print("Tam muoi ");
            else if ((tr == 0) && (ch == 9) && (dv == 0))
                System.out.print("Chin muoi ");

            else if ((tr == 0) && (ch == 0) && (dv == 0))
                System.out.print(" Khong ");
            else if ((tr == 0) && (ch == 0) && (dv == 1))
                System.out.print(" Mot ");
            else if ((tr == 0) && (ch == 0) && (dv == 2))
                System.out.print("Hai ");
            else if ((tr == 0) && (ch == 0) && (dv == 3))
                System.out.print("Ba ");
            else if ((tr == 0) && (ch == 0) && (dv == 4))
                System.out.print("Bon ");
            else if ((tr == 0) && (ch == 0) && (dv == 5))
                System.out.print("Nam ");
            else if ((tr == 0) && (ch == 0) && (dv == 6))
                System.out.print("Sau ");
            else if ((tr == 0) && (ch == 0) && (dv == 7))
                System.out.print("Bay ");
            else if ((tr == 0) && (ch == 0) && (dv == 8))
                System.out.print("Tam ");
            else if ((tr == 0) && (ch == 0) && (dv == 9))
                System.out.print("Chin ");

            else {
                switch (tr) {
                    case 0:
                        System.out.print(" ");
                        break;
                    case 1:
                        System.out.print("Mot tram ");
                        break;
                    case 2:
                        System.out.print("Hai tram ");
                        break;
                    case 3:
                        System.out.print("Ba tram ");
                        break;
                    case 4:
                        System.out.print("Bon tram ");
                        break;
                    case 5:
                        System.out.print("Nam tram ");
                        break;
                    case 6:
                        System.out.print("Sau tram ");
                        break;
                    case 7:
                        System.out.print("Bay tram ");
                        break;
                    case 8:
                        System.out.print("Tam tram ");
                        break;
                    case 9:
                        System.out.print("Chin tram ");
                        break;
                }
                switch (ch) {
                    case 0:
                        System.out.print("Le ");
                        break;
                    case 1:
                        System.out.print("Muoi ");
                        break;
                    case 2:
                        System.out.print("Hai muoi ");
                        break;
                    case 3:
                        System.out.print("Ba muoi ");
                        break;
                    case 4:
                        System.out.print("Bon muoi ");
                        break;
                    case 5:
                        System.out.print("Nam muoi ");
                        break;
                    case 6:
                        System.out.print("Sau muoi ");
                        break;
                    case 7:
                        System.out.print("Bay muoi ");
                        break;
                    case 8:
                        System.out.print("Tam muoi ");
                        break;
                    case 9:
                        System.out.print("Chin muoi ");
                        break;
                }
                switch (dv) {

                    case 1:
                        System.out.print("Mot ");
                        break;
                    case 2:
                        System.out.print("Hai ");
                        break;
                    case 3:
                        System.out.print("Ba ");
                        break;
                    case 4:
                        System.out.print("Bon ");
                        break;
                    case 5:
                        System.out.print("Nam ");
                        break;
                    case 6:
                        System.out.print("Sau ");
                        break;
                    case 7:
                        System.out.print("Bay ");
                        break;
                    case 8:
                        System.out.print("Tam ");
                        break;
                    case 9:
                        System.out.print("Chin");
                        break;
                }
            }

        }
}
