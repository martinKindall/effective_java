package org.walruscode.effective_java.chap_3.equals_and_hash;

public class NonAsymmetric {

    public static void main(String[] args) {
        ColorPoint cp = new ColorPoint();
        Point p = new Point();

        // reflection is ok
        System.out.println(p.equals(p));
        System.out.println(cp.equals(cp));

        // but symmetry is not ok
        System.out.println(cp.equals(p));
        System.out.println(p.equals(cp));
    }

    static class Point {
        int x, y;

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point)) return false;

            Point p = (Point) obj;

            return x == p.x && y == p.y;
        }
    }

    static class ColorPoint extends Point {
        int x, y;
        String color = "somecolor";

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ColorPoint)) return false;

            ColorPoint p = (ColorPoint) obj;

            return super.equals(obj) && color.equals(p.color);
        }
    }
}
