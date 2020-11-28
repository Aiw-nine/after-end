<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><c:if test="${entry==null}">增加电子图书</c:if><c:if test="${entry!=null}">更新电子图书</c:if></title>
    <style>
        form{width: 600px;margin: 0 auto;}
        table{width:100%;}
        table,tr,td,caption{border:1px solid #666666;border-collapse:collapse;padding:5px 10px;}
        span{color:red;}
        textarea{height:60px;width:350px;}
        tr:nth-last-of-type(1) td{text-align:center;}
        select{width:173px;}
        .back{text-decoration: none;margin-left: 20px;display: inline-block;width: 40px;height: 22px;line-height:22px;border:1px solid #ccc;font-size:13.3px}
    </style>
</head>
<body>
    <form action="save" method="post" onsubmit="return check()">
        <table>
            <caption><c:if test="${entry==null}">增加电子图书</c:if><c:if test="${entry!=null}">更新电子图书</c:if></caption>
            <c:if test='${entry!=null}'>
            <tr>
                <td>图书编号</td>
                <td><input type="text" name="id" readonly="readonly" value="${entry.id}"></td>
            </tr>
            </c:if>
            <tr>
                <td>图书名称<span>(*)</span></td>
                <td><input type="text" name="title" maxlength="15" value="${entry.title}"></td>
            </tr>
            <tr>
            	<td>图书分类</td>
            	<td>
            		<select name="categoryid">
						<c:forEach items="${list2}" var="c">
			        	<option value="${c.id}" <c:if test='${entry.categoryid==c.id}'>selected</c:if>>${c.name}</option>
			        	</c:forEach>
					</select>
            	</td>
            </tr>
            <tr>
                <td>图书摘要</td>
                <td><textarea cols="30" rows="10" name="summary">${entry.summary}</textarea></td>
            </tr>

            <tr>
                <td>上传人</td>
                <td><input type="text" name="uploaduser" value="${entry.uploaduser}"></td>
            </tr>
            <tr>
                <td>上传时间<span>(*)</span></td>
                <td><input type="date" name="createdate" value="<fmt:formatDate value="${entry.createdate}" pattern="yyyy-MM-dd"/>">(yyyy-MM-dd)</td>
            </tr>
            <tr>
                <td colspan="2"><button type="sumbit">提交</button><a href="./" class="back">返回</a></td>
            </tr>
        </table>
    </form>
    <script>
    	function checkName() {
            var name = document.getElementsByName("title")[0].value;
            if (name == "") {
                alert("图书名称不能为空！");
                return false;
            }
            return true;
        }

        function checkCreatedate() {
            var createdate = document.getElementsByName("createdate")[0].value;
            if (createdate == "") {
                alert("上传时间不能为空！");
                return false;
            }
            return true;
        }

        function check() {
            return checkName() && checkCreatedate();
        }
    </script>
</body>
</html>