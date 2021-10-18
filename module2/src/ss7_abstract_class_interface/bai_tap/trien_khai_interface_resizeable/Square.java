package ss7_abstract_class_interface.bai_tap.trien_khai_interface_resizeable;

public class Square implements Resizeable{
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
    public void resize(double percent) {
        System.out.println("A Square with side="
                + getSide()
                +"Area = "
                +getArea()
                + ", resize "
                + percent
                + " percent, has area "
                + +(getArea() + (getArea() * percent / 100))
        );
    }
}
