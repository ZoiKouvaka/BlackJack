//Zoi Kouvaka  4706

class Dealer
{
	private River river=null;
	private Hand handOfDealer=new Hand();

	public Dealer(River river)
	{
		this.river=river;
	}

	public Hand getHand()
	{
		return handOfDealer;
	}

	public void draw()
	{
		handOfDealer.addCard(river.nextCard());
	}

	public void deal(Player player)
	{
		player.getHand().addCard(river.nextCard());
	}

	public void play()
	{
		//while(handOfDealer.getScore()<17)
		while(handOfDealer.score()<17)
		{
			this.draw();
		}
	}

	public void settle(Player player)
	{
		if((!handOfDealer.isBust())&&(!player.getHand().isBust()))
		{
			//if (handOfDealer.getScore()>player.getHand().getScore())
			if (handOfDealer.score()>player.getHand().score())
			{
				player.loses();
			}
			//else if (handOfDealer.getScore()<player.getHand().getScore())
			else if (handOfDealer.score()<player.getHand().score())
			{
				player.wins();
			}
			else
			{
				System.out.println("Tie with: "+player);
			}
		}
		else if(handOfDealer.isBust())
		{
			player.wins();
		}
	}

	public String toString()
	{
		return "Dealer: "+handOfDealer;
	}

	public static void main(String[] args) 
	{
		River river=new River(1);
		Dealer dealer=new Dealer(river);
		Player player=new Player(new CasinoCustomer("Zoi Kouvaka",100));
		dealer.deal(player);
		dealer.deal(player);
		System.out.println(player);
		dealer.draw();
		dealer.draw();
		dealer.play();
		System.out.println(dealer);
		System.out.println(dealer.getHand().score());////////
		System.out.println(player.getHand().score());////////
		dealer.settle(player);

	}
}