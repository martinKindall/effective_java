package org.walruscode.effective_java.chap_2.caches;

import java.util.Map;
import java.util.WeakHashMap;

public class CacheEx1 {

    public static void main(String[] args) {
        WeakHashMap<Data, String> map = new WeakHashMap<>();
        Data someDataObject = new Data("foo");
        map.put(someDataObject, someDataObject.value);
        System.out.println("map contains someDataObject ? " + map.containsKey(someDataObject));

        // -- now make someDataObject elligible for garbage collection...
        // do an experiment and try commenting the following line and compare results
        someDataObject = null;

        System.gc();

        for (int i = 0; i < 10000; i++) {
            if (map.size() != 0) {
                System.out.println("At iteration " + i + " the map still holds the reference: " + map.containsKey(new Data("foo")));
            } else {
                System.out.println("somDataObject has finally been garbage collected at iteration " + i + ", hence the map is now empty");
                break;
            }
        }
    }

    static class Data {
        String value;
        Data(String value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;

            if (o instanceof Data) {
                return value.equals(((Data) o).value);
            }

            return false;
        }

        @Override
        public int hashCode() {
            return value.hashCode();
        }
    }

    void example() {
        Map<String, String> example = new WeakHashMap<>();

        String somedata = new String("foo");
        example.put(somedata, "foo");

        System.out.println("example contains somedata: " + example.get("foo"));
        System.out.println("example size: " + example.size());

        somedata = null;

        System.gc();

        System.out.println("example contains somedata: " + example.get("foo"));
        System.out.println("example size: " + example.size());
    }
}
