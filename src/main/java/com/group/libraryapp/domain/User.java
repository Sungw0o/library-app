package com.group.libraryapp.domain;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id=  null;
    @Column(nullable = false,length = 20) // name varchar(20) <- 필드명과 동일하기 때문에 생략 가능
    private String name;
    private Integer age;
    protected User(){}
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public User(String name, Integer age) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.",name));
        }
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void updateName(String name){
        this.name = name;
    }
}
