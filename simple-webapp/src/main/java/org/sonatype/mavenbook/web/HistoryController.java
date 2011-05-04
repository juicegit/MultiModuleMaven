package org.sonatype.mavenbook.web;

import org.hibernate.property.Dom4jAccessor;
import org.sonatype.mavenbook.weather.model.Location;
import org.sonatype.mavenbook.weather.model.Weather;
import org.sonatype.mavenbook.weather.persist.LocationFinder;
import org.sonatype.mavenbook.weather.persist.WeatherDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: chq-justinh
 * Date: 3/22/11
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class HistoryController implements Controller {
    private LocationFinder locationDao;
    private WeatherDAO weatherDao;

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        String zip = httpServletRequest.getParameter("zip");
        Location location = locationDao.findByZip(zip);
        List<Weather> weathers = weatherDao.recentForLocation( location );
        Map<String,Object> model = new HashMap<String,Object>();
        model.put( "location", location );
        model.put( "weathers", weathers );
        if ("xls".equals(httpServletRequest.getParameter("output"))) {
            return new ModelAndView("excelHistory", model);
        } else {
            return new ModelAndView("history", model);
        }
    }

    public LocationFinder getLocationDao() {
        return locationDao;
    }

    public void setLocationDao(LocationFinder locationDao) {
        this.locationDao = locationDao;
    }

    public WeatherDAO getWeatherDao() {
        return weatherDao;
    }

    public void setWeatherDao(WeatherDAO weatherDao) {
        this.weatherDao = weatherDao;
    }
}
