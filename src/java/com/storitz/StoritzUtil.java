package com.storitz;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StoritzUtil {

    public static String stackTraceToString(Throwable t) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        t.printStackTrace(printWriter);
        return result.toString();
    }

    public static boolean isCaliforniaZip(String zip) {
        if (zip == null) {
            return false;
        }

        int iZip = new Integer(zip).intValue();

        return iZip >= 90001 && iZip <= 96162;
    }

    /**
     * Fancy division + rounding with a lower limit on the result. Returns the number of
     * items in each partition, when partitioning `list` into `num` sub-lists of at least
     * `min` items each. Meant to be used in a for loop such as:
     *
     *   List l = new ArrayList();
     *   // add some items to l
     *   int n = partition(l);
     *   for (int i = 0; i < l.size(); i++) {
     *       System.out.print(l.get(i));
     *       if (i > 0 && i % n == 0 && i < l.size()) {
     *           System.out.print("\n");
     *       }
     *   }
     * @param list the list to partition
     * @param num  the number of sublists into which `list` should be partitioned
     * @param min  the smallest allowable partition size
     * @return the size of each partition
     */
    public static int partition(List list, Integer num, Integer min) {
        int n = new BigDecimal(list.size()).divide(new BigDecimal(num), 0, RoundingMode.CEILING).intValue();
        return (n < min) ? min : n;
    }

    static private int BLACKLIST = 0;
    static private int WHITESPACE = 1;
    static private int HYPHENS = 2;

    static Pattern[] patterns = new Pattern[3];
    static {
        String[] _patterns = new String[] {
                "[^a-zA-Z0-9 \\-]", // only alphanumeric, space, and dash
                "\\s+", // run of whitespace; replace with '-'
                "-+" // run of hyphens, replace with '-'
        };
        for (int i = 0; i < _patterns.length; i++) {
            patterns[i] = Pattern.compile(_patterns[i]);
        }
    };

    public static String seoEncode(String s) {
        Matcher m1 = patterns[BLACKLIST].matcher(s.trim().toLowerCase());
        s = m1.replaceAll("");
        Matcher m2 = patterns[WHITESPACE].matcher(s);
        s = m2.replaceAll("-");
        Matcher m3 = patterns[HYPHENS].matcher(s);
        s = m3.replaceAll("-");
        while(s.endsWith("-")) {
          s = s.substring(0, s.length() - 1);
        }
        while(s.startsWith("-")) {
          s = s.substring(1);
        }
        return s;
    }

    public static String titleize(String s) {
      StringBuilder sb = new StringBuilder();
      String[] words = s.split("\\s+");
      for (int i = 0; i < words.length; i++) {
        sb.append(words[i].substring(0, 1).toUpperCase());
        if (words[i].length() > 0) {
            sb.append(words[i].substring(1).toLowerCase());
        }
        if (i < words.length - 1) {
          sb.append(" ");
        }
      }
      return sb.toString();
    }

}
