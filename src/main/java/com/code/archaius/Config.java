package com.code.archaius;

import com.netflix.config.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/18.
 */
@RestController
public class Config {

    @RequestMapping(value = "/test/startConfig")
    public void startConfig()
    {
        PolledConfigurationSource polledConfigurationSource = new DBConfigurationSource();
        AbstractPollingScheduler abstractPollingScheduler = new MyScheduler();
        DynamicConfiguration dynamicConfiguration = new DynamicConfiguration(polledConfigurationSource,abstractPollingScheduler);

        ConfigurationManager configurationManager = new ConfigurationManager();
        configurationManager.install(dynamicConfiguration);

        DynamicStringProperty dynamicStringProperty = DynamicPropertyFactory.getInstance().getStringProperty("property","");
        dynamicStringProperty.get();
    }
}
