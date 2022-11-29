package org.example;

import org.example.v2.Animal;
import org.example.v2.Bird;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BirdTest {

    // tesler private olmaz public

    @Test
    public void birdConstructor() throws ClassNotFoundException {
        Class<?> birdClass = getBirdClass();

        Constructor<?>[] birdConstructor = birdClass.getConstructors();

        assertEquals(3, birdConstructor.length);
    }

    @Test
    public void birdDeclareField() throws ClassNotFoundException {
        Class<?> birdClass = getBirdClass();

        Field[] birdFields = birdClass.getFields();
        Field[] birdDeclaredFields = birdClass.getDeclaredFields();

        assertEquals(1, birdFields.length);
        assertEquals(3, birdDeclaredFields.length);
    }

    @Test
    public void birdConstructorParams() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> birdClass = getBirdClass();

        Constructor<?> birdConstructor1 = birdClass.getConstructor();
        Constructor<?> birdConstructor2 = birdClass.getConstructor(boolean.class);
        Constructor<?> birdConstructor3 = birdClass.getConstructor(String.class, boolean.class);

        Bird bird1 = (Bird) birdConstructor1.newInstance();
        Bird bird2 = (Bird) birdConstructor2.newInstance(true);
        Bird bird3 = (Bird) birdConstructor3.newInstance("limon", false);

        assertEquals("bird", bird1.getName());
        assertEquals("cicikus", bird2.getName());
        assertEquals("limon", bird3.getName());

        // bird1 bird2 bird3 isWalk test et

        assertFalse(bird1.isWalks());
        assertTrue(bird2.isWalks());
        assertFalse(bird3.isWalks());
    }

    @Test
    public void birdFieldTest() throws ClassNotFoundException {
        Class<?> birdClass = getBirdClass();

        Field[] birdFields = birdClass.getFields();
        Field[] birdDeclaredFields = birdClass.getDeclaredFields();

        assertEquals(1, birdFields.length);
        assertEquals(3, birdDeclaredFields.length);

        assertEquals("BASE_NAME", birdFields[0].getName());
        assertEquals("abcd", birdDeclaredFields[1].getName());
    }

    @Test
    public void birdFieldTest2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<?> birdClass = getBirdClass();

        Bird bird = (Bird) getBirdClass().getConstructor().newInstance();

        assertFalse(bird.isWalks());

        Field birdField = birdClass.getDeclaredField("walks");

        birdField.setAccessible(true);
        birdField.set(bird, true);

        assertTrue(bird.isWalks());
    }

    // Bizim animal sınıfımız içerisinde ki BASE_NAME animal ilk olarak
    // normal değerlerini test edip
    // sonrasında set BASE_NAME edip test

    @Test
    public void birdFieldTest3() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> birdClass = getBirdClass();

        Bird bird = (Bird) birdClass.getConstructor().newInstance();

        Field birdField = birdClass.getField("BASE_NAME");

        assertEquals("animal", birdField.get(bird));

        birdField.set(bird, "köpek");

        assertEquals("köpek", birdField.get(bird));
    }

    @Test
    public void birdMethodTest() throws ClassNotFoundException {
        Class<?> birdClass = getBirdClass();

        Method[] birdDeclaredMethods = birdClass.getDeclaredMethods();
        Method[] birdMethods = birdClass.getMethods();

        List<String> methodNames = getMethodNames(birdMethods);
        List<String> methodDeclaredNames = getMethodNames(birdDeclaredMethods);

        assertTrue(methodDeclaredNames.containsAll(Arrays.asList("isWalks", "setWalks", "getSounds", "eat")));
    }

    private List<String> getMethodNames(Method[] birdDeclaredMethods) {
        List<String> methodNames = new ArrayList<>();
        for (var method : birdDeclaredMethods)
            methodNames.add(method.getName());
        return methodNames;
    }

    private Class<?> getBirdClass() throws ClassNotFoundException {
        return Class.forName("org.example.v2.Bird");
    }
}
