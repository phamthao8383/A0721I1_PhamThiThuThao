package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;

public class GopMang {
    public static void main(String[] args) {
        int [] array1={1,2,3};
        int [] array2={4,5,6};
        int length=array1.length+array2.length;
        int[] result= new int[length];
        int pos=0;
        for(int element :array1){
            result[pos]=element;
            pos++;
        }
        for (int element : array2) {
            result[pos] = element;
            pos++;
        }
        System.out.println(Arrays.toString(result));
    }
}
