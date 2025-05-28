package com.auth.User;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;



@Controller
@RestController
@RequestMapping("/auth")
public class UserController {

    @Value("${session.expiration}")
    private Long sessionExpiration;

    private UserService userService;
    private JedisPool jedisPool;
    public UserController(UserService userService,JedisPool jedisPool){
        this.userService = userService;
        this.jedisPool = jedisPool;
    }

    @PostMapping("/createUser")
    ResponseEntity<Map<String,Object>> createUser( @RequestBody User user ){
        try{

            boolean isCreated = this.userService.createUser(user);
            if(isCreated){
                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> sessionData = mapper.convertValue(user, Map.class);
                sessionData.remove("password");
                String sessionId = UUID.randomUUID().toString();
                try (Jedis jedis = jedisPool.getResource()) {
                    jedis.setex("session:" + sessionId, 1800, sessionData.toString());
                }
                return new ResponseEntity(Map.of("status", true, "sessionId",sessionId), HttpStatus.OK);
            }
            else{
                return new ResponseEntity(Map.of("status", false, "message", "Error Occured! Please try in sometime"), HttpStatus.OK);
            }
        }
        catch(Exception e){
            return new ResponseEntity(Map.of("status",false, "message",e.getMessage()), HttpStatus.OK);
        }
        
    }

}
