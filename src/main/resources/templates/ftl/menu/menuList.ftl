<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>菜单列表</title>
    <link href="${re.contextPath}/css/demo.css" rel="stylesheet" type="text/css"/>
    <script src="${re.contextPath}/plugin/boot.js" type="text/javascript"></script>

</head>
<body>
<h1>菜单管理</h1>
<div>
    <a class="mini-button" iconCls="icon-add" onclick="add()">新增</a>&nbsp;
    <a class="mini-button" iconCls="icon-edit" onclick="edit()">修改</a>&nbsp;
    <a class="mini-button" iconCls="icon-remove" onclick="remove()">删除</a>&nbsp;
</div>
<div id="treegrid1" class="mini-treegrid" style="width:700px;height:280px;"
     url="${re.contextPath}/menu/menus" showTreeIcon="true"
     treeColumn="menuname" idField="id" parentField="pid" resultAsTree="false"
     allowResize="true" expandOnLoad="true"
>
    <div property="columns">
        <div type="indexcolumn"></div>
        <div name="menuname" field="text" width="160">菜单名称</div>
        <div field="url" width="80">地址</div>
        <div field="icon" width="60" align="right">图标</div>
        <div field="operation" width="60" align="right">操作</div>
    </div>
</div>
<script>

    function add() {
        mini.open({
            url: "${re.contextPath}/menu/addMenu",
            title: "新增菜单", width: 600, height: 400,
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

    function edit(str) {
        alert(str);
        if (str) {
            mini.open({
                url: "${re.contextPath}/menu/addMenu",
                title: "编辑菜单", width: 600, height: 400,
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
            alert("请选中一条记录");
        }

    }

    function remove() {
        var rows = grid.getSelecteds();
        if (rows.length > 0) {
            if (confirm("确定删除选中记录？")) {
                var ids = [];
                for (var i = 0, l = rows.length; i < l; i++) {
                    var r = rows[i];
                    ids.push(r.id);
                }
                var id = ids.join(',');
                grid.loading("操作中，请稍后......");
                $.ajax({
                    url: "${re.contextPath}/menu/del/" + id,
                    success: function (text) {
                        alert(text.msg);
                        grid.reload();
                    },
                    error: function () {
                    }
                });
            }
        } else {
            alert("请选中一条记录");
        }
    }
</script>

</body>
</html>
