package ss15_xu_li_ngoai_le_debug.baitap.su_dung_lop_illegaltriangleexception;

public class TestException {
    public static void main(String[] args) {
        try {
            System.out.println(sum(new int[] {1,2,3,4,5}));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n" + e.getMessage());
            System.out.println("\n" + e.toString());

        }
    }
    private static int sum(int[] list) {
        int result = 0;
        for (int i = 0; i <= list.length; i++) {
            result += list[i];
        }
        return result;
    }
    }

