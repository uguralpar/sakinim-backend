package com.sakinim.helloworld;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {
    private final JdbcTemplate jdbcTemplate;

    public HelloWorldService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getMessage() {
        return jdbcTemplate.queryForObject(
                "SELECT content FROM messages WHERE id = 1",
                String.class
        );
    }
}
