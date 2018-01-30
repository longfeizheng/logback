package cn.merryyou.logback.service;

import cn.merryyou.logback.domain.Person;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * Created on 2017/11/7.
 *
 * @author zlf
 * @since 1.0
 */
public interface PersonService {
    Person save(Person person);

    List<Person> findByAge(Integer age);

    @PreAuthorize("hasRole('ADMIN')")
    @PostFilter("filterObject.name == authentication.name")
    List<Person> findAll();

    @PostAuthorize("returnObject.name == authentication.name")
    Person findOne(Integer id);

    void delete(Integer id);
}
