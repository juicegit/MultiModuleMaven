package org.sonatype.mavenbook.web;

import junit.framework.TestCase;
import org.sonatype.mavenbook.exercise.model.ClothingComfort;
import org.sonatype.mavenbook.exercise.model.Run;
import org.sonatype.mavenbook.exercise.persist.RunDAO;
import org.sonatype.mavenbook.weather.model.Location;
import org.sonatype.mavenbook.weather.model.Weather;
import org.sonatype.mavenbook.weather.persist.WeatherDAO;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import java.nio.channels.UnsupportedAddressTypeException;
import java.util.List;

/**
 * User: chq-justinh
 * Date: 4/15/11
 * Time: 5:13 PM
 * <p/>
 * Class Description
 */
public class RunControllerTest extends TestCase {
    public void testPostNewRun() throws Exception {

        RunController rc = new RunController();
        rc.setRunDao(new RunDAO() {
            public Run findByWeather(Weather weather) {
                throw new UnsupportedOperationException("findByWeather");
            }

            public List all() {
                throw new UnsupportedOperationException("all");
            }

            public void save(Run run) {
                System.out.println("Saved Run: " + run.getClothingComfort());
            }
        } );

        final MockHttpServletRequest request = new MockHttpServletRequest();
        request.setMethod("POST");
        request.setParameter("runSensation", "3");
        request.setParameter("usedPants", "TRUE");
        request.setParameter("usedJacket", "TRUE");
        request.setParameter("clothingComfort", "JUST_RIGHT");
        rc.setSuccessView("run");

        final ModelAndView modelAndView = rc.handleRequest(request, new MockHttpServletResponse());

        assertNotNull(modelAndView);
        final Run run = (Run) modelAndView.getModel().get("run");
        assertNotNull(run);
        assertEquals(Integer.valueOf("3"), run.getRunSensation());
        assertTrue(run.getUsedPants());
        assertTrue(run.getUsedJacket());
        assertEquals(ClothingComfort.JUST_RIGHT, run.getClothingComfort());
    }

    public void testLoadExistingRun() throws Exception {

        RunController rc = new RunController();
        rc.setRunDao(new RunDAO() {
            public Run findByWeather(Weather weather) {
                assert weather != null;
                final Run run = new Run();
                run.setId(Integer.valueOf(1));
                return run;
            }

            public List all() {
                throw new UnsupportedOperationException("all is not supported");
            }

            public void save(Run run) {
                throw new UnsupportedOperationException("save is not supported");
            }
        });

        rc.setWeatherDao(new WeatherDAO() {
            public void save(Weather weather) {
                throw new UnsupportedOperationException("save is not supported");
            }

            public Weather load(Integer id) {
                Weather weather = new Weather();
                weather.setId(id);
                return weather;
            }

            public List<Weather> recentForLocation(Location location) {
                throw new UnsupportedOperationException("recentForLocation is not supported");
            }
        });

        final MockHttpServletRequest request = new MockHttpServletRequest();
        request.setMethod("GET");
        request.setParameter("weatherId", "2");
        rc.setSuccessView("run");

        final ModelAndView modelAndView = rc.handleRequest(request, new MockHttpServletResponse());

        final Run run = (Run) modelAndView.getModel().get("run");
        assertNotNull(run);
        assertEquals(Integer.valueOf(1), run.getId());

    }

    public void testNewRun() throws Exception {

        RunController rc = new RunController();
        rc.setRunDao(new RunDAO() {
            public Run findByWeather(Weather weather) {
                return null;
            }

            public List all() {
                throw new UnsupportedOperationException("all is not supported");
            }

            public void save(Run run) {
                throw new UnsupportedOperationException("save is not supported");
            }
        });

        rc.setWeatherDao(new WeatherDAO() {
            public void save(Weather weather) {
                throw new UnsupportedOperationException("save is not supported");
            }

            public Weather load(Integer id) {
                Weather weather = new Weather();
                weather.setId(id);
                return weather;
            }

            public List<Weather> recentForLocation(Location location) {
                throw new UnsupportedOperationException("recentForLocation is not supported");
            }
        });

        final MockHttpServletRequest request = new MockHttpServletRequest();
        request.setMethod("GET");
        request.setParameter("weatherId", "2");
        rc.setSuccessView("run");

        final ModelAndView modelAndView = rc.handleRequest(request, new MockHttpServletResponse());

        final Run run = (Run) modelAndView.getModel().get("run");
        assertNotNull(run);

    }

}
