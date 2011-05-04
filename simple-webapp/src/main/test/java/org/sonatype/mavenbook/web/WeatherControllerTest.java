package org.sonatype.mavenbook.web;

import junit.framework.TestCase;
import org.sonatype.mavenbook.weather.WeatherService;
import org.sonatype.mavenbook.weather.model.Location;
import org.sonatype.mavenbook.weather.model.Weather;
import org.sonatype.mavenbook.weather.persist.WeatherDAO;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * User: chq-justinh
 * Date: 5/4/11
 * Time: 10:59 AM
 * <p/>
 * Class Description
 */
public class WeatherControllerTest extends TestCase {


    public void testHandleRequestUpdate() throws Exception {

        WeatherController wc = new WeatherController();
        wc.setWeatherDao(new WeatherDAO() {
            public void save(Weather weather) {
                throw new UnsupportedOperationException("save was called :(");
            }

            public Weather load(Integer id) {
                if (id == null) {
                    fail("WeatherController did not pass in id");
                }
                final Weather weather = new Weather();
                weather.setId(id);
                return weather;
            }

            public List<Weather> recentForLocation(Location location) {
                throw new UnsupportedOperationException("recentForLocation was called");
            }
        });

        // set up the mock so that it does ensures the method is not called.
        final WeatherService mock = mock(WeatherService.class);
        final String zip = "98104";
        when(mock.retrieveForecast(zip)).thenThrow(new RuntimeException("this should not be called"));
        wc.setWeatherService(mock);

        final MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter("zip", zip);
        request.setParameter("id", "123");
        final ModelAndView modelAndView = wc.handleRequest(request, new MockHttpServletResponse());

        assertNotNull(modelAndView);
        Weather weather = (Weather) modelAndView.getModel().get("weather");
        assertNotNull(weather);
        assertEquals(Integer.valueOf("123"), weather.getId());

    }
}
