var eventArray = new Array();
var eventData =new Array();
var numberOfDataInEvent=7;


$(document).ready(function(){
	$('#addEvent').click(function(){
		var eventname = $( "#eventname" ).val();
		//alert(eventname);
		eventArray.push(eventname);
		//addEventToArray(eventname);
		//alert(eventArray[0]);
		//$('#eventslist').append("<a  target='eventFrame' href='"+profileID+"/"+eventname+"/index.html'><img src='event_icon.png'/></img><b>"+eventname+"</a><br>");
		$('#eventslist').append("<a  target='eventFrame' href='MyEvent' onclick='retrieveEventData($(this).text())'><img src='event_icon.png'/><b>"+eventname+"1</a><br>");
		//var obj = new Object();
		//obj.name = eventname;
		//obj.age = 16;
		//obj["sex"] = "male"; // equivalent to obj.sex = "male"
		//eventArray.push(obj);
		//var x=document.getElementById("profileID");
		//x.innerHTML=eventArray;
	});
});
