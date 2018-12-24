<%@ page pageEncoding="utf-8"%>

<style type="text/css">
    body {
        text-align: center;
    }
</style>
<script type="text/javascript">
    $(function() {
        $("#addAlbumFormAlbumTitle").textbox({
            type : "text",
            required : true,
            validType : "minLength[1]"
        });

        $("#addAlbumFormAlbumAuthor").textbox({
            type : "text",
            required : true,
            validType : "minLength[1]"

        });
        $("#addAlbumFormAlbumBroadcast").textbox({
            type : "text",
            required : true,
            validType : "minLength[1]"
        });

        $("#addAlbumFormAlbumBrief").textbox({
            type : "text",
            multiline:true,
            height:40,
            width:200

        });


        $("#addAlbumFormSubmit").linkbutton({
            onClick : function() {
                $("#addAlbumForm").form("submit", {
                    url:"${pageContext.request.contextPath}/album/addAlbum",
                    onSubmit:function() {
                        return $("#addAlbumForm").form("validate");
                    },
                    success:function() {
                        $.messager.show({
                            title : "添加",
                            msg : "添加成功"
                        });
                        $("#AlbumDialog").dialog("close");
                        $("#albumDg").treegrid("load");
                        $.parser.parse();
                    }
                });
            }
        });
        $("#addAlbumFormReset").linkbutton({
            onClick : function() {
                $("#addAlbumForm").form("reset");
            }
        });
        $.extend($.fn.validatebox.defaults.rules, {
            minLength : {
                validator : function(value, param) {
                    return value.length >= param[0];
                },
                message : "不能为空"
            }
        });
    });
</script>


<h1>商品添加</h1>


<form id="addAlbumForm" enctype="multipart/form-data" method="post">
    专辑标题: <input id="addAlbumFormAlbumTitle" name="title" /> <br> <br>
    上传的专辑的背景图片：<input id="addAlbumFormAlbumPhoto" class="easyui-filebox" name="file1" /> <br> <br>
    专辑作者：<input	id="addAlbumFormAlbumAuthor" name="author" /> <br> <br>
    播音：<input	id="addAlbumFormAlbumBroadcast" name="broadcast" /> <br> <br>
    专辑描述：<input	id="addAlbumFormAlbumBrief" name="brief" /> <br> <br>
    </select>
    <br><br> <br>
    <a id="addAlbumFormSubmit">提交</a> <a id="addAlbumFormReset">重置 </a> <input
        type="button" value="返回上一级" onclick="history.go(-1);" />
</form>


