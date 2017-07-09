package com.code.archaius;

import com.netflix.config.PollResult;
import com.netflix.config.PolledConfigurationSource;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/18.
 */
public class DBConfigurationSource implements PolledConfigurationSource {
    @Override
    public PollResult poll(boolean b, Object o) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("test","11111111111111188888888888");
        return PollResult.createFull(map);
    }
}
