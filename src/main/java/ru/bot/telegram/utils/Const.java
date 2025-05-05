package ru.bot.telegram.utils;

import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class Const {

    @UtilityClass
    public static class MessageUser {

        public final static String START_MESSAGE = "/start";
    }

    @UtilityClass
    public static class Keyboard {
        public final static List<String> ALL_KEYBOARD_BUTTON = List.of(
                "Мои задолженности",
                "Добавить категорию",
                "Внести платеж");

        //TODO: Возможно убрать
        public final static String CREATE_NEW_DEBT = "Добавить категорию";
        public final static String GET_CATEGORY_DEBT = "Остаток задлжности по категории";
        public final static String GET_ALL_DEBT = "Сумма общей задолжности";
    }

    @UtilityClass
    public static class UserMessage {

        private final static String BUTTON_CREATE_CATEGORY = "Добавить категорию";
        private final static String BUTTON_MY_DEBT = "Мои задолженности";
        private final static String BUTTON_PAYMENT = "Внести платеж";
    }

    @UtilityClass
    public static class BotMessage {

        public final static String HELLO_USER = "Добро пожаловать, %s";
    }
}
