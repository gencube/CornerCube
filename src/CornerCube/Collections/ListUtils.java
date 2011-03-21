/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CornerCube.Collections;

import CornerCube.Lang.EMPTY;
import java.io.PrintStream;
import java.util.*;

/**
 *
 * @author MatthewOng
 */
public class ListUtils {

    public static <T> List<T> makeList(int length, T value) {
        LinkedList<T> list = new LinkedList<T>();
        for (int i = 0; i < length; i++) {
            list.add(value);
        }
        return list;
    }

    public static <T> List<T> makeList(T... values) {
        int len = values.length;
        LinkedList<T> list = new LinkedList<T>();
        for (int i = 0; i < len; i++) {
            list.add(values[i]);
        }
        return list;
    }

    public static <T> List<T> newList(T[] array) {
        List<T> list = new LinkedList<T>(); // Default uses linkedlist to avoid out of memory error.
        int max = array.length;
        for (int i = 0; i < max; i++) {
            list.add(array[i]);
        }
        return list;
    }

    public static <T> List<T> rep(int count, T... values) {
        int len = values.length * count;
        List<T> list = new LinkedList<T>();
        for (int i = 0; i < len; i++) {
            list.add(values[i % values.length]);
        }
        return list;
    }

    public static <T> List<T> repeat(int count, T value) {
        return makeList(count, value);
    }

    public static <T> List<T> repeat(int count, T[] values) {
        int len = values.length * count;
        LinkedList<T> list = new LinkedList<T>();
        for (int i = 0; i < len; i++) {
            list.add(values[i % values.length]);
        }
        return list;
    }

    public static <T> List<T> delete(List<T> values, int... indexes) {
        return remove(values, indexes);
    }

    public static <T> List<T> remove(List<T> values, int... indexes) {
        if (values == null) {
            return null;
        }
        LinkedList<T> list = new LinkedList<T>();
        int max = values.size();
        if (indexes.length == 1) {
            int idx = indexes[0];
            for (int i = 0; i < max; i++) {
                if (i != idx) {
                    list.add(values.get(i));
                }
            }
        } else {
            HashMap<Integer, String> maps = new HashMap<Integer, String>();
            for (int i = 0; i < indexes.length; i++) {
                maps.put(new Integer(indexes[i]), "T");
            }
            for (int i = 0; i < max; i++) {
                Integer idx = new Integer(i);
                if ("T".equals(maps.get(idx)) == false) {
                    list.add(values.get(i));
                }
            }
        }
        return list;
    }

