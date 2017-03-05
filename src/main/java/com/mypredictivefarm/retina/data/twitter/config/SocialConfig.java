package com.mypredictivefarm.retina.data.twitter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;

import javax.inject.Inject;

/**
 * Created by Helmut on 05.03.2017.
 */

@Configuration
public class SocialConfig {

    @Inject
    private Environment environment;

    /**
     * When a new provider is added to the app, register its {@link ConnectionFactory} here.
     */
    @Bean
    ConnectionFactoryLocator connectionFactoryLocator() {
        ConnectionFactoryRegistry connectionFactoryRegistry = new ConnectionFactoryRegistry();
        connectionFactoryRegistry.addConnectionFactory(new TwitterConnectionFactory(environment.getProperty
            ("twitter.clientId"), environment.getProperty("twitter.clientSecret")));

        return connectionFactoryRegistry;
    }
}
