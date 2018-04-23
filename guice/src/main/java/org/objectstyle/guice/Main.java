package org.objectstyle.guice;

import java.util.Set;

import com.google.inject.Guice;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import org.objectstyle.di.service.Service;

public class Main {

    public static void main(String[] args) {
        Set<Service> services = Guice.createInjector(new MainModule())
                .getInstance(Key.get(new TypeLiteral<Set<Service>>(){}));

        for(Service s : services) {
            System.out.println(s.doIt());
        }
    }
}
