package com.group.libraryapp.repository.user;

import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


//@Repository
public class UserJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isUserNotExist(long id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> 0, id).isEmpty();
    }
    public void updateUserName(String name, long id) {
        String sql = "UPDATE user SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, id);
    }
    public void deleteUserByName(String name) {
        String sql = "DELETE FROM user WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }

    public boolean isUserNotExist(String name) {
        String sql = "SELECT * FROM user WHERE name = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> 0, name).isEmpty();
    }

    public void saveUser(String name, Integer age) {
        String sql = "INSERT INTO user(name,age) VALUES(?,?)"; // 값이 들어가는 부분 ? 사용
        jdbcTemplate.update(sql, name,age);
    }

    public List<UserResponse> getUsers(){
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, (rs, rowNum) -> { //query를 사용해 SELECT 쿼리를 날림
            long id = rs.getLong("id"); //객체에 gettype을 사용해서 실제 값을 가져올 수 있음
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new UserResponse(id, name, age);
        });
    }
}
