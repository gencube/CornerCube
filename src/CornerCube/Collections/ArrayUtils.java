/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CornerCube.Collections;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * This class provides Ruby like methods to the java domain.
 * @author MatthewOng
 */
public class ArrayUtils {

    /*  DO NOT use such code as it will create runtime casting exception */
    private static <T> T[] makeError(int len, T value) {
        // creating using reflection seems to be hard to read.
        ArrayList<T> list = new ArrayList<T>(len);
        // DO NOT USE
        return (T[]) list.toArray(); //BUT, this will cause casting error!!!
    }

    public static <T> T[] make(int len, T value) {
        // creating using ArrayList<T> makes code better to read.
        T[] array = (T[]) java.lang.reflect.Array.newInstance(
                value.getClass(), len);
        for (int i = 0; i < len; i++) {
            array[i] = value;
        }
        return array;
    }

    public static <T> T[] make(T... values) {
        int len = values.length;
        T val = values[0];
        T[] array = (T[]) java.lang.reflect.Array.newInstance(
                val.getClass(), len);
        for (int i = 0; i < len; i++) {
            array[i] = values[i];
        }
        return array;
    }

    public static <T> boolean anyEmpty(T[] array) {
        if (array == null || array.length < 1) {
            return true;
        }
        boolean retVal = false;
        // check if all the content is null.
        for (T item : array) {
            if (item == null) {
                retVal = true;
            } else if (item instanceof String) {
                // if String check
                String str = (String) item;
                //str = str.trim();
                if (str.length() < 1) {
                    retVal = true;
                }
            }
        }
        return retVal;
    }

    public static <T> boolean allEmpty(T[] array) {
        if (array == null || array.length < 1) {
            return true;
        }
        boolean retVal = true;
        // check if all the content is null.
        for (T item : array) {
            if (item != null) {
                retVal = false;
            } else if (item instanceof String) {
                // if String check
                String str = (String) item;
                //str = str.trim();
                if (str.length() > 0) {
                    retVal = false;
                }
            } else if (item instanceof Number) {
                Number val = (Number) item;
                if (val.doubleValue() != 0) {
                    retVal = false;
                }
            }
        }
        return retVal;
    }

    public static HashList makeHashList(Object... values) {
        int len = values.length;
        HashList array = new HashList();
        for (int i = 0; i + 1 < len; i += 2) {
            Object key = values[i];
            Object value = values[i + 1];
            array.add(key.toString(), value);
        }
        return array;
    }

    public static HashList newHashList(Object[] values) {
        int len = values.length;
        HashList array = new HashList();
        for (int i = 0; i + 1 < len; i += 2) {
            Object key = values[i];
            Object value = values[i + 1];
            array.add(key.toString(), value);
        }
        return array;
    }

    public static HashMap makeHashMap(Object... values) {
        int len = values.length;
        HashMap array = new HashMap();
        for (int i = 0; i + 1 < len; i += 2) {
            Object key = values[i];
            Object value = values[i + 1];
            array.put(key, value);
        }
        return array;
    }

    public static HashMap newHashMap(Object[] values) {
        int len = values.length;
        HashMap array = new HashMap();
        for (int i = 0; i + 1 < len; i += 2) {
            Object key = values[i];
            Object value = values[i + 1];
            array.put(key, value);
        }
        return array;
    } 

    public static <T> T[] repeat(int count, T value) {
        // repeat same value is the same as make
        return make(count, value);
    }

    /**
     * Create a new array using the values within the param.
     * @param an array with values of type T
     * @return a new instance of array with all the values.
     */
    public static <T> T[] repeat(int count, T[] values) {
        int len = values.length * count;
        T val = values[0];
        T[] array = (T[]) java.lang.reflect.Array.newInstance(
                val.getClass(), len);
        for (int i = 0; i < len; i++) {
            array[i] = values[i % values.length];
        }
        return array;
    }

    /**
     * Create a new array using the values within the param.
     * @param an array with values of type T
     * @return a new instance of array with all the values.
     */
    public static <T> T[] rep(int count, T... values) {
        int len = values.length * count;
        T val = values[0];
        T[] array = (T[]) java.lang.reflect.Array.newInstance(
                val.getClass(), len);
        for (int i = 0; i < len; i++) {
            array[i] = values[i % values.length];
        }
        return array;
    }

