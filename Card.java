//Zoi Kouvaka  4706

class Card
{
	private String figure="";
	private int value=0;

	public Card(String figure)
	{
		this.figure=figure;
		if(figure.equals("J")||figure.equals("Q")||figure.equals("K"))
		{
			value=10;
		}
		else if(figure.equals("A"))
		{
			value=1;
		}
		else
		{
			value=Integer.valueOf(figure);
		}
	}

	public int getValue()
	{
		return value;
	}

	public boolean isAce()
	{
		if(figure.equals("A"))
		{
			return true;
		}
		return false;
	}

	public boolean equals(Card other)
	{
		if ((this.figure).equals(other.figure))
		{
			return true;
		}
		return false;
	}

	public String toString()
	{
		return figure;
	}

}