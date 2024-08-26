package com.liligo.config;

import java.nio.charset.StandardCharsets;
import java.time.Clock;
import java.time.ZoneId;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
public class AppConfig {

    private static final ZoneId ZONE_ID = ZoneId.of("Europe/Budapest");

    @Bean
    public MessageSource messageSource() {
        var messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages");
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver() {
        var sessionLocaleResolver = new AcceptHeaderLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(new Locale.Builder().setLanguage("en").build());
        return sessionLocaleResolver;
    }

    @Bean
    public Clock localClock() {
        return Clock.system(ZONE_ID);
    }

}
