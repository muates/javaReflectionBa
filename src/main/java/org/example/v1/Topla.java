package org.example.v1;

public class Topla implements ISonuc {

    private int sayi1;
    private int sayi2;
    private int result;

    @Override
    public void sonuc() {
        result = sayi1 + sayi2;
    }
}
