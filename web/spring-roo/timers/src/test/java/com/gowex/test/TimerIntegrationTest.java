package com.gowex.test;

import org.springframework.roo.addon.test.RooIntegrationTest;
import com.gowex.test.Timer;
import org.junit.Test;

@RooIntegrationTest(entity = Timer.class)
public class TimerIntegrationTest {

    @Test
    public void testMarkerMethod() {
    }
}
