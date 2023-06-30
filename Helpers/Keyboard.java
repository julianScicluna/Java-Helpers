package Helpers;

import java.io.*;

public class Keyboard
{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static String readString() {
        try {
            return br.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }
    
    public static int readInt() {
        return Integer.parseInt(readString());
    }
    
    public static byte readByte(){
        return Byte.parseByte(readString());
    }

    public static short readShort(){
        return Short.parseShort(readString());
    }

    public static long readLong(){
        return Long.parseLong(readString());
    }

    public static float readFloat(){
        return Float.parseFloat(readString());
    }

    public static double readDouble(){
        return Double.parseDouble(readString());
    }

    public static char readChar(){
        return readString().charAt(0);
    }

    public static boolean readBoolean(){
        return Boolean.parseBoolean(readString());
    }
}