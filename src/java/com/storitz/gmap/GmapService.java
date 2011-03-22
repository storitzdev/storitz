package com.storitz.gmap;

import com.google.gdata.client.maps.MapsService;
import com.google.gdata.data.Person;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.maps.MapEntry;
import com.google.gdata.data.maps.MapFeed;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

import java.io.IOException;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Oct 27, 2009
 * Time: 8:28:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class GmapService {

    final static String STORITZ_MAP_URL = "http://maps.google.com/maps/feeds/maps/216045305154148112243/full/000439cb966a17d77fd04";
    final static String API_KEY = "ABQIAAAAEDNru_s_vCsZdWplqCj4hxSjGMYCLTKEQ0TzQvUUxxIh1qVrLhTUMUuVByc3xGunRlZ-4Jv6pHfFHA";
    final MapsService myService;

    public void printUserMaps() throws ServiceException, IOException {

        // Request the default metafeed
        final URL feedUrl = new URL("http://maps.google.com/maps/feeds/maps/default/full");
        MapFeed resultFeed = myService.getFeed(feedUrl, MapFeed.class);

        // Print the title of the feed itself.
        System.out.println(resultFeed.getTitle().getPlainText());

        // Iterate through the feed entries (maps) and print out info
        // for each map
        for (int i = 0; i < resultFeed.getEntries().size(); i++) {
            MapEntry entry = resultFeed.getEntries().get(i);
            System.out.println(entry.getTitle().getPlainText());
            System.out.println("  Summary: " + entry.getSummary().getPlainText());
            System.out.println("  Self Link: " + entry.getSelfLink().getHref() + "\n");
        }
    }

    public MapEntry createMap()
            throws ServiceException, IOException {

        final URL feedUrl = new URL("http://maps.google.com/maps/feeds/maps/216045305154148112243/full");
        MapFeed resultFeed = myService.getFeed(feedUrl, MapFeed.class);
        URL mapUrl = new URL(resultFeed.getEntryPostLink().getHref());

        // Create a MapEntry object
        MapEntry myEntry = new MapEntry();
        myEntry.setTitle(new PlainTextConstruct("StorageTech"));
        myEntry.setSummary(new PlainTextConstruct("StorageTech Storage facilities map"));
        Person author = new Person("StorageTech", null, "mamster@webeasy.com");
        myEntry.getAuthors().add(author);

        return myService.insert(mapUrl, myEntry);
    }

    public GmapService() {
        myService = new MapsService("storitz");

        try {
            myService.setUserCredentials("mamster@webeasy.com", "fpb123");
        } catch (AuthenticationException e) {
            System.err.println("Could not authenticate to map service: " + e.getMessage());
        }
    }

    public static void main(String[] argv) {
        GmapService gmap = new GmapService();

        if (argv.length > 0 && argv[0].equals("create")) {
            try {
                gmap.createMap();
            } catch (ServiceException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        try {
            gmap.printUserMaps();
        } catch (ServiceException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
