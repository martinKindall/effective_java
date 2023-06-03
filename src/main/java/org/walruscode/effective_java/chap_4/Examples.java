package org.walruscode.effective_java.chap_4;

import java.util.Stack;

public class Examples {

    public static void main(String[] args) {

        // historically, Stack extends Vector, but it should've used Composition instead of inheritance
        // as conceptually a stack is not a vector, thus a vector is merely an implementation detail in this case
        Stack<Integer> stack = new Stack<>();
    }
}
