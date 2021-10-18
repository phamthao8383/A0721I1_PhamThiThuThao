package ss7_abstract_class_interface.bai_tap.trien_khai_interface_coloraable;

public class TestColorable {
    public static void main(String[] args) {
        Colorable colorable[]=new Colorable[3];
        Square square1=new Square(2);
        Square square2=new Square(2);
        Square square3=new Square(2);
        colorable[0]=square1;
        colorable[1]=square2;
        colorable[2]=square3;
        for(int i=0;i< colorable.length;i++){
//            if (colorable[i] instanceof Colorable) {
//                Colorable squarei = (Square) colorable[i];
//                squarei.howToColor();
//            }
            colorable[i].howToColor();
        }
    }
}
