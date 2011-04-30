package org.sonatype.mavenbook.web;

import junit.framework.TestCase;
import org.sonatype.mavenbook.weather.model.Location;
import org.sonatype.mavenbook.weather.model.Weather;
import org.sonatype.mavenbook.weather.persist.LocationDAO;
import org.sonatype.mavenbook.weather.persist.WeatherDAO;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * User: chq-justinh
 * Date: 4/29/11
 * Time: 4:38 PM
 * <p/>
 * Class Description
 */
public class HistoryControllerTest extends TestCase {
    public void testHandleRequest() throws Exception {

        HistoryController hc = new HistoryController();

        hc.setLocationDao(new LocationDAO() {
            public Location findByZip(String zip) {
                return new Location();
            }

            public List<Location> all() {
                throw new UnsupportedOperationException("method not supported");
            }
        });

        hc.setWeatherDao(new WeatherDAO() {
            public void save(Weather weather) {
                throw new UnsupportedOperationException("not supported");
            }

            public Weather load(Integer id) {
                throw new UnsupportedOperationException("not supported");
            }

            public List<Weather> recentForLocation(Location location) {
                final ArrayList<Weather> weathers = new ArrayList<Weather>();
                weathers.add(new Weather());
                weathers.add(new Weather());
                return weathers;
            }
        });

        final MockHttpServletRequest request = new MockHttpServletRequest("GET", "history?zip=60462&output=xls");
        request.setParameter("zip", "60462");
        request.setParameter("output", "xls");

        final ModelAndView modelAndView = hc.handleRequest(request,
                new MockHttpServletResponse());

        assertNotNull(modelAndView);
        assertSame(ExcelHistoryView.class, modelAndView.getView().getClass());

    }
}