    public static <T> boolean anyEmpty(List<T> list) {
        if (list == null || list.size() < 1) {
            return true;
        }
        boolean retVal = false;
        // check if all the content is null.
        for (T item : list) {
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

    public static <T> List<T> shrink(List<T> values, T value) {
        LinkedList<T> list = new LinkedList<T>();
        for (T item : values) {
            if (item == null || item == value) {
                continue;
            } else if (item != value && item.equals(value) == false) {
                list.add(item);
            }
        }
        return list;
    }

    /**
     * Works more or less like the subString within java.lang.String class.
     * @return a List of values from that range of position.
     */
    public static <T> List<T> subList(List<T> list, int beginIdx, int endIdx) {
        if (list == null || beginIdx < 0
                || endIdx < 0 || endIdx <= beginIdx || endIdx >= list.size()) {
            return EMPTY.LINKED_LIST;
        }
        List<T> retVal = new LinkedList<T>();
        for (int i = beginIdx; i <= endIdx; i++) {
            T val = list.get(i);
            retVal.add(val);
        }
        return retVal;
    }

    public static <T> List<T> subList(List<T> list, T fromValue, T toValue) {
        if (list == null || fromValue == null
                || toValue == null) {
            return EMPTY.LINKED_LIST;
        }
        int beginIdx = list.indexOf(fromValue);
        int endIdx = list.indexOf(toValue);
        List<T> retVal = new LinkedList<T>();
        for (int i = beginIdx; i <= endIdx; i++) {
            T val = list.get(i);
            retVal.add(val);
        }
        return retVal;
    }

    public static <T> boolean allEmpty(List<T> values) {
        if (values == null || values.size() < 1) {
            return true;
        }
        // check if all the content is null.
        for (T item : values) {
            if (item != null) {
                return false;
            } else if (item instanceof String) {
                // if String check
                String str = (String) item;
                //str = str.trim();
                if (str.length() > 0) {
                    return false;
                }
            } else if (item instanceof Number) {
                Number val = (Number) item;
                if (val.doubleValue() != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check if any element that match with value.
     * @return return true if there is a single element that match with value.
     */
    public static final boolean containValue(List list, final Object value) {
        if (list == null || value == null) {
            return false; // if any one of the variable is null.
        }
        TrinarySearch hopper = new TrinarySearch() {

            @Override
            public void runOperation(int i, Object objI, int j, Object objJ, int k, Object objK, int l, Object objL) {
                if (value.equals(objI) || value.equals(objJ)
                        || value.equals(objK) || value.equals(objL)) {
                    isStop = true;
                    retValBool = true;
                }
            }
        };
        hopper.search(list); // run the code
        return hopper.retValBool;
    }

    public static final List indexesOf(List list, final Object value) {
        if (list == null || value == null) {
            return EMPTY.LINKED_LIST;// if any one of the variable is null.
        }
        final List retList = new LinkedList();
        final HashMap map = new HashMap();
        TrinarySearch hopper = new TrinarySearch() {

            private void addUnique(int idx) {
                Integer idxInt = new Integer(idx);
                if ("T".equals(map.get(idxInt)) == false) {
                    map.put(idxInt, "T");
                    retList.add(idxInt);
                }
            }
            // ### NEED to check this method to see

            @Override
            public void runOperation(int i, Object objI, int j, Object objJ, int k, Object objK, int l, Object objL) {
                if (value.equals(objI)) {
                    addUnique(i);
                }
                if (value.equals(objJ)) {
                    addUnique(j);
                }
                if (value.equals(objK)) {
                    addUnique(k);
                }
                if (value.equals(objL)) {
                    addUnique(l);
                }
            }
        };
        hopper.search(list); // run the code
        Collections.sort(retList);
        return retList;
    }

    public static <T> boolean isWithin(T value, List<T> values) {
        if (values == null || values.size() < 1) {
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

    public static <T> boolean isIntersect(List<T> setA, List<T> setB) {
        List<T> list = intersect(setA, setB);
        return (list.size() > 0);
    }

    public static <T> List<T> intersect(List<T> setA, List<T> setB) {
        List<T> listA = setA;
        List<T> list = new LinkedList<T>();
        if (setA == setB) {
            return listA;
        }
        if (allEmpty(setA)) {
            return list;
        }
        if (allEmpty(setB)) {
            return list;
        }
        List<T> listB = setB;
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

    public static <T> boolean isDiff(List<T> listA, List<T> listB) {
        return !isEqual(listA, listB);
    }

    public static boolean isSubsetOf(List listA, List listB) {
        return listB.containsAll(listA);
    }

    public static <T> boolean isEqual(List<T> listA, List<T> listB) {
        if (listA == listB) {
            return true;
        }
        if (allEmpty(listA)) {
            return false;
        }
        if (allEmpty(listB)) {
            return false;
        }
        if (listA.size() != listB.size()) {
            return false; // no way to be exactly equal
        }
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

    public static <T> void fills(List<T> values, T value) {
        fills(values, value, 0, values.size());
    }

    public static <T> void fills(List<T> values, T value, int pos) {
        fills(values, value, pos, values.size());
    }

    public static <T> void fills(List<T> values, T value, int pos, int len) {
        if (values == null || values.size() < 1) {
            return; // does nothing
        }
        int max = Math.min(values.size(), len + pos);
        for (int i = pos; i < max; i++) {
            values.set(i, value);
        }
    }

    public static <T> boolean isElementOf(T value, List<T> values) {
        if (values == null || values.size() < 1) {
            // empty list is always false;
            return false;
        }
        HashMap<T, String> map = new HashMap<T, String>();
        // check if all the content is null.
        for (T item : values) {
            if (item != null) {
                map.put(item, "T");
            }
        }
        return "T".equals(map.get(value));
    }

    /**
     * Count the number of element(s) that match value.
     * @return the number of element that match value.
     */
    public static final int count(List list, final Object value) {
        if (list == null) {
            return 0; // if any one of the variable is null.
        }
        TrinarySearch hopper = new TrinarySearch() {

            @Override
            public void runOperation(int i, Object objI, int j, Object objJ, int k, Object objK, int l, Object objL) {
                if (value.equals(objI) || value.equals(objJ)
                        || value.equals(objK) || value.equals(objL)) {
                    retValInt++;
                }
            }
        };
        hopper.retValInt = 0;
        hopper.search(list); // run the code
        return hopper.retValInt;
    }

    /**
     * Remove element from list that matches anyone of the values.
     * @return elements that does not match any values.
     */
    public static final List remove(List list, Object[] values) {
        if (list == null || values == null) {
            return EMPTY.LINKED_LIST; // if any one of the variable is null.
        }
        List retList = new LinkedList();
        // Using this to avoid having to loop in i * j times.
        HashMap map = new HashMap();
        for (Object val : values) {
            map.put(val, "T");
        }
        for (Object obj : list) {
            if ("T".equals(map.get(obj)) == false) {
                retList.add(obj);
            }
        }
        return retList;
    }

    public static final List replaceFirst(List list, Object oldVal, Object newVal) {
        if (list == null || oldVal == null || newVal == null) {
            return EMPTY.LINKED_LIST; // if any one of the variable is null.
        }
        List retList = new LinkedList();
        boolean isFirst = false;
        // no choice, need to loop linear manner.
        for (Object obj : list) {
            if (list.equals(oldVal) && isFirst == false) {
                retList.add(newVal);
                isFirst = true;
            } else {
                retList.add(obj);
            }
        }
        return retList;
    }

    public static final List replace(List list, Object oldVal, Object newVal) {
        if (list == null || oldVal == null || newVal == null) {
            return EMPTY.LINKED_LIST; // if any one of the variable is null.
        }
        List retList = new LinkedList();
        for (Object obj : list) {
            if (list.equals(oldVal)) {
                retList.add(newVal);
            } else {
                retList.add(obj);
            }
        }
        return retList;
    }

    public static <T> List<T> reverse(List<T> values) {
        if(values==null || values.size()<1){
             return EMPTY.LINKED_LIST;
        }
        LinkedList<T> list = new LinkedList<T>();
        int len = values.size();
        for (int i = len - 1; i >= 0; i--) {
            list.add(values.get(i));
        }

        return list;
    }

    /**
     * Trim away all null values within the list.
     * @return all non-null value objects.
     */
    public static final List trim(List list) {
        if (list == null) {
            return EMPTY.LINKED_LIST; // if any one of the variable is null.
        }
        List retList = new LinkedList();
        for (Object obj : list) {
            if (obj != null) {
                retList.add(obj);
            }
        }
        return retList;
    }

    public static <T> String toString(List<T> values, String separator) {
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

    public static <T> List<T> union(List<T> setA, List<T> setB) {
        List<T> listA = setA;
        List<T> list = new LinkedList<T>();
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
        List<T> listB = setB;
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


    public static <T> List<T> unique(List<T> values) {
        if (values == null) {
            return null; // no choice, noway to determine data type via reflection
        }
        HashMap<T, String> map = new HashMap<T, String>();
        LinkedList<T> list = new LinkedList<T>();
        for (T item : values) {
            if ("T".equals(map.get(item)) == false) {
                map.put(item, "T");
                list.add(item);
            }
        }
        return list;
    }

    public static void dump(List values) {
        dump(values, System.out);
    }

    public static void dump(List values, PrintStream out) {
        out.println(toString(values, ", "));
        out.flush();
    }

    /**
     * @return return a list of component that are different
     */
    public static <T> List<T> diff(List<T> setA, List<T> setB) {
        if (setA == setB) {
            return EMPTY.LINKED_LIST;
        }
        if (allEmpty(setA)) {
            return EMPTY.LINKED_LIST;
        }
        if (allEmpty(setB)) {
            return EMPTY.LINKED_LIST;
        }
        List<T> list = new LinkedList<T>();
        int max = setA.size();
        for (int i = 0; i < max; i++) {
            T valA = setA.get(i);
            if (setB.contains(valA) == false) {
                // if any one does not same, it is added because its diff.
                list.add(valA);
            }
        }
        max = setB.size();
        for (int i = 0; i < max; i++) {
            T valB = setB.get(i);
            if (setA.contains(valB) == false) {
                // if any one does not same, it is added because its diff.
                list.add(valB);
            }
        }
        return list;
    }

    public static List same(List a, List b) {
        return EMPTY.LINKED_LIST;
    }
}
