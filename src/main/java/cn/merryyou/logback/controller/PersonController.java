package cn.merryyou.logback.controller;

import cn.merryyou.logback.converter.PersonForm2Person;
import cn.merryyou.logback.domain.Person;
import cn.merryyou.logback.domain.Result;
import cn.merryyou.logback.exception.PersonException;
import cn.merryyou.logback.from.PersonForm;
import cn.merryyou.logback.service.PersonService;
import cn.merryyou.logback.utils.ResultUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ApiOperation(value = "获得person列表", notes = "")
    @GetMapping(value = "/persons")
    public List<Person> getPersons() {
        return personService.findAll();
    }

    /**
     * 添加一个人员
     */
    @ApiOperation(value = "创建person", notes = "根据Person创建person")
    @ApiImplicitParam(name = "person", value = "person详细实体Person", required = true, dataType = "Person")
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
    @ApiOperation(value = "获取person详细信息", notes = "根据url的id来获取person详细信息")
    @ApiImplicitParam(name = "id", value = "personID", required = true, dataType = "Integer")
    @GetMapping("/person/{id}")
    public Person personFindOne(@PathVariable("id") Integer id) {
        return personService.findOne(id);
    }

    /**
     * 更新人员
     */
    @ApiOperation(value = "更新person详细信息", notes = "根据url的id来指定更新对象，根据传过来的name,age,address")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "PersonID", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "name", value = "name", required = true, dataType = "String"),
            @ApiImplicitParam(name = "age", value = "age", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "address", value = "address", required = true, dataType = "String"),
    })
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
        //实体类设置了字段校验
        Person resultPerson = personService.findOne(id);
        BeanUtils.copyProperties(resultPerson, p);
        return personService.save(p);
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除person", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "personID", required = true, dataType = "Integer")
    @DeleteMapping("/person/{id}")
    public Result PersonDelete(@PathVariable("id") Integer id) {
        personService.delete(id);
        return ResultUtil.success();
    }

    /**
     * 新增人员@RequestBody接收
     */
    @ApiOperation(value = "添加Person", notes = "新增Person")
    @ApiImplicitParam(name = "person", value = "表单PersonForm信息", required = true, dataType = "PersonForm")
    @PutMapping("/person/2")
    public Result personAdd2(@RequestBody PersonForm person) throws PersonException {
        Person resultPerson = personService.findOne(person.getId());
        BeanUtils.copyProperties(resultPerson, person);
        return ResultUtil.success(personService.save(PersonForm2Person.convert(person)));

    }

    @GetMapping("/session/invalid")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public Result<String> sessionInvalid() {
        return ResultUtil.error(HttpStatus.UNAUTHORIZED.value(), "session失效");
    }


}
