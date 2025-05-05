package ru.bot.telegram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bot.telegram.model.CreditCategory;
import ru.bot.telegram.repository.CreditCategoryRepository;

@Service
@RequiredArgsConstructor
public class DataManagementBotServiceImpl implements DataManagementBotService {

    private final CreditCategoryRepository creditCategoryRepository;

    @Override
    public CreditCategory createNewCategory(CreditCategory category) {

        return creditCategoryRepository.save(category);
    }
}
