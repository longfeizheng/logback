package cn.merryyou.logback.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 角色
 * Created on 2018/2/6 0028.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Entity
@Data
@DynamicInsert
@DynamicUpdate
public class SysRole implements Serializable {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String remark;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateDate;

//
//    @ManyToMany(mappedBy = "roles")
//    private Set<SysUser> users;

//    @ManyToMany
//    @JoinTable(
//            name = "sys_role_menu",
//            joinColumns = @JoinColumn(
//                    name = "role_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "menu_id", referencedColumnName = "id"))
//    private Set<SysMenu> menus;
}
