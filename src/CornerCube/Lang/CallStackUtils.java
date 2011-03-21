/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CornerCube.Lang;

/**
 * Use this simple info to do debugging.
 * @author MatthewOng
 */
public class CallStackUtils {

    public static CallerInfo getCallerInfo() {
        return getCallerInfo(0);
    }

    public static CallerInfo getCallerInfo(int level) {
        Class caller = cism.getCallerClass(level + 1);
        //Class caller =sun.reflect.Reflection.getCallerClass(level+1);
        String clsName = caller.getSimpleName();
        String pkgName = caller.getCanonicalName().replaceFirst("." + clsName, "");
        CallerInfo info = CallerInfo.getNewIntance(pkgName, clsName, null, null, null);
        // info is not debug, there will not be any method & source file name.
        return info;
    }
    private static final CallerInfoSecurityManager cism = new CallerInfoSecurityManager();

    private static class CallerInfoSecurityManager extends SecurityManager {

        public Class getCallerClass(int level) {
            Class caller = getClassContext()[level];
            return caller;
        }
    }

    public static CallerInfo getCallerDebug() {
        return getCallerDebug(1);       // current level of caller
    }

    public static CallerInfo getCallerInfo(Throwable throwable) {
        if (throwable == null) {
            return getCallerDebug(1);
        } else {
            final StackTraceElement[] stes = throwable.getStackTrace();
            StackTraceElement ste = stes[stes.length - 1];
            return CallerInfo.getNewInstance(ste);
        }
    }

    public static CallerInfo getCallerDebug(int level) {
        try {
            final StackTraceElement[] stes = new Throwable().getStackTrace();
            StackTraceElement ste = stes[stes.length - level];
            return CallerInfo.getNewInstance(ste);
        } catch (Throwable e) {
            return null;
            //return "ERROR in getCaller"; // rather impossible to reach here.
        }
    }
}
