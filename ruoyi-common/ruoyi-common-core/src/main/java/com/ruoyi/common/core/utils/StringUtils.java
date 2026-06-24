package com.ruoyi.common.core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Lightweight string utilities (subset of the upstream RuoYi-Cloud helper).
 */
public final class StringUtils {

    private StringUtils() {}

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    public static boolean isBlank(CharSequence cs) {
        if (cs == null) return true;
        int len = cs.length();
        for (int i = 0; i < len; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(CharSequence cs) {
        return !isBlank(cs);
    }

    public static boolean equals(CharSequence cs1, CharSequence cs2) {
        if (cs1 == cs2) return true;
        if (cs1 == null || cs2 == null) return false;
        if (cs1.length() != cs2.length()) return false;
        if (cs1 instanceof String && cs2 instanceof String) {
            return cs1.equals(cs2);
        }
        return cs1.toString().contentEquals(cs2);
    }

    /** Convert camelCase to snake_case. */
    public static String toUnderScoreCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        Matcher matcher = Pattern.compile("[A-Z]").matcher(str);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group().toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.charAt(0) == '_' ? sb.substring(1) : sb.toString();
    }
}
