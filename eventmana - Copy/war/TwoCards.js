
//var cardScriptPath = "MemoryCard.js";

scriptsToLoad.splice(0, 0, "MemoryCard.js");
loadNext();


var TwoCards = Class.create({
	init: function(cardImage1,cardImage2, startX, startY, direction1X, direction1Y, startX2, startY2, direction2X, direction2Y,context)
	{
		//console.log(cardImage1 + " " + context + " " + startX + " " + startY + " " + direction1X + " " + direction1Y);
		this.card1 = new Card(cardImage1, context,startX,startY,direction1X,direction1Y);
		this.card2 = new Card(cardImage2, context,startX2,startY2,direction2X,direction2Y);
		
		this.cardsRemoved = null;
		this.card1.setEvent(this.removeCards,this);
		this.card2.setEvent(this.removeCards,this);
	},
	removeCards: function(twoCards)
	{
		if(twoCards.card1.shouldShow && twoCards.card2.shouldShow)
		{
			twoCards.card1.removeCard();
			twoCards.card2.removeCard();
			if (twoCards.cardsRemoved !== null)
				twoCards.cardsRemoved(twoCards);
		}

	}
	
});