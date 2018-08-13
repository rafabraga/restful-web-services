package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@JsonFilter("UserFilter")
@ApiModel(description = "Detalhes sobre o usuário.")
public class User {

    // @com.fasterxml.jackson.annotation.JsonIgnore
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2, message = "O nome deve possuir no mínimo 2 caracteres.")
    @ApiModelProperty(notes = "O nome deve possuir no mínimo 2 caracteres.")
    private String name;

    @Past
    @ApiModelProperty(notes = "A data de aniversário deve ser no passado.")
    private Date birthday;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    /**
     * @param id
     * @param name
     * @param birthday
     */
    public User(final Integer id, final String name, final Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return this.birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(final Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the posts
     */
    public List<Post> getPosts() {
        return this.posts;
    }

    /**
     * @param posts the posts to set
     */
    public void setPosts(final List<Post> posts) {
        this.posts = posts;
    }

}
