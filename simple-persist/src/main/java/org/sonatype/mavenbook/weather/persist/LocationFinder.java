package org.sonatype.mavenbook.weather.persist;

import org.sonatype.mavenbook.weather.model.Location;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: chq-justinh
 * Date: 3/30/11
 * Time: 11:07 AM
 * To change this template use File | Settings | File Templates.
 */
public interface LocationFinder {
    Location findByZip(String zip);

    @SuppressWarnings("unchecked")
    List<Location> all();
}