    /**
     * Create a new array using the values within the param.
     * @param an array with values of type T
     * @return a new instance of array with all the values.
     */
    public static <T> T[] duplicate(T[] values) {
        T[] array = (T[]) java.lang.reflect.Array.newInstance(
                values.getClass(), values.length);
        int i = 0;
        for (T item : values) {
            array[i] = item;
            i++;
        }
        return array;
    }

    /**
     * Create a new array using the values within the param.
     * @param an array with values of type T
     * @return a new instance of array with all the values.
     */
    public static <T> T[] dup(T... values) {
        T[] array = (T[]) java.lang.reflect.Array.newInstance(
                values.getClass(), values.length);
        int i = 0;
        for (T item : values) {
            array[i] = item;
            i++;
        }
        return array;
    }

    public static <T> T[] unique(T[] values) {
        if (values == null) {
            return null; // no choice, noway to determine data type via reflection
        }
        HashMap map = new HashMap();
        ArrayList<T> list = new ArrayList<T>();
        for (T item : values) {
            if ("T".equals(map.get(item)) == false) {
                map.put(item, "T");
                list.add(item);
            }
        }
        int len = list.size();
        T val = values[0];
        T[] array = (T[]) java.lang.reflect.Array.newInstance(
                val.getClass(), len);
        for (int i = 0; i < len; i++) {
            array[i] = (T) list.get(i);
        }
        return array;
    }

    public static <T> T[] uniq(T... values) {
        HashMap map = new HashMap();
        ArrayList<T> list = new ArrayList<T>();
        for (T item : values) {
            if ("T".equals(map.get(item)) == false) {
                map.put(item, "T");
                list.add(item);
            }
        }
        int len = list.size();
        T val = values[0];
        T[] array = (T[]) java.lang.reflect.Array.newInstance(
                val.getClass(), len);
        for (int i = 0; i < len; i++) {
            array[i] = (T) list.get(i);
        }
        return array;
    }

    public static <T> T[] reverse(T[] values) {
        ArrayList<T> list = new ArrayList<T>();
        int len = values.length;
        for (int i = len - 1; i >= 0; i--) {
            list.add(values[i]);
        }
        int max = list.size();
        T val = values[0];
        T[] array = (T[]) java.lang.reflect.Array.newInstance(
                val.getClass(), max);
        for (int i = 0; i < max; i++) {
            array[i] = (T) list.get(i);
        }
        return array;
    }

    public static <T> void fills(T[] values, T value) {
        fills(values, value, 0, values.length);
    }

    public static <T> void fills(T[] values, T value, int pos) {
        fills(values, value, pos, values.length);
    }

    public static <T> void fills(T[] values, T value, int pos, int len) {
        int max = Math.min(values.length, len + pos);
        for (int i = pos; i < max; i++) {
            values[i] = value;
        }
    }

    public static <T> T[] remove(T[] values, T[] keys) {
        if (values == null) {
            return null;
        }
        ArrayList<T> list = new ArrayList<T>();
        HashMap maps = new HashMap();
        for (int i = 0; i < keys.length; i++) {
            maps.put(keys[i], "T");
        }
        for (int i = 0; i < values.length; i++) {
            T item = values[i];
            if ("T".equals(maps.get(item)) == false) {
                list.add(values[i]);
            }
        }
        int max = list.size();
        T val = values[0];
        T[] array = (T[]) java.lang.reflect.Array.newInstance(
                val.getClass(), max);
        for (int i = 0; i < max; i++) {
            array[i] = (T) list.get(i);
        }
        return array;
    }

    public static <T> T[] remove(T[] values, int[] indexes) {
        if (values == null) {
            return null;
        }
        ArrayList<T> list = new ArrayList<T>();
        HashMap maps = new HashMap();
        for (int i = 0; i < indexes.length; i++) {
            maps.put(new Integer(indexes[i]), "T");
        }
        for (int i = 0; i < values.length; i++) {
            Integer idx = new Integer(i);
            if ("T".equals(maps.get(idx)) == false) {
                list.add(values[i]);
            }
        }
        int max = list.size();
        T val = values[0];
        T[] array = (T[]) java.lang.reflect.Array.newInstance(
                val.getClass(), max);
        for (int i = 0; i < max; i++) {
            array[i] = (T) list.get(i);
        }
        return array;
    }

