var sizeOfMenuBar = 30;
var gameTimeout = 0;
var Game = Class.create({
	init: function(width,height)
	{
		this.onStartGame = null;
		this.onResetGame = null;
		this.doGameStep = null;
		this.shouldGameStop = false;
		this.onEndGame = null;
		this.interval = 25;
		this.onCanvasClick = null;
		this.ctx = document.getElementById('gameCanvas').getContext('2d');
		this.canvas = $("#gameCanvas")[0];
		this.canvas.setAttribute('width', width);
		this.canvas.setAttribute('height', height);
		
		settings = $("#gameSettings");
		settings.width(width);
	},
	
	setResetGame: function(resetFunc)
	{
		this.onResetGame = resetFunc;
		gameDiv = $("#gameSettings");
		resetButton  =$("#resetButton");
		if ($("#resetButton").length==0)
		{
			
			resetButton = $("<button style='float:right'>Reset</button>");
			resetButton.height(gameDiv.height()*0.9);
			gameDiv.append(resetButton);
			var theGame = this;
			resetButton.click(function() {theGame.resetGame();});
		}
	},
	
	setClickFunction: function(clickFunc)
	{
		
		if (this.onCanvasClick!==null)
		{
			game.canvas.removeEventListener('click', this.onCanvasClick,false);
		}
		this.onCanvasClick = clickFunc;
		
		this.canvas.addEventListener('click', this.onCanvasClick,false);
		
	},
	startGameLoop: function()
	{
		this.ctx.clearRect ( 0 , 0 , this.canvas.width , this.canvas.height );
		if (!this.shouldGameStop)
		{
			if (this.doGameStep!==null)
			{
				this.doGameStep();
				
				var game = this;
				
				gameTimeout = window.setTimeout(function(){game.startGameLoop();}, game.interval);
			}
		}
		else
		{
			if(this.onEndGame!==null)
			{
				this.onEndGame();
			}
		}
	},
	startGame: function()
	{
		if (this.onStartGame!==null)
		{
			this.onStartGame();		
		}
	},
	resetGame: function()
	{
		this.shouldGameStop = false;
		clearTimeout(gameTimeout);
		if (this.onResetGame!=null)
		{
			this.onResetGame();		
		}
	},
	
	onClick: function()
	{
		console.log("on click with " +onCanvasClick );
		if (this.onCanvasClick!==null)
		{
			this.onCanvasClick();
		}
	}
});




