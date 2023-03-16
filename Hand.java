//Zoi Kouvaka  4706

import java.util.ArrayList;
class Hand
{
	private ArrayList<Card> hand=new ArrayList<Card>();
	private int sum=0;
	private boolean has11Ace=false;
	public void addCard(Card card)
	{
		hand.add(card);
		sum+=card.getValue();
	}

	public int score()
	{
		for(Card element:hand)
		{
			if ((element.isAce())&&(sum+10<=21))
			{
				sum+=10;
				has11Ace=true;
				break;
			}
		}
		if (sum>21&&(has11Ace==true))
		{
			sum-=10;
			has11Ace=false;
		}
		return sum;
	}

	public boolean canSplit()
	{
		if (hand.size()==2&&(hand.get(0).equals(hand.get(1))))
		{
			return true;
		}
		return false;
	}

	public Hand[] split()
	{
		if (this.canSplit())
		{
			Hand[] handsSeparated=new Hand[2];
			handsSeparated[0]=new Hand();
			handsSeparated[1]=new Hand();
			handsSeparated[0].addCard(hand.get(0));
			handsSeparated[1].addCard(hand.get(0));
			return handsSeparated;
		}
		return null;
	}

	public boolean isBlackJack()
	{
		if (hand.size()==2&&(this.score()==21))
		{
			return true;
		}
		return false;
	}

	public boolean isBust()
	{
		//this.score();//////////
		if (sum>21)
		{
			return true;
		}
		return false;
	}

	public String toString()
	{
		String helper="";
		for(Card element:hand)
		{
			helper+=(element.toString()+" ");
		}
		return helper;
	}

	//public int getScore()
	//{
	//	return sum;
	//}

	public static void main(String[] args)
	{
		Hand handTester=new Hand();
		handTester.addCard(new Card("A"));
		handTester.addCard(new Card("A"));
		System.out.println(handTester);
		//System.out.println(""+handTester.getScore());
		System.out.println(""+handTester.canSplit());
		Hand[] handsDouble=handTester.split();
		System.out.println("1st "+handsDouble[0].toString());
		//System.out.println(""+handsDouble[0].getScore());
		System.out.println(handsDouble[0].score());
		System.out.println("2nd "+handsDouble[1].toString());
		//System.out.println(""+handsDouble[1].getScore());
		System.out.println(handsDouble[1].score());
		handsDouble[0].addCard(new Card("K"));
		System.out.println("1st "+handsDouble[0].toString());
		//System.out.println(""+handsDouble[0].getScore());
		System.out.println(handsDouble[0].score());
		handsDouble[0].addCard(new Card("A"));
		System.out.println("1st "+handsDouble[0].toString());
		//System.out.println(""+handsDouble[0].getScore());
		System.out.println(handsDouble[0].score());
		handsDouble[0].addCard(new Card("10"));
		System.out.println("1st "+handsDouble[0].toString());
		//System.out.println(""+handsDouble[0].getScore());
		System.out.println(handsDouble[0].score());
		System.out.println(""+handsDouble[0].isBust());		
		Hand second=new Hand();
		second.addCard(new Card ("10"));//
		second.addCard(new Card("A"));//
		//second.addCard(new Card ("9"));//
		//System.out.println(""+second.getScore());//
		System.out.println(second.score());
		System.out.println(""+second.isBust());	//
		System.out.println(second.isBlackJack());

	}
}