    public static <T> T[] delete(T[] values, int... indexes) {
        if (values == null) {
            return null;
        }
        ArrayList<T> list = new ArrayList<T>();        
        if (indexes.length == 1) {
            int idx = indexes[0];
            for (int i = 0; i < values.length; i++) {
                if (i != idx) {
                    list.add(values[i]);
                }
            }
        } else {
            HashMap maps = new HashMap();
            for (int i = 0; i < indexes.length; i++) {
                maps.put(new Integer(indexes[i]), "T");
            }
            for (int i = 0; i < values.length; i++) {
                Integer idx = new Integer(i);
                if ("T".equals(maps.get(idx)) == false) {
                    list.add(values[i]);
                }
            }
        }
        int max = list.size();
        T val = values[0];
        T[] array = (T[]) java.lang.reflect.Array.newInstance(
                val.getClass(), max);
        for (int i = 0; i < max; i++) {
            array[i] = (T) list.get(i);
        }
        return array;
    }

    /**
     * This method will shrink the size of the array by removing any item that
     * is of null.
     * @return a new array, T[], that does't have null.
     */
    public static <T> T[] shrink(T[] values) {
        return shrink(values, null);
    }

    /**
     * This method will shrink the size of the array by removing any item that
     * is of value.
     * @return a new array, T[], that does't have value.
     */
    public static <T> T[] shrink(T[] values, T value) {
        ArrayList<T> list = new ArrayList<T>();
        if (values == null) {
            return (T[]) java.lang.reflect.Array.newInstance(
                    value.getClass(), 0);
        }
        for (T item : values) {
            if (item == null || item == value) {
                continue;
            } else if (item != value && item.equals(value) == false) {
                list.add(item);
            }
        }
        int max = list.size();
        T val = values[0];
        T[] array = (T[]) java.lang.reflect.Array.newInstance(
                val.getClass(), max);
        for (int i = 0; i < max; i++) {
            array[i] = (T) list.get(i);
        }
        return array;
    }

    public static String[] toStringArray(String string, String separator) {
        return string.split(separator);
    }

    public static int[] toIntArray(String string, String separator) {
        String[] numStrs = string.split(separator);
        int[] nums = new int[numStrs.length];
        int i = 0;
        for (String aNum : numStrs) {
            try {
                nums[i] = Integer.parseInt(aNum);
            } catch (Exception e) {
                nums[i] = Integer.MIN_VALUE;
            }
            i++;
        }
        return nums;
    }

    public static long[] toLongArray(String string, String separator) {
        String[] numStrs = string.split(separator);
        long[] nums = new long[numStrs.length];
        int i = 0;
        for (String aNum : numStrs) {
            try {
                nums[i] = Long.parseLong(aNum);
            } catch (Exception e) {
                nums[i] = Long.MIN_VALUE;
            }
            i++;
        }
        return nums;
    }

    public static double[] toDoubleArray(String string, String separator) {
        String[] numStrs = string.split(separator);
        double[] nums = new double[numStrs.length];
        int i = 0;
        for (String aNum : numStrs) {
            try {
                nums[i] = Double.parseDouble(aNum);
            } catch (Exception e) {
                nums[i] = Double.MIN_VALUE;
            }
            i++;
        }
        return nums;
    }

    public static float[] toFloatArray(String string, String separator) {
        String[] numStrs = string.split(separator);
        float[] nums = new float[numStrs.length];
        int i = 0;
        for (String aNum : numStrs) {
            try {
                nums[i] = Float.parseFloat(aNum);
            } catch (Exception e) {
                nums[i] = Float.MIN_VALUE;
            }
            i++;
        }
        return nums;
    }

    public static boolean[] toBooleanArray(String string, String separator) {
        String[] valStrs = string.split(separator);
        boolean[] values = new boolean[valStrs.length];
        int i = 0;
        for (String aVal : valStrs) {
            try {
                values[i] = Boolean.parseBoolean(aVal);
            } catch (Exception e) {
                values[i] = Boolean.FALSE; // default to False
            }
            i++;
        }
        return values;
    }

    public static <T> String implode(T[] values, String separator) {
        StringBuilder sb = new StringBuilder();
        for (T item : values) {
            if (item instanceof String) {
                sb.append(item);
                sb.append(separator);
            } else if (item == null) {
                sb.append("null");
                sb.append(separator);
            } else {
                sb.append(item.toString());
                sb.append(separator);
            }
        }
        // remove the last ", "
        sb.delete(sb.length() - separator.length(), sb.length());

        return sb.toString();
    }

    public static <T> String toString(T[] values) {
        return toString(values, ", ");
    }

