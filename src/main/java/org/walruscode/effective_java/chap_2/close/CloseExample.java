package org.walruscode.effective_java.chap_2.close;

public class CloseExample {

    public static void main(String[] args) {

        try(MyResource resource = new MyResource()) {
            resource.use();
        }
    }

    static class MyResource implements AutoCloseable {

        public void use() {}

        @Override
        public void close() {
            System.out.println("Closing resource");
        }
    }
}
