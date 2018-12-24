<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <script>
        $(function () {

            var toolbar=[{
                iconCls: "icon-add",
                text:"添加专辑",
                handler: function(){
                    $("#AlbumDialog").dialog({
                        title:"录入专辑信息",
                        modal:false,
                        width:300,
                        colsed:true,
                        href:"${pageContext.request.contextPath}/album/addAlbum.jsp"
                    });

                }
            },'-', {
                iconCls: "icon-remove",
                text:"删除",
                handler: function(){
                    //获取选中行
                    var row = $("#albumDg").edatagrid("getSelected");
                    if (row != null) {
                     if(row.author!=null){
                         $.messager.confirm("确定","你确定要删除这个专辑吗？",function(r){
                             if(r){
                                 $.post(
                                     "${pageContext.request.contextPath}/album/deleteAlbum",
                                     "id="+row.id,
                                     function(){
                                         $("#albumDg").treegrid("reload");

                                     }
                                 );
                             }
                         });
                     }else{
                         $.messager.confirm("确定","你确定要删除这个音频吗？",function(r){
                             if(r){
                                 $.post(
                                     "${pageContext.request.contextPath}/album/deleteChapter",
                                     "id="+row.id,
                                     function(){
                                         $("#albumDg").treegrid("reload");
                                     }
                                 );
                             }
                         });
                     }
                    } else {
                        $.messager.alert("友情提醒","请先选择需要删除的行");
                    }
                }
            },'-', {
                iconCls: "icon-edit",
                text:"下载",
                handler: function(){
                    //获取选中行
                    var row = $("#albumDg").edatagrid("getSelected");
                    if (row != null) {

                        if(row.url!=null){
                            location.href="${pageContext.request.contextPath}/album/downLoadChapter?url="+row.url;
                        }else {
                            alert("请选择需要下载的音频");
                        }
                        //编辑指定行
                    } else {
                        alert("请先选中行")
                    }

                }
            },'-',{
                iconCls: "icon-help",
                text:"专辑详情",
                handler: function(){
                    var row = $("#albumDg").treegrid("getSelected");
                    if(row!=null){
                        if(row.author!=null){
                            $("#AlbumDg").dialog({
                                title:"商品详情",
                                modal:false,
                                width:300,
                                colsed:true,

                            content:   "&nbsp id：<input disabled type='text' value='" + row.id + "'/><br/>" +
                                "&nbsp标题：<input disabled type='text' value='" + row.title + "'/><br/>" +
                            "章节数:<input disabled type='text' value='" + row.count + "'/><br/>" +
                            "&nbsp头像：<img alt='' disabled width='50px' height:'50px' src=${pageContext.request.contextPath}"+row.coverImg+"/><br/>" +
                            "&nbsp评分：<input disabled type='text' value='" + row.score + "'/><br/>" +
                            "&nbsp作者：<input disabled type='text' value='" + row.author + "'/><br/>" +
                            "&nbsp播音：<input disabled type='text' value='" + row.broadcast + "'/><br/>" +
                            "&nbsp简介：<input disabled type='text' value='" + row.brief + "'/><br/>" +
                            "&nbsp日期：<input disabled type='text' value='" + row.pubDate + "'/><br/>"
                            });
                        }else{
                            alert("你选了音频行，请选择专辑行");
                        }
                    }else{
                        alert("请先选中行")
                    }


                }
            },'-',{
                iconCls: "icon-help",
                text:"添加音频",
                handler: function(){
                    var row = $("#albumDg").treegrid("getSelected");
                    if(row!=null){
                        if(row.author!=null){
                            $("#addChapterDg").dialog({
                                title:"录入音频信息",
                                modal:false,
                                width:300,
                                colsed:true,
                                href:"${pageContext.request.contextPath}/album/addChapter.jsp?id="+row.id
                            });
                        }else{
                            alert("请先选中专辑~~，不要选音频行！！")
                        }

                    }else{
                        alert("请先选中专辑~~")
                    }
                }
            }]


            $("#albumDg").treegrid({
                method:"get",
                url:"${pageContext.request.contextPath}/album/queryAllAlbum",
                idField:"id",
                treeField:"title",
                animate:true,
                columns:[[
                    {field:"title",title:"标题",width:80},
                    {field:"url",title:"音频",formatter: function(value,row,index){
                        if(row.url){
                            return '<audio src=\"${pageContext.request.contextPath}'+row.url+'\" controls="controls"> </audio >';

                        }
                        }
                        ,width:100},
                    {field:"size",title:"章节大小",width:80},

                    {field:"duration",title:"章节时长",width:80}
                ]],
                fitColumns:true,
                fit:true,
                toolbar: toolbar

            });


        })


        
    </script>

<table id="albumDg"></table>

<div id="addChapterDg"></div>

<div id="AlbumDialog" ></div>

<div id="AlbumDg"></div>