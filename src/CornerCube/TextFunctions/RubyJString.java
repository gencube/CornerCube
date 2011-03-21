/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CornerCube.TextFunctions;

import CornerCube.Lang.EMPTY;
import java.io.*;
import java.util.*;
import java.util.regex.*;

/**
 * Provide wrapper for the Ruby String functionality.
 * This class will tries to emulate as close as possible all the
 * functionality of ruby string operation
 * @author MatthewOng
 */
public class RubyJString {

    public static String capitalize(String str) {
        return StringTools.uppercaseFirstChar(str);
    }

    /**
     * UTF-8 aware alternative to strcasecmp
     * A case insensivite string comparison
     * @param string1 string 1 to compare
     * @param string2 string 2 to compare
     * @return int < 0 if str1 is less than str2; > 0 if str1 is greater than
     *         str2, and 0 if they are equal.
     */
    public static int casecmp(String string1, String string2) {
        return StringTools.compare(string1, string2, false);
    }

    public static String chomp(String str) {
        if (empty(str)) {
            return "";
        }
        return str.replaceAll("\n", "");
    }

    public static String chop(String str) {
        if (empty(str)) {
            return "";
        }
        return str.substring(0, str.length() - 1);
    }

    public static int count(String str, String... values) {
        if (empty(str)) {
            return 0;
        }
        int cnt = 0;
        for (String aVal : values) {
            if (str.contains(aVal)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static int countStrs(String str, String[] values) {
        if (empty(str)) {
            return 0;
        }
        int cnt = 0;
        for (String aVal : values) {
            if (str.contains(aVal)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static String crypt(String str) {
        return StringTools.crypt(str);
    }

    public static String delete(String str, String... values) {
        return StringTools.remove(str, values);
    }

    public static String deletes(String str, String[] values) {
        return StringTools.remove(str, values);
    }

    public static String downcase(String string) {
        if (empty(string)) {
            return "";
        }
        return string.toLowerCase(Locale.getDefault());
    }

    public static boolean empty(String str) {
        return StringTools.empty(str);
    }

    public static boolean eql(String str, String val) {
        if (str == val) {
            return true;
        }
        if (empty(str)) {
            return false;
        }
        if (empty(val)) {
            return false;
        }
        return str.equals(val);
    }

    public static void dump(String str, PrintStream out) {
        out.println(str);
        out.flush();
    }

    public static void dump(String str) {
        dump(str, System.out);
    }

    public static String gsub(String string, String oldValPatt, String newVal) {
        return StringTools.replace(string, oldValPatt, newVal, Integer.MAX_VALUE);
    }

    public static String gsub(String string, String oldValPatt, String newVal, int count) {
        return StringTools.replace(string, oldValPatt, newVal, count);
    }

    public static boolean include(String str, String val) {
        if (empty(str)) {
            // no changes to the string
            return false;
        }
        return str.contains(val);
    }

    public static String insert(String str, int index, String val) {
        if (empty(str)) {
            return "";
        }
        if (empty(val)) {
            return str;
        }
        String sub0 = str.substring(0, index - 1);
        String sub1 = str.substring(index);
        return sub0 + val + sub1;
    }

    /**
     * Returns a printable version of str, with special characters escaped.
     */
    public static String inspect(String str) {
        if (empty(str)) {
            return "";
        }
        String pat = "[^\\p{Print}]";
        Pattern patt = Pattern.compile(pat);
        Matcher mat = patt.matcher(str);

        StringBuffer sb = new StringBuffer();
        while (mat.find()) {
            String fnd = mat.group();
            char ch = fnd.charAt(0);
            fnd = "\\" + Integer.toHexString(ch);
            mat.appendReplacement(sb, fnd);
        }
        mat.appendTail(sb);
        return sb.toString();
    }

    /**
     * Returns a copy of str with leading whitespace removed.
     */
    public static String lstrip(String str) {
        return StringTools.ltrim(str);
    }

    public static boolean match(String str, String pat) {
        if (empty(str)) {
            return false;
        }
        if (empty(pat)) {
            return false;
        }

        return str.matches(pat);
    }

    /**
     * Treats leading characters of str as a string of octal digits 
     * (with an optional sign) and returns the corresponding number.
     * Returns 0 if the conversion fails.
     */
    public static int oct(String str) {
        return 0;
    }

    /**
     * Returns a new string with the characters from str in reverse order.
     */
    public static String reverse(String str) {
        return StringTools.reverse(str);
    }

    /**
     * Returns the index of the last occurrence of the given substring,
     * character (fixnum), or pattern (regexp) in str.
     */
    public static int rindex(String str, String pat) {
        if (empty(str)) {
            return -1;
        }
        if (empty(pat)) {
            return -1;
        }
        return str.lastIndexOf(pat);
    }

    /**
     * Returns a copy of str with trailing whitespace removed.
     */
    public static String rstrip(String str) {
       return StringTools.rtrim(str);
    }

    /**
     * Both forms iterate through str, matching the pattern 
     * (which may be a Regexp or a String). For each match, a result is 
     * generated and either added to the result array or passed to the block.
     * @param string - string to operate on
     * @param pattern - a Regexp or a String to look for.
     * @return an empty array,new String[0], if no result found.
     */
    public static String[] scan(String string, String pattern) {
        if (empty(string) || empty(pattern)) {
            return EMPTY.STRING_ARRAY; // empty array.
        }
        Pattern patt = Pattern.compile(pattern);
        Matcher mat = patt.matcher(string);
        LinkedList<String> strings = new LinkedList<String>();
        while (mat.find()) {
            String fnd = mat.group();
            strings.add(fnd);
        }
        return strings.toArray(EMPTY.STRING_ARRAY);
    }

    /**
     * Similar function to String.substring(int beginIdx)
     */
    public static String slice(String str, int start) {
        if (empty(str)) {
            return "";
        }
        return str.substring(start);
    }

    /**
     * Similar function to String.substring(int beginIdx, int endIdx),
     * where endIdx=start+length-1;
     * @param string string to operate on.
     * @param start location where the operation starts.
     * @param length how much the operation will last.
     */
    public static String slice(String str, int start, int length) {
        if (empty(str)) {
            return "";
        }
        int end = start + length - 1;
        return str.substring(start, end);
    }

    public static String slice(String string, String pattern) {
        if (empty(string)) {
            return "";
        }
        Pattern patt = Pattern.compile(pattern);
        Matcher mat = patt.matcher(string);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (mat.find()) {
            String fnd = mat.group();
            sb.append(fnd);
        }
        return sb.toString();
    }

    public static String slice(String string, String pattern, int count) {
        if (empty(string)) {
            return "";
        }
        Pattern patt = Pattern.compile(pattern);
        Matcher mat = patt.matcher(string);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (mat.find()) {
            i++;
            String fnd = mat.group();
            sb.append(fnd);
            if (i >= count) {
                break;
            }
        }
        return sb.toString();
    }

    public static String squeeze(String string) {
        return squeeze(string, null);
    }

    public static String squeeze(String string, String charlist) {
        if (empty(string)) {
            return "";
        }
        char[] chars = null;
        if (empty(charlist)) {
            chars = string.toCharArray();
            HashMap map = new HashMap();
            for (char ch : chars) {
                map.put(ch + "", "T"); // make uniq
            }
            Object[] strs = map.keySet().toArray();
            for (Object s : strs) {
                String pattern = ((String) s) + "+"; // multiple occurance
                string = string.replaceAll(pattern, ((String) s));
            }
        } else {
            chars = charlist.toCharArray();
            for (char ch : chars) {
                String pattern = ch + "+"; // multiple occurance
                string = string.replaceAll(pattern, "" + ch);
            }
        }
        return string;
    }

    public static String strip(String string) {
        string = lstrip(string);
        return rstrip(string);
    }

    public static String sub(String string, String pattern, String replacement) {
        if (empty(string)) {
            return "";
        }
        if (empty(pattern)) {
            return string;
        }
        return string.replaceFirst(pattern, replacement);
    }

    public static String swapcase(String string) {
        if (empty(string)) {
            return "";
        }
        char[] chars = string.toCharArray();
        int idx = 0;
        for (char ch : chars) {
            if (Character.isLowerCase(ch)) {
                chars[idx] = Character.toUpperCase(ch);
            }
            if (Character.isUpperCase(ch)) {
                chars[idx] = Character.toLowerCase(ch);
            }
            idx++;
        }
        return new String(chars);
    }

    public static String tr(String string, String fromChars, String toChars) {
        if (empty(string)) {
            return "";
        }
        if (empty(fromChars) || string.length() < fromChars.length()) {
            return string; // no changes
        }
        char[] fchs = fromChars.toCharArray();
        char[] tchs = toChars.toCharArray();
        int i = 0;
        for (char ch : fchs) {
            int idx = Math.min(i, tchs.length - 1);
            char to = tchs[idx];
            string = string.replace(ch, to);
            i++;
        }
        return string;
    }

    public static String tr_s(String string, String fromChars, String toChars) {
        string = squeeze(string, fromChars);// this should be faster

        return tr(string, fromChars, toChars);
    }

    public static String unpack(String string, String format) {
        return "";
    }

    public static String upcase(String string) {
        if (empty(string)) {
            return "";
        }
        return string.toUpperCase(Locale.getDefault());
    }

    private static void prn(String msg) {
        System.out.print(msg);
    }

    private static void prnln(String msg) {
        System.out.println(msg);
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {
        String str = "aaasdffghjjkk;lpoiuyreeAAAAAeeeeewqwqwwwwwwertyyu0009899887766655443322";
        String str2 = "  this  is a test.   ";
        prnln("             :" + str);
        prnln("squeeze      :" + squeeze(str));
        prnln("squeeze(0jw) :" + squeeze(str, "0jw"));
        prnln("swapcase     :" + swapcase(str));
        prnln("             :" + str);
        prnln("tr(09w,12X)  :" + tr(str, "09w", "12X"));
        prnln("tr_s(09w,12X):" + tr_s(str, "09w", "12X"));
    }
}
