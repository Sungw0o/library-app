package com.group.libraryapp.controller.HW;

import com.group.libraryapp.dto.calculator.request.FruitUpdateRequest;
import com.group.libraryapp.dto.response.FruitStatResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import com.group.libraryapp.dto.calculator.request.FruitRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class FruitController {
    private final JdbcTemplate jdbcTemplate;

    public FruitController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitRequest request) {
        String sql = "INSERT INTO fruits (name, warehousingDate, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getDate(), request.getPrice());
    }

    @PutMapping("/api/v1/fruit")
    public void updateFruit(@RequestBody FruitUpdateRequest request){
        String readsql = "SELECT * FROM fruits WHERE id = ?";
        boolean isUserNotExist = jdbcTemplate.query(readsql,(rs,rowNum)->0,request.getId()).isEmpty();
        if(isUserNotExist){
            throw new IllegalArgumentException();
        }
        String sql = "UPDATE fruits SET sold = 1 WHERE id = ?";
        jdbcTemplate.update(sql,request.getId());
   }

   @GetMapping("/api/v1/fruit/stat")
    public FruitStatResponse GetFruitResponse(@RequestParam String name){
        String readSql = "SELECT * FROM fruits WHERE name = ?";
       boolean isFruitNotExist = jdbcTemplate.query(readSql,(rs, rowNum) ->0, name).isEmpty();
       if (isFruitNotExist) {
           throw new IllegalArgumentException();
       }
       String soldSql = "SELECT SUM(price) AS sold_sum FROM fruits WHERE name = ? AND sold = 1";
       long soldSum = jdbcTemplate.queryForObject(soldSql, Long.class, name);
       String notSoldSql = "SELECT SUM(price) AS unsold_sum FROM fruits WHERE name = ? AND sold = 0";
       long notSoldSum = jdbcTemplate.queryForObject(notSoldSql, Long.class, name);
       return new FruitStatResponse(soldSum,notSoldSum);
   }
//    String sql = "DELETE FROM fruits WHERE name =?";
}
