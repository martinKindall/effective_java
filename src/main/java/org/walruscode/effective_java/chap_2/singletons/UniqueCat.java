package org.walruscode.effective_java.chap_2.singletons;

public class UniqueCat {

    public static final UniqueCat INSTANCE = new UniqueCat();

    private UniqueCat() {
        if (INSTANCE != null) {
            throw new RuntimeException("Already instantiated");
        }
    }

    public String greet() {
        return "Meow";
    }
}
