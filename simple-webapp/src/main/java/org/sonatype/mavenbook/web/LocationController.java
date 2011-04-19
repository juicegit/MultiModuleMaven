package org.sonatype.mavenbook.web;

import org.sonatype.mavenbook.weather.persist.LocationFinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: chq-justinh
 * Date: 3/29/11
 * Time: 5:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class LocationController implements Controller {
    private LocationFinder locationDao;

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        return new ModelAndView("location", "locations", locationDao.all());
    }


    public void setLocationDao(LocationFinder locationDAO) {
        this.locationDao = locationDAO;
    }
}
