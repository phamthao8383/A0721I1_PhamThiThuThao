package ss7_abstract_class_interface.bai_tap.trien_khai_interface_coloraable;

import ss6_ke_thua.thuc_hanh.Shape;

public class Square  implements Colorable{
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getArea(){
        return side*4;
    }

    public int getSide() {
        return side;
    }
    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
