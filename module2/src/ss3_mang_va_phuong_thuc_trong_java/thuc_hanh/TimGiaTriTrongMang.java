package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class TimGiaTriTrongMang {
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
        boolean isExits=false;
        System.out.print("Nhập input = ");
        int input_name=scanner.nextInt();
        for (int i=0;i<arr.length;i++){
         //   System.out.println("Position of the students in the list " + input_name + " is: " + (i + 1));
            if(arr[i]== input_name){
                System.out.print(input_name+" Đã có trong danh sách");
                isExits = true;
                break;
            }
        }
        if(isExits==false){
            System.out.println("Không tìm thấy số "+input_name+" trong danh sách");
        }
    }
}