    public static <T> String toString(T[] values, String separator) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (T item : values) {
            if (item instanceof String) {
                sb.append(item);
                sb.append(separator);
            } else if (item == null) {
                sb.append("null");
                sb.append(separator);
            } else {
                sb.append(item.toString());
                sb.append(separator);
            }
        }
        // remove the last ", "
        sb.delete(sb.length() - separator.length(), sb.length());
        sb.append("]");
        return sb.toString();
    }

    public static <T> boolean isElementOf(T value, T[] values) {
        if (values == null || values.length < 1) {
            // empty list is always false;
            return false;
        }       
        HashMap<T,String> map = new HashMap<T,String>();
        // check if all the content is null.
        for (T item : values) {
            if (item != null) {
                map.put(item, "T");
            }
        }
        return "T".equals(map.get(value));
    }

    public static <T> boolean isWithin(T value, T... values) {
        if (values == null || values.length < 1) {
            // empty list is always false;
            return false;
        }
       
        // check if all the content is null.
        for (T item : values) {
            if (item != null) {
                if (item.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final static <T> List<T> newList(T[] array) {
        List<T> list = new LinkedList<T>(); // Default uses linkedlist to avoid out of memory error.
        int max = array.length;
        for (int i = 0; i < max; i++) {
            list.add(array[i]);
        }
        return list;
    }


    public static <T> boolean isSubsetOf(T[] setA, T[] setB) {
        List listA = newList(setA);
        List listB = newList(setB);
        return listB.containsAll(listA);
    }

    public static <T> boolean isEqual(T[] setA, T[] setB) {
        if (setA == setB) {
            return true;
        }
        if (allEmpty(setA)) {
            return false;
        }
        if (allEmpty(setB)) {
            return false;
        }
        if (setA.length != setB.length) {
            return false; // no way to be exactly equal
        }

        List<T> listA = newList(setA);
        List<T> listB = newList(setB);
        int max = listA.size();
        for (int i = 0; i < max; i++) {
            T valA = listA.get(i);
            if (listB.contains(valA) == false) {
                // if any one does not same, it returns false.
                return false;
            }
        }
        return true;
    }

    public static <T> boolean isIntersect(T[] setA, T[] setB) {
        List<T> list = intersect(setA, setB);
        return (list.size() > 0);
    }

    public static <T> List intersect(T[] setA, T[] setB) {
        List<T> listA = newList(setA);
        List list = new LinkedList();
        if (setA == setB) {
            return listA;
        }
        if (allEmpty(setA)) {
            return list;
        }
        if (allEmpty(setB)) {
            return list;
        }
        List<T> listB = newList(setB);
        int max = listA.size();
        for (int i = 0; i < max; i++) {
            T valA = listA.get(i);
            if (listB.contains(valA)) {
                // if any one does not same, it returns false.
                list.add(valA);
            }
        }
        return ListUtils.unique(list);
    }

    public static <T> List union(T[] setA, T[] setB) {
        List<T> listA = newList(setA);
        List list = new LinkedList();
        if (setA == setB) {
            return listA;
        }
        if (allEmpty(setA)) {
            return list;
        }
        if (allEmpty(setB)) {
            return list;
        }
        int max = listA.size();
        for (int i = 0; i < max; i++) {
            T valA = listA.get(i);
            list.add(valA);
        }
        List<T> listB = newList(setB);
        max = listB.size();
        for (int i = 0; i < max; i++) {
            T valB = listB.get(i);
            if (listA.contains(valB) == false) {
                // if any one does not same, it is added because its union.
                list.add(valB);
            }
        }
        return ListUtils.unique(list);
    }

    public static <T> boolean isDiff(T[] setA, T[] setB) {
        return !isEqual(setA, setB);
    }

    public static <T> List diff(T[] setA, T[] setB) {
        List<T> listA = newList(setA);
        List list = new LinkedList();
        if (setA == setB) {
            return listA;
        }
        if (allEmpty(setA)) {
            return list;
        }
        if (allEmpty(setB)) {
            return list;
        }
        List<T> listB = newList(setB);
        int max = listA.size();
        for (int i = 0; i < max; i++) {
            T valA = listA.get(i);
            if (listB.contains(valA) == false) {
                // if any one does not same, it is added because its diff.
                list.add(valA);
            }
        }
        max = listB.size();
        for (int i = 0; i < max; i++) {
            T valB = listB.get(i);
            if (listA.contains(valB) == false) {
                // if any one does not same, it is added because its diff.
                list.add(valB);
            }
        }
        return list;
    }

    public static <T> void dump(T[] values) {
        dump(values, System.out);
    }

    public static <T> void dump(T[] values, PrintStream out) {
        out.println(toString(values, ", "));
        out.flush();
    }

    public static void prn(String msg) {
        System.out.print(msg);
    }

    public static void prnln(String msg) {
        System.out.println(msg);
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {
        String[] strings2 = ArrayUtils.make(5, "abcd");
        String[] strings1 = ArrayUtils.make("abc", "def", "ghi", "ght",
                "ghi", "tzr", null, "tar");

        Integer[] nums1 = ArrayUtils.make(55, 66, 77);
        Integer[] nums2 = ArrayUtils.make(5, (int) 333);

        Integer[] numsA = ArrayUtils.make(11, 22, 44, 34, 76, 55, 66, 77);
        Integer[] numsB = ArrayUtils.make(22, 33, 55, 88, 99, 55, 66, 77);
        Integer[] numsC = ArrayUtils.make(55, 76, 22);
        Integer[] numsD = ArrayUtils.make(55, 76, 22);

        prn("nums1:");
        dump(nums1);
        prn("nums2:");
        dump(nums2);
        prn("numsA:");
        dump(numsA);
        prn("numsB:");
        dump(numsB);
        prn("numsC:");
        dump(numsC);
        prn("numsD:");
        dump(numsD);

        prnln("55 in numsC:" + isElementOf(55, numsC));
        prnln("55 within 55,76,22:" + isWithin(55, 55, 76, 22));
        prnln("53 within 55,76,22:" + isWithin(53, 55, 76, 22));
        prnln("nums1 != numsC:" + isEqual(nums1, numsC));
        prnln("numsC == numsC:" + isEqual(numsC, numsC));
        prnln("numsD == numsC:" + isEqual(numsD, numsC));
        prnln("numsC sub numsA:" + isSubsetOf(numsC, numsA));
        prnln("numsA sub numsC:" + isSubsetOf(numsA, numsC));
        prnln("numsA sub numsC:" + isSubsetOf(numsA, numsC));
        prnln("numsC intersect numsA:" + isIntersect(numsC, numsA));
        prn("numsA                :");
        dump(numsA);
        prn("numsC                :");
        dump(numsC);
        prn("numsC intersect numsA:");
        ListUtils.dump(intersect(numsC, numsA));
        prn("numsB                :");
        dump(numsB);
        prn("numsB intersect numsA:");
        ListUtils.dump(intersect(numsB, numsA));
        prn("numsB intersect numsC:");
        ListUtils.dump(intersect(numsB, numsC));
        prn("numsC intersect numsB:");
        ListUtils.dump(intersect(numsC, numsB));
        prnln("nums2 intersect numsA:" + isIntersect(nums2, numsA));
        prnln("===========================================================");
        prn("numsA                :");
        dump(numsA);
        prn("numsB                :");
        dump(numsB);
        prn("numsC                :");
        dump(numsC);
        prn("numsB intersect numsA:");
        ListUtils.dump(intersect(numsB, numsA));
        prn("numsB diff numsA     :");
        ListUtils.dump(diff(numsB, numsA));
        prn("numsC diff numsA     :");
        ListUtils.dump(diff(numsC, numsA));
        prn("numsC diff numsB     :");
        ListUtils.dump(diff(numsC, numsB));
        prnln("*************************************************************");
        prn("numsA                :");
        dump(numsA);
        prn("numsB                :");
        dump(numsB);
        prn("numsC                :");
        dump(numsC);
        prn("numsB intersect numsA:");
        ListUtils.dump(intersect(numsB, numsA));
        prn("numsB diff numsA     :");
        ListUtils.dump(diff(numsB, numsA));
        prn("numsB union numsA    :");
        ListUtils.dump(union(numsB, numsA));

        /*
        System.out.print("strings2:");
        dump(strings2);
        System.out.print("nums1:");
        dump(nums1);
        System.out.print("nums2:");
        dump(nums2);
        System.out.print(">>>strings1:");
        dump(strings1);

        String[] ret = ArrayUtils.uniq(strings1);
        System.out.print("uniq:");
        dump(ret);

        ret = ArrayUtils.shrink(strings1);
        System.out.print("shrink:");
        dump(ret);

        ret = ArrayUtils.shrink(strings1, "ghi");
        System.out.print("shrink(ghi):");
        dump(ret);

        ret = ArrayUtils.reverse(strings1);
        System.out.print("reverse:");
        dump(ret);

        ArrayUtils.fills(ret, "eee", 2, 4);
        System.out.print("fills(ret, eee, 2,4):");
        dump(ret);
         */
    }
}
