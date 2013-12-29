<!DOCTYPE html>
<html>
<head>
<div id="fb-root"></div>
<script src="jquery-1.10.2.min.js"></script>
<script src="javascript/functions.js"></script>
<script src="javascript/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="event.css" title="event manager" />
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
    	//window.top.location = "http://rawisakhnini1992.appspot.com/HelloWorld.html";
    	
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
<style>
.container {
   /* Optional - You can set a  min-height : whatever px; for reserving some space*/
   height: 300px; /* Fix a height here */
   overflow: auto; /* Optionally you can also use overflow: scroll; */
}

</style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tr>
			<td width="10%">
				<div id="profileimg"></div>
			</td>
			<td width="90%"><div id="profilename">Welcome to the site
					:</div> -
				<div id="profileID"></div>
				 -
				<div id="Logout">
					<img src="logout_FB.png" onclick="fbLogout()" />
			</div>
				</td>
				
		</tr>
		<tr>
			<td><div class="container" id="eventslist"></div></td>
			<td><iframe id="eventFrame" src="" width=100%
					height="100%"></iframe></td>
		</tr>
		<tr>
			<td>
				<table>
					<tr>
						<td><input name="eventname" type="text" maxlength="50"
							id="eventname" /> <br>
						<td>
					<tr>
						<td>
						<img id="addEvent" src="add_event.jpg"/>
						<!-- <input type="button" value="New event" onclick="newEvent()"/>-->
							<!-- <button onclick="newEvent()">add event</button> -->
						</td>
					</tr>
				</table>

			</td>
		</tr>
	</table>

</body>
</html>