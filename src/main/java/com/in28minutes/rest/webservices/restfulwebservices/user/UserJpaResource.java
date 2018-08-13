package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.util.FilterUtil;

@RestController
@RequestMapping("/jpa/users")
public class UserJpaResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public MappingJacksonValue listAll() {
        final List<User> users = this.userRepository.findAll();
        return FilterUtil.getFilter(users, "UserFilter", "id", "name");
    }

    @GetMapping("/{id}")
    public MappingJacksonValue findById(@PathVariable final Integer id) {
        final Optional<User> user = this.userRepository.findById(id);
        return FilterUtil.getFilter(user.get(), "UserFilter", "id", "name");
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody final User user) {
        final User savedUser = this.userRepository.save(user);

        final URI uriLocation = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(uriLocation).build();
    }

}
