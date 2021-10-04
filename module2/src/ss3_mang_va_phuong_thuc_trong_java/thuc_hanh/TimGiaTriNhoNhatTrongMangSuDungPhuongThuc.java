package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMangSuDungPhuongThuc {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int []array=new int[5];
         System.out.println("Nhập 5 phần tử");
        for(int i=0;i<array.length;i++){
            System.out.print("Nhap phan tu thứ "+i+" = ");
            array[i]=scanner.nextInt();
        }
        int index=minValue(array);
        System.out.println(index);
    }
    public static int minValue(int [] arr){
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }
}
