package com.test.test.service;

import com.test.test.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class UserService {
    private Map<Long, UserDto> list = new HashMap<>();
    Long id = 1L;

    public List<UserDto> getAll() {
        return new ArrayList<UserDto>(list.values());
    }

    public UserDto getById(Long id) {
        return list.get(id);
    }

    public UserDto save(UserDto user) {
        user.setId(id);
        list.put(user.getId(), user);
        id++;
        return user;
    }

    public UserDto update(UserDto user, Long id) {
        if (list.containsKey(id)) {
            user.setId(id);
            list.put(id, user);
            return user;
        }else{
            return null;
        }
    }

    public void delete(Long id) {
        list.remove(id);
    }
}
