package org.sonatype.mavenbook.weather.persist;

import org.sonatype.mavenbook.weather.model.Location;
import org.sonatype.mavenbook.weather.model.Weather;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: chq-justinh
 * Date: 4/5/11
 * Time: 10:02 AM
 * To change this template use File | Settings | File Templates.
 */
public interface WeatherDAO {
    @Transactional(propagation= Propagation.SUPPORTS, readOnly=false)
    void save(Weather weather);

    Weather load(Integer id);

    List<Weather> recentForLocation(Location location);
}
