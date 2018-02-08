/**
* jQuery MiniUI v3.0
* 
* Web Site : http://www.miniui.com
*
* Commercial License : http://www.miniui.com/license
*
* Copyright(c) 2012 All Rights Reserved. Shanghai PusSoft Co., Ltd (上海普加软件有限公司) [ services@plusoft.com.cn ]. 
* 
*/


mini.locale = "zh_CN";


/* Date
-----------------------------------------------------------------------------*/

mini.dateInfo = {
    monthsLong: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
    monthsShort: ["1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"],
    daysLong: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"],
    daysShort: ["日", "一", "二", "三", "四", "五", "六"],
    quarterLong: ['一季度', '二季度', '三季度', '四季度'],
    quarterShort: ['Q1', 'Q2', 'Q2', 'Q4'],
    halfYearLong: ['上半年', '下半年'],
    patterns: {
        "d": "yyyy-M-d",
        "D": "yyyy年M月d日",
        "f": "yyyy年M月d日 H:mm",
        "F": "yyyy年M月d日 H:mm:ss",
        "g": "yyyy-M-d H:mm",
        "G": "yyyy-M-d H:mm:ss",
        "m": "MMMd日",
        "o": "yyyy-MM-ddTHH:mm:ss.fff",
        "s": "yyyy-MM-ddTHH:mm:ss",
        "t": "H:mm",
        "T": "H:mm:ss",
        "U": "yyyy年M月d日 HH:mm:ss",
        "y": "yyyy年MM月"
    },
    tt: {
        "AM": "上午",
        "PM": "下午"
    },
    ten: {
        "Early": "上旬",
        "Mid": "中旬",
        "Late": "下旬"
    },
    today: '今天',
    clockType: 24
};

/* Number
-----------------------------------------------------------------------------*/
mini.cultures["zh-CN"] = {
    name: "zh-CN",
    numberFormat: {
        number: {
            pattern: ["n", "-n"],
            decimals: 2,
            decimalsSeparator: ".",
            groupSeparator: ",",
            groupSize: [3]
        },
        percent: {
            pattern: ["n%", "-n%"],
            decimals: 2,
            decimalsSeparator: ".",
            groupSeparator: ",",
            groupSize: [3],
            symbol: "%"
        },
        currency: {
            pattern: ["$n", "$-n"],
            decimals: 2,
            decimalsSeparator: ".",
            groupSeparator: ",",
            groupSize: [3],
            symbol: "¥"
        }
    }
}
mini.culture("zh-CN");

/* MessageBox
-----------------------------------------------------------------------------*/
if(mini.MessageBox){
    mini.copyTo(mini.MessageBox, {
        alertTitle: "提醒",
        confirmTitle: "确认",
        prompTitle: "输入",
        prompMessage: "请输入内容：",
        buttonText: {
            ok: "确定", //"OK",
            cancel: "取消", //"Cancel",
            yes: "是", //"Yes",
            no: "否"//"No"
        }
    });
};

/* Calendar
-----------------------------------------------------------------------------*/
if (mini.Calendar) {
    mini.copyTo(mini.Calendar.prototype, {
        firstDayOfWeek: 0,
        yesterdayText: "昨天",
        todayText: "今天",
        clearText: "清除",
        okText: "确定",
        cancelText: "取消",
        daysShort: ["日", "一", "二", "三", "四", "五", "六"],
        format: "yyyy年MM月",

        timeFormat: 'H:mm'
    });
}


