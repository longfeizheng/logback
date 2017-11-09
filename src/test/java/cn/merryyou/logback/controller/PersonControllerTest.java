package cn.merryyou.logback.controller;

import cn.merryyou.logback.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static cn.merryyou.logback.utils.MvcIntegrationTestUtils.postForm;
import static cn.merryyou.logback.utils.ObjectMapperUtils.asJsonString;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created on 2017/11/7.
 *
 * @author zlf
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PersonControllerTest {
    private MockMvc mvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }

    @Test
    public void testGetAllPersons() throws Exception {
        String responseString = mvc.perform(get("/person"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        log.info(responseString);
    }

    @Test
    public void testPersonFindOne() throws Exception {
        String responseString = mvc.perform(get("/person/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.address").value("beijing"))
                .andExpect(jsonPath("$.address", notNullValue()))
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        log.info(responseString);
    }

    @Test
    public void testPersonAdd() throws Exception {
        Person p = new Person();
        p.setName("jerry");
        p.setAddress("handan");
        p.setAge(30);
        String responseString = mvc.perform(postForm("/person",p,"name","address","age"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        log.info(responseString);
    }

    @Test
    public void testPersonUpdate() throws Exception{
        String responseString = mvc.perform(put("/person/1").param("name","zhangSan"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        log.info(responseString);
    }

    @Test
    public void testPersonDelete() throws Exception{
        String responseString = mvc.perform(delete("/person/4"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        log.info(responseString);
    }

    @Test
    public void testPersonAdd2() throws Exception{
        Person person = new Person();
        person.setId(1);
        person.setName("marry");
        String responseString = mvc.perform(put("/person/2")
                .content(asJsonString(person))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        log.info(responseString);
    }

}