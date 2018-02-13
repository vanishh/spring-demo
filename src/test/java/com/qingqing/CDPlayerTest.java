package com.qingqing;

import com.qingqing.config.CDPlayerConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private CompactDisc compactDisc;

    @Autowired
    private CDPlayer cdPlayer;

    @Test
    public void testShouldNotBeNull() {
        Assert.assertNotNull(compactDisc);
        // spring容器确实创建出 CompactDisc bean
        System.out.println(compactDisc);
    }

    @Test
    public void testPlay() {
        cdPlayer.play();
    }
}
