package com.djimenez.example.spring.mvc.service.test.unitary;

import org.springframework.dao.DataAccessException;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;

import com.djimenez.example.spring.mvc.model.User;

public class MockUserDetailsService implements UserDetailsService {

  public UserDetails loadUserByUsername(final String username)
    throws UsernameNotFoundException, DataAccessException {
    return new User("testuser");
  }
}
