package com.pismery.study.gof23.pattern.behavior.interpreter;

public enum KeyWord {
    MOVE, COPY, TABLE, VIEW, FROM, TO;

    public static boolean isKeyWork(String string) {
        try {
            KeyWord.valueOf(string.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    /**
     * @return true: KeyWord.value(string) == aimKey or else return false;
     */
    public static boolean isKeyWork(String string, KeyWord aimKey) {
        if (isKeyWork(string) && aimKey.equals(KeyWord.valueOf(string.toUpperCase()))) {
            return true;
        }

        return false;
    }
}
