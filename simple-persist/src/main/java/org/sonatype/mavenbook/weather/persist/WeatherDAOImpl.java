package org.sonatype.mavenbook.weather.persist;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.sonatype.mavenbook.weather.model.Location;
import org.sonatype.mavenbook.weather.model.Weather;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 */
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class WeatherDAOImpl extends HibernateDaoSupport implements WeatherDAO {

    public WeatherDAOImpl() {

    }

    @Transactional(propagation= Propagation.SUPPORTS, readOnly=false)
    public void save(Weather weather) {
        getHibernateTemplate().save(weather);
    }

    public Weather load(Integer id) {
        final Weather weather = (Weather) getHibernateTemplate().load(Weather.class, id);
        Hibernate.initialize(weather);
        return weather;
    }

    public List<Weather> recentForLocation(final Location location) {
        return (List<Weather>) getHibernateTemplate().execute(
                new HibernateCallback() {
                    public Object doInHibernate(Session session) throws HibernateException, SQLException {
                        Query query = getSession().getNamedQuery("Weather.byLocation");
                        query.setParameter("location", location);
                        return new ArrayList<Location>(query.list());
                    }
                }
        );
    }

}
