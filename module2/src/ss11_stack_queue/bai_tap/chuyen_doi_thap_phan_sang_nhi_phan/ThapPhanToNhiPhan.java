package ss11_stack_queue.bai_tap.chuyen_doi_thap_phan_sang_nhi_phan;

import java.util.Scanner;
import java.util.Stack;

public class ThapPhanToNhiPhan {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        Stack<Integer> stack=new Stack<Integer>();
        System.out.println(" NHẬP SỐ THẬP PHÂN CẦN CHUYỂN :");
        int num=scanner.nextInt();
        while (num != 0)
        {
            int d = num % 2;
            stack.push(d);
            num /= 2;
        }
        System.out.print("\nGiá trị nhị phân là: ");
        while (!(stack.isEmpty() ))
        {
            System.out.print(stack.pop());
        }
        System.out.println();

    }


}
