package com.example.zoo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ZooRestControllerIt {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnSuccess_exampleZoo() throws Exception{
        MockHttpServletRequestBuilder getRequestBuilder = get("/zoo/example");
        mockMvc.perform(getRequestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"Fajne Zoo\",\"location\":\"Gdansk\",\"open\":true,\"animals\":[{\"id\":1,\"specimen\":\"lion\",\"diet\":\"MEAT\",\"type\":\"LAND\",\"hunger\":false,\"health\":\"HEALTHY\"}]}"));
    }

    @Test
    void shouldReturnSuccess_emptyZoo() throws Exception{
        String name="nazwa";
        MockHttpServletRequestBuilder getRequestBuilder = get("/zoo/empty");
        mockMvc.perform(getRequestBuilder .param("name",name))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"Fajne Zoo\",\"location\":\"Gdansk\",\"open\":true,\"animals\":null}"));
    }
}
