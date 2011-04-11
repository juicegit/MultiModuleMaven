package org.sonatype.mavenbook.weather.model;


import org.hibernate.engine.Cascade;
import org.sonatype.mavenbook.exercise.model.Run;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: chq-justinh
 * Date: 3/22/11
 * Time: 9:44 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@NamedQueries({
@NamedQuery(name="Weather.byLocation",
query="from Weather w where w.location = :location order by w.date desc")
})
public class Weather {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;



    @ManyToOne(cascade=CascadeType.ALL)
    private Location location;

    @OneToOne(mappedBy="weather", cascade = CascadeType.ALL)
    private Condition condition;

    @OneToOne(mappedBy = "weather", cascade = CascadeType.ALL)
    private Wind wind;

    @OneToOne(mappedBy = "weather", cascade = CascadeType.ALL)
    private Atmosphere atmosphere;

    @OneToOne(mappedBy = "weather", cascade = CascadeType.ALL)
    private Run run;

    private Date date;

    public Weather() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Run getRun() {
        return run;
    }

    public void setRun(Run run) {
        this.run = run;
    }
}
