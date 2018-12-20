<%@ page pageEncoding="utf-8"%>

<style type="text/css">
	body {
		text-align: center;
	}
</style>
<script type="text/javascript">
    $(function() {
        $("#addBannerFormBannerTitle").textbox({
            type : "text",
            required : true,
            validType : "minLength[1]"
        });

        $("#addBannerFormBannerDescription").textbox({
            type : "text",
            multiline:true

        });


        $("#addBannerFormSubmit").linkbutton({
            onClick : function() {
                $("#addBannerForm").form("submit", {
                    url:"${pageContext.request.contextPath}/banner/addBanner",
                    onSubmit:function() {
                        return $("#addBannerForm").form("validate");
                    },
                    success:function(value) {
                        $.messager.show({
                            title : "添加",
                            msg : "添加成功"
                        });
                        $("#addBannerDialog").dialog("close");
                        $("#BannerTable").datagrid("load");
                        $.parser.parse();
                    }
                });
            }
        });
        $("#addBannerFormReset").linkbutton({
            onClick : function() {
                $("#addBannerForm").form("reset");
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


<form id="addBannerForm" enctype="multipart/form-data" method="post">
	图片标题: <input id="addBannerFormBannerTitle" name="title" /> <br> <br>
	上传的图片图片：<input id="addBannerFormBannerPhoto" class="easyui-filebox" name="file1" /> <br> <br>
	图片的描述：<input	id="addBannerFormBannerDescription" name="description" /> <br> <br>
	图片的状态：<select id="addBannerFormBannerddStatus" class="easyui-combobox" name="status" style="width:200px;">
		<option value="Y">展示</option>
		<option value="N">不展示</option>
	</select>
	<br><br> <br>
	<a id="addBannerFormSubmit">提交</a> <a id="addBannerFormReset">重置 </a> <input
		type="button" value="返回上一级" onclick="history.go(-1);" />
</form>


