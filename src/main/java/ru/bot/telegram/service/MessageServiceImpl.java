package ru.bot.telegram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import ru.bot.telegram.utils.Const;


@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final KeyboardService keyboardService;

    public SendMessage getStartMessage(Long chatId, String firstName) {
        return SendMessage.builder()
                .chatId(chatId)
                .replyMarkup(keyboardService.getMainMenuKeyboard())
                .text(Const.BotMessage.HELLO_USER.formatted(firstName))
                .build();
    }

    public DeleteMessage getDeleteMessage(Long chatId, Integer messageId) {
        return DeleteMessage.builder()
                .chatId(chatId)
                .messageId(messageId)
                .build();
    }
}