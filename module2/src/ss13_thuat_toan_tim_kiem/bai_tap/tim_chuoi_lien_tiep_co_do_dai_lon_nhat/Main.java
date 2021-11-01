package ss13_thuat_toan_tim_kiem.bai_tap.tim_chuoi_lien_tiep_co_do_dai_lon_nhat;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Character> max = new LinkedList<>();
        LinkedList<Character> list = new LinkedList<>();

        System.out.print("Nhập chuỗi: ");
        String string = input.nextLine();

        // Tìm chuỗi liên tiếp có độ dài lớn nhất
        for (int i = 0; i < string.length(); i++) { 		//1 Vòng lặp
            if (list.size() > 1 && string.charAt(i) <= list.getLast() &&
                    list.contains(string.charAt(i))) {
                list.clear(); //1 câu lệnh
            }

            list.add(string.charAt(i)); // 1 câu lệnh

            if (list.size() > max.size()) { // 1 câu lệnh
                max.clear();
                max.addAll(list);
            }
        }

        // Hiển thị chuỗi liên tiếp dài nhất
        for (Character ch: max) { // 1 vòng lặp
            System.out.print(ch); // 1 câu lệnh
        }
        System.out.println();
    }

/*********************************************************************************
 * Tính toán độ phức tạp của bài toán này:                                        *
 * 	1 vòng lặp * 3 câu lệnh = 3;                                                  *
 * 	1 vòng lặp * 1 câu lệnh = 1;                                                  *
 *                                                                                *
 * 	T(n) = O(n)                                                                   *
 *  Độ phức tạp của bài toán là O(n)                                           	  *
 *********************************************************************************/
}

