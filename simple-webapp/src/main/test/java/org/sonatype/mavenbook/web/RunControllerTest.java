package org.sonatype.mavenbook.web;

import junit.framework.TestCase;
import org.sonatype.mavenbook.exercise.model.ClothingComfort;
import org.sonatype.mavenbook.exercise.model.Run;
import org.sonatype.mavenbook.exercise.persist.RunDAO;
import org.sonatype.mavenbook.weather.model.Weather;
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
    public void testHandleRequest() throws Exception {

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
}
