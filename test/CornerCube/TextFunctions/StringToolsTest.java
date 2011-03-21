/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CornerCube.TextFunctions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MatthewOng
 */
public class StringToolsTest {

    public StringToolsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of empty method, of class StringTools.
     */
    @Test
    public void testEmpty() {
        System.out.println("empty");
        String aVal = "";
        boolean expResult = true;
        boolean result = StringTools.empty(aVal);
        assertEquals(true, result);
        result = StringTools.empty("abcde");
        assertEquals(false, result);
        result = StringTools.empty(null);
        assertEquals(true, result);
    }

    /**
     * Test of anyEmpty method, of class StringTools.
     */
    @Test
    public void testAnyEmpty() {
        System.out.println("anyEmpty");
        String[] values = null;
        boolean expResult = false;
        boolean result = StringTools.anyEmpty(values);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of allEmpty method, of class StringTools.
     */
    @Test
    public void testAllEmpty() {
        System.out.println("allEmpty");
        String[] values = null;
        boolean expResult = false;
        boolean result = StringTools.allEmpty(values);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reline method, of class StringTools.
     */
    @Test
    public void testReline() {
        System.out.println("reline");
        String text = "";
        int sizePerLine = 0;
        String expResult = "";
        String result = StringTools.reline(text, sizePerLine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toLines method, of class StringTools.
     */
    @Test
    public void testToLines() {
        System.out.println("toLines");
        String text = "";
        int sizePerLine = 0;
        LinkedList expResult = null;
        LinkedList result = StringTools.toLines(text, sizePerLine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of strPosition method, of class StringTools.
     */
    @Test
    public void testStringPosition() {
        System.out.println("stringPosition");
        String string = "";
        String searchVal = "";
        boolean isCaseSensitive = false;
        int expResult = 0;
        int result = StringTools.strPosition(string, searchVal, isCaseSensitive);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of substr method, of class StringTools.
     */
    @Test
    public void testSubstr_String_int() {
        System.out.println("substr");
        String str = "";
        int offset = 0;
        String expResult = "";
        String result = StringTools.substr(str, offset);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of substr method, of class StringTools.
     */
    @Test
    public void testSubstr_3args() {
        System.out.println("substr");
        String str = "";
        int offset = 0;
        int length = 0;
        String expResult = "";
        String result = StringTools.substr(str, offset, length);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subString method, of class StringTools.
     */
    @Test
    public void testSubString_String_String() {
        System.out.println("subString");
        String string = "";
        String searchVal = "";
        String expResult = "";
        String result = StringTools.subString(string, searchVal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subString method, of class StringTools.
     */
    @Test
    public void testSubString_3args() {
        System.out.println("subString");
        String string = "";
        String search = "";
        boolean isCaseSensitive = false;
        String expResult = "";
        String result = StringTools.subString(string, search, isCaseSensitive);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of repeat method, of class StringTools.
     */
    @Test
    public void testRepeat_char_int() {
        System.out.println("repeat");
        char aChar = ' ';
        int count = 0;
        String expResult = "";
        String result = StringTools.repeat(aChar, count);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of repeat method, of class StringTools.
     */
    @Test
    public void testRepeat_String_int() {
        System.out.println("repeat");
        String value = "";
        int count = 0;
        String expResult = "";
        String result = StringTools.repeat(value, count);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cropString method, of class StringTools.
     */
    @Test
    public void testCropString() {

        System.out.println("cropString");
        String string = "#3#Start#===========================================";
        String fromHere = "#3";
        String toHere = "#=";
        String expResult = "#Start";
        String result = StringTools.cropString(string, fromHere, toHere);
        assertEquals(expResult, result);

    }

    /**
     * Test of rjust method, of class StringTools.
     */
    @Test
    public void testRjust() {
        System.out.println("rjust");
        String string = "";
        int length = 0;
        String padding = "";
        String expResult = "";
        String result = StringTools.rjust(string, length, padding);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rightJustify method, of class StringTools.
     */
    @Test
    public void testRightJustify() {
        System.out.println("rightJustify");
        String string = "";
        int lenght = 0;
        String padding = "";
        String expResult = "";
        String result = StringTools.rightJustify(string, lenght, padding);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ljust method, of class StringTools.
     */
    @Test
    public void testLjust() {
        System.out.println("ljust");
        String string = "";
        int lenght = 0;
        String padding = "";
        String expResult = "";
        String result = StringTools.ljust(string, lenght, padding);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leftJustify method, of class StringTools.
     */
    @Test
    public void testLeftJustify() {
        System.out.println("leftJustify");
        String string = "";
        int lenght = 0;
        String padding = "";
        String expResult = "";
        String result = StringTools.leftJustify(string, lenght, padding);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toLower method, of class StringTools.
     */
    @Test
    public void testStringToLower() {
        System.out.println("stringToLower");
        String string = "";
        String expResult = "";
        String result = StringTools.toLower(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toUpper method, of class StringTools.
     */
    @Test
    public void testStringToUpper() {
        System.out.println("stringToUpper");
        String string = "";
        String expResult = "";
        String result = StringTools.toUpper(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of swapCase method, of class StringTools.
     */
    @Test
    public void testSwapCase() {
        System.out.println("swapCase");
        String string = "";
        String expResult = "";
        String result = StringTools.swapCase(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of skipChar method, of class StringTools.
     */
    @Test
    public void testSkipChar() {
        System.out.println("skipChar");
        String string = "";
        char ch = ' ';
        int start = 0;
        int expResult = 0;
        int result = StringTools.skipChar(string, ch, start);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of padding method, of class StringTools.
     */
    @Test
    public void testPaddingString() {


        System.out.println("paddingString");
        String string = " a test ";
        char ch = '#';
        int newSize = 20;

        String expResult = "########### a test ";
        String ret1 = StringTools.padding(string, ch, newSize, true);
        assertEquals(expResult, ret1);

        expResult = " a test ###########";
        String ret2 = StringTools.padding(string, ch, newSize, false);
        assertEquals(expResult, ret2);
        prnln(string);
        prnln(ret1);
        prnln(ret2);
    }

    /**
     * Test of padZeroes method, of class StringTools.
     */
    @Test
    public void testPadZeroToString() {
        System.out.println("padZeroToString");
        String string = "";
        int newSize = 0;
        boolean isLead = false;
        String expResult = "";
        String result = StringTools.padZeroes(string, newSize, isLead);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of replace method, of class StringTools.
     */
    @Test
    public void testStringReplace() {
        System.out.println("stringReplace");
        String string = "";
        String pattern = "";
        String newValue = "";
        boolean isCaseSensitive = false;
        String expResult = "";
        String result = StringTools.replace(string, pattern, newValue, isCaseSensitive);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of split method, of class StringTools.
     */
    @Test
    public void testStringSplit() {
        System.out.println("stringSplit");
        String pattern = "";
        String string = "";
        ArrayList expResult = null;
        List result = StringTools.split(pattern, string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of explode method, of class StringTools.
     */
    @Test
    public void testExplode() {
        System.out.println("explode");
        char delimiter = ' ';
        String string = "";
        String[] expResult = null;
        String[] result = StringTools.explode(delimiter, string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of implode method, of class StringTools.
     */
    @Test
    public void testImplode_char_List() {
        System.out.println("implode");
        char delimiter = ' ';
        List strings = null;
        String expResult = "";
        String result = StringTools.implode(delimiter, strings);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of implode method, of class StringTools.
     */
    @Test
    public void testImplode_char_StringArr() {
        System.out.println("implode");
        char delimiter = ' ';
        String[] values = null;
        String expResult = "";
        String result = StringTools.implode(delimiter, values);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compare method, of class StringTools.
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        String string1 = "";
        String string2 = "";
        boolean isCaseSensitive = false;
        int expResult = 0;
        int result = StringTools.compare(string1, string2, isCaseSensitive);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reverse method, of class StringTools.
     */
    @Test
    public void testReverse() {

        System.out.println("reverse");
        String string = "  this is a test.  ";
        String expResult = "";
        String result = StringTools.reverse(string);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of countWords method, of class StringTools.
     */
    @Test
    public void testCountWords() {
        System.out.println("countWords");
        String string = "";
        int expResult = 0;
        int result = StringTools.countWords(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of containValue method, of class StringTools.
     */
    @Test
    public void testContainValue() {
        System.out.println("containValue");
        String string = "";
        String value = "";
        boolean expResult = false;
        boolean result = StringTools.containValue(string, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of containValues method, of class StringTools.
     */
    @Test
    public void testContainValues_String_StringArr() {
        System.out.println("containValues");
        String string = "";
        String[] subStrings = null;
        boolean expResult = false;
        boolean result = StringTools.containValues(string, subStrings);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of containValues method, of class StringTools.
     */
    @Test
    public void testContainValues_StringArr_StringArr() {
        System.out.println("containValues");
        String[] strings = null;
        String[] subStrings = null;
        boolean expResult = false;
        boolean result = StringTools.containValues(strings, subStrings);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crypt method, of class StringTools.
     */
    @Test
    public void testCrypt() {
        System.out.println("crypt");
        String string = "";
        String expResult = "";
        String result = StringTools.crypt(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reverseWords method, of class StringTools.
     */
    @Test
    public void testReverseWords() {
        System.out.println("reverseWords");
         String string = "  this is a test.  ";
        String expResult = "";
        String result = StringTools.reverseWords(string);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of isSpaceLine method, of class StringTools.
     */
    @Test
    public void testIsEmptyLine() {
        System.out.println("isEmptyLine");
        String aLine = "";
        boolean expResult = false;
        boolean result = StringTools.isSpaceLine(aLine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sspc method, of class StringTools.
     */
    @Test
    public void testSspc() {
        System.out.println("sspc");
        String string = "";
        String expResult = "";
        String result = StringTools.sspc(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of squashSpace method, of class StringTools.
     */
    @Test
    public void testSquashSpace() {
        System.out.println("squashSpace");
        String string = "";
        String expResult = "";
        String result = StringTools.squashSpace(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ltrim method, of class StringTools.
     */
    @Test
    public void testLtrim_String_String() {
        System.out.println("ltrim");
        String string = "";
        String chars = "";
        String expResult = "";
        String result = StringTools.ltrim(string, chars);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leftTrim method, of class StringTools.
     */
    @Test
    public void testLeftTrim_String_String() {
        System.out.println("leftTrim");
        String string = "";
        String chars = "";
        String expResult = "";
        String result = StringTools.leftTrim(string, chars);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ltrim method, of class StringTools.
     */
    @Test
    public void testLtrim_String() {
        System.out.println("ltrim");
        String string = "";
        String expResult = "";
        String result = StringTools.ltrim(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leftTrim method, of class StringTools.
     */
    @Test
    public void testLeftTrim_String() {
        System.out.println("leftTrim");
        String string = "";
        String expResult = "";
        String result = StringTools.leftTrim(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class StringTools.
     */
    @Test
    public void testRemove_String_int() {
        System.out.println("remove");
        String string = "";
        int posBegin = 0;
        String expResult = "";
        String result = StringTools.remove(string, posBegin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeLast method, of class StringTools.
     */
    @Test
    public void testRemoveLast() {
        System.out.println("removeLast");
        String string = "";
        int charsCount = 0;
        String expResult = "";
        String result = StringTools.removeLast(string, charsCount);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeFirst method, of class StringTools.
     */
    @Test
    public void testRemoveFirst_String_String() {
        System.out.println("removeFirst");
        String string = "";
        String pattern = "";
        String expResult = "";
        String result = StringTools.removeFirst(string, pattern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeFirst method, of class StringTools.
     */
    @Test
    public void testRemoveFirst_3args() {
        System.out.println("removeFirst");
        String string = "";
        String pattern = "";
        boolean ignoreCase = false;
        String expResult = "";
        String result = StringTools.removeFirst(string, pattern, ignoreCase);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removes method, of class StringTools.
     */
    @Test
    public void testRemoves() {
        System.out.println("removes");
        String string = "";
        String[] patterns = null;
        String expResult = "";
        String result = StringTools.removes(string, patterns);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class StringTools.
     */
    @Test
    public void testRemove_String_StringArr() {
        System.out.println("remove");
        String string = "";
        String[] patterns = null;
        String expResult = "";
        String result = StringTools.remove(string, patterns);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class StringTools.
     */
    @Test
    public void testRemove_String_String() {
        System.out.println("remove");
        String string = "";
        String pattern = "";
        String expResult = "";
        String result = StringTools.remove(string, pattern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class StringTools.
     */
    @Test
    public void testRemove_3args() {
        System.out.println("remove");
        String string = "";
        String pattern = "";
        boolean ignoreCase = false;
        String expResult = "";
        String result = StringTools.remove(string, pattern, ignoreCase);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of replace method, of class StringTools.
     */
    @Test
    public void testReplace() {
        System.out.println("replace");
        String string = "";
        String oldValPatt = "";
        String newVal = "";
        int count = 0;
        String expResult = "";
        String result = StringTools.replace(string, oldValPatt, newVal, count);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of trimFirstXmlTag method, of class StringTools.
     */
    @Test
    public void testTrimFirstXmlTag() {
        System.out.println("trimFirstXmlTag");
        String string = "";
        String tagName = "";
        String expResult = "";
        String result = StringTools.trimFirstXmlTag(string, tagName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of trimAllXmlTag method, of class StringTools.
     */
    @Test
    public void testTrimAllXmlTag_String_String() {
        System.out.println("trimAllXmlTag");
        String string = "";
        String tagName = "";
        String expResult = "";
        String result = StringTools.trimAllXmlTag(string, tagName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of trimAllXmlTag method, of class StringTools.
     */
    @Test
    public void testTrimAllXmlTag_String() {
        System.out.println("trimAllXmlTag");
        String string = "";
        String expResult = "";
        String result = StringTools.trimAllXmlTag(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rtrim method, of class StringTools.
     */
    @Test
    public void testRtrim_String_String() {
        System.out.println("rtrim");
        String string = "";
        String chars = "";
        String expResult = "";
        String result = StringTools.rtrim(string, chars);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rightTrim method, of class StringTools.
     */
    @Test
    public void testRightTrim_String_String() {
        System.out.println("rightTrim");
        String string = "";
        String chars = "";
        String expResult = "";
        String result = StringTools.rightTrim(string, chars);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rtrim method, of class StringTools.
     */
    @Test
    public void testRtrim_String() {
        System.out.println("rtrim");
        String string = "";
        String expResult = "";
        String result = StringTools.rtrim(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rightTrim method, of class StringTools.
     */
    @Test
    public void testRightTrim_String() {
        System.out.println("rightTrim");
        String string = "";
        String expResult = "";
        String result = StringTools.rightTrim(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of trim method, of class StringTools.
     */
    @Test
    public void testTrim() {
        System.out.println("trim");
        String string = "";
        String expResult = "";
        String result = StringTools.trim(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of uppercaseFirstChar method, of class StringTools.
     */
    @Test
    public void testUppercaseFirstChar() {
        System.out.println("uppercaseFirstChar");
        String string = "";
        String expResult = "";
        String result = StringTools.uppercaseFirstChar(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of uppercaseWords method, of class StringTools.
     */
    @Test
    public void testUppercaseWords() {
        System.out.println("uppercaseWords");
        String string = "";
        String expResult = "";
        String result = StringTools.uppercaseWords(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    private static void prnln(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        /*
        String testStr = repeat("  this is    a test.  ", 3);
        prnln("testStr:" + testStr);
        prnln("count:" + countWords(testStr));
        prnln("subString:" + subString(testStr, " is "));
        prnln("squashSpace:" + squashSpace(testStr));
        prnln("reverseWords():>>" + reverseWords(testStr) + "<<");
        prnln("uppercaseFirstChar:" + uppercaseFirstChar(testStr));
        prnln("uppercaseWord:" + uppercaseWords(testStr));

        testStr = "  this is a test.  ";
        prnln("               >>" + testStr + "<<");
        prnln("reverse():     >>" + reverse(testStr) + "<<");
        prnln("reverseWords():>>" + reverseWords(testStr) + "<<");

        
        String str1 = "<verse number=\"24\">蒙救的萬民、都在這光輝裏行走、世上的諸王、將尊榮歸與這城。<note>This is a test tag</note></verse>";
        prnln("org   :" + str1);
        prnln("crop  :" + cropString(str1, "<verse number=\"", "\">"));
        prnln("trimFirstXmlTag:" + trimFirstXmlTag(str1, "verse"));
        prnln("trimAllXmlTag:" + trimAllXmlTag(str1));
         */


    }
}
