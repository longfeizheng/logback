/*
    标准模板：弹出选择面板
    注意，只需要修改搜索框和mini.DataGrid相关的列配置信息即可。
*/

UserSelectWindow = function () {
    UserSelectWindow.superclass.constructor.call(this);
    this.initControls();
    this.initEvents();
}
mini.extend(UserSelectWindow, mini.Window, {

    url: "",
    keyField: "key",
    multiSelect: false,

    title: "选择用户",
    keyLable: "名称：",
    searchLable: "查询：",

    width: 580,
    height: 320,
    bodyStyle: "padding:0;",
    allowResize: true,
    showModal: true,
    showToolbar: true,
    showFooter: true,
    initControls: function () {
        var toolbarEl = this.getToolbarEl();
        var footerEl = this.getFooterEl();
        var bodyEl = this.getBodyEl();

        //toolbar
        var labelId = this.id + "$label";
        var topHtml =
            '<div style="padding:5px;text-align:center;">'
                + '<span id="' + labelId + '">' + this.keyLable + '</span>    '
                + '<input name="keyText" class="mini-textbox" style="width:160px;"/> '
                + '<a name="searchBtn" class="mini-button">查找</a>       '
            + '</div>';
        jQuery(toolbarEl).append(topHtml);

        //footer
        var footerHtml =
            '<div style="padding:8px;text-align:center;">'
                + '<a name="okBtn" class="mini-button" style="width:60px;">确定</a>       '
                + '<span style="display:inline-block;width:25px;"></span>'
                + '<a name="cancelBtn" class="mini-button" style="width:60px;">取消</a>       '
            + '</div>';
        jQuery(footerEl).append(footerHtml);

        /////////////////////////////////////////////////////
        //body        
        this.grid = new mini.DataGrid();
        this.grid.set({
            multiSelect: this.multiSelect,
            style: "width: 100%;height: 100%;",
            borderStyle: "border:0",
            columns: [
                { type: "checkcolumn", header: "#" },
            //{ type: "indexcolumn", header: "#", headerAlign: "center" },
                {header: "帐号", field: "loginname" },
                { header: "姓名", field: "name" }
            ]
        });
        this.grid.setUrl(this.url);
        this.grid.render(bodyEl);
        /////////////////////////////////////////////////////

        //组件对象
        mini.parse(this.el);
        this._okBtn = mini.getbyName("okBtn", this);
        this._cancelBtn = mini.getbyName("cancelBtn", this);
        this._searchBtn = mini.getbyName("searchBtn", this);
        this._keyText = mini.getbyName("keyText", this);
    },
    initEvents: function () {
        this._searchBtn.on("click", function (e) {
            var key = this._keyText.getValue();
            this.search(key);
        }, this);
        this._keyText.on("enter", function (e) {
            var key = this._keyText.getValue();
            this.search(key);
        }, this);

        /////////////////////////////////////
        this._okBtn.on("click", function (e) {
            var ret = true;
            if (this._Callback) ret = this._Callback('ok');
            if (ret !== false) {
                this.hide();
            }
        }, this);
        this._cancelBtn.on("click", function (e) {
            var ret = true;
            if (this._Callback) ret = this._Callback('cancel');
            if (ret !== false) {
                this.hide();
            }
        }, this);
        this.on("beforebuttonclick", function (e) {
            if (e.name == "close") {                
                e.cancel = true;
                var ret = true;
                if (this._Callback) ret = this._Callback('close');
                if (ret !== false) {
                    this.hide();
                }
            }
        }, this);
    },
    setKeyLable: function (value) {
        var labelId = this.id + "$label";
        var label = document.getElementById(label);
        if (label) {
            label.innerHTML = value;
            this.keyLable = value;
        }
    },
    setSearchLable: function (value) {
        this._searchBtn.setText(value);
    },
    setUrl: function (value) {
        this.url = value;        
        this.grid.setUrl(value);
    },
    setKeyField: function (value) {
        this.keyField = value;
    },
    setMultiSelect: function (value) {
        this.multiSelect = value;
        this.grid.setMultiSelect(value);
    },
    search: function (key) {
        var args = {};
        args[this.keyField] = key;
        this.grid.load(args);
    },
    setData: function (data, callback) {
        this._Callback = callback;
        //this.grid.selects(data);
    },
    getData: function () {
        var row = this.grid.getSelected();
        return row;
    }
});
mini.regClass(UserSelectWindow, "userselectwindow");