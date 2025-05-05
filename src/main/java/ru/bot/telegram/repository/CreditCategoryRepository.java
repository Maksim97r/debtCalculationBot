package ru.bot.telegram.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.bot.telegram.model.CreditCategory;

@Repository
public interface CreditCategoryRepository extends CrudRepository<CreditCategory, Long> {

}
