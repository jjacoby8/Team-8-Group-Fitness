package com.example.GroupFitness.controller;

import java.io.IOException;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
public abstract class AbstractTest {
    
    protected MockMvc mvc;

    @Autowired
    WebApplicationContext webAppCtxt;

    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webAppCtxt).build();
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objMapper = new ObjectMapper();
        return objMapper.writeValueAsString(obj);
    }

    protected <T> T mapFomJson(String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper objMapper = new ObjectMapper();
        return objMapper.readValue(json, clazz);
    }

}
