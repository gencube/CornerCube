/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CornerCube.junitLib;

import java.util.Date;

/**
 *
 * @author MatthewOng
 */
public class JUnitClassTester {

    public static void prn(String msg) {
        System.out.print(msg);
        System.out.flush();
    }

    public static void prnln(String msg) {
        System.out.println(msg);
        System.out.flush();
    }

    public static void err(String msg) {
        System.err.print(msg);
        System.err.flush();
    }

    public static void errln(String msg) {
        System.err.println(msg);
        System.err.flush();
    }

    public static String getRandomString() {
        return "";
    }

    public static int getRandomInt() {
        return 0;
    }

    public static long getRandomLong() {
        return 0L;
    }

    public static Date getRandomDate() {
        long milis = getRandomLong();
        return new java.util.Date(milis);
    }

    //public static

}
