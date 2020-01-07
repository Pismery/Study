package com.pismery.study.util;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyboardUtils {

    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        System.out.println("width: " + width);
        System.out.println("height: " + height);

        pressKeyWithWindows(KeyEvent.VK_R);

        pressString("cmd");
        pressKey(KeyEvent.VK_ENTER);

        robot.delay(200);
        pressString("`-=[]\\;',./");
        pressString("    ");
        pressString("~!@#$%^&*()_+{}|:\"<>?");
        pressString("    ");
        pressString("qwertyuiopasdfghjklzxcvbnm");
        pressString("    ");
        pressString("QWERTYUIOPASDFGHJKLZXCVBNM");

        robot.delay(200);
        pressKeyWithAlt(KeyEvent.VK_F4);
    }


    public static void pressString(String str) {
        pressChars(str.toCharArray());
    }

    public static void pressChars(char[] chars) {
        for (char ch : chars) {
            pressChar(ch);
        }
    }

    public static void pressChar(char ch) {
        if (Character.isUpperCase(ch)) {
            ch = Character.toLowerCase(ch);
            pressKeyWithShift(getInputKey(ch));
        } else if (isShiftKey(ch)) {
            pressKeyWithShift(getInputKey(ch));
        } else if (isUnShiftKey(ch)) {
            pressKey(getInputKey(ch));
        } else {
            throw new IllegalArgumentException("Illegal input:" + ch);
        }
    }

    private static Integer getInputKey(char ch) {
        return keyMap.get(ch);
    }

    public static void pressKeyWithAlt(int inputKey) {
        robot.keyPress(KeyEvent.VK_ALT);
        robot.delay(10);

        pressKey(inputKey);

        robot.keyRelease(KeyEvent.VK_ALT);
        robot.delay(10);
    }

    public static void pressKeyWithWindows(int inputKey) {
        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.delay(10);

        pressKey(inputKey);

        robot.keyRelease(KeyEvent.VK_WINDOWS);
        robot.delay(10);
    }

    public static void pressKeyWithShift(int inputKey) {
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.delay(10);

        pressKey(inputKey);

        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.delay(10);
    }


    private static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private static final List<Character> UNSHIFT_KEYS = Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z',

            ' ', '`', '-', '=',
            '[', ']', '\\',
            ';', '\'',
            ',', '.', '/'
    );

    private static final List<Character> SHIFT_KEYS = Arrays.asList(
            '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+',
            '{', '}', '|',
            ':', '"',
            '<', '>', '?'
    );

    private static final Map<Character, Integer> keyMap = new HashMap<>();

    static {
        keyMap.put('a', KeyEvent.VK_A);
        keyMap.put('b', KeyEvent.VK_B);
        keyMap.put('c', KeyEvent.VK_C);
        keyMap.put('d', KeyEvent.VK_D);
        keyMap.put('e', KeyEvent.VK_E);
        keyMap.put('f', KeyEvent.VK_F);
        keyMap.put('g', KeyEvent.VK_G);
        keyMap.put('h', KeyEvent.VK_H);
        keyMap.put('i', KeyEvent.VK_I);
        keyMap.put('j', KeyEvent.VK_J);
        keyMap.put('k', KeyEvent.VK_K);
        keyMap.put('l', KeyEvent.VK_L);
        keyMap.put('m', KeyEvent.VK_M);
        keyMap.put('n', KeyEvent.VK_N);
        keyMap.put('o', KeyEvent.VK_O);
        keyMap.put('p', KeyEvent.VK_P);
        keyMap.put('q', KeyEvent.VK_Q);
        keyMap.put('r', KeyEvent.VK_R);
        keyMap.put('s', KeyEvent.VK_S);
        keyMap.put('t', KeyEvent.VK_T);
        keyMap.put('u', KeyEvent.VK_U);
        keyMap.put('v', KeyEvent.VK_V);
        keyMap.put('w', KeyEvent.VK_W);
        keyMap.put('x', KeyEvent.VK_X);
        keyMap.put('y', KeyEvent.VK_Y);
        keyMap.put('z', KeyEvent.VK_Z);


        keyMap.put(' ', KeyEvent.VK_SPACE);
        keyMap.put('`', KeyEvent.VK_BACK_QUOTE);
        keyMap.put('-', KeyEvent.VK_MINUS);
        keyMap.put('=', KeyEvent.VK_EQUALS);
        keyMap.put('[', KeyEvent.VK_OPEN_BRACKET);
        keyMap.put(']', KeyEvent.VK_CLOSE_BRACKET);
        keyMap.put('\\', KeyEvent.VK_BACK_SLASH);
        keyMap.put(';', KeyEvent.VK_SEMICOLON);
        keyMap.put('\'', KeyEvent.VK_QUOTE);
        keyMap.put(',', KeyEvent.VK_COMMA);
        keyMap.put('.', KeyEvent.VK_PERIOD);
        keyMap.put('/', KeyEvent.VK_SLASH);


        keyMap.put('~', KeyEvent.VK_BACK_QUOTE);
        keyMap.put('!', KeyEvent.VK_1);
        keyMap.put('@', KeyEvent.VK_2);
        keyMap.put('#', KeyEvent.VK_3);
        keyMap.put('$', KeyEvent.VK_4);
        keyMap.put('%', KeyEvent.VK_5);
        keyMap.put('^', KeyEvent.VK_6);
        keyMap.put('&', KeyEvent.VK_7);
        keyMap.put('*', KeyEvent.VK_8);
        keyMap.put('(', KeyEvent.VK_9);
        keyMap.put(')', KeyEvent.VK_0);
        keyMap.put('_', KeyEvent.VK_MINUS);
        keyMap.put('+', KeyEvent.VK_EQUALS);


        keyMap.put('{', KeyEvent.VK_OPEN_BRACKET);
        keyMap.put('}', KeyEvent.VK_CLOSE_BRACKET);
        keyMap.put('|', KeyEvent.VK_BACK_SLASH);
        keyMap.put(':', KeyEvent.VK_SEMICOLON);
        keyMap.put('"', KeyEvent.VK_QUOTE);
        keyMap.put('<', KeyEvent.VK_COMMA);
        keyMap.put('>', KeyEvent.VK_PERIOD);
        keyMap.put('?', KeyEvent.VK_SLASH);
    }

    private static boolean isShiftKey(char key) {
        return SHIFT_KEYS.contains(key);
    }

    private static boolean isUnShiftKey(char key) {
        return UNSHIFT_KEYS.contains(key);
    }


    private static void pressKey(int inputKey) {
        robot.keyPress(inputKey);
        robot.delay(10);
        robot.keyRelease(inputKey);
        robot.delay(10);
    }
}
