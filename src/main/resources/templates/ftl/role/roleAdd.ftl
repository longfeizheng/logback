<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>新增用户</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <script src="${re.contextPath}/plugin/boot.js" type="text/javascript"></script>
    <style type="text/css">
        html, body {
            font-size: 12px;
            padding: 0;
            margin: 0;
            border: 0;
            height: 100%;
            overflow: hidden;
        }
    </style>
</head>
<body>

<form id="form1" method="post">
    <input name="id" class="mini-hidden"/>
    <fieldset style="border:solid 1px #aaa;padding:3px;">
        <legend>基本信息</legend>
        <div style="padding:5px;">
            <table>
                <tr>
                    <td style="width:70px;">角色名称</td>
                    <td style="width:150px;">
                        <input name="roleName" class="mini-textbox" required="true"/>
                    </td>
                    <td style="width:70px;">角色描述：</td>
                    <td>
                        <input name="remark" class="mini-textbox" required="true"/>
                    </td>

                </tr>
            </table>

            <h1>权限分配</h1>
            <input type="button" value="获取权限" onclick="getCheckedNodes()"/>
            <ul id="tree2" class="mini-tree" url="${re.contextPath}/menu/menuList" style="width:200px;padding:5px;"
                showTreeIcon="false" textField="text" idField="id" parentField="pid" resultAsTree="false"
                showCheckBox="true" checkRecursive="true"
                onbeforenodecheck="onBeforeNodeCheck" allowSelect="false" enableHotTrack="false"

            >
            </ul>
        </div>
    </fieldset>
    <div style="text-align:center;padding:10px;">
        <a class="mini-button" onclick="onOk" style="width:60px;margin-right:20px;">确定</a>
        <a class="mini-button" onclick="onCancel" style="width:60px;">取消</a>
    </div>
</form>
<script type="text/javascript">
    mini.parse();

    var form = new mini.Form("form1");

    function SaveData() {
        var tree = mini.get("tree2");

        var value = tree.getValue(true);
        console.log(value);
        var o = form.getData();
        o.menuIds = value;
        console.log(o);
        form.validate();
        if (form.isValid() == false) return;
        var json = mini.encode([o]);
        $.ajax({
            url: "${re.contextPath}/role/saveRole",
            type: 'post',
            data: {data: json},
            cache: false,
            success: function (text) {
                alert(text.msg);
                CloseWindow("save");
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.responseText);
                CloseWindow();
            }
        });
    }

    ////////////////////
    //标准方法接口定义
    function SetData(data) {
        if (data.action == "edit") {
            var tree = mini.get("tree2");
            tree.expandAll();
            //跨页面传递的数据对象，克隆后才可以安全使用
            data = mini.clone(data);

            $.ajax({
                url: "${re.contextPath}/role/" + data.id,
                cache: false,
                success: function (text) {
                    var o = mini.decode(text);
                    //设置数的选中状态
                    console.log(o.menuIds);
                    var nodes = tree.getAllChildNodes(tree.getRootNode());
                    for(var i=0;i<nodes.length;i++){
                        if(o.menuIds.indexOf(nodes[i]['id'])>=0){
                            tree.checkNode(nodes[i]);
                        }else{
                            tree.uncheckNode(nodes[i]);
                        }
                    }
                    form.setData(o);
                    form.setChanged(false);
                }
            });
        }
    }

    function GetData() {
        var o = form.getData();
        return o;
    }

    function CloseWindow(action) {
        if (action == "close" && form.isChanged()) {
            if (confirm("数据被修改了，是否先保存？")) {
                return false;
            }
        }
        if (window.CloseOwnerWindow) return window.CloseOwnerWindow(action);
        else window.close();
    }

    function onOk(e) {
        SaveData();
    }

    function onCancel(e) {
        CloseWindow("cancel");
    }

    function getCheckedNodes() {true
        var tree = mini.get("tree2");

        var value = tree.getValue(true);
        alert(value);
    }

    function onBeforeNodeCheck(e) {
        var tree = e.sender;
        var node = e.node;
        if (tree.hasChildren(node)) {
            //e.cancel = true;
        }
    }

</script>
</body>
</html>
