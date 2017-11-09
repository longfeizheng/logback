package cn.merryyou.logback.controller;

import cn.merryyou.logback.converter.PersonForm2Person;
import cn.merryyou.logback.domain.Person;
import cn.merryyou.logback.domain.Result;
import cn.merryyou.logback.exception.PersonException;
import cn.merryyou.logback.from.PersonForm;
import cn.merryyou.logback.service.PersonService;
import cn.merryyou.logback.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public List<Person> getPersons() {
        return personService.findAll();
    }

    /**
     * 添加一个人员
     */
    @PostMapping("/person")
    public Result<Person> personAdd(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(personService.save(person));
    }

    /**
     * 查询人员
     */
    @GetMapping("/person/{id}")
    public Person personFindOne(@PathVariable("id") Integer id) {
        return personService.findOne(id);
    }

    /**
     * 更新人员
     */
    @PutMapping("/person/{id}")
    public Person personUpdate(@PathVariable("id") Integer id,
                               @RequestParam(required = false, value = "name") String name,
                               @RequestParam(required = false, value = "age") Integer age,
                               @RequestParam(required = false, value = "address") String address) {
        Person p = new Person();
        if (StringUtils.isNotBlank(name)) {
            p.setName(name);
        }
        if (ObjectUtils.allNotNull(age)) {
            p.setAge(age);
        }
        if (StringUtils.isNotBlank(address)) {
            p.setAddress(address);
        }
        p.setId(id);
        //实体类设置了字段校验
        Person resultPerson = personService.findOne(id);
        BeanUtils.copyProperties(resultPerson, p);
        return personService.save(p);
    }

    /**
     * 删除
     */
    @DeleteMapping("/person/{id}")
    public Result PersonDelete(@PathVariable("id") Integer id) {
        personService.delete(id);
        return ResultUtil.success();
    }

    /**
     * 新增人员@RequestBody接收
     */
    @PutMapping("/person/2")
    public Result personAdd2(@RequestBody PersonForm person) throws PersonException {
        Person resultPerson = personService.findOne(person.getId());
        BeanUtils.copyProperties(resultPerson,person);
        return ResultUtil.success(personService.save(PersonForm2Person.convert(person)));

    }

}
