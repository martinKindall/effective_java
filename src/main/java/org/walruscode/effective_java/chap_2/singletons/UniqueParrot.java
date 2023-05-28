package org.walruscode.effective_java.chap_2.singletons;

public enum UniqueParrot {
    INSTANCE;

    public String greet() {
        return "Hi, my name is Polly";
    }
}
