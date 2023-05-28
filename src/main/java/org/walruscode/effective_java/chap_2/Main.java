package org.walruscode.effective_java.chap_2;

import org.walruscode.effective_java.chap_2.internal.Dog;

public class Main {

    public static void main(String[] args) {

        Dog myDog = Dog.create();

        System.out.println(myDog.bark());
    }
}
