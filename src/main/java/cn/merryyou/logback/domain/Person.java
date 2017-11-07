package cn.merryyou.logback.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created on 2017/11/7.
 *
 * @author zlf
 * @since 1.0
 */
@Entity
@Data
public class Person {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull(message = "姓名必填字段")
    private String name;

    @Min(value = 18,message = "未成年禁止进入")
    private Integer age;

    @NotNull(message = "地址必填字段")
    private String address;
}
