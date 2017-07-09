package com.code.archaius;

//import com.netflix.config.DynamicLongProperty;
//import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicLongProperty;
import com.netflix.config.DynamicPropertyFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/12.
 */
@RestController
public class ArchaiusController {

    @RequestMapping(value = "/archaius/test")
    public void testArchaius(){
        System.out.println("=========test=============");
        DynamicLongProperty timeToWait = DynamicPropertyFactory.getInstance().getLongProperty("lock.waitTime",1000);
        System.out.println("=====value=========:"+timeToWait.get());
    }

    @RequestMapping(value = "/archaius/testtwo")
    public void testArchaiustwo() throws Exception
    {
        System.out.println("==========two begin============");
        ConfigurationManager.getDeploymentContext().setDeploymentEnvironment("perf");
        System.out.println("environment:"+ ConfigurationManager.getDeploymentContext().getDeploymentEnvironment());
        ConfigurationManager.loadCascadedPropertiesFromResources("sample");
        String myProp = DynamicPropertyFactory.getInstance().getStringProperty("myprop", "NOT FOUND").get();
        System.out.println("the value is :"+myProp);
        System.out.println("===========two end====================");
    }
}
