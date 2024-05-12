package com.group.libraryapp.Repository;

import com.group.libraryapp.dto.calculator.request.FruitRequest;
import com.group.libraryapp.dto.calculator.request.FruitUpdateRequest;
import com.group.libraryapp.dto.response.FruitStatResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class FruitMySQLRepository implements FruitRepository {
    private final JdbcTemplate jdbcTemplate;

    public FruitMySQLRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveFruit(FruitRequest request) {
        String sql = "INSERT INTO fruits (name, warehousingDate, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getDate(), request.getPrice());
    }

    @Override
    public void updateFruit(FruitUpdateRequest request) {
        String readsql = "SELECT * FROM fruits WHERE id = ?";
        boolean isFruitNotExist = jdbcTemplate.query(readsql, (rs, rowNum) -> 0, request.getId()).isEmpty();
        if (isFruitNotExist) {
            throw new IllegalArgumentException();
        }
        String sql = "UPDATE fruits SET sold = 1 WHERE id = ?";
        jdbcTemplate.update(sql, request.getId());
    }

    @Override
    public FruitStatResponse getFruitStatResponse(String name) {
        String soldSql = "SELECT SUM(price) AS sold_sum FROM fruits WHERE name = ? AND sold = 1";
        long soldSum = jdbcTemplate.queryForObject(soldSql, Long.class, name);
        String notSoldSql = "SELECT SUM(price) AS unsold_sum FROM fruits WHERE name = ? AND sold = 0";
        long notSoldSum = jdbcTemplate.queryForObject(notSoldSql, Long.class, name);
        return new FruitStatResponse(soldSum, notSoldSum);
    }
}
