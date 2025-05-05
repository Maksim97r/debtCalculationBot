package ru.bot.telegram.api;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.bot.telegram.configuration.CommonProperties;
import ru.bot.telegram.service.MessageService;
import ru.bot.telegram.service.UserService;
import ru.bot.telegram.utils.Const;

@Component
@RequiredArgsConstructor
@Slf4j
public class BotInteractionService extends TelegramLongPollingBot {

    private final CommonProperties commonProperties;
    private final UserService userService;
    private final MessageService messageService;

    @Override
    public String getBotUsername() {
        return commonProperties.getDebtCalculationBot().name();
    }

    @Override
    public String getBotToken() {
        return commonProperties.getDebtCalculationBot().botToken();
    }

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            User user = update.getMessage().getFrom();

            if (messageText.equalsIgnoreCase(Const.MessageUser.START_MESSAGE)) {
                handleStartCommand(update, user);
            }
        }
    }

    public void handleStartCommand(Update update, User user) throws TelegramApiException {
        Long chatId = update.getMessage().getChatId();
        Integer messageId = update.getMessage().getMessageId();

        if (!userService.existsUserById(user.getId())) {
            userService.createUser(user);
        }

        execute(messageService.getDeleteMessage(chatId, messageId));
        execute(messageService.getStartMessage(chatId, user.getFirstName()));
    }
}