package org.example.v2;

public abstract class Animal implements Eating {

    public static String BASE_NAME = "animal";
    private String  name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract String getSounds();

    public static String getBaseName() {
        return BASE_NAME;
    }

    public static void setBaseName(String baseName) {
        BASE_NAME = baseName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
