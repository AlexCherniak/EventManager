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
<!-- Calendar -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script>
	$(function() {
	  $( "#datepicker" ).datepicker();
	});
</script>
<script>
function changeImage()
{
var x=document.getElementById("EventInvitation").value;
//x.value=x.value.toUpperCase();
document.getElementById("EventInvitationImage").src=x;
}
</script>
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
<%String time=DataBaseManager.getInstance().getCalendar(eventName);  %>
<%boolean PrivateOrpublic=DataBaseManager.getInstance().getPrivateOrpublic(eventName);  %>
<%String eventLocation=DataBaseManager.getInstance().getLocation(eventName);  %>
<%String eventCalendar=DataBaseManager.getInstance().getCalendar(eventName);  %>

<form id="editEvent" action="editEvent" method="post" target="_parent">
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
	<input type="text"  readonly="readonly" id="eventtName" name="eventtName" value="<%=eventName%>">
	<input type="hidden" id="eventNameOld" name="eventNameOld" value="<%=eventName%>">
	<input type="hidden" id="eventHoster" name="eventHoster" value="<%=eventHoster%>">
	</td>
</tr>

<tr>
	<td>event Location:</td>
	<td><input type="text" id="EventLocation" name="EventLocation" value="<%=eventLocation%>"></td>
</tr>

<tr>
	<td>event Date:</td>
	<td><input type="text" id="datepicker" name="datepicker" value="<%=eventCalendar%>"></td>
</tr>

<tr>
	<td>Public?:</td>
	<td>
	<select name="EventPublic" form="editEvent">
	<%if(PrivateOrpublic==true){ %>
	  <option  value="true" selected>public</option>
	  <option  value="false">private</option>
	  <%} else{ %>
	  <option  value="true">public</option>
	  <option  value="false" selected>private</option>
	  <%} %>
	</select>
	</td>
</tr>

<tr>
	<td>Invitation URL:</td>
	<td><input type="text" id="EventInvitation" name="EventInvitation" value="<%=invitation%>" onchange="changeImage()"></td>
	<td><a href="<%=invitation%>" target="_blank"><img id="EventInvitationImage" name="EventInvitationImage" src="<%=invitation%>" alt="<%=eventName%>" height="90" width="110"></a></td>
</tr>

<tr>
<td><input type="submit" value="save"/></td>
<td></td> 
<td>
<form id="editEvent" action="deleteEvent" method="post" target="_parent">
<input type="hidden" id="eventNameOld" name="eventNameOld" value="<%=eventName%>">
<input type="submit" value="delete"/>
</form>
</td>
</tr>

</table>
</form>



</body>
</html>