var imageWidth = 70;
var imageHeight = 100;

var cards =[];
var cardPairs = [];
var game;
var timeAtBegining;
var stepsRequired = 0;
var numOfRows = 2;
var maxVelocity = 3;

var didILoad = false;
afterLoad = function()
{
	
	if(scriptsToLoad.length > 0)
	{
		//setTimeout(afterLoad, 10);
		return;
	}
	if(didILoad)
	{
		return;
	}
	didILoad = true;
	game = new Game(500,500);
	
    //game.canvas.addEventListener('click', onCanvasClick,false);
    game.doGameStep = theGameStep;
    game.onStartGame = startGame;
    game.onEndGame = onEndGame;
    game.setResetGame(resetGame);
    game.startGame();
};

setGame = function()
{
	game.setClickFunction(onCanvasClick);
	cards =[];
	cardPairs = [];
	timeAtBegining = new Date().getTime() / 1000;
	stepsRequired = 1;
	randomlyInsertCards();
	game.startGameLoop();

};
var pictureList = [
                   "dragon.jpg",
                   "green_dragon.jpg",
                   "red_dragon.jpg",
                   "orange_dragon.jpg",
                   "Flying_girl_with_wild_geese.jpg",
                   "Flying_swans_with_boys.jpg",
                   "giraffe1.jpg",
                   "giraffe2.jpg"];
var numberOfImagesSoFar = 0;
countImages = function(totalNumber, whenDone)
{
	numberOfImagesSoFar +=1;
	if (numberOfImagesSoFar == totalNumber && whenDone!=null) whenDone();
};
startGame = function()
{
	game.ctx.clearRect ( 0 , 0 , game.canvas.width , game.canvas.height );
	game.ctx.fillStyle = "blue";
	game.ctx.font = "bold 32px Arial";
	game.ctx.textAlign = 'center';
	game.ctx.fillText("טוען את התמונות", game.canvas.width/2, game.canvas.height/2);
	for (imageName in pictureList)
	{
		img = new Image();
		img.onload = function() {countImages(pictureList.length , afterLoadingImages)}
		img.src = "images/" + pictureList[imageName];
	}
//	setGame();
};
afterLoadingImages = function()
{
	game.ctx.clearRect ( 0 , 0 , game.canvas.width , game.canvas.height );
	game.ctx.fillStyle = "blue";
	game.ctx.font = "bold 32px Arial";
	game.ctx.textAlign = 'center';
	game.ctx.fillText("לחץ כדי להתחיל", game.canvas.width/2, game.canvas.height/2);
	
	game.setClickFunction(function() {
		setGame();
	});
};


$(document).ready(function ()
{

	//var twoCardsScriptPath = "TwoCards.js";
	scriptsToLoad.push("TwoCards.js");
	//var gameScriptPath = "gameScripts.js";
	scriptsToLoad.push("gameScripts.js");
	loadNext();

});



function loadScript(url, callback)
{
    // adding the script tag to the head as suggested before
   var head = document.getElementsByTagName('head')[0];
   var script = document.createElement('script');
   script.type = 'text/javascript';
   script.src = url;

   // then bind the event to the callback function 
   // there are several events for cross browser compatibility
   script.onreadystatechange = callback;
   script.onload = callback;

   // fire the loading
   head.appendChild(script);
}
var scriptsToLoad = [];
function loadNext()
{

	if (scriptsToLoad[0])
	{
		console.log(scriptsToLoad[0]);
		next = scriptsToLoad[0];
		scriptsToLoad.splice(0, 1);
		loadScript(next, loadNext);
		console.log("loaded " + next);
	}
	else
	{
		setTimeout(afterLoad, 100);
	}
}
var clicks = 0;
onCanvasClick = function(e)
{
	
	
    var xClick;
    var yClick;
    if ((e.pageX) || (e.pageY)) {
    	xClick = e.pageX;
    	yClick = e.pageY;
    } else {
    	xClick = e.clientX + document.body.scrollLeft +
           document.documentElement.scrollLeft;
    	yClick = e.clientY + document.body.scrollTop +
           document.documentElement.scrollTop;
    }

    xClick -= game.canvas.getBoundingClientRect().left;//game.canvas.offsetLeft;
    yClick -= game.canvas.getBoundingClientRect().top;//game.canvas.offsetTop;
    clickedCard = findTopMostCard(xClick,yClick);
    if (clickedCard !== null)
	{
    	clicks++;
    	if (clicks > 2)
    	{
        	clicks -= 2;
            cards.forEach(function(card) {
                if(card.shouldShow)
            	{
                	card.onClick();
            	}
              });
            stepsRequired++;
    	}
    	clickedCard.onClick();
	}
    
};

