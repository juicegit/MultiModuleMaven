package org.sonatype.mavenbook.weather.model;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: chq-justinh
 * Date: 3/22/11
 * Time: 9:48 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Wind {

    private static final String directions[] = {"N", "NE", "E", "SE", "S", "SW", "W", "NW", "N"};


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String chill;
    private String direction;
    private String speed;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weather_id", nullable = false)
    private Weather weather;


    public String getChill() {
        return chill;
    }

    public void setChill(String chill) {
        this.chill = chill;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public String getDirectionDescription() {
        return directions[ (int)Math.round((
                ((double)Double.parseDouble(direction) % 360) / 45)) ];
    }
}
