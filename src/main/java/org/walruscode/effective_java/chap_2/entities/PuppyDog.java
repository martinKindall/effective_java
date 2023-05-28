package org.walruscode.effective_java.chap_2.entities;

enum PuppyDog implements Dog {
    INSTANCE;

    @Override
    public String bark() {
        return "Woof woof";
    }
}
