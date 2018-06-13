package cn.merryyou.logback.repository;

import cn.merryyou.logback.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created on 2017/11/7.
 *
 * @author zlf
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository repository;

    @Test
    public void save() {
        Person p = new Person();
        p.setName("tom");
        p.setAge(20);
        p.setAddress("beijing");
        Person resultPerson = repository.save(p);
        Assert.assertNotNull(resultPerson);
        Assert.assertNotNull(resultPerson.getId());
    }

    @Test
    public void findOne() {
        Person person = repository.findById(1).get();
        log.info("【person】 person={}",person);
    }

    @Test
    public void findByAge() throws Exception {
        List<Person> personList = repository.findByAge(20);
        log.info("【findByAGE】 personList={}",personList);
    }

    @Test
    public void update() {
        Person person = repository.findById(1).get();
        person.setAddress("city");
        Person resultPerson = repository.save(person);
        Assert.assertNotNull(resultPerson);
        Assert.assertNotNull(resultPerson.getId());
    }

}