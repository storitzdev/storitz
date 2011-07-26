package com.storitz;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.IllegalFormatException;


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

        try {
            int iZip = new Integer(zip).intValue();

            return iZip >= 90001 && iZip <= 96162;
        } catch (NumberFormatException n) {
            n.printStackTrace();
        }

        return false;
    }

    /**
     *  convert stuff like 19.949999999999999289457264239899814128875732421875
     *  to 19.95
     */
    public static Double roundToMoney (BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return null; // garbage in, garbage out
        }
        return bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }


}
