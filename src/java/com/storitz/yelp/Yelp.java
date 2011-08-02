package com.storitz.yelp;

/*
 Example code based on code from Nicholas Smith at http://imnes.blogspot.com/2011/01/how-to-use-yelp-v2-from-java-including.html
 For a more complete example (how to integrate with GSON, etc) see the blog post above.
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;
import com.google.gson.stream.*;

/**
 * Example for accessing the Yelp API.
 */
public class Yelp {

  OAuthService service;
  Token accessToken;

  /**
   * Setup the Yelp API OAuth credentials.
   *
   * OAuth credentials are available from the developer site, under Manage API access (version 2 API).
   *
   * @param consumerKey Consumer key
   * @param consumerSecret Consumer secret
   * @param token Token
   * @param tokenSecret Token secret
   */
  public Yelp(String consumerKey, String consumerSecret, String token, String tokenSecret) {
    this.service = new ServiceBuilder().provider(com.storitz.yelp.YelpApi2.class).apiKey(consumerKey).apiSecret(consumerSecret).build();
    this.accessToken = new Token(token, tokenSecret);
  }

  /**
   * Search with term and location.
   *
   * @param latitude Latitude
   * @param longitude Longitude
   * @param params the yelp id of the biz. and other arguments that might be needed.
   * @return JSON string response
   */
  public String search(double latitude, double longitude, String params) {
    OAuthRequest request;
    if (params.length() <= 0) {
        request = new OAuthRequest(Verb.GET, "http://api.yelp.com/v2/search");
        request.addQuerystringParameter("term", "self+storage");
        request.addQuerystringParameter("ll", latitude + "," + longitude);
        request.addQuerystringParameter("category_filter", "selfstorage");
        request.addQuerystringParameter("limit", "1");
        request.addQuerystringParameter("sort", "1");
        request.addQuerystringParameter("radius_filter", "300");
    }
    else {
        request = new OAuthRequest(Verb.GET, "http://api.yelp.com/v2/business/"+params);
    }
    this.service.signRequest(this.accessToken, request);
    Response response = request.send();
    return response.getBody();
  }


  public static Yelp newInstance() {
      String consumerKey = "XGY74hMiq2Vqe_2rXTGkXg";
      String consumerSecret = "BjvEVIe7XDavXGyOlnVxz8Qo_Qk";
      String token = "1F3P66uwRv-t9NwIXzhz371tkTbO8rgz";
      String tokenSecret = "03LJdE-bst4sX-SNQvnvKqtsRNE";

      return new Yelp(consumerKey, consumerSecret, token, tokenSecret);
  }

//  CLI
  public static void main(String[] args) {
    Yelp yelp = Yelp.newInstance();
    String response = yelp.search(30.361471, -87.164326, "extra-space-storage-los-angeles-2");
    System.out.println(response);
  }
}
