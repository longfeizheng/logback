package cn.merryyou.logback.converter;

import cn.merryyou.logback.domain.Person;
import cn.merryyou.logback.from.PersonForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

/**
 * Created on 2017/11/8 0008.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Slf4j
public class PersonForm2Person {
    public static Person convert(PersonForm person) {
        Person p = new Person();
        BeanUtils.copyProperties(person, p);
        return p;
    }
}

