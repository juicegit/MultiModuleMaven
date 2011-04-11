package org.sonatype.mavenbook.exercise.persist;

import org.sonatype.mavenbook.exercise.model.Run;
import org.sonatype.mavenbook.weather.model.Weather;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/**
 * User: chq-justinh
 * Date: 4/6/11
 * Time: 4:28 PM
 * <p/>
 * Class Description
 */
public class RunDAOImplTest extends AbstractTransactionalDataSourceSpringContextTests {

    RunDAO runDao;

    public RunDAOImplTest() {
        super();
        setDependencyCheck(false);
        setAutowireMode(AUTOWIRE_BY_NAME);
    }

    @Override
    protected String[] getConfigLocations() {
        return new String[] {"test-applicationContext.xml"};
    }

    public void setRunDao(RunDAO runDAO) {
        this.runDao = runDAO;
    }

    public void testFindByWeather() throws Exception {
        final Weather weather = new Weather();
        weather.setId(1);
        final Run run = runDao.findByWeather(weather);
        assertNotNull(run);
    }

    public void testAll() throws Exception {

    }
}
