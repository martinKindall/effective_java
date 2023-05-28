package org.walruscode.effective_java.chap_2.entities;

/**
 * This example shows the advantage of using static methods as factories
 * The end user doesn't have to know the internals of PuppyDog.
 */
public interface Dog {

    String bark();

    static Dog create() {
        return new PuppyDog();
    }
}
