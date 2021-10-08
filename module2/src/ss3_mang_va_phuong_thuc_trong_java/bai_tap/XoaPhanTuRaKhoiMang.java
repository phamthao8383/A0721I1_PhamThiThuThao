package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class XoaPhanTuRaKhoiMang {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int size;
        int []arr;
        System.out.print("Nhập size");
        size=scanner.nextInt();
        arr = new int[size];
        for(int i=0;i<arr.length;i++){
            System.out.print("Nhập từng phần tử "+i+" = ");
            arr[i]=scanner.nextInt();
        }
        System.out.printf("%-20s%s", "Elements in array: ", "");
        for(int i=0;i<arr.length;i++){

            System.out.print(arr[i]+"\t");
        }

        System.out.print("Nhập input = ");
        int input_name=scanner.nextInt();
        for (int i=0;i<arr.length;i++){
            //   System.out.println("Position of the students in the list " + input_name + " is: " + (i + 1));
            if(arr[i]== input_name){
             //   System.out.print(input_name+" Đã có trong danh sách");
                for (int j=i;j<arr.length-1;j++){
                    arr[j]=arr[j+1];
                }
                arr[arr.length-1]=0;
                i--;
            }

        }
        for( int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t");
        }
    }
}
