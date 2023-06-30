package Helpers;

public class Concurrency {
    public static void pause(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}