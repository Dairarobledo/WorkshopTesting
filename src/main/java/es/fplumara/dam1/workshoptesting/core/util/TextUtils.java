package es.fplumara.dam1.workshoptesting.core.util;

public class TextUtils {

    private TextUtils() {
    }

    public static String normalize(String s) {
        if (s == null) return null;
        return s.toLowerCase();
    }
}
