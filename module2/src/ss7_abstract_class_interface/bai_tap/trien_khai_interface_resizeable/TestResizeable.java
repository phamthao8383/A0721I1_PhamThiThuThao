package ss7_abstract_class_interface.bai_tap.trien_khai_interface_resizeable;

public class TestResizeable {
    public static void main(String[] args) {
       Resizeable [] resizeablesArray= new Resizeable[3];
       Circle circle = new Circle(3.0);

       resizeablesArray[0]=circle;
        Rectangle rectangle = new Rectangle(2,3);
        resizeablesArray[1]=rectangle;
        Square square = new Square(4);
        resizeablesArray[2]=square;
        for (int i = 0; i < resizeablesArray.length ; i++) {
            System.out.println(resizeablesArray[i]);
            resizeablesArray[i].resize(getRandom());
        }
    }
    public static int getRandom() {
        return (int )(Math.random() * 50 + 1);
    }
}
