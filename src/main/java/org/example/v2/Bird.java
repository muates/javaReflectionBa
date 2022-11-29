package org.example.v2;

public class Bird extends Animal{

    private boolean walks;
    private int abcd;
    protected String name;

    public Bird() {
        super("bird");
    }

    public Bird(boolean walks) {
        super("cicikus");
        this.walks = walks;
    }

    public Bird(String name, boolean walks) {
        super(name);
        this.walks = walks;
    }

    public boolean isWalks() {
        return walks;
    }

    public void setWalks(boolean walks) {
        this.walks = walks;
    }

    @Override
    public String getSounds() {
        return null;
    }

    @Override
    public void eat() {

    }
}
