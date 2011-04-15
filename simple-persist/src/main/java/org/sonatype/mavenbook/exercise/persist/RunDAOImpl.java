package org.sonatype.mavenbook.exercise.persist;

import org.hibernate.Query;
import org.hibernate.Session;
import org.sonatype.mavenbook.exercise.model.Run;
import org.sonatype.mavenbook.weather.model.Location;
import org.sonatype.mavenbook.weather.model.Weather;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: chq-justinh
 * Date: 4/6/11
 * Time: 4:26 PM
 * <p/>
 * Class Description
 */
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class RunDAOImpl extends HibernateDaoSupport implements RunDAO {
    public Run findByWeather(final Weather weather) {
        return (Run) getHibernateTemplate().execute(new HibernateCallback() {
                    public Object doInHibernate(Session session) {
                        Query query = getSession().getNamedQuery("Run.uniqueByWeather");
                        query.setEntity("weather", weather);
                        return query.uniqueResult();
                    }
                });
    }

    public List<Run> all() {
        return (List<Run>) getHibernateTemplate().loadAll(Run.class);
    }

    public void save(Run run) {
        getHibernateTemplate().save(run);
    }
}
