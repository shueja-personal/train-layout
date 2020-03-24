package util;

public class MathUtil{
    public static double clamp(double val, double low, double high){
        return Math.min(Math.max(low, val), high);
    }
    public static double clamp(int val, int low, int high){
        return Math.min(Math.max(low, val), high);
    }
}