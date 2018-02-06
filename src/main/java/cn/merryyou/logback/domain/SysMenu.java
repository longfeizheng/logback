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
 * 菜单
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
public class  SysMenu implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

//    @ManyToMany(mappedBy = "menus")
//    private Set<SysRole> roles;
    /**
     * 名称
     */
    private String name;

    /**
     * 父ID
     */
    private String pId;

    /**
     * url
     */
    private String url;

    private Integer orderNum;

    /**
     * 图标
     */
    private String icon;

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
    /**
     * 权限
     */
    private String permission;

    private Byte menuType;
    /**
     * 菜单排序id 填充菜单展示id
     */
    private int num;
}
