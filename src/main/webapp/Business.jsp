<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/15
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<h2>添加</h2>
　<form action="business/insert.action" method="post"  enctype="multipart/form-data">
    商家名称：<input type="text" name="bname"/>
    商家地址：<input type="text" name="address"/>
    图片：<input type="file" name="file"/>
    <input type="submit" value="提交">
</form>

<h2>修改</h2>
<form action="business/updateByPrimaryKey.action" method="post" enctype="multipart/form-data">
    bid:<input type="text" name="bid"/>
    商家名称：<input type="text" name="bname"/>
    商家地址：<input type="text" name="address"/>
    图片：<input type="file" name="file"/>
    <input type="submit" value="提交">
</form>

<form action="businessImg/uploadBusinessImg.action"  method="post" enctype="multipart/form-data">
    <%--imgId：<input type="text" name="imgId"/>--%>
    bid：<input type="text" name="bid"/>
    img_path：<input type="file" name="file"/>
    <input type="submit" value="提交">
</form>

<form action="/businessKeepsake/addKeepsake.action" method="post" enctype="multipart/form-data">
    <%--imgId：<input type="text" name="imgId"/>--%>
    bid：<input type="text" name="bid"/>
    info:<input type="text" name="info" >
    img_path：<input type="file" name="file"/>
    <input type="submit" value="提交">
</form>

<form action="/businessKeepsake/updateKeepsake.action" method="post" enctype="multipart/form-data">
    <%--imgId：<input type="text" name="imgId"/>--%>
    kid: <input type="text" name="kid"/>
    bid：<input type="text" name="bid"/>
    info:<input type="text" name="info" >
    img_path：<input type="file" name="file"/>
    <input type="submit" value="提交">
</form>

<h2>添加</h2>
<form action="businessCarousel/insertSelective.action"  method="post" enctype="multipart/form-data">

    <input type="text" name="name"/>
    img_path：<input type="file" name="file"/>
    <input type="text" name="type"/>
    <input type="text" name="bid"/>
    <input type="text" name="status"/>
    <input type="submit" value="提交">
</form>
<h2>修改</h2>
<form action="businessCarousel/updateByPrimaryKeySelective.action"  method="post" enctype="multipart/form-data">
    <input type="text" name="bcid"/>
    <input type="text" name="name"/>
    img_path：<input type="file" name="file"/>
    <input type="text" name="type"/>
    <input type="text" name="bid"/>
    <input type="text" name="status"/>
    <input type="submit" value="提交">
</form>
</html>
