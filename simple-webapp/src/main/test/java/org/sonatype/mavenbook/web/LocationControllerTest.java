package org.sonatype.mavenbook.web;

import junit.framework.TestCase;
import org.sonatype.mavenbook.weather.model.Location;
import org.sonatype.mavenbook.weather.persist.LocationFinder;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * User: chq-justinh
 * Date: 3/29/11
 * Time: 5:35 PM
 *
 * Class Description
 */
public class LocationControllerTest extends TestCase {
    public void testHandleRequest() throws Exception {

        LocationController controller = new LocationController();

        controller.setLocationDao(new LocationFinder() {
            public Location findByZip(String zip) {
                return null;
            }

            public List<Location> all() {
                List<Location> locations = new ArrayList<Location>();
                locations.add(new Location());
                locations.add(new Location());
                return locations;  //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        final MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
        final ModelAndView modelAndView = controller.handleRequest(httpServletRequest, new MockHttpServletResponse());
        assertNotNull(modelAndView);
        assertEquals("locations", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        assertEquals(2, ((List) modelAndView.getModel().get("locations")).size());

    }
}
