//Zoi Kouvaka  4706

import java.util.Random;
class River
{
	private int decks=0;
	private Card[] river={};
	//private String[] deckArray={"2","3","4","5","6","7","8","9","10","J","Q","K","A","2","3","4","5","6","7","8","9","10","J","Q","K","A","2","3","4","5","6","7","8","9","10","J","Q","K","A","2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	private int cardsLeft=0;
	private int numberOfCards=0;
	private String[] deckArray={"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	public River(int decks)
	{
		this.decks=decks;
		river=new Card[decks*52];
		//for(int i=0;i<decks;i++)
		//{
		//	for(int j=0;j<deckArray.length;j++)
		//	{
		//		river[j+i*52]=new Card(deckArray[j]);
		//	}
		//}
		for(int i=0;i<decks*4;i++)
		{
			for(int j=0;j<deckArray.length;j++)
			{
				river[j+i*13]=new Card(deckArray[j]);
			}
		}
		cardsLeft=decks*52;
		numberOfCards=decks*52;
	}

	public Card nextCard()
	{
		if (cardsLeft==0)
		{
			return null;
		}
		Random randomReader=new Random();
		Card card=null;
		if (cardsLeft-1>0)
		{
			int cardPosition=randomReader.nextInt((cardsLeft-1));
			card=river[cardPosition];
			Card helperSwap=river[cardsLeft-1];
			river[cardsLeft-1]=card;
			river[cardPosition]=helperSwap;
			cardsLeft--;
		}
		else
		{
			card=river[cardsLeft-1];
			cardsLeft--;
		}
		return card;
	}


	public boolean shouldRestart()
	{
		if(cardsLeft<0.25*numberOfCards)
		{
			return true;
		}
		return false;
	}

	public void restart()
	{
		cardsLeft=numberOfCards;
	}

	//public void printR()
	//{
	//	for(Card element:river)
	//	{
	//		System.out.println(element);
	//		System.out.println(numberOfCards);
	//	}
	//}

	public void mainHelper()//necessary only for my tester-main which calls method nextCard() twice and cardsLeft must be balanced.
	{
		cardsLeft++;
	}

	public static void main(String[] args)
	{
		River riverTest=new River(1);
		while(!riverTest.shouldRestart())
		{
			System.out.println(riverTest.nextCard());
		}

		System.out.println("---------------------------------------------------");
		riverTest.restart();
		while(riverTest.nextCard()!=null)
		{
			riverTest.mainHelper();
			System.out.println(riverTest.nextCard());
		}
		//System.out.println("?????????????????????????????????");	
	}
}



