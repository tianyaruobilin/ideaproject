package com.springjwt.springjwt.service;

import com.springjwt.springjwt.commons.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {

    User findUserById(String userId);

    User findByUsername(User user);
}
