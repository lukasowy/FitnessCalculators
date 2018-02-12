package org.lukasowy.fitnesscalculators;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BMIActivityTest {

    BMIActivity bmiActivity;

    @Before
    public void before() {
        bmiActivity = new BMIActivity();
    }

    @Test
    public void testCalculateBMI_1() {
        assertEquals(9.13, bmiActivity.calculateBMI(34, 193),0.0);
    }
    @Test
    public void testCalculateBMI_2() {
        assertEquals(9.13, bmiActivity.calculateBMI(34, 193),0.0);
    }
}