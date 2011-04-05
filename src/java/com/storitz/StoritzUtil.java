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

}
