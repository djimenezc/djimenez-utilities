package com.djimenez.example.spring.mvc.service.test.unitary.mock;

import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;

import com.djimenez.example.spring.mvc.model.User;

public final class MockUserDetailsService implements UserDetailsService {

  public UserDetails loadUserByUsername(final String username) {

    return new User("testuser");
  }
}
