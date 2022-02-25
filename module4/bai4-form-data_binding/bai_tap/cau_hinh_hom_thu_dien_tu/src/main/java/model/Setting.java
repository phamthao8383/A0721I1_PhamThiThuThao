package model;

public class Setting {
    private String languages;
    private int size;
    private boolean spams;
    private String signature;

    public Setting() {
    }

    public Setting(String languages, int size, boolean spams, String signature) {
        this.languages = languages;
        this.size = size;
        this.spams = spams;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isSpams() {
        return spams;
    }

    public void setSpams(boolean spams) {
        this.spams = spams;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
