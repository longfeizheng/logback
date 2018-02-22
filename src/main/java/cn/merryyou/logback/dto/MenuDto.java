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

    @JsonProperty("iconCls")
    private String icon;

    private String operation;

    public String getOperation() {
        return "<a class=\"mini-button\" iconCls=\"icon-edit\" onclick=\"edit('"+this.id+"')\">修改</a>  |  <a class=\"mini-button\" iconCls=\"icon-remove\" onclick=\"remove('\"+this.id+\"')\">删除</a>";
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
