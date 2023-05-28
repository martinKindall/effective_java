package org.walruscode.effective_java.chap_2.entities;

final class PuppyDog implements Dog {

    @Override
    public String bark() {
        return "Woof woof";
    }
}
