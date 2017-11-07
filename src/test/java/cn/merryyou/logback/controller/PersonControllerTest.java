package cn.merryyou.logback.controller;

import cn.merryyou.logback.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created on 2017/11/7.
 *
 * @author zlf
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonControllerTest {
    private MockMvc mvc;

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonController personController;
    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(personController).build();
    }
    @Test
    public void getPersons() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/persons");
        mvc.perform(request).andExpect(status().isOk());
    }

}