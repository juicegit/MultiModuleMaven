package org.sonatype.mavenbook.web;

import org.sonatype.mavenbook.exercise.model.Run;
import org.sonatype.mavenbook.exercise.persist.RunDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 * Created by IntelliJ IDEA.
 * User: chq-justinh
 * Date: 4/1/11
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class RunController extends SimpleFormController {

    private RunDAO runDao;

    public RunController() {
        setCommandClass(Run.class);
        setCommandName("run");
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        runDao.save((Run) command);
        return super.onSubmit(command);
    }

    public void setRunDao(RunDAO runDAO) {

        this.runDao = runDAO;
    }
}
