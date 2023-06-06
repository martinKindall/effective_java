package org.walruscode.effective_java.chap_5;

import java.util.HashSet;
import java.util.Set;

public class RawTypes {

    public static void main(String[] args) {

        Set<String> someSet = new HashSet<>();
        someSet.add("cat");

        System.out.println("There are " + setCounter(someSet) + " elements in the set");

        // raw types collections accept insertions
        Set<Integer> numbers = new HashSet<>();
        numbers.add(15);

        modifyNumbers(numbers);
        cannotModifyNumbers(numbers);
    }

    private static int setCounter(Object someSet) {

        // pattern variables
        if (someSet instanceof Set<?> aSet) {
            return aSet.size();
        }

        // Previous Java 16
//        if (someSet instanceof Set) {
//            Set<?> aSet = (Set<?>) someSet;
//            return aSet.size();
//        }

        throw new ClassCastException();
    }

    // raw type - don't use this
    private static void modifyNumbers(Set numbers) {
        numbers.add("Hi there");  // corrupting the set
    }

    // unbounded wildcards are safe and raw types are not
    private static void cannotModifyNumbers(Set<?> numbers) {
        // numbers.add("Hi there");  // cannot compile
    }
}