findTopMostCard = function(xClick, yClick)
{
	var c = null;
	for(index in cards) 
	{
	
      if (cards[index].isInImage(xClick,yClick))
	  {
    	  c = cards[index];
	  }
    }
	return c;
};
theGameStep = function()
{
	if (cards.length==0)
	{
		game.shouldGameStop=true;
	}
    cards.forEach(function(card) {
    	card.move(game.canvas.width, game.canvas.height);
    	card.redraw();
      });
};

removeCards = function(twoCards)
{
	var index = cardPairs.indexOf(twoCards);
	cardPairs.splice(index, 1);
	index = cards.indexOf(twoCards.card1);
	cards.splice(index, 1);
	index = cards.indexOf(twoCards.card2);
	cards.splice(index, 1);
};

randomlyInsertCards = function()
{
	var f =  function(n) {
		var arr = [];
		for (var i=0; i<n; i++)
		{
			arr.push(0);
		}
		return arr;
	};
	var arrX = f(pictureList.length);
	var arrY = f(pictureList.length);
	var directionX = f(pictureList.length);
	var directionY = f(pictureList.length);
	var lengthOfArray = pictureList.length;
	var inEachRow = lengthOfArray/numOfRows;
	for (var i=0; i<lengthOfArray; i++)
	  {
		var cardToWorkOn = Math.floor(Math.random()*lengthOfArray/2);
		while(directionX[cardToWorkOn] > 0)
		{
			cardToWorkOn++;
			if (cardToWorkOn == lengthOfArray) cardToWorkOn = 0;
		}
		
		var multiplyByX = i%inEachRow;
		var multiplyByY = Math.floor(i/inEachRow);
		arrX[cardToWorkOn] = (multiplyByX * imageWidth * 1.5);
		arrY[cardToWorkOn] = (multiplyByY * imageHeight * 1.5); 
		//console.log(cardToWorkOn + " " + arrX[cardToWorkOn] + "," + arrY[cardToWorkOn] );
		directionX[cardToWorkOn] = Math.floor(Math.random()*maxVelocity) + 1;
		directionY[cardToWorkOn] = Math.floor(Math.random()*maxVelocity) + 1;
	  }
	var insertedItems = [];
	var jump=3;
	for (var i=0; i<lengthOfArray/2; i++)
	  {
		var cardToWorkOn = Math.floor(Math.random()*(lengthOfArray/2));
		while(insertedItems.indexOf(cardToWorkOn) > -1)
		{
			cardToWorkOn +=jump;
			cardToWorkOn %= (lengthOfArray/2);
			
		}
		insertedItems.push(cardToWorkOn);
		var firstCard = cardToWorkOn*2;
		var secondCard = cardToWorkOn*2+1;
		cardPairs.push(new TwoCards(pictureList[firstCard],pictureList[secondCard],
				arrX[firstCard], arrY[firstCard], directionX[firstCard], directionY[firstCard],
				arrX[secondCard], arrY[secondCard],directionX[secondCard], directionY[secondCard],
				game.ctx));
		cards.push(cardPairs[i].card1);
		cards.push(cardPairs[i].card2);
		cardPairs[i].cardsRemoved = removeCards;
	  }
};

resetGame = function()
{
	console.log("reseting");	
	setGame();
};



onEndGame = function()
{
	game.ctx.clearRect ( 0 , 0 , game.canvas.width , game.canvas.height );
	game.ctx.fillStyle = "blue";
	game.ctx.font = "bold 32px Arial";
	game.ctx.fillText("ניצחת!", game.canvas.width/2, game.canvas.height/2);
	secondsInterval = new Date().getTime() / 1000 - timeAtBegining;
	game.ctx.font = "bold 20px Arial";
	game.ctx.fillText("לקח לך " + Math.floor(secondsInterval) + " שניות לסיים", game.canvas.width/2, game.canvas.height/2 + 32 );
	game.ctx.fillText("ביצעת " + stepsRequired + " ניסיונות", game.canvas.width/2, game.canvas.height/2 + 60 );
	
	$("#scoreField").val(stepsRequired);
	$("#timeField").val(secondsInterval);
	$("#formDiv").css("display","block");
	

};
