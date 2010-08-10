package com.storitz.geoip;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GeoIp {

    private static String geoFile;
    private static String os;
    private static LookupService lookupService;
    final ServletContext servletContext;

    static {
        if (System.getProperty("os.name").startsWith("Windows")) {
            os = "windows";
        } else {
            os = "linux";
        }
    }

    String getGeoFile() {

        if (geoFile == null) {
            InputStream stream;
            Properties prop = new Properties();
            String propertyFile = "/WEB-INF/storitz.properties";
            String propertyName = "geodb." + os;
            try {
                // Get the property as stream.
                stream = servletContext.getResourceAsStream(propertyFile );

                //load the stream to Property object.
                prop.load(stream );

                // Now get the value from properties file.
                geoFile = prop.getProperty(propertyName);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return geoFile;
    }

    public Location getLocation(String ipAddr) {
        String file = getGeoFile();

        Location loc = null;

        if (lookupService == null) {
            try {
                lookupService = new LookupService(file, LookupService.GEOIP_MEMORY_CACHE | LookupService.GEOIP_CHECK_CACHE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (lookupService != null) {
            if (ipAddr.equals("127.0.0.1")) {
                ipAddr = "71.118.52.85";
            }
            loc = lookupService.getLocation(ipAddr);
        }
        return loc;
    }

    public GeoIp(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
