package cn.merryyou.logback.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.social.security.SocialUserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created on 2018/1/28 0028.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
@Entity
@Data
@DynamicInsert
@DynamicUpdate
public class SysUser implements Serializable, SocialUserDetails {
    private static final long serialVersionUID = 6531851807610479464L;
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
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮件
     */
    private String email;

    /**
     * 头像
     */
    private String photo;

    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createDate;

    /**
     * 更新时间
     */
    @UpdateTimestamp
    private Date updateDate;

    /**
     * 是否删除，逻辑删除
     */
    private String delFlag;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN");
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUserId() {
        //使用username 与社交账号的openid关联
        return username;
    }
}
