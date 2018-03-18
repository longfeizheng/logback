<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>新增用户</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <script src="${re.contextPath}/plugin/boot.js" type="text/javascript"></script>
    <style type="text/css">
        html, body
        {
            font-size:12px;
            padding:0;
            margin:0;
            border:0;
            height:100%;
            overflow:hidden;
        }
    </style>
</head>
<body>

<form id="form1" method="post">
    <input name="id" class="mini-hidden" />
    <fieldset style="border:solid 1px #aaa;padding:3px;">
        <legend >基本信息</legend>
        <div style="padding:5px;">
            <table>
                <tr>
                    <td style="width:70px;">登录名</td>
                    <td style="width:150px;">
                        <input name="username" class="mini-textbox" required="true"/>
                    </td>
                    <td style="width:70px;">真是姓名：</td>
                    <td >
                        <input name="realName" class="mini-textbox" required="true"/>
                    </td>

                </tr>
                <tr>
                    <td >年龄：</td>
                    <td >
                        <input name="age" class="mini-spinner" value="25" minValue="1" maxValue="200" />
                    </td>
                    <td >邮箱：</td>
                    <td >
                        <input name="email" class="mini-textbox" minValue="1" maxValue="200" />
                    </td>
                </tr>
                <tr>
                    <td >所属角色：</td>
                    <td  colspan="3">
                        <div id="combobox2" class="mini-combobox" style="width:250px;" name="roles"  popupWidth="400" textField="roleName" valueField="id"
                             url="${re.contextPath}/role/roleList"  multiSelect="true"  showClose="true" oncloseclick="onCloseClick" ajaxType="post">
                            <div property="columns">
                                <div header="ID" field="id"></div>
                                <div header="角色名称" field="roleName"></div>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
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
        var o = form.getData();

        form.validate();
        if (form.isValid() == false) return;

        var json = mini.encode([o]);
        console.log(json);
       $.ajax({
            url: "${re.contextPath}/user/saveUser",
            type: 'post',
            data: { data: json },
            cache: false,
            success: function (text) {
                if(text.code ===0 ){
                    CloseWindow("save");
                }else{
                    alert(text.msg);
                }

            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(1111);
                alert(jqXHR.responseText);
                CloseWindow();
            }
        });
    }

    ////////////////////
    //标准方法接口定义
    function SetData(data) {
        if (data.action == "edit") {
            //跨页面传递的数据对象，克隆后才可以安全使用
            data = mini.clone(data);

            $.ajax({
                url: "${re.contextPath}/user/"+data.id,
                cache: false,
                success: function (text) {
                    var o = mini.decode(text);
                    form.setData(o);
                    form.setChanged(false);

//                    mini.getbyName("position").setValue(o.position);
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

    function onCloseClick(e) {
        var obj = e.sender;
        obj.setText("");
        obj.setValue("");
    }

</script>
</body>
</html>
