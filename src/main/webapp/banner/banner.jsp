<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <script>
        $(function () {
            var toolbar=[{
                iconCls: "icon-add",
                text:"添加",
                handler: function(){
                    $("#addBannerDialog").dialog({
                        title:"录入商品信息",
                        modal:false,
                        width:500,
                        colsed:true,
                        href:"${pageContext.request.contextPath}/banner/add.jsp"
                    });

                }
            },'-', {
                iconCls: "icon-remove",
                text:"删除",
                handler: function(){
                    //获取选中行
                    var row = $("#dg").edatagrid("getSelected");
                    if (row != null) {
                        $.messager.confirm("确定","你确定要删除这条数据吗？",function(r){
                            if(r){
                                $.post(
                                    "${pageContext.request.contextPath}/banner/deleteBanner",
                                    "id="+row.id,
                                    function(result){
                                        $("#dg").edatagrid("reload");
                                    }
                                );
                            }
                        });
                    } else {
                        $.messager.alert("友情提醒","请先选择需要删除的行");
                    }
                }
            },'-', {
                iconCls: "icon-edit",
                text:"修改",
                handler: function(){
                    //获取选中行
                    var row = $("#dg").edatagrid("getSelected");
                    if (row != null) {
                        //编辑指定行
                            var index = $("#dg").edatagrid("getRowIndex", row);
                        $("#dg").edatagrid("editRow", index);
                    } else {
                        alert("请先选中行")
                    }

                }
            },'-',{
                iconCls: "icon-help",
                text:"帮助",
                handler: function(){alert('帮助按钮')}
            },'-',{
                iconCls: "icon-help",
                text:"保存",
                handler: function(){
                    $("#dg").edatagrid("saveRow");
                    var row = $("#dg").edatagrid("getSelected");
                    $.post(
                      "${pageContext.request.contextPath}/banner/saveStatus",
                      "status="+row.status+"&id="+row.id,
                      function () {
                          $.messager.show({
                              title:"系统提示",
                              msg:"修改状态成功"
                          });
                      }
                    );
                }
            }]


            $("#dg").edatagrid({
                url:"${pageContext.request.contextPath}/banner/queryAllBanner",
                updateUrl:"${pageContext.request.contextPath}/banner/updateBanner",
                fitColumns:true,
                fit:true,
                pagination:true,
                rownumbers:true,
                pageSize:3,
                pageList:[3,5,7,9,11],
                columns:[[
                    {field:"id",title:"id",width:100,align:"center"},
                    {field:"title",title:"标题",width:100,align:"center"},
                    {field:"imgPath",title:'路径',width:100,align:"center"},
                    {field:"status",title:'状态',editor: {
                            type: "text",
                            options: {required:true}},width:100,align:"center"},
                    {field:"pubDate",title:'上传时间',width:100,align:"center"}
                ]],
                toolbar: toolbar,
                view: detailview,
                detailFormatter: function (rowIndex, rowData) {
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}' + rowData.imgPath + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>描述: ' + rowData.description + '</p>' +
                        '<p>日期: ' + rowData.pubDate + '</p>' +
                        '</td>' +
                        '</tr></table>';
                }
            });





        })
        
    </script>

<table id="dg"></table>

<div id="addBannerDialog" ></div>