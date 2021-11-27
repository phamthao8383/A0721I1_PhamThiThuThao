package ss19_string_regex.bai_tap.validate_ten_lop_hoc;

public class ClassNameExampleTest {
    private static ClassNameExample classNameExample;

    public static final String[] validClassNames = new String[] {"C0318G","A1299M","C0320H"};
    public static final String[] invalidClassNames = new String[] {"M132g","M0318G","P0323A","adfasdf","12314","C2120H"};

    public static void main(String[] args) {
        classNameExample = new ClassNameExample();

        for (String className : validClassNames) {
            boolean isValid = classNameExample.validate(className);
            System.out.println("Class name " + className + " is valid: " + isValid);
        }

        for (String className : invalidClassNames) {
            boolean isValid = classNameExample.validate(className);
            System.out.println("Class name " + className + " is valid: " + isValid);
        }
    }
}
