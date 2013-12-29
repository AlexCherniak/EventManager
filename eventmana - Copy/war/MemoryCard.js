var backOfCard = "images/card_back.jpg";

var onImageLoad = function(ctx, x,y, img)
{
	width = imageWidth;//theCard.img.width;
	height = imageHeight;//card.img.height;
	ctx.drawImage(img, x , y,width,height);
	ctx.beginPath();
	ctx.rect(x, y, width, height);
	ctx.stroke();
	
};
var Card = Class.create({

	  init: function(cardImage, context, startX, startY, directionX, directionY) {
			this.shouldShow = false;
			this.directionX = directionX;
			this.directionY = directionY;
			this.ctx = context;
			this.cardPicture = cardImage;
			//var name = cardID;
			this.positionX = startX;
			this.positionY = startY;
			this.width = imageWidth;
			this.height = imageHeight;
			this.img = document.createElement('img');//new image();
			var x = this.positionX;
			var y = this.positionY;
			var ctx = this.ctx;
			this.img.onload = function() { onImageLoad(ctx,x,y,this);};
//			this.img.src = backOfCard;
			this.clickEvent = null;
		  },
		isInImage:function (x,y)
		{
			if (x > this.positionX && x < this.positionX+this.width &&
					y > this.positionY && y<this.positionY+this.height) return true;
			return false;
		},
		onClick: function()
		{
			
			if (this.shouldShow)
			{
				
				this.img.src = backOfCard;
				this.shouldShow = false;

			}
			else
			{
				this.img.src = "images/" + this.cardPicture;
				this.shouldShow = true;
				if (this.clickEvent !== null)
					this.clickEvent(this.pairContainer);
			}	
			
		},
		
		redraw: function()
		{
			//console.log("in redraw with " + this.img.src);
			if(this.img.src==="")
			{
				//default draw
				//console.log("drawing default in context " + this.ctx + " for card " + this.cardPicture + " at " + this.positionX + "," + this.positionY);
				this.img.src = backOfCard;
			}
			else
			{
				if (this.img.onload !== null)
					this.img.onload = null;
				onImageLoad(this.ctx,this.positionX,this.positionY,this.img);
			}
		},
		
		removeCard: function()
		{
			//for now do nothing
			//console.log("show be removed");

		},
		
		setEvent: function(func, twoCards)
		{
			this.clickEvent = func;
			this.pairContainer = twoCards;
		},
		move: function(boundX, boundY)
		{
			this.positionX += this.directionX;
			this.positionY += this.directionY;
			this.positionX = this.setToBound(boundX, this.positionX, this.width);
			this.positionY = this.setToBound(boundY, this.positionY, this.height);
			if (this.isInBound(boundY, this.positionY, this.height))
				this.directionY *=-1;
			if (this.isInBound(boundX, this.positionX, this.width))
				this.directionX *=-1;	
		},
		
		setToBound: function(bound, pos, size)
		{
			if (pos < 0)
				return 0;
			if (pos+size > bound)
				return bound - size;
			return pos;
		},
		isInBound: function(bound, pos, size)
		{
			return (pos==0 || pos+size==bound);
		}
		  

});
