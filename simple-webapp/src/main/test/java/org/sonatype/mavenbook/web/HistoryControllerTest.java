package org.sonatype.mavenbook.web;

import junit.framework.TestCase;
import org.apache.log4j.helpers.DateTimeDateFormat;
import org.sonatype.mavenbook.weather.model.Location;
import org.sonatype.mavenbook.weather.model.Weather;
import org.sonatype.mavenbook.weather.persist.LocationDAO;
import org.sonatype.mavenbook.weather.persist.WeatherDAO;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.DateFormatter;
import java.sql.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * User: chq-justinh
 * Date: 4/29/11
 * Time: 4:38 PM
 * <p/>
 * Class Description
 */
@SuppressWarnings("unchecked")
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
        assertSame("excelHistory", modelAndView.getViewName());
        final List<Weather> weathers = (List<Weather>) modelAndView.getModelMap().get("weathers");
        assertNotNull(weathers);
        assertEquals(2, weathers.size());

    }


    public void testGetLocales() {
        final Locale[] locales = Locale.getAvailableLocales();

        Arrays.sort(locales, new Comparator<Locale>() {
            public int compare(Locale o1, Locale o2) {
                final int i = o1.getISO3Language().compareTo(o2.getISO3Language());
                if (i == 0) {
                    return o1.getCountry().compareTo(o2.getCountry());
                }
                return i;
            }
        });


        for (Locale locale: locales) {
            String tab = "\t\t";
            if (locale.toString().length() < 3) {
                tab = "\t\t\t";
            } else if (locale.toString().length() > 5) {
                tab = "\t";
            }
            System.out.println(locale.toString() + tab + locale.getDisplayName());
        }

        Locale hindi = new Locale("hi");
        Locale hindiIndia = new Locale("hi", "IN");

        SimpleDateFormat format = (SimpleDateFormat) SimpleDateFormat.getDateInstance(DateFormat.FULL, hindi);
        SimpleDateFormat specFormat = (SimpleDateFormat) SimpleDateFormat.getDateInstance(DateFormat.FULL, hindiIndia);
        SimpleDateFormat chinaFormat = (SimpleDateFormat) SimpleDateFormat.getDateInstance(DateFormat.FULL, Locale.CHINESE);

        System.out.println(format.format(new Date()));
        System.out.println(specFormat.format(new Date()));
        System.out.println(chinaFormat.format(new Date()));

        Locale norsk = new Locale("nb");
        Locale bogus = new Locale("88");

    }
}
