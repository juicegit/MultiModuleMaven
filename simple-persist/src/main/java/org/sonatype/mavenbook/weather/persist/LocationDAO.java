package org.sonatype.mavenbook.weather.persist;

import org.sonatype.mavenbook.weather.model.Location;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: chq-justinh
 * Date: 4/5/11
 * Time: 10:00 AM
 * To change this template use File | Settings | File Templates.
 */
public interface LocationDAO extends LocationFinder {
    Location findByZip(String zip);

    @SuppressWarnings("unchecked")
    List<Location> all();
}
