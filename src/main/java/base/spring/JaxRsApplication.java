package base.spring;

import base.controller.impl.AssetControllerImpl;

import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class JaxRsApplication extends javax.ws.rs.core.Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.add(AssetControllerImpl.class);
        return set;
    }
}
