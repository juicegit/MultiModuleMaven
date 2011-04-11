package org.sonatype.mavenbook.weather;

import org.sonatype.mavenbook.weather.model.Weather;

import java.io.InputStream;

/**
 * Created by IntelliJ IDEA.
 * User: chq-justinh
 * Date: 3/22/11
 * Time: 10:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class WeatherService {
    private YahooRetriever yahooRetriever;
    private YahooParser yahooParser;
    public WeatherService() {
    }
    public Weather retrieveForecast(String zip) throws Exception {
// Retrieve Data
        InputStream dataIn = yahooRetriever.retrieve(zip);
// Parse DataS
        Weather weather = yahooParser.parse(zip, dataIn);
        return weather;
    }
    public YahooRetriever getYahooRetriever() {
        return yahooRetriever;
    }
    public void setYahooRetriever(YahooRetriever yahooRetriever) {
        this.yahooRetriever = yahooRetriever;
    }
    public YahooParser getYahooParser() {
        return yahooParser;
    }
    public void setYahooParser(YahooParser yahooParser) {
        this.yahooParser = yahooParser;
    }
}
