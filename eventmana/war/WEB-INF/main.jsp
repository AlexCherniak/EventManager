<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.google.appengine.api.datastore.DatastoreServiceFactory"%>
<%@page import="com.google.appengine.repackaged.com.google.api.client.util.store.DataStore"%>
<%@page import="dbManager.PMF"%>
<%@page import="dbManager.MyClass"%>
<%@ page import="backend.example.project.server.Fib" %>
<%@page import="gaming.newEvent" %>
<%@page import="dbManager.DataBaseManager" %>
<%@page import="java.util.List;" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Event Manager</title>

<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="Event manager site" />
<meta name="keywords" content="events,event manager" />
<meta name="author" content="Event Manager" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="css/coda-slider.css" type="text/css" media="screen" charset="utf-8" />

<script src="js/jquery-1.2.6.js" type="text/javascript"></script>
<script src="js/jquery.scrollTo-1.3.3.js" type="text/javascript"></script>
<script src="js/jquery.localscroll-1.2.5.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.serialScroll-1.2.1.js" type="text/javascript" charset="utf-8"></script>
<script src="js/coda-slider.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.easing.1.3.js" type="text/javascript" charset="utf-8"></script>
<script src="javascript/functions.js"></script>
<script src="jquery-1.10.2.min.js"></script>
<script src="http://digg.googlecode.com/files/Class-0.0.2.js"></script>

<script>
  window.fbAsyncInit = function() {
    FB.init({
   appId      : '675762885808171', // App ID
      channelUrl : 'tester--tester.appspot.com/channel.html',
      status     : true, // check login status
      cookie     : true, // enable cookies to allow the server to access the session
      xfbml      : true  // parse XFBML
    });
    
      FB.Event.subscribe('auth.authResponseChange', function(response) 
    {
     if (response.status === 'connected') 
    {
    	//window.top.location = "http://tester--tester.appspot.com/HelloWorld.html";
    	
    	//document.getElementById("status").innerHTML="";
    	fbgetUserName();
    	getfbgetUserID2();
    	fbgetUserId();
    	fbgetPhoto();
    	getfbgetUserName();
    	getTheEvent();
    	getfbgetUserID();//get the ID
    	myIDforSession();
    	
    	
    }
    else if (response.status === 'not_authorized') 
    {
       // document.getElementById("message").innerHTML +=  "<br>Failed to Connect";
 
        //FAILED
    } else 
    {
        //document.getElementById("message").innerHTML +=  "<br>Logged Out";
 window.top.location = "http://tester--tester.appspot.com/test.html";
        //UNKNOWN ERROR
    }
    }); 
    
    
    };
    
  (function(d){
     var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement('script'); js.id = id; js.async = true;
     js.src = "//connect.facebook.net/en_US/all.js";
     ref.parentNode.insertBefore(js, ref);
   }(document));
 
</script>
<meta charset="ISO-8859-1">
</head>
<body>

<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=675762885808171";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>

<div id="slider">
	
    <div id="templatemo_sidebar">
    	<div id="templatemo_header">
        	<a href="http://1.tester--tester.appspot.com/" target="_parent"><img src="images/templatemo_logo.png" alt="EventManager" /></a>
        </div> <!-- end of header -->
        
        <ul class="navigation">
        	 <li></li>
        	<li><img src="logout_FB.png" onclick="fbLogout()" style="height: 38px; width: 150px" /></li>
            <li><a href="#home">Home<span class="ui_icon home"></span></a></li>
            <li><a href="#services">show/add events<span class="ui_icon services"></span></a></li>
            <li><a href="#drawInvitation">create your letter<span class="ui_icon drawInvitation"></span></a></li>
            <li><a href="#gallery">Gallery<span class="ui_icon gallery"></span></a></li>
            <li><a href="#contactus">Contact Us<span class="ui_icon contactus"></span></a></li>
        </ul>
    </div> <!-- end of sidebar -->

	<div id="templatemo_main">
    	<ul id="social_box">
            <li><div id="profileimg"></div></li>
            <li>welcome: <div id="profilename"></div></li>
            <li></li>
            <li>
            <div class="fb-like" data-href="http://1.tester--tester.appspot.com" data-width="150" data-layout="standard" data-action="like" data-show-faces="true" data-share="true"></div>
           </li>
            
     </ul>
        
        <div id="content">
        
        <!-- scroll -->
        
        	
            <div class="scroll">
                <div class="scrollContainer">
                
                    <div class="panel" id="home">
                        <h1>welcome</h1>
                        <p>
                        This website aims to help people manage their events in a more easier and efficient way. Nowadays communicating through internet websites has become more popular then ever. EventManager is intended for event-planners who invite their guests using the internet.
                        </p>
                       
                      <div class="cleaner_h40"></div>
                    <div class="btn_more"><a href="#services">click here to create a new event. <span>&raquo;</span></a></div>
                    </div> <!-- end of home -->
                    
                    
            <div class="panel" id="services">
                       	<%
			List<newEvent> list;
				%>
			<div id="myID"></div>
			<%
			if (session.getAttribute("userName") == null)
			{
				list = DataBaseManager.getInstance().getAllEvents();
			%> <h1>ALL Events</h1> <%
			}
			else
			{
				%> <h1>My Events</h1> <%
				list = DataBaseManager.getInstance().getEvent(session.getAttribute("userName").toString());
			%>
			<%
			}
			%> 
		<tbody>
			  <tr>
			    <td colspan="2">
			      <div class="scrollit">
			        <table>
			 <%
			 
			for (newEvent item : list)
			{
				
				%><tr>
				<td>
				<form id="eventinfo" action="eventinfo" method="post" target="eventFrame"><!-- eventinfo make a session -->
				<input type="hidden" id="EventName" name="EventName" value="<%=item.name%>">
				<img src="event_icon.png"/></img><%=item.name%><input type="submit" value="edit"/>
				</form>
				</td>
				
				</tr><%
			}
			%> </table>
					</div>
						</td>
							</tr>
							<tr>
							<td>
							<div id="myIDD">
							</div>
							</tr>
								</tbody>
			<iframe src="" name="eventFrame" id="eventFrame" width=100% height="500" scrolling="no"></iframe>
                    </div> <!-- end of services -->
                
                <div class="panel" id="drawInvitation">
                <h1>here you'll able to create your letter</h1>
                </div> <!-- end of drawInvitation -->
                
                    <div class="panel" id="gallery">
                        <h1>Our Gallery</h1>
                    </div>
                
                    <div class="panel" id="contactus">
                        <h1>Feel free to send us a message</h1>
                        <div id="contact_form">
                            <form method="post" name="contact" action="#contactus">
                                
                                <label for="author">Your Name:</label> <input type="text" id="author" name="author" class="required input_field" />
                                <div class="cleaner_h10"></div>
                                
                                <label for="email">Your Email:</label> <input type="text" id="email" name="email" class="validate-email required input_field" />
                                <div class="cleaner_h10"></div>
                                
                                <label for="text">Message:</label> <textarea id="text" name="text" rows="0" cols="0" class="required"></textarea>
                                <div class="cleaner_h10"></div>
                                
                                <input type="submit" class="submit_btn" name="submit" id="submit" value="Send" />
                                <input type="reset" class="submit_btn" name="reset" id="reset" value="Reset" />
                            
                            </form>
						</div>
                    </div>
                
                </div>
			</div>
            
        <!-- end of scroll -->
        
        </div> <!-- end of content -->
        
        <div id="templatemo_footer">
        <h1>EVENT MANAGER</h1>
        </div> <!-- end of templatemo_footer -->
    
    </div> <!-- end of main -->
</div>

</body>
</html>