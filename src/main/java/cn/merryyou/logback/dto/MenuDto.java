package cn.merryyou.logback.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created on 2018/2/8.
 *
 * @author zlf
 * @since 1.0
 */
@Data
public class MenuDto {

    private String id;

    @JsonProperty("pid")
    private String pId;

    @JsonProperty("text")
    private String name;

    private String url;

    private String permission;

    @JsonProperty("iconCls")
    private String icon;

    public MenuDto() {
    }

    public MenuDto(String id, String pId, String name, String url) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.url = url;
    }

    public MenuDto(String id, String pId, String name, String url, String permission) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.url = url;
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "MenuDto{" +
                "id='" + id + '\'' +
                ", pId='" + pId + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
