package ru.bot.telegram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import ru.bot.telegram.utils.Const;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KeyboardServiceImpl implements KeyboardService {

    public ReplyKeyboardMarkup getMainMenuKeyboard() {
        KeyboardRow allButtons = new KeyboardRow();

        allButtons.addAll(Const.Keyboard.ALL_KEYBOARD_BUTTON);

        return ReplyKeyboardMarkup.builder()
                .keyboard(List.of(allButtons))
                .resizeKeyboard(true)
                .isPersistent(true)
                .build();
    }
}
