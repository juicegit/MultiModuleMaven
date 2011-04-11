package org.sonatype.mavenbook.exercise.persist;

import org.sonatype.mavenbook.exercise.model.Run;
import org.sonatype.mavenbook.weather.model.Weather;

import java.util.List;

/**
 * User: chq-justinh
 * Date: 4/6/11
 * Time: 4:21 PM
 * <p/>
 * Class Description
 */
public interface RunDAO {

    Run findByWeather(Weather weather);

    List<Run> all();
}
