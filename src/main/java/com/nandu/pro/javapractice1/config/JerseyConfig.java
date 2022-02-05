package com.nandu.pro.javapractice1.config;

import com.nandu.pro.javapractice1.resources.HelloResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(HelloResource.class);

        // Register resources and providers using package-scanning.
        packages("com.nandu.pro.javapractice1.config");
    }
}
