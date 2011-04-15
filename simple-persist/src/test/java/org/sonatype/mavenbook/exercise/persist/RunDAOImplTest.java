package org.sonatype.mavenbook.exercise.persist;

import org.sonatype.mavenbook.exercise.model.ClothingComfort;
import org.sonatype.mavenbook.exercise.model.Run;
import org.sonatype.mavenbook.weather.model.Weather;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import java.util.List;

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

    public void testSaveRetrieveEnum() {
        Run run = new Run();
        final Weather weather = new Weather();
        run.setWeather(weather);
        run.setClothingComfort(ClothingComfort.JUST_RIGHT);
        runDao.save(run);

        final Run fetchedRun = runDao.findByWeather(weather);
        assertEquals(ClothingComfort.JUST_RIGHT, fetchedRun.getClothingComfort());
    }

    public void testAll() throws Exception {
        Run run1 = new Run();
        run1.setWeather(new Weather());
        runDao.save(run1);

        Run run2 = new Run();
        run2.setWeather(new Weather());
        runDao.save(run2);

        List<Run> runs = runDao.all();
        assertNotNull(runs);
        assertEquals(2, runs.size());
    }
}
