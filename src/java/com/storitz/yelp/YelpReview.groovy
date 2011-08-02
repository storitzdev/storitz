package com.storitz.yelp

import org.apache.commons.validator.routines.IntegerValidator

/**
 * Created by IntelliJ IDEA.
 * User: dominique
 * Date: 8/2/11
 * Time: 10:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class YelpReview {
  private String id
  private Integer reviewCount
  private String starUrl
  private String bizUrl
  private List reviews

  public String getId ( ) {
    return id ;
  }

  public void setId ( String id ) {
    this . id = id ;
  }

  public Integer getReviewCount ( ) {
    return reviewCount ;
  }

  public void setReviewCount ( Integer reviewCount ) {
    this . reviewCount = reviewCount ;
  }

  public String getStarUrl ( ) {
    return starUrl ;
  }

  public void setStarUrl ( String starUrl ) {
    this . starUrl = starUrl ;
  }

  public String getBizUrl ( ) {
    return bizUrl ;
  }

  public void setBizUrl ( String bizUrl ) {
    this . bizUrl = bizUrl ;
  }

  public void setReviews ( List reviews) {
    this.reviews = reviews;
  }

  public List getReviews () {
    return reviews;
  }
}
