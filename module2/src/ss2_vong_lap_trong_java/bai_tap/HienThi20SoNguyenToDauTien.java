package ss2_vong_lap_trong_java.bai_tap;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        int num = 2, count = 0;
        String result = "";
        while (count < 20) {
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
                count++;
            }
            num++;
        }
        System.out.print(result);

    }
}
