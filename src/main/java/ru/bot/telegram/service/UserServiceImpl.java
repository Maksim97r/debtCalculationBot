package ru.bot.telegram.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.User;
import ru.bot.telegram.dto.UserDto;
import ru.bot.telegram.mapper.UserMapper;
import ru.bot.telegram.repository.UserDtoRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserDtoRepository repository;
    private final UserMapper userMapper;

    @Override
    public void createUser(User user) {
        UserDto userDto = userMapper.mapToUserDto(user);

        repository.save(userDto);

        log.info("создан новый пользователь {}", userDto.getUserName());
    }

    @Override
    public boolean existsUserById(Long id) {
        boolean existUserDto = repository.existsUserDtoById(id);

        if (existUserDto) {
            log.info("пользователь уже существует");
        }

        return existUserDto;
    }
}
