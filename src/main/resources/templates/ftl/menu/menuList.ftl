<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>菜单列表</title>
    <link href="${re.contextPath}/css/demo.css" rel="stylesheet" type="text/css" />
    <script src="${re.contextPath}/plugin/boot.js" type="text/javascript"></script>

</head>
<body>
<h1>菜单列表</h1>
<div id="treegrid1" class="mini-treegrid" style="width:700px;height:280px;"
     url="${re.contextPath}/menu/menus" showTreeIcon="true"
     treeColumn="menuname" idField="id" parentField="pid" resultAsTree="false"
     allowResize="true" expandOnLoad="true"
>
    <div property="columns">
        <div type="indexcolumn"></div>
        <div name="menuname" field="text" width="160" >菜单名称</div>
        <div field="url" width="80">地址</div>
        <div field="icon" width="60" align="right">图标</div>
    </div>
</div>


</body>
</html>
