<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>菜单列表</title>
    <link href="${re.contextPath}/css/demo.css" rel="stylesheet" type="text/css"/>
    <script src="${re.contextPath}/plugin/boot.js" type="text/javascript"></script>

</head>
<body>
<h1>菜单管理</h1>
<div id="treegrid1" class="mini-treegrid" style="width:700px;height:280px;"
     url="${re.contextPath}/menu/menus" showTreeIcon="false"
     treeColumn="menuname" idField="id" parentField="pid" resultAsTree="false"
     allowResize="true" expandOnLoad="true"
>
    <div property="columns">
        <div type="indexcolumn"></div>
        <div name="menuname" field="text" width="160">菜单名称</div>
        <div field="url" width="80">地址</div>
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
</script>

</body>
</html>
