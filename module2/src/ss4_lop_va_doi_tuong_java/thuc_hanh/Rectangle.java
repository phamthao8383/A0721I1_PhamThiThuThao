package ss4_lop_va_doi_tuong_java.thuc_hanh;


import java.util.Scanner;

public class Rectangle {
    double width, height;
    public Rectangle(){

    }
    public Rectangle(double width,double height){
        this.width=width;
        this.height = height;
    }
    public double getArea(){
        return this.width*this.height;
    }
    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    public String display() {
        return "Rectangle{" + "width=" + width + ", height=" + height + "}";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập width =");
        double width =scanner.nextDouble();
        System.out.println("Nhập height =");
        double height =scanner.nextDouble();
        Rectangle hcn= new Rectangle(width,height);
        System.out.println("Area = "+hcn.getArea());
        System.out.println("Perimeter = "+hcn.getPerimeter());
    }
}
