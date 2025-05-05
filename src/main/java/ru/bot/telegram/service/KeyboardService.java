package ru.bot.telegram.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public interface KeyboardService {

    ReplyKeyboardMarkup getMainMenuKeyboard();
}
