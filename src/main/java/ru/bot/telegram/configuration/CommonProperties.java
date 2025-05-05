package ru.bot.telegram.configuration;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "common")
@Getter
@Valid
@AllArgsConstructor
public class CommonProperties {

    private TelegramBot debtCalculationBot;

    @Valid
    public record TelegramBot(
            @NotNull String botToken,
            @NotNull String name
    ) {

    }
}