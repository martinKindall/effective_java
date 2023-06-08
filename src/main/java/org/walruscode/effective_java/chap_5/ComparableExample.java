package org.walruscode.effective_java.chap_5;

import java.util.ArrayList;
import java.util.List;

public class ComparableExample {

    public static void main(String[] args) {

        List<Rabbit> rabbits = new ArrayList<>();
        rabbits.add(new Rabbit(10));
        rabbits.add(new Rabbit(21));
        rabbits.add(new Rabbit(22));
        rabbits.add(new Rabbit(23));
        rabbits.add(new Rabbit(100));

        Rabbit maxRabbit = max(rabbits);

        System.out.println(maxRabbit);
    }

    /**
     * Not a proper max method, just illustrating the power of generics
     *
     * if instead of <E extends Comparable<? super E>>
     * we define <E extends Comparable<E>>
     *
     * then it won't compile, because Rabbit does not implement Comparable<Rabbit>, but
     * Comparable<Mammal>
     */
    private static <E extends Comparable<? super E>> E max(List<? extends E> elements) {
        if (elements.isEmpty()) throw new IndexOutOfBoundsException("empty list");

        E max = elements.get(0);
        E current;
        int idx;

        for (idx = 1; idx < elements.size(); idx++) {
            current = elements.get(idx);

            if (max.compareTo(current) < 0) {
                max = current;
            }
        }

        return max;
    }

    interface Comparable<E> {
        int compareTo(E element);
    }

    static class Mammal implements Comparable<Mammal> {
        private final int age;

        public Mammal(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(Mammal element) {
            return Integer.compare(this.age, element.age);
        }

        @Override
        public String toString() {
            return "age: " + this.age;
        }
    }

    static final class Rabbit extends Mammal {
        public Rabbit(int age) {
            super(age);
        }
    }
}
