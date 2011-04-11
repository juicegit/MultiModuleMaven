package org.sonatype.mavenbook.weather;

import org.apache.log4j.Logger;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by IntelliJ IDEA.
 * User: chq-justinh
 * Date: 3/22/11
 * Time: 10:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class YahooRetriever {

    private static Logger log = Logger.getLogger(YahooRetriever.class);

	public InputStream retrieve(String zipcode) throws Exception {
		log.info( "Retrieving Weather Data" );
		String url = "http://weather.yahooapis.com/forecastrss?p=" + zipcode;

        URLConnection conn = new URL(url).openConnection();
		return conn.getInputStream();
	}
}
