<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>


<style type="text/css">
    body {
        text-align: center;
    }
</style>
<script type="text/javascript">
    $(function() {

        var id=${param.id};

        $("#chapterFormTitle").textbox({
            type : "text",
            required : true,
            validType : "minLength[1]"
        });
        $('#chapterFormFile').filebox({
            buttonText: "选择音频",
            buttonAlign: "left",
            required : true
        });
        $.extend($.fn.validatebox.defaults.rules, {
            minLength : {
                validator : function(value, param) {
                    return value.length >= param[0];
                },
                message : "不能为空"
            }
        });

        $("#chapterFormSubmit").linkbutton({
            onClick : function() {
                $("#chapterForm").form("submit", {
                    url:"${pageContext.request.contextPath}/album/addChapter",
                    onSubmit:function() {
                        return $("#chapterForm").form("validate");
                    },
                    success:function() {
                        $("#addChapterDg").dialog("close");
                        $.messager.show({
                            title : "添加",
                            msg : "添加音频成功"
                        });

                        $("#albumDg").treegrid("load");
                        $.parser.parse();
                    },
                    queryParams:{"aid":id}
                });
            }
        });
        $("#chapterFormReset").linkbutton({
            onClick : function() {
                $("#chapterForm").form("reset");
            }
        });




    });
</script>


<h1>专辑详情</h1>


<form id="chapterForm" enctype="multipart/form-data" method="post">
    专辑标题: <input id="chapterFormTitle" name="title" /> <br> <br>
    上传的音频： <input id="chapterFormFile" class="easyui-filebox" name="file1" /> <br> <br>

    <a id="chapterFormSubmit">提交</a> <a id="chapterFormReset">重置 </a>

</form>


