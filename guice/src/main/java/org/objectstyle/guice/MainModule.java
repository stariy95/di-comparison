package org.objectstyle.guice;

import com.google.inject.Binder;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;
import org.objectstyle.di.service.Service;
import org.objectstyle.di.service.ServiceImpl;
import org.objectstyle.di.service.SubService;
import org.objectstyle.di.service.SubServiceImpl;

import javax.inject.Named;
import javax.inject.Singleton;

public class MainModule implements Module {

    @Override
    public void configure(Binder binder) {
        Multibinder<Service> multibinder = Multibinder.newSetBinder(binder, Service.class);
        multibinder.addBinding().to(Key.get(Service.class));
        multibinder.addBinding().to(ServiceImpl2.class);

        MapBinder.newMapBinder(binder, String.class, String.class)
                .addBinding("1").to(Key.get(String.class, Names.named("test")));
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
