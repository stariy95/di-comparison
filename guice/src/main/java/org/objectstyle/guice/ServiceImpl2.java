package org.objectstyle.guice;

import java.util.Map;
import javax.inject.Inject;

import org.objectstyle.di.service.Service;

public class ServiceImpl2 implements Service {

    @Inject
    private Map<String, String> map;

    @Override
    public String doIt() {
        return "SubServiceImpl2";
    }
}
