package org.objectstyle.bootique;

import java.util.Set;

import io.bootique.di.DIBootstrap;
import io.bootique.di.Key;
import org.objectstyle.di.service.Service;

public class Main {

    public static void main(String[] args) {
        Set<Service> services = DIBootstrap.createInjector(new MainModule())
                .getInstance(Key.getSetOf(Service.class));

        for(Service s : services) {
            System.out.println(s.doIt());
        }
    }
}
