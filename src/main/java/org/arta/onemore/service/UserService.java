package org.arta.onemore.service;

import lombok.RequiredArgsConstructor;
import org.arta.onemore.database.repository.UserRepository;
import org.arta.onemore.dto.UserCreateEditDto;
import org.arta.onemore.dto.UserFilter;
import org.arta.onemore.dto.UserReadDto;
import org.arta.onemore.mapper.UserCreateEditMapper;
import org.arta.onemore.mapper.UserReadMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserCreateEditMapper userCreateEditMapper;
    public List<UserReadDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userReadMapper::map).toList();
    }

    public List<UserReadDto> findAll(UserFilter filter) {
        return userRepository.findAllByFilter(filter)
                .stream()
                .map(userReadMapper::map).toList();
    }

    public Optional<UserReadDto> findById(Integer id) {
        return userRepository.findById(id)
                .map(userReadMapper::map);
    }

    @Transactional
    public UserReadDto create(UserCreateEditDto userDto) {
        return Optional.of(userDto)
                .map(userCreateEditMapper::map)
                .map(userRepository::save)
                .map(userReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<UserReadDto> update(Integer id, UserCreateEditDto user) {
        return userRepository.findById(id)
                .map(entity -> userCreateEditMapper.map(user, entity))
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::map);
    }

    @Transactional
    public boolean delete(Integer id) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    return true;
                })
                .orElse(false);

    }
}
