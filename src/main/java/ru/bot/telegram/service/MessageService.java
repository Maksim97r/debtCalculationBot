package ru.bot.telegram.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;

public interface MessageService {

    SendMessage getStartMessage(Long chatId, String firstName);

    DeleteMessage getDeleteMessage(Long chatId, Integer messageId);
}
