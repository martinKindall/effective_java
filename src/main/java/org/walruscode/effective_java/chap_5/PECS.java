package org.walruscode.effective_java.chap_5;

import java.util.*;


/**
 * PECS stands for "producer-extends, consumer-super"
 */
public class PECS {

    public static void main(String[] args) {

        Stack<Jumper> myStack = new Stack<>();
        List<Frog> frogs = new ArrayList<>();
        frogs.add(new Frog());

        addAll(frogs, myStack);

        List<Animal> animals = new LinkedList<>();
        popAll(animals, myStack);
    }

    // upper bound -> accept a collection of types E or any subtype of it
    private static <E> void addAll(Collection<? extends E> elements, Stack<E> stack) {
        for (E element: elements) {
            stack.add(element);
        }
    }

    // this is a lower bound to the type E -> accept E as a type or any supertype of it
    private static <E> void popAll(Collection<? super E> receiver, Stack<E> stack) {
        while (!stack.isEmpty()) {
            receiver.add(stack.pop());
        }
    }

    interface Animal {}

    interface Jumper extends Animal {
        void jump();
    }

    static class Frog implements Jumper {

        @Override
        public void jump() {
            System.out.println("jumping...");
        }
    }
}
