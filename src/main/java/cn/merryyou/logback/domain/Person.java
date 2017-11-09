package cn.merryyou.logback.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created on 2017/11/7.
 *
 * @author zlf
 * @since 1.0
 */
@Entity
@Data
@DynamicInsert
@DynamicUpdate
public class Person {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer age;

    private String address;
}
