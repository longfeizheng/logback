package cn.merryyou.logback.repository;

import cn.merryyou.logback.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created on 2017/11/7.
 *
 * @author zlf
 * @since 1.0
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByAge(Integer age);
}
