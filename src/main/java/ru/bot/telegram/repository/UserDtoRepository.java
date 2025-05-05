package ru.bot.telegram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telegram.telegrambots.meta.api.objects.User;
import ru.bot.telegram.dto.UserDto;

public interface UserDtoRepository extends JpaRepository<UserDto, Long> {

    boolean existsUserDtoById(Long id);
}
