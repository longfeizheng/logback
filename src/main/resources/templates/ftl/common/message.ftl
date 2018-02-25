<div style="display: none">
    x: <select id="x2">
    <option value="left">Left</option>
    <option value="center" selected>Center</option>
    <option value="right" >Right</option>
</select>
    y: <select id="y2">
    <option value="top" selected>Top</option>
    <option value="center" >Center</option>
    <option value="bottom" >Bottom</option>
</select>
    state: <select id="state">
    <option value="">default</option>
    <option value="success" selected>success</option>
    <option value="info" >info</option>
    <option value="warning" >warning</option>
    <option value="danger" >danger</option>
</select>
    <input type="button" value="showTips" onclick="showTips()"/>
    <br /><br />
    x: <select id="x">
    <option value="left">Left</option>
    <option value="center" >Center</option>
    <option value="right" selected>Right</option>
</select>
    y: <select id="y">
    <option value="top" >Top</option>
    <option value="middle" >Middle</option>
    <option value="bottom" selected>Bottom</option>
</select>
    <input id="button10" type="button" value="Notify" onclick="notify()" /><br /><br />
</div>

<script>
    function notify(message) {

        var x = document.getElementById("x").value;
        var y = document.getElementById("y").value;

        mini.showMessageBox({
            showModal: false,
            width: 250,
            title: "提示",
            iconCls: "mini-messagebox-warning",
            message: message,
            timeout: 3000,
            x: x,
            y: y
        });
    }
    function showTips(message) {
        var x = document.getElementById("x2").value;
        var y = document.getElementById("y2").value;
        var state = document.getElementById('state').value;
        mini.showTips({
            content: "<b>成功</b> <br/>"+message,
            state: state,
            x: x,
            y: y,
            timeout: 3000
        });
    }
</script>