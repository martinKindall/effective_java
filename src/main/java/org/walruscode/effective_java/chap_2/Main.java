package org.walruscode.effective_java.chap_2;

import org.walruscode.effective_java.chap_2.builders.Pizza;
import org.walruscode.effective_java.chap_2.entities.Dog;
import org.walruscode.effective_java.chap_2.singletons.UniqueCat;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        singleton();
    }

    static void dog() {
        Dog myDog = Dog.create();

        System.out.println(myDog.bark());
    }

    static void pizza() {
        var ingredients = List.of("Mozarella", "Tomato", "Chorizo");
        Pizza myPizza = Pizza.create(ingredients);

        System.out.println(myPizza.showIngredients());
    }

    static void singleton() {
        System.out.println(UniqueCat.INSTANCE.greet());
    }
}
