package ru.bot.telegram.service;

import org.telegram.telegrambots.meta.api.objects.User;

public interface UserService {

    void createUser(User user);

    boolean existsUserById(Long id);
}
