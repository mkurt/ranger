/**
 * Copyright 2016 Flipkart Internet Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flipkart.ranger.healthservice.monitor;

import com.flipkart.ranger.healthcheck.HealthcheckStatus;
import org.junit.Assert;
import org.junit.Test;

public class RollingWindowHealthQueueTest {

    @Test
    public void testCheckInRollingWindow1() throws Exception {
        RollingWindowHealthQueue rollingWindowHealthQueue = new RollingWindowHealthQueue(5, 3);
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
    }

    @Test
    public void testCheckInRollingWindowEdge() throws Exception {
        try {
            RollingWindowHealthQueue rollingWindowHealthQueue = new RollingWindowHealthQueue(1, 3);
            Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
        } catch (Exception u) {
            Assert.assertTrue(u instanceof UnsupportedOperationException);
        }
    }

    @Test
    public void testCheckInRollingWindowEdge2() throws Exception {
        RollingWindowHealthQueue rollingWindowHealthQueue = new RollingWindowHealthQueue(3, 3);
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
        Assert.assertFalse(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
        Assert.assertFalse(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
    }

    @Test
    public void testCheckInRollingWindowEdge3() throws Exception {
        RollingWindowHealthQueue rollingWindowHealthQueue = new RollingWindowHealthQueue(5, 1);
        Assert.assertFalse(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
        Assert.assertFalse(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
        Assert.assertFalse(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
        Assert.assertFalse(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertFalse(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertFalse(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertFalse(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertFalse(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
    }


    @Test
    public void testCheckInRollingWindow2() throws Exception {
        RollingWindowHealthQueue rollingWindowHealthQueue = new RollingWindowHealthQueue(5, 3);
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
    }


    @Test
    public void testCheckInRollingWindow3() throws Exception {
        RollingWindowHealthQueue rollingWindowHealthQueue = new RollingWindowHealthQueue(5, 3);
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
        Assert.assertFalse(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
        Assert.assertFalse(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
        Assert.assertFalse(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertFalse(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
    }

    @Test
    public void testCheckInRollingWindow4() throws Exception {
        RollingWindowHealthQueue rollingWindowHealthQueue = new RollingWindowHealthQueue(5, 3);
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
        Assert.assertFalse(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
        Assert.assertFalse(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
        Assert.assertFalse(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertFalse(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
        Assert.assertFalse(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.healthy));
        Assert.assertTrue(rollingWindowHealthQueue.checkInRollingWindow(HealthcheckStatus.unhealthy));
    }
}