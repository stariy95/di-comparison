package org.objectstyle.bootique;

import javax.inject.Named;
import javax.inject.Singleton;

import io.bootique.di.Binder;
import io.bootique.di.Key;
import io.bootique.di.Module;
import io.bootique.di.Provides;
import org.objectstyle.di.service.Service;
import org.objectstyle.di.service.ServiceImpl;
import org.objectstyle.di.service.SubService;
import org.objectstyle.di.service.SubServiceImpl;

public class MainModule implements Module {

    @Override
    public void configure(Binder binder) {
        binder.bindSet(Service.class)
                .add(Key.get(Service.class))
                .add(ServiceImpl2.class);

        binder.bindMap(String.class, String.class)
                .put("1", Key.get(String.class, "test"));
    }

    @Provides
    @Singleton
    Service provideService(SubService subService) {
        return new ServiceImpl(subService);
    }

    @Provides
    @Singleton
    SubService provideSubService() {
        return new SubServiceImpl();
    }

    @Provides
    @Named("test")
    public String provideString() {
        return "test";
    }

}
