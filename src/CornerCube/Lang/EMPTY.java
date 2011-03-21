/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CornerCube.Lang;

import java.util.*;
import CornerCube.Collections.HashList;


/**
 * Provide system wide with single instance of empty array of all primitives
 * type.
 * @author MatthewOng
 */
public interface EMPTY {

    public final static String[] STRING_ARRAY = new String[0];
    public final static char[] CHAR_ARRAY = new char[0];
    public final static byte[] BYTE_ARRAY = new byte[0];
    public final static short[] SHORT_ARRAY = new short[0];
    public final static int[] INT_ARRAY = new int[0];
    public final static long[] LONG_ARRAY = new long[0];
    public final static double[] DOUBLE_ARRAY = new double[0];
    public final static float[] FLOAT_ARRAY = new float[0];
    public final static boolean[] BOOL_ARRAY = new boolean[0];

    public final static HashList HASH_LIST = new HashList();
     public final static List LINKED_LIST =new LinkedList();
}
