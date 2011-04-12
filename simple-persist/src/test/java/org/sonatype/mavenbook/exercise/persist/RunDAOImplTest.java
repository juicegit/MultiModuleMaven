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
        Weather weather = new Weather();
        Run run = new Run();
        run.setWeather(weather);
        runDao.save(run);

        final Run foundRun = runDao.findByWeather(weather);
        assertNotNull(foundRun);
        assertEquals(run, foundRun);
    }

    public void testAll() throws Exception {

    }
}
