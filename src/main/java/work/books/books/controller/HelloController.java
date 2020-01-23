package work.books.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @RequestMapping(value="/hello", method=RequestMethod.GET)
    public String index() {
        String sql = "SELECT token FROM user WHERE id = ?";
        // 通过jdbcTemplate查询数据库
        String token = (String)jdbcTemplate.queryForObject(
                sql, new Object[] { 2 }, String.class);
        return "Hello "+ token;
    }
}