package org.murillo.fluentq.impl;

import org.murillo.fluentq.ListQ;

public class ListQFuncs{

    public static byte[] toByteArray(ListQ<? extends Number> list) {
        byte[] result = new byte[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i).byteValue();
        }
        return result;
    }

    public static short[] toShortArray(ListQ<? extends Number> list) {
        short[] result = new short[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i).shortValue();
        }
        return result;
    }

    public static int[] toIntArray(ListQ<? extends Number> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i).intValue();
        }
        return result;
    }

    public static long[] toLongArray(ListQ<? extends Number> list) {
        long[] result = new long[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i).longValue();
        }
        return result;
    }

    public static float[] toFloatArray(ListQ<? extends Number> list) {
        float[] result = new float[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i).floatValue();
        }
        return result;
    }

    public static double[] toDoubleArray(ListQ<? extends Number> list) {
        double[] result = new double[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i).doubleValue();
        }
        return result;
    }

    public static boolean[] toBooleanArray(ListQ<Boolean> list) {
        boolean[] result = new boolean[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static char[] toCharArray(ListQ<Character> list) {
        char[] result = new char[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static byte[] toByteArray(ListQ<? extends Number> list, byte nullValue) {
        byte[] result = new byte[list.size()];
        for (int i = 0; i < result.length; i++) {
            Number get = list.get(i);
            if (get == null) {
                result[i] = nullValue;
            } else {
                result[i] = list.get(i).byteValue();
            }
        }
        return result;
    }

    public static short[] toShortArray(ListQ<? extends Number> list, short nullValue) {
        short[] result = new short[list.size()];
        for (int i = 0; i < result.length; i++) {
            Number get = list.get(i);
            if (get == null) {
                result[i] = nullValue;
            } else {
                result[i] = list.get(i).shortValue();
            }
        }
        return result;
    }

    public static int[] toIntArray(ListQ<? extends Number> list, int nullValue) {
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            Number get = list.get(i);
            if (get == null) {
                result[i] = nullValue;
            } else {
                result[i] = list.get(i).intValue();
            }
        }
        return result;
    }

    public static long[] toLongArray(ListQ<? extends Number> list, long nullValue) {
        long[] result = new long[list.size()];
        for (int i = 0; i < result.length; i++) {
            Number get = list.get(i);
            if (get == null) {
                result[i] = nullValue;
            } else {
                result[i] = list.get(i).longValue();
            }
        }
        return result;
    }

    public static float[] toFloatArray(ListQ<? extends Number> list, float nullValue) {
        float[] result = new float[list.size()];
        for (int i = 0; i < result.length; i++) {
            Number get = list.get(i);
            if (get == null) {
                result[i] = nullValue;
            } else {
                result[i] = list.get(i).floatValue();
            }
        }
        return result;
    }

    public static double[] toDoubleArray(ListQ<? extends Number> list, double nullValue) {
        double[] result = new double[list.size()];
        for (int i = 0; i < result.length; i++) {
            Number get = list.get(i);
            if (get == null) {
                result[i] = nullValue;
            } else {
                result[i] = list.get(i).doubleValue();
            }
        }
        return result;
    }

    public static boolean[] toBooleanArray(ListQ<Boolean> list, boolean nullValue) {
        boolean[] result = new boolean[list.size()];
        for (int i = 0; i < result.length; i++) {
            Boolean get = list.get(i);
            if (get == null) {
                result[i] = nullValue;
            } else {
                result[i] = list.get(i);
            }
        }
        return result;
    }

    public static char[] toCharArray(ListQ<Character> list, char nullValue) {
        char[] result = new char[list.size()];
        for (int i = 0; i < result.length; i++) {
            Character get = list.get(i);
            if (get == null) {
                result[i] = nullValue;
            } else {
                result[i] = list.get(i);
            }
        }
        return result;
    }
}
