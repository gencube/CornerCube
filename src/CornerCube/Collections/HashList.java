/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CornerCube.Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * This collections class allow to be used like a LinkedList and also a HashMap.
 * Such collection is very useful for storing datasets that is similar to a SQL
 * table row. You may refers to it using name or it index sequence. You may also
 * use this to similar model of data once out of its data source and keep both its
 * name indexing and also sequence.
 * @author MatthewOng
 */
public class HashList<T> implements java.io.Serializable {

    private LinkedList<String> mKeys = null;
    private HashMap mKeyIdxs = null;
    private HashMap<String, T> mKeyValHash = null;

    public HashList() {
        mKeys = new LinkedList();
        mKeyIdxs = new HashMap();
        mKeyValHash = new HashMap<String, T>();
    }

    public void clear() {
        mKeys.clear();
        mKeyIdxs.clear();
        mKeyValHash.clear();
    }

    public void add(String aKey, T aValue) {
        mKeys.add(aKey);
        String idx = "" + (mKeys.size() - 1);
        mKeyIdxs.put(aKey, idx);
        mKeyValHash.put(aKey, aValue);
    }

    public boolean contains(T aValue) {
        return mKeyValHash.containsValue(aValue);
    }

    public void remove(int idx) {
        String aKey = (String) mKeys.remove(idx);
        mKeyIdxs.remove(aKey);
        mKeyValHash.remove(aKey);
    }

    public void remove(String aKey) {
        String idxStr = (String) mKeyIdxs.remove(aKey);
        int idx = Integer.parseInt(idxStr);
        mKeys.remove(idx);
        mKeyValHash.remove(aKey);
    }

    public String getKey(int idx) {
        return (String) mKeys.get(idx);
    }

    public String getKey(T uniqueVal) {
        int max = getSize();
        for (int i = 0; i < max; i++) {
            T thisVal = getValue(i);
            if (thisVal.equals(uniqueVal)) {
                return getKey(i);
            }
        }
        return "";
    }

    public int getIndex(T uniqueVal) {
        int max = getSize();
        for (int i = 0; i < max; i++) {
            T thisVal = getValue(i);
            if (thisVal.equals(uniqueVal)) {
                return i;
            }
        }
        return -1;
    }

    public T get(int idx) {
        return getValue(idx);
    }

    public T getValue(int idx) {
        String aKey = (String) mKeys.get(idx);
        return mKeyValHash.get(aKey);
    }

    public T get(String aKey) {
        return getValue(aKey);
    }

    public T getValue(String aKey) {
        return mKeyValHash.get(aKey);
    }

    public int length() {
        return mKeys.size();
    }

    public int size() {
        return mKeys.size();
    }

    public int getSize() {
        return mKeys.size();
    }

    public T[] toArray() {
        int len = length();
        if (len < 1) {
            return null;
        }
        T value = get(0);
        T[] array = (T[]) java.lang.reflect.Array.newInstance(
                value.getClass(), len);
        for (int i = 0; i < len; i++) {
            array[i] = get(i);
        }
        return array;
    }

    public HashMap<String, T> getHashMap() {
        return mKeyValHash;
    }

    public LinkedList<T> getLinkedList() {
        LinkedList<T> list = new LinkedList<T>();
        int max = getSize();
        for (int i = 0; i < max; i++) {
            list.add(getValue(i));
        }
        return list;
    }

    public ArrayList<T> getArrayList() {
        ArrayList<T> list = new ArrayList<T>();
        int max = getSize();
        for (int i = 0; i < max; i++) {
            list.add(getValue(i));
        }
        return list;
    }
}
