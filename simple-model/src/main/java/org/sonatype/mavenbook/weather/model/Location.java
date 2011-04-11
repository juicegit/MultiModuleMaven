package org.sonatype.mavenbook.weather.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Created by IntelliJ IDEA.
 * User: chq-justinh
 * Date: 3/22/11
 * Time: 9:46 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Location.uniqueByZip", query="from Location l where l.zip = :zip")
})
public class Location {

    @Id
    private String zip;

    private String city;
    private String region;
    private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
