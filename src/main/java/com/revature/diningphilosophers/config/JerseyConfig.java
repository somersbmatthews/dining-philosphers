package com.revature.diningphilosophers.config;

import com.revature.diningphilosophers.controller.Dining;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(Dining.class);
//        setProperties(Collections.singletonMap(
//                "jersey.config.server.response.setStatusOverSendError", true));
    }

}
