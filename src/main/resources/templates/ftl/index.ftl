<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>主页</title>
    <link rel="stylesheet" href="${re.contextPath}/css/reset.css"/>
    <link rel="stylesheet" href="${re.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="${re.contextPath}/css/font-awesome.min.css"/>
</head>
<body>
<div class="wrap login_wrap">
    <div class="content">
        <div class="logo"></div>
        <div class="login_box">
            <div class="login_form">
                <div class="login_title">
                ${username!''}<br/><br/>
                    <a href="/signOut">退出</a>
                    <form action="${re.contextPath}/connect/qq" method="post">
                        <button type="submit">绑定qq</button>
                    </form>
                    <form action="${re.contextPath}/connect/weixin" method="post">
                        <button type="submit">绑定weixin</button>
                    </form>
                    <form action="${re.contextPath}/connect/weibo" method="post">
                        <button type="submit">绑定weibo</button>
                    </form>
                </div>
                <div class="other_login">
                    <div class="other_right" style="text-align: center;">
                        <a id="bindingQq" href=""><i class="fa fa-qq fa-2x"></i></a>
                        <a href=""><i class="fa fa-weixin fa-2x"></i></a>
                        <a href=""><i class="fa fa-weibo fa-2x"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${re.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${re.contextPath}/js/common.js"></script>
<script>
    $(function () {
        $.ajax({
            url: "${re.contextPath}/connect",
            type: "get",
            async: true,
            dataType: "json",
            success: function (data) {
                if (data.code === 0) {
                    if (data.data.qq) {
                        //解绑
                        $("#bindingQq").attr("title", "解绑")
                    } else {
                        //绑定
                        $("#bindingQq").attr("title", "绑定")
                    }
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status);
                alert(XMLHttpRequest.readyState);
                alert(textStatus); // paser error;
            }

        });

        $("#bindingQq").click(function () {
            var title = $("#bindingQq").attr("title");
            if ("绑定" === title) {
                //执行绑定事件
                <#--$.post("${re.contextPath}/connect/qq");-->
                alert("绑定！");
                $("#bindingForm").attr("acction","${re.contextPath}/connect/qq")
                $("#bindingForm").submit();
            } else {
                //执行解绑事件
                $.delete("${re.contextPath}/connect/qq");
            }
        });
    });
</script>
</body>
</html>
