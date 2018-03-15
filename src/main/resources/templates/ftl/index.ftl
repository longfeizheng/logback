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
                    <a href="${re.contextPath}/main">后台管理</a><br/>
                    <a href="${re.contextPath}/signOut">退出</a>
                    <form id="bindingForm" method="post">
                        <input id="method" type="hidden" name="_method" value="delete"/>
                        <button id="bindingBut"></button>
                    </form>
                </div>
                <div class="other_login">
                    <div class="other_right" style="text-align: center;">
                        <a id="bindingQq" href="javascript:void(0)"><i class="fa fa-qq fa-2x"></i></a>
                        <a id="bindingWeixin" href="javascript:void(0)"><i class="fa fa-weixin fa-2x"></i></a>
                        <a id="bindingWeibo" href="javascript:void(0)"><i class="fa fa-weibo fa-2x"></i></a>
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
                        $(".fa-qq").addClass("social_title");
                    } else {
                        //绑定
                        $("#bindingQq").attr("title", "绑定")
                        $(".fa-qq").removeClass("social_title");
                    }
                    if (data.data.weixin) {
                        //解绑
                        $("#bindingWeixin").attr("title", "解绑")
                        $(".fa-weixin").addClass("social_title");
                    } else {
                        //绑定
                        $("#bindingWeixin").attr("title", "绑定")
                        $(".fa-weixin").removeClass("social_title");
                    }
                    if (data.data.weibo) {
                        //解绑
                        $("#bindingWeibo").attr("title", "解绑")
                        $(".fa-weibo").addClass("social_title");
                    } else {
                        //绑定
                        $("#bindingWeibo").attr("title", "绑定")
                        $(".fa-weibo").removeClass("social_title");
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
            $("#bindingForm").attr("action","${re.contextPath}/connect/qq");
            if ("绑定" === title) {
                //执行绑定炒作
                $("#method").val("post");
                $("#bindingForm").submit();
            } else {
                //执行解绑事件
                $("#method").val("delete");
                $("#bindingForm").submit();
            }
        });
        $("#bindingWeixin").click(function () {
            var title = $("#bindingWeixin").attr("title");
            $("#bindingForm").attr("action","${re.contextPath}/connect/weixin");
            if ("绑定" === title) {
                //执行绑定炒作
                $("#method").val("post");
                $("#bindingForm").submit();
            } else {
                //执行解绑事件
                $("#method").val("delete");
                $("#bindingForm").submit();
            }
        });
        $("#bindingWeibo").click(function () {
            var title = $("#bindingWeibo").attr("title");
            $("#bindingForm").attr("action","${re.contextPath}/connect/weibo");
            if ("绑定" === title) {
                //执行绑定炒作
                $("#method").val("post");
                $("#bindingForm").submit();
            } else {
                //执行解绑事件
                $("#method").val("delete");
                $("#bindingForm").submit();
            }
        });
    });
</script>
</body>
</html>
