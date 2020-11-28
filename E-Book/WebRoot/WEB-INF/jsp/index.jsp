<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>首页</title>
    <style>
        #center{margin:0 auto;max-width: 900px;}
        table,th,tr,td,caption{text-align:left;border:1px solid #8a8989;border-collapse:collapse;padding:5px 10px;}
        caption{text-align: center;}
        th{background: #e4e4e4;}
        form{margin-bottom:10px;}
        tr:nth-of-type(n) td{background:white;}
        tr:nth-of-type(2n) td{background:green;}
        tr:nth-last-of-type(1) td{background: white;text-align: center;color:red;}
        .add{text-decoration: none;margin-left: 80px;display: inline-block;width: 80px;height: 22px;line-height:22px;border:1px solid #ccc;font-size:13.3px}
        button{margin-left: 10px}
    </style>
</head>
<body>
    <div id="center">
    	<form action="./" method="post">
	       	图书分类:
	        <select name="categoryid">	        	
	            <option value="0" <c:if test='${categoryid==0}'>selected</c:if>>全部</option>
	            <c:forEach items="${list2}" var="c">
	        	<option value="${c.id}" <c:if test='${categoryid==c.id}'>selected</c:if>>${c.name}</option>
	        	</c:forEach>
	        </select>
	        <button type="submit">查询</button> 
	        <a href="toInsert" class="add">新增电子图书</a>
        </form>

        <table>
            <caption>电子图书列表</caption>
            <tr>
                <th>图书编号</th>
                <th>图书名称</th>
                <th>图书精要</th>
                <th>图书分类</th>
                <th>上传人</th>
                <th>上传时间</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${list}" var="e">
            <tr>
                <td>${e.id}</td>
                <td>${e.title}</td>
                <td>${e.summary}</td>
                <td>
                	<c:forEach items="${list2}" var="c">
                	<c:if test='${e.categoryid==c.id}'>${c.name}</c:if>
                	</c:forEach>
				</td>
                <td>${e.uploaduser}</td>
                <td><fmt:formatDate value="${e.createdate}" pattern="yyyy-MM-dd"/></td>
                <td><a href="toUpdate?id=${e.id}">修改</a> <a href="delete?id=${e.id}">删除</a></td>
            </tr>
        	</c:forEach>
            <tr>
                <td colspan="7"><c:if test="${msg!=null}">${msg}</c:if></td>
            </tr>
            
        </table>
    </div>
</body>
</html>