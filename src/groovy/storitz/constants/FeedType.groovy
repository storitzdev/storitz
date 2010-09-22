package storitz.constants

/**
 * Created by IntelliJ IDEA.
 * User: mamster
 * Date: Sep 21, 2010
 * Time: 2:26:50 PM
 * To change this template use File | Settings | File Templates.
 */
public enum FeedType {
  SITELINK("SiteLink"),
  CENTERSHIFT("Centershift"),
  QUIKSTOR("QuikStor")

  final display

  public FeedType(String display) {
    this.display = display
  }

  static list() {
    [SITELINK, CENTERSHIFT, QUIKSTOR]
  }
}