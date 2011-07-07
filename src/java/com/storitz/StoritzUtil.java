package com.storitz;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;


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
}
