package com.group.libraryapp.dto.user.response;

import com.group.libraryapp.domain.user.User;

public class UserResponse {
    private Long id;
    private String name;
    private Integer age;

    public UserResponse(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }
}
