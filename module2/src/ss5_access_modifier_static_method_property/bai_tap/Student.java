package ss5_access_modifier_static_method_property.bai_tap;

public class Student {
    private String name="Join";
    private String classes="C02";
    public Student(){};

    public void setName(String name) {
        this.name = name;

    }


    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
