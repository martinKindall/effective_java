package org.walruscode.effective_java.chap_4;

public class InstrumentedJumper implements Jumper {

    private int jumpCount = 0;

    private final Jumper jumper;


    public static void main(String[] args) {
        InstrumentedJumper myFrog = new InstrumentedJumper(new Frog());

        System.out.println(myFrog.getJumpCount());

        jumpLogic(myFrog);

        System.out.println(myFrog.getJumpCount());
    }

    public static void jumpLogic(Jumper jumper) {
        jumper.jump();

        System.out.println("Processing...");

        jumper.jump();
    }

    public InstrumentedJumper(Jumper jumper) {
        this.jumper = jumper;
    }

    public void jump() {
        jumper.jump();
        jumpCount++;
    }

    public int getJumpCount() {
        return jumpCount;
    }
}

interface Jumper {
    void jump();
}

class Frog implements Jumper {

    @Override
    public void jump() {
        System.out.println("The frog jumped");
    }
}
