package org.sonatype.mavenbook.weather.model;

import junit.framework.TestCase;

/**
 * Created by IntelliJ IDEA.
 * User: chq-justinh
 * Date: 3/25/11
 * Time: 9:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class PressureStateTest extends TestCase {

    public void testGetStateFromInteger() {

        assertEquals(PressureState.STEADY, PressureState.values()[0]);
        assertEquals(PressureState.RISING, PressureState.values()[1]);
        assertEquals(PressureState.FALLING, PressureState.values()[2]);
        assertEquals("RISING", PressureState.values()[1].toString());
        assertEquals("STEADY", PressureState.values()[0].toString());
        assertEquals("FALLING", PressureState.values()[2].toString());
    }

}
