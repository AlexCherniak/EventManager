
var profileID;
//var clickedevent=,,, this will check which event clicked to get the data.
function fbLogin()
{

	FB.login(function(response) {
		if (response.authResponse) 
		{
			// getUserInfo();
		} else 
		{
			console.log('User cancelled login or did not fully authorize.');
		}
	},{scope: 'email,user_photos,user_videos'});

}

function fbgetUserName() {
	FB.api('/me', function(response) {
		var str="<h4>"+response.name+"</h4>";
		document.getElementById("profilename").innerHTML+=str;});
}
function fbgetUserId() {
	FB.api('/me', function(response) {

		var str1 ="<b>"+response.id+"</b>";
		profileID=response.id;
		document.getElementById("profileID").innerHTML=str1;});
}


/*
		square - 50x50
		small - 50 pixels wide, variable height
		normal - 100 pixels wide, variable height
		large - about 200 pixels wide, variable height
 */
function fbgetPhoto()
{
	FB.api('/me/picture?type=normal', function(response) {

		var str="<img src='"+response.data.url+"'/>";
		//str +="<br><b>Link:</b> "+response.data.url+"<br>";
		document.getElementById("profileimg").innerHTML+=str;});
}

function fbLogout()
{
	FB.logout(function(){document.location.reload();});
	window.location.href = "http://1.manager-event.appspot.com/";
}

function fbGetLoginStatus() {
	FB.getLoginStatus(function(response) {
		if (response.status === 'connected') {
			var str="";
			// the user is logged in and has authenticated your
			// app, and response.authResponse supplies
			// the user's ID, a valid access token, a signed
			// request, and the time the access token 
			// and signed request each expire
			var accessToken = response.authResponse.accessToken;
			str+="<br>"+accessToken+"<br>";
			document.getElementById("status").innerHTML+=str;
		} else if (response.status === 'not_authorized') {
			// the user is logged in to Facebook, 
			// but has not authenticated your app
		} else {
			// the user isn't logged in to Facebook.
		}
	});
}


function getEventName(){
	alert(eventArray[0]);
	//return eventArray;
}

function getfbgetUserName() {
	FB.api('/me', function(response) {

		var str1=response.name;
		var str="<form action='Servlet' method='post'> <input type='text' name='info' value='"+str1+"'> <input type='submit' value='submit'></form>";
		document.getElementById("infor").innerHTML+=str;});

}

function getTheEvent() {
		var str1=response.id;
		var str=" <input type='text' name='eventInfo' value='"+str1+"'> <input type='submit' onclick='newEvent()' value='submit' >";
		document.getElementById("eventz").innerHTML+=str;

}

function newEvent() {
		var eventname = document.getElementById('eventname').value;
		//var UserID=response.id;
		document.getElementById("eventslist").innerHTML+="<a  target='eventFrame' href='"+profileID+"/"+eventname+"/index.html'><img src='event_icon.png'/></img><b>"+eventname+"</a><br>";	
}

function getfbgetUserID() {
	FB.api('/me', function(response) {

		var str1=response.id;
		
		var str="<% session.setAttribute('userName', '"+str1+"'); %>";
		document.getElementById("myID").innerHTML+=str;});
}

function getfbgetUserID2() {
	FB.api('/me', function(response) {

		var str1=response.id;
		var str="<form id='formDiv' action='SaveTheEvent' method='post'><input type='hidden' name='theEventHoster' value='"+str1+"'><input type='text' id='theEventName' name='theEventName'><input type='submit' value='add new event' onclick='newEvent()'/></form>";
		document.getElementById("myIDD").innerHTML+=str;});
}

function greeting()
{
	var eventname = document.getElementById('pprofilename').value;
    confirm("Great to see you, "+ eventname );
}



