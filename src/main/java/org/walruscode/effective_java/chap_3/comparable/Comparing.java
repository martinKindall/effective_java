package org.walruscode.effective_java.chap_3.comparable;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Comparing {

    public static void main(String[] args) {

        Cat myCat1 = new Cat("Tom", 8);
        Cat myCat2 = new Cat("Felix", 5);

        System.out.println(myCat1.compareTo(myCat2));

        Cat[] cats = new Cat[]{myCat1, myCat2};
        Arrays.sort(cats);

        System.out.println(cats[0]);

        List<Cat> myCats = List.of(myCat1, myCat2);
        var algo = myCats.stream().sorted().toList();

        System.out.println(algo.get(0));
    }

    static class Cat implements Comparable<Cat> {

        public final String name;
        public final int age;

        Cat(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Cat (name, age): (" + name + ", " + age + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Cat)) return false;

            return this.age == ((Cat) o).age && this.name.equals(((Cat) o).name);
        }

        @Override
        public int compareTo(@Nonnull Cat o) {
            int nameComp = this.name.compareTo(o.name);

            if (nameComp == 0) {
                return this.age - o.age;
            }

            return nameComp;
        }
    }
}
