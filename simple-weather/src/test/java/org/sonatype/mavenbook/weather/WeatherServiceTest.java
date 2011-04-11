package org.sonatype.mavenbook.weather;

import junit.framework.TestCase;
import org.sonatype.mavenbook.weather.model.Weather;

/**
 * User: chq-justinh
 * Date: 3/22/11
 * Time: 3:24 PM
 *
 * Class Description
 */
public class WeatherServiceTest extends TestCase {
    public void testRetrieveForecast() throws Exception {

        WeatherService service = new WeatherService();
        service.setYahooParser(new YahooParser());
        service.setYahooRetriever(new YahooRetriever());

        final Weather weather = service.retrieveForecast("98104");
        assertNotNull(weather);
    }
}
