package ru.bot.telegram.service;

import ru.bot.telegram.model.CreditCategory;

import java.math.BigDecimal;

public interface DataManagementBotService {
    CreditCategory createNewCategory(CreditCategory category);

}
