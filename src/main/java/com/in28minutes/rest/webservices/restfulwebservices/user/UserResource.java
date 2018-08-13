package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.util.FilterUtil;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping
    public MappingJacksonValue listAll() {
        final List<User> users = this.userDaoService.findAll();
        return FilterUtil.getFilter(users, "UserFilter", "id", "name");
    }

    @GetMapping("/{id}")
    public MappingJacksonValue findById(@PathVariable final Integer id) {
        final User user = this.userDaoService.findOne(id);
        return FilterUtil.getFilter(user, "UserFilter", "id", "name");
    }

}
