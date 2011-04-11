package org.sonatype.mavenbook.web;

import org.sonatype.mavenbook.weather.WeatherService;
import org.sonatype.mavenbook.weather.model.Weather;
import org.sonatype.mavenbook.weather.persist.WeatherDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: chq-justinh
 * Date: 3/22/11
 * Time: 4:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class WeatherController implements Controller {
    private WeatherService weatherService;
    private WeatherDAO weatherDao;

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        String zip = httpServletRequest.getParameter("zip");
        Weather weather = weatherService.retrieveForecast(zip);
        weatherDao.save(weather);
        return new ModelAndView("weather", "weather", weather);
    }

    public WeatherDAO getWeatherDao() {
        return weatherDao;
    }

    public void setWeatherDao(WeatherDAO weatherDao) {
        this.weatherDao = weatherDao;
    }

    public WeatherService getWeatherService() {
        return weatherService;
    }

    public void setWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
}
