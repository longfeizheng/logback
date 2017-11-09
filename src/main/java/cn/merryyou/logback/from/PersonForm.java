package cn.merryyou.logback.from;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created on 2017/11/8 0008.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Data
public class PersonForm {

    private Integer id;

    @NotNull(message = "姓名必填字段")
    private String name;

    @Min(value = 18,message = "未成年禁止进入")
    private Integer age;

    @NotNull(message = "地址必填字段")
    private String address;
}
