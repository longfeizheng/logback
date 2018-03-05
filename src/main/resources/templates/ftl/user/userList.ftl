<#assign  sec=JspTaglibs["http://www.springframework.org/security/tags"] />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>DataGrid 数据表格</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <link href="${re.contextPath}/css/demo.css" rel="stylesheet" type="text/css"/>
    <script src="${re.contextPath}/plugin/boot.js" type="text/javascript"></script>
</head>
<body>
<h1>用户管理</h1>
<#include "../common/message.ftl">
<div style="width:800px;">
    <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
        <table style="width:100%;">
            <tr>
                <td style="width:100%;">
                     <@sec.authorize access="hasAuthority('user:select')">
                    <a class="mini-button" iconCls="icon-add" onclick="add()">增加</a>
                     </@sec.authorize>
                    <@sec.authorize access="hasAuthority('user:update')">
                    <a class="mini-button" iconCls="icon-add" onclick="edit()">编辑</a>
                    </@sec.authorize>
                    <@sec.authorize access="hasAuthority('user:del')">
                    <a class="mini-button" iconCls="icon-remove" onclick="remove()">删除</a>
                    </@sec.authorize>

                </td>
                <td style="white-space:nowrap;">
                    <input id="key" class="mini-textbox" emptyText="请输入姓名" style="width:150px;" onenter="onKeyEnter"/>
                    <a class="mini-button" onclick="search()">查询</a>
                </td>
            </tr>
        </table>
    </div>
</div>
<div id="datagrid1" class="mini-datagrid" style="width:800px;height:280px;" allowResize="true"
     url="${re.contextPath}/user/userList" idField="id" multiSelect="true"
>
    <div property="columns">
        <div type="checkcolumn"></div>
        <div field="username" width="120" headerAlign="center" allowSort="true">用户名</div>
        <div field="age" width="120" headerAlign="center" allowSort="true">年龄</div>
        <div field="email" width="120" headerAlign="center" allowSort="true">邮箱</div>
        <div field="realName" width="120" headerAlign="center" allowSort="true">真实姓名</div>
        <div field="createDate" width="120" headerAlign="center" allowSort="true" renderer="onBirthdayRenderer">创建时间</div>
        <div field="updateDate" width="120" headerAlign="center" allowSort="true" renderer="onBirthdayRenderer">更新时间</div>
    </div>
</div>
<script type="text/javascript">
    mini.parse();
    var grid = mini.get("datagrid1");
    grid.load();


    function add() {
        mini.open({
            url: "${re.contextPath}/user/addUser",
            title: "新增员工", width: 600, height: 400,
            onload: function () {
                var iframe = this.getIFrameEl();
                var data = {action: "new"};
                iframe.contentWindow.SetData(data);
            },
            ondestroy: function (action) {

                grid.reload();
            }
        });
    }

    function edit() {
        var row = grid.getSelected();
        if (row) {
            mini.open({
                url: "${re.contextPath}/user/addUser",
                title: "编辑员工", width: 600, height: 400,
                onload: function () {
                    var iframe = this.getIFrameEl();
                    var data = {action: "edit", id: row.id};
                    iframe.contentWindow.SetData(data);

                },
                ondestroy: function (action) {
                    grid.reload();

                }
            });

        } else {
            notify("请选中一条记录");
//            alert("请选中一条记录");
        }

    }

    function remove() {
        var rows = grid.getSelecteds();
        if (rows.length > 0) {
            mini.confirm("确定删除记录？", "确定？",
                    function (action) {
                        if (action == "ok") {
                            var ids = [];
                            for (var i = 0, l = rows.length; i < l; i++) {
                                var r = rows[i];
                                ids.push(r.id);
                            }
                            var id = ids.join(',');
                            grid.loading("操作中，请稍后......");
                            $.ajax({
                                url: "${re.contextPath}/user/del/" + id,
                                success: function (text) {
                                    if (text.code == 105) {
                                        notify(text.msg);
                                    } else {
                                        showTips(text.data);
                                    }
                                    grid.reload();
                                },
                                error: function () {
                                }
                            });
                        } else {
//                            alert("不删除!");
                        }
                    }
            );
//            if (confirm("确定删除选中记录？")) {
//
//            }
        } else {
            notify("请选中一条记录");
        }
    }

    function search() {
        var key = mini.get("key").getValue();
        grid.load({key: key});
    }

    function onKeyEnter(e) {
        search();
    }

    /////////////////////////////////////////////////
    function onBirthdayRenderer(e) {
        var value = e.value;
//        if (value) return mini.formatDate(value, 'yyyy-MM-dd');
        if (value) return getLocalDate(value);
        return "";
    }

    function onMarriedRenderer(e) {
        if (e.value == 1) return "是";
        else return "否";
    }

    var Genders = [{id: 1, text: '男'}, {id: 2, text: '女'}];

    function onGenderRenderer(e) {
        for (var i = 0, l = Genders.length; i < l; i++) {
            var g = Genders[i];
            if (g.id == e.value) return g.text;
        }
        return "";
    }

    function getLocalDate(str) {
        var date = new Date(str * 1000);
        Y = date.getFullYear() + '-';
        M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
        D = date.getDate() + ' ';
        return Y + M + D; //
    }
</script>
</body>
</html>