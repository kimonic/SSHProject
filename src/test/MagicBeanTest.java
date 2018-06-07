package test;

import mspring4.S_3_1.MagicBean;
import mspring4.S_3_1.MagicBeanConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MagicBeanConfig.class)
public class MagicBeanTest {
    @Autowired
    private MagicBean magicBean;
    @Test
    public void injectSucess(){
        Assert.assertEquals(magicBean.getName(),"亦筝笙");
        Assert.assertEquals(magicBean.getPassword(),"12345678");
    }
}
