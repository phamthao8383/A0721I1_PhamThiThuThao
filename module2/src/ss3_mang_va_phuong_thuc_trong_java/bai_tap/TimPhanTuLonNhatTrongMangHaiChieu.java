package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

public class TimPhanTuLonNhatTrongMangHaiChieu {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3}, {9, 5, 6}
        };
        int index = maxValue(array);
        System.out.println(index);
    }

    public static int maxValue(int[][] arr) {
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }
}
