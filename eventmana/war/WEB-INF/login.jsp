<!DOCTYPE html>
<html>
<head>
<div id="fb-root"></div>
<script src="javascript/functions.js"></script>
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
    	window.top.location = "http://1.manager-event.appspot.com/Main";
    	
    	/*document.getElementById("status").innerHTML="";
    	fbgetUserInfo();
    	fbgetPhoto();
    	fbGetLoginStatus();*/
        document.getElementById("message").innerHTML +=  "<br>Connected to Facebook";
        //SUCCESS
    }    
    else if (response.status === 'not_authorized') 
    {
        document.getElementById("message").innerHTML +=  "<br>Failed to Connect";
 
        //FAILED
    } else 
    {
        document.getElementById("message").innerHTML +=  "<br>Logged Out";
 
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
 
 

$('#trigger').click( function() {
    if ($('#popout').hasClass('hidden')) {
        $('#popout').removeClass('hidden');
        showPopout();
    }
    else {
        $('#popout').addClass('hidden');
        hidePopout();
    }
});

function showPopout() {
    $('#popout').animate({
        left: 0
    }, 'slow', function () {
        $('#trigger span').html('Close');  //change the trigger text at end of animation
    });
}

function hidePopout() {
    $('#popout').animate({
        left: -40
    }, 'slow', function () {
        $('#trigger span').html('Show');  //change the trigger text at end of animation
    });
}
 
</script>

<style>

#demo
{
background:url(event_manager.png) no-repeat center;
height:500px;
width:408px;
position: relative;
left:35%;
}

</style>


<meta charset="windows-1255">
<title>EventManager</title>
</head>
<body background="templatemo_body.jpg">

	<div id="demo">
		<img id="image2" style="position: absolute; top: 238px; left: 89px; cursor:pointer;"
			src="login-via-facebook.png" onclick="fbLogin()" />
	</div>
	
</body>
</html>