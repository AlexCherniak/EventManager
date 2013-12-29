<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.google.appengine.api.datastore.DatastoreServiceFactory"%>
<%@page import="com.google.appengine.repackaged.com.google.api.client.util.store.DataStore"%>
<%@page import="dbManager.PMF"%>
<%@page import="dbManager.MyClass"%>
<%@ page import="backend.example.project.server.Fib" %>
<%@page import="gaming.GameScore" %>
<%@page import="dbManager.DataBaseManager" %>
<%@page import="java.util.List;" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<script src="javascript/functions.js"></script>
<script src="jquery-1.10.2.min.js"></script>
<script src="http://digg.googlecode.com/files/Class-0.0.2.js"></script>
<title>Insert title here</title>
</head>
<body background="../images/eventIndex.jpg">
	
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=615599291832366";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>


<%String eventName = request.getParameter("name");%>
<%if(eventName==null) eventName="";  %>


<%String eventHoster=DataBaseManager.getInstance().getHosterID(eventName); %>
<%String invitation=DataBaseManager.getInstance().getInvitation(eventName);  %>
<%float time=DataBaseManager.getInstance().getTime(eventName);  %>
<%boolean PrivateOrpublic=DataBaseManager.getInstance().getPrivateOrpublic(eventName);  %>
<%String eventLocation=DataBaseManager.getInstance().getLocation(eventName);  %>

<form id="editEvent" action="editEvent" method="post">
<table>
<tr>
<td>
<div class="fb-send" data-href="<%=invitation%>" data-width="110" data-height="80" data-colorscheme="light"></div>
</td>
<td></td>
<td>
<div class="fb-share-button" data-href="<%=invitation%>" data-width="150" data-type="button_count"></div>
</td>
</tr>
<tr>
	<td>Event name:</td>
	<td>
	<input type="text" id="eventName" name="eventtName" value="<%=eventName%>">
	<input type="hidden" id="eventNameOld" name="eventNameOld" value="<%=eventName%>">
	<input type="hidden" id="eventHoster" name="eventHoster" value="<%=eventHoster%>">
	</td>
</tr>

<tr>
	<td>event Location:</td>
	<td><input type="text" id="EventLocation" name="EventLocation" value="<%=eventLocation%>"></td>
</tr>

<tr>
	<td>Event time:</td>
	<td><input type="text" id="EventTime" name="EventTime" value="<%=time%>">(enter just numbers)</td>
</tr>

<tr>
	<td>Public?:</td>
	<td><input type="text" id="EventPublic" name="EventPublic" value="<%=PrivateOrpublic%>"></td>
</tr>

<tr>
	<td>Invitation URL:</td>
	<td><input type="text" id="EventInvitation" name="EventInvitation" value="<%=invitation%>"></td>
</tr>

<tr>
<td><input type="submit" value="edit"/></td>
</tr>

</table>
</form>


</body>
</html>