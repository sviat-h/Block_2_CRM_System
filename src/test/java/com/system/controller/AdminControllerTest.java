package com.system.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.model.entities.Account;
import com.system.model.entities.User;
import com.system.model.enums.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.util.NestedServletException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU5NDMxMjgzMCwiaWF0IjoxNTkzMDE2ODMwfQ.vuq4vAa5rS3sSUH1j2jAzj895aMrcCTxI_xkbR1o68s";


    @Test
    public void test_getAccount_should_return_adminAccount() throws Exception {

        Account expectedAccount = new Account(1, "admin", "admin@gmail.com", null, null, Role.ADMIN, new User(1, "Admin", "Adminovich", 100, "+380000000000"));

        MvcResult mvcResult = this.mockMvc.perform(get("/admin/getAccount/{id}", 1)
                .header("authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();

        Account actualAccount = this.objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), new TypeReference<Account>() {
        });

        assertEquals(expectedAccount, actualAccount);
    }

    @Test
    public void test_getAccount_should_return_exceptionMessage() throws Exception {

        Exception exception = assertThrows(NestedServletException.class, () -> mockMvc.perform(get("/admin/getAccount/{id}", 100)
                .header("authorization", "Bearer " + token))
                .andDo(print())
                .andReturn());

        String expectedExceptionMessage = "User not found.";
        String actualExceptionMessage = exception.getCause().getMessage();

        assertEquals(expectedExceptionMessage, actualExceptionMessage);
    }
}
