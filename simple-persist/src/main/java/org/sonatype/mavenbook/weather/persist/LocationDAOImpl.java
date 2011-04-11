package org.sonatype.mavenbook.weather.persist;

import org.hibernate.Query;
import org.hibernate.Session;
import org.sonatype.mavenbook.weather.model.Location;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 */
@Transactional(propagation= Propagation.SUPPORTS, readOnly=true)
public class LocationDAOImpl extends HibernateDaoSupport implements LocationDAO {

    public LocationDAOImpl() {}

    public Location findByZip(final String zip) {
    	return (Location) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				Query query = getSession().getNamedQuery("Location.uniqueByZip");
				query.setString("zip", zip);
				return query.uniqueResult();
			}
		});
    }

    @SuppressWarnings("unchecked")
	public List<Location> all() {
    	return new ArrayList<Location>( getHibernateTemplate().loadAll(Location.class) );
    }

}
