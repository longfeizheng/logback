package cn.merryyou.logback.controller;

import cn.merryyou.logback.domain.Person;
import cn.merryyou.logback.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 2017/11/7.
 *
 * @author zlf
 * @since 1.0
 */
@RestController
@RequestMapping
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    /**
     * 查询所有人员
     */
    @GetMapping(value = "/persons")
    public List<Person> getPersons(){
        return personService.findAll();
    }
}
