package com.keystone;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class ResourceConfiguration extends ResourceConfig {

    public ResourceConfiguration() {
        packages("com.keystone.rest");
    }
}
