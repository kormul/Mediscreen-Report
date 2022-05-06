package com.mediscreen.report.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportControllerTest {

    private MockMvc mockMvc;
	
    @Autowired
    private WebApplicationContext webContext;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();

    }
    
    @Test
    public void postAddNote() throws Exception{
    	
    	mockMvc.perform(get("/report/patient?id=1")
        )
    	.andExpect(status().isOk())
    	.andExpect(model().attributeExists("demographics"))
    	.andExpect(model().attributeExists("report"))
        .andReturn();
    }	
}
