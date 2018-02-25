package cn.merryyou.logback.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
public class  SysMenu implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @ManyToMany(mappedBy = "menus")
    private List<SysRole> roles = new ArrayList<>();
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

    private int menuType;


    @Override
    public String toString() {
        return "SysMenu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
