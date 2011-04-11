package org.sonatype.mavenbook.weather.model;


import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: chq-justinh
 * Date: 3/22/11
 * Time: 9:50 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Atmosphere {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String humidity;
    private String visibility;
    private String pressure;
    private String rising;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="weather_id",nullable = false)
    private Weather weather;

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getRising() {
        return rising;
    }

    public void setRising(String rising) {
        this.rising = rising;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public String getRisingDescription() {
        return PressureState.values()[Integer.valueOf(this.rising)].toString();
    }
}
