package ru.bot.telegram.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.bot.telegram.Storage;
import ru.bot.telegram.utils.Const;

@Component
@RequiredArgsConstructor
@Slf4j
public class MyBot extends TelegramLongPollingBot {

    private final Storage storage;
    private final CommonProperties commonProperties;

    @Override
    public String getBotUsername() {
        return commonProperties.getDebtCalculationBot().name();
    }

    @Override
    public String getBotToken() {
        return commonProperties.getDebtCalculationBot().botToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                //достаем сообщение пользователя
                Message message = update.getMessage();
                // id чата пользователя
                var chatId = message.getChatId();
                // получим текст сообщения пользователя
                String response = parseMessage(message.getText());
                //Создаем объект класса SendMessage - наш будущий ответ пользователю
                SendMessage sendMessage = new SendMessage();

                //Добавляем в наше сообщение id чата а также наш ответ
                sendMessage.setChatId(chatId);
                sendMessage.setText(response);

                //отправим в чат
                execute(sendMessage);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
//            log.error("ошибка при работе с сообщением, exception {}",
//                    e.getMessage());
        }
    }

    public String parseMessage(String textMsg) {
        String response;
        if (textMsg.equals(Const.MessageUser.START_MESSAGE)) {
            response = "Приветствую, бот знает много цитат. Жми /get, чтобы получить случайную из них";
        } else if (textMsg.equals(Const.MessageUser.GET_COMMAND)) {
            response = storage.getPhrase();
        } else if (textMsg.equalsIgnoreCase("хочу")) {
            response = "вот ваша бесплатная консультация";
        } else {
            return "сообщение не распознано";
        }

        return response;
    }
}