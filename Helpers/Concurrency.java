package Helpers;

public class Concurrency {
    //Pause the thread for a given time
    public static void pause(long time) {
        try {
            //InterruptedException is POTENTIALLY thrown (public void sleep(long time) throws InterruptedException) - handle it
            Thread.sleep(time);
        } catch (InterruptedException ie) {
            //NEVER EVER EVER silence and leave exceptions of this type unhandled - EVER!!!
            ie.printStackTrace();
        }
    }
}