package ss2_vong_lap_trong_java.bai_tap;

public class HienThiCacSoNguyenToNhoHonMotTram {
    public static void main(String[] args) {
        int num = 2;
        String result = "";
        while (num < 100) {
            boolean flag = true;
            if (num < 2) {
                flag = false;
            } else {
                for (int i = 2; i < num; i++) {
                    if (num % i == 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                result += num + " ";
            }
            num++;
        }
        System.out.print(result);
    }

}