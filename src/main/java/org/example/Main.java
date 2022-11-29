package org.example;

import org.example.v2.Bird;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    /**
     * 1. constructor
     * 2. field
     * 3. method
     * @param args
     */

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException {
        Class<?> birdClass = Class.forName("org.example.v2.Bird");

        Constructor<?>[] birdConstructor = birdClass.getConstructors();
        Constructor<?>[] birdDeclaredConstructor = birdClass.getDeclaredConstructors();

        for (var cons : birdConstructor)
            System.out.println("Constructor: " + cons.getName());

        System.out.println("----------------------------------------------");

        for (var cons : birdDeclaredConstructor)
            System.out.println("DeclaredConstructor: " + cons.getName());

        System.out.println("----------------------------------------------");

        Field[] birdField = birdClass.getFields();
        Field[] birdDeclaredField = birdClass.getDeclaredFields();

        for (var field : birdField)
            System.out.println(field.getName());

        System.out.println("----------------------------------------------");

        for (var field : birdDeclaredField)
            System.out.println(field.getName());

        System.out.println("----------------------------------------------");

        Method[] birdMethods = birdClass.getMethods();
        Method[] birdDeclaredMethods = birdClass.getDeclaredMethods();

        for (var method : birdMethods)
            System.out.println(method.getName());

        System.out.println("----------------------------------------------");

        for (var method : birdDeclaredMethods)
            System.out.println("DeclaredMethod:" + method.getName());

        Bird bird = new Bird();

        Field[] bird1Fields = bird.getClass().getDeclaredFields();

        System.out.println("----------------------------------------------");

        System.out.println(bird.isWalks());

        for (var field : bird1Fields) {
            if (field.getName().equals("walks")) {
                field.setAccessible(true);
                field.set(bird, true);
            }
        }

        System.out.println(bird.isWalks());

    }
}
