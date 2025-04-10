package ru.bot.telegram.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CommonProperties.class)
public class ConfigurationCommon {
}