/* required | loadingMsg
-----------------------------------------------------------------------------*/
for (var id in mini) {
    var clazz = mini[id];
    if (clazz && clazz.prototype && clazz.prototype.isControl) {
        clazz.prototype.requiredErrorText = "不能为空";
        clazz.prototype.loadingMsg = "加载中...";
    }

}
/* VTypes
-----------------------------------------------------------------------------*/
if (mini.VTypes) {
    mini.copyTo(mini.VTypes, {
        minDateErrorText: '不能小于日期 {0}',
        maxDateErrorText: '不能大于日期 {0}',

        uniqueErrorText: "字段不能重复",
        requiredErrorText: "不能为空",
        emailErrorText: "请输入邮件格式",
        urlErrorText: "请输入URL格式",
        floatErrorText: "请输入数字",
        intErrorText: "请输入整数",
        dateErrorText: "请输入日期格式 {0}",
        maxLengthErrorText: "不能超过 {0} 个字符",
        minLengthErrorText: "不能少于 {0} 个字符",
        maxErrorText: "数字不能大于 {0} ",
        minErrorText: "数字不能小于 {0} ",
        rangeLengthErrorText: "字符长度必须在 {0} 到 {1} 之间",
        rangeCharErrorText: "字符数必须在 {0} 到 {1} 之间",
        rangeErrorText: "数字必须在 {0} 到 {1} 之间"
    });
}

/* Pager
-----------------------------------------------------------------------------*/
if (mini.Pager) {
    mini.copyTo(mini.Pager.prototype, {
        firstText: "首页",
        prevText: "上一页",
        nextText: "下一页",
        lastText: "尾页",
        pageInfoText: "每页 {0} 条, 共 {1} 条"
    });
}

/* DataGrid
-----------------------------------------------------------------------------*/
if (mini.DataGrid) {
    mini.copyTo(mini.DataGrid.prototype, {
        emptyText: "没有返回的数据"
    });
}

if (mini.FileUpload) {
    mini.FileUpload.prototype.buttonText = "浏览..."
}
if (mini.HtmlFile) {
    mini.HtmlFile.prototype.buttonText = "浏览..."
}

/* Gantt
-----------------------------------------------------------------------------*/
if (window.mini.Gantt) {
    mini.GanttView.ShortWeeks = [
        '日', '一', '二', '三', '四', '五', '六'
    ];
    mini.GanttView.LongWeeks = [
        '星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'
    ];

    mini.Gantt.PredecessorLinkType = [
        { ID: 0, Name: '完成-完成(FF)', Short: 'FF' },
        { ID: 1, Name: '完成-开始(FS)', Short: 'FS' },
        { ID: 2, Name: '开始-完成(SF)', Short: 'SF' },
        { ID: 3, Name: '开始-开始(SS)', Short: 'SS' }
    ];

    mini.Gantt.ConstraintType = [
        { ID: 0, Name: '越早越好' },
        { ID: 1, Name: '越晚越好' },
        { ID: 2, Name: '必须开始于' },
        { ID: 3, Name: '必须完成于' },
        { ID: 4, Name: '不得早于...开始' },
        { ID: 5, Name: '不得晚于...开始' },
        { ID: 6, Name: '不得早于...完成' },
        { ID: 7, Name: '不得晚于...完成' }
    ];

    mini.copyTo(mini.Gantt, {
        ID_Text: "标识号",
        Name_Text: "任务名称",
        PercentComplete_Text: "进度",
        Duration_Text: "工期",
        Start_Text: "开始日期",
        Finish_Text: "完成日期",
        Critical_Text: "关键任务",

        PredecessorLink_Text: "前置任务",
        Work_Text: "工时",
        Priority_Text: "重要级别",
        Weight_Text: "权重",
        OutlineNumber_Text: "大纲字段",
        OutlineLevel_Text: "任务层级",
        ActualStart_Text: "实际开始日期",
        ActualFinish_Text: "实际完成日期",
        WBS_Text: "WBS",
        ConstraintType_Text: "限制类型",
        ConstraintDate_Text: "限制日期",
        Department_Text: "部门",
        Principal_Text: "负责人",
        Assignments_Text: "资源名称",

        Summary_Text: "摘要任务",
        Task_Text: "任务",
        Baseline_Text: "比较基准",
        LinkType_Text: "链接类型",
        LinkLag_Text: "延隔时间",
        From_Text: "从",
        To_Text: "到",

        Goto_Text: "转到任务",
        UpGrade_Text: "升级",
        DownGrade_Text: "降级",
        Add_Text: "新增",
        Edit_Text: "编辑",
        Remove_Text: "删除",
        Move_Text: "移动",
        ZoomIn_Text: "放大",
        ZoomOut_Text: "缩小",
        Deselect_Text: "取消选择",
        Split_Text: "拆分任务"


    });

}