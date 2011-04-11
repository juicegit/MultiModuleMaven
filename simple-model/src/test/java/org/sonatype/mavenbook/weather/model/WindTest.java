package org.sonatype.mavenbook.weather.model;

import junit.framework.TestCase;

/**
 * Created by IntelliJ IDEA.
 * User: chq-justinh
 * Date: 3/25/11
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class WindTest extends TestCase {


    public void testGetDirectionString() {

        Wind wind = new Wind();
        wind.setDirection("180");
        assertEquals("S", wind.getDirectionDescription());

        wind.setDirection("0");
        assertEquals("N", wind.getDirectionDescription());

        wind.setDirection("360");
        assertEquals("N", wind.getDirectionDescription());

        wind.setDirection("90");
        assertEquals("E", wind.getDirectionDescription());

        wind.setDirection("269");
        assertEquals("W", wind.getDirectionDescription());




    }
}
