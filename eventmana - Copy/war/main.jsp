<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <style type="text/css">
        .logo
        {
            height: 132px;
            width: 185px;
        }
    </style>
<div id="fb-root"></div>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="Event manager site" />
<meta name="keywords" content="events,event manager" />
<meta name="author" content="Event Manager" />
<link rel="stylesheet" type="text/css" href="event.css" title="event manager" />
<script src="javascript/functions.js"></script>
<script src="jquery-1.10.2.min.js"></script>
<script>
 window.fbAsyncInit = function() {
    FB.init({
      appId      : '615599291832366', // App ID
      channelUrl : 'manager-event.appspot.com/channel.html',
      status     : true, // check login status
      cookie     : true, // enable cookies to allow the server to access the session
      xfbml      : true  // parse XFBML
    });
    
      FB.Event.subscribe('auth.authResponseChange', function(response) 
    {
     if (response.status === 'connected') 
    {
    	//window.top.location = "http://manager-event.appspot.com/HelloWorld.html";
    	
    	//document.getElementById("status").innerHTML="";
    	fbgetUserName();
    	fbgetUserId();
    	fbgetPhoto();
    	//fbGetLoginStatus();
       // document.getElementById("message").innerHTML +=  "<br>Connected to Facebook";
        //SUCCESS
    }    
    else if (response.status === 'not_authorized') 
    {
       // document.getElementById("message").innerHTML +=  "<br>Failed to Connect";
 
        //FAILED
    } else 
    {
        //document.getElementById("message").innerHTML +=  "<br>Logged Out";
 window.top.location = "http://manager-event.appspot.com/test.html";
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
<title>Insert title here</title>
</head>
<body>
    <div id="maincontent">
	<table style="width: 100%">
		<tr>
			<td  align="center" colspan="2">
				<img src="logo.jpg"/ class="logo" align="middle" dir="ltr"></td>
        </tr>
       
		<tr>
			<td>
			<div id="profileimg"></div>
				<div id="profilename"></div>, <div id="profileID"></div>
			 </td>
		</tr>
		<tr>
			<td>
					<img src="logout_FB.png" onclick="fbLogout()" style="height: 38px; width: 186px" /></td>
		</tr>
		
		
		<tr>
			<td width=20%>&nbsp;</td>
			<td width=80%><iframe src="index.html" name="index" id="index" width=100% height=60px scrolling=no></iframe></td>
		</tr>
		
		
		<tr>
			<td width=20%>My Events<div class="container" id="eventslist"></div></td>
			<td width=80%><iframe src="http://www.yahoo.com" name="eventFrame" id="eventFrame" width=100% height=100%></iframe></td>
		</tr>
		<tr>
			<td colspan="2">
				<table>
					<tr>
						<td><input name="eventname" type="text" maxlength="50" id="eventname" value="add event" /> <br>
						</td>
						<td>
						<img id="addEvent" src="plus.png" class="plus" onclick="newEvent()"/>
						<!-- <input type="button" value="New event" onclick="newEvent()"/>-->
							<!-- <button onclick="newEvent()">add event</button> -->
						</td>
					</tr>
				</table>

			</td>
		</tr>
	</table>
	</div>

</body>
</html>