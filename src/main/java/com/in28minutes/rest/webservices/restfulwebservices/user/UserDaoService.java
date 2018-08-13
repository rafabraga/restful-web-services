package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

    public List<User> findAll() {
        final List<User> users = new ArrayList<>();
        users.add(new User(1, "Jimi", new Date(1990 - 1900, 11, 27)));
        users.add(new User(2, "Jack", new Date(1991 - 1900, 06, 25)));
        users.add(new User(3, "Joe", new Date(1991 - 1900, 10, 23)));
        return users;
    }

    public User findOne(final Integer id) {
        return this.findAll().stream().filter(u -> u.getId().equals(id)).findFirst().get();
    }

}
