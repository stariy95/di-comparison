package org.objectstyle.bootique;

import javax.inject.Inject;
import javax.inject.Provider;

import io.bootique.di.DIRuntimeException;
import org.objectstyle.di.service.Service;
import org.objectstyle.di.service.ServiceImpl;
import org.objectstyle.di.service.SubService;

public class SubServiceProvider implements Provider<Service> {

    @Inject
    private SubService subService;

    @Override
    public Service get() throws DIRuntimeException {
        return new ServiceImpl(subService);
    }
}
