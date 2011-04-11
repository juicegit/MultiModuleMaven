package org.sonatype.mavenbook.exercise.model;

import org.sonatype.mavenbook.weather.model.Weather;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: chq-justinh
 * Date: 4/1/11
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Run.uniqueByWeather", query="from Run r where r.weather = :weather")
})
public class Run {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="weather_id", nullable=false)
    Weather weather;

    Boolean usedPants;

    Boolean usedLongSleeve;

    Boolean usedJacket;

    ClothingComfort clothingComfort;

    Integer runSensation;

    public ClothingComfort getClothingComfort() {
        return clothingComfort;
    }

    public void setClothingComfort(ClothingComfort clothingComfort) {
        this.clothingComfort = clothingComfort;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRunSensation() {
        return runSensation;
    }

    public void setRunSensation(Integer runSensation) {
        this.runSensation = runSensation;
    }

    public Boolean getUsedJacket() {
        return usedJacket;
    }

    public void setUsedJacket(Boolean usedJacket) {
        this.usedJacket = usedJacket;
    }

    public Boolean getUsedLongSleeve() {
        return usedLongSleeve;
    }

    public void setUsedLongSleeve(Boolean usedLongSleeve) {
        this.usedLongSleeve = usedLongSleeve;
    }

    public Boolean getUsedPants() {
        return usedPants;
    }

    public void setUsedPants(Boolean usedPants) {
        this.usedPants = usedPants;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }
}
