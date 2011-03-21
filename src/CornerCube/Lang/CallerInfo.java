/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CornerCube.Lang;

import CornerCube.TextFunctions.StringTools;

/**
 *
 * @author MatthewOng
 */
public class CallerInfo {

    private String mThreadName = null;
    private String mPackageName = null;
    private String mClassName = null;
    private String mMethodName = null;
    private String mSourceFile = null;
    private String mLineNo = null;
    private String toStr = null;

    private CallerInfo() {
    }

    public static CallerInfo getNewInstance(StackTraceElement ste) {
        CallerInfo info = new CallerInfo();
        info.mThreadName = Thread.currentThread().getName()
                + "#" + Thread.currentThread().getId();

        info.mSourceFile = ste.getFileName();
        info.mLineNo = ste.getLineNumber() + "";
        info.mMethodName = ste.getMethodName();
        String[] array = StringTools.explode("\\.", ste.getClassName());
        info.mClassName = array[array.length - 1];
        info.mPackageName = ste.getClassName().replaceFirst("." + info.mClassName, "");
        info.toStr = getToString(info);
        return info;
    }

    public static CallerInfo getNewIntance(String pkgName,
            String clzName, String metName,
            String srcFile, String lineNo) {

        CallerInfo info = new CallerInfo();
        info.mThreadName = Thread.currentThread().getName()
                + "#" + Thread.currentThread().getId();
        info.mPackageName = pkgName;
        info.mClassName = clzName;
        info.mMethodName = metName;
        info.mSourceFile = srcFile;
        info.mLineNo = lineNo;
        info.toStr = getToString(info);
        return info;
    }

    public static final String getToString(CallerInfo info) {
        StringBuilder sb = new StringBuilder();
        sb.append("package:");
        sb.append(info.mPackageName);
        sb.append("; class:");
        sb.append(info.mClassName);
        if (info.mMethodName != null && info.mMethodName.length() > 1) {
            sb.append("; method:");
            sb.append(info.mMethodName);
        }
        if (info.mSourceFile != null && info.mSourceFile.length() > 1) {
            sb.append("; source:");
            sb.append(info.mSourceFile);
        }
        if (info.mLineNo != null && info.mLineNo.length() > 1) {
            sb.append("; line no:");
            sb.append(info.mLineNo);
        }
        if(info.mThreadName!=null && info.mThreadName.length()>1){
            sb.append("; thread:");
            sb.append(info.mThreadName);
        }
        return sb.toString();
    }

    public String toString() {
        return toStr;


    }

    public String getClassName() {
        return mClassName;


    }

    public String getLineNo() {
        return mLineNo;


    }

    public String getMethodName() {
        return mMethodName;


    }

    public String getPackageName() {
        return mPackageName;


    }

    public String getSourceFile() {
        return mSourceFile;

    }
}
