//Zoi Kouvaka  4706

import java.util.Scanner;
class Player
{
	private CasinoCustomer player=null;
	private Hand hand=new Hand();
	private double bet=0.00;
	private Scanner inputReader=new Scanner(System.in);

	public Player(CasinoCustomer player)
	{
		this.player=player;
	}

	public Player(CasinoCustomer player,Hand hand,double bet)
	{
		this.player=player;
		this.hand=hand;
		this.bet=bet;
	}

	public CasinoCustomer getPlayer()
	{
		return player;
	}

	public Hand getHand()
	{
		return hand;
	}

	public double getBet()
	{
		return bet;
	}

	public void wins()
	{
		System.out.println(player+" wins and collects "+bet);
		player.collectBet(bet);
	}

	public void winsBlackJack()
	{
			System.out.println(player+" wins isBlackJack and collects "+ 1.5*bet);
			player.collectBet(1.5*bet);
	}

	public void loses()
	{
		System.out.println(player+" lost and pays "+bet);
		player.payBet(bet);
	}

	public void placeBet()
	{
		player.printState();
		double putBet=0.00;
		do
		{
			System.out.println("Please put an accepted bet: ");
			putBet=inputReader.nextDouble();
		}
		while((!(player.canCover(putBet)))||(putBet<1.00));
		bet=putBet;
	}
	
	public void doubleBet()
	{
		bet*=2;
	}

	public boolean wantsToDouble()
	{
		if(player.canCover(2*bet))
		{
			System.out.println("Do you wanna double? ");
			String decision=inputReader.next();
			if (decision.equals("y"))
			{
				return true;
			}
		}
		return false;
	}

	public boolean wantsToSplit()
	{
		if(player.canCover(2*bet)&&hand.canSplit())
		{
			System.out.println("Do you wanna split? ");
			String decision=inputReader.next();
			if (decision.equals("y"))
			{
				return true;
			}
		} 
		return false;
	}

	public String toString()
	{
		return player+" : "+hand;
	}

	public static void main(String[] args)
	{
		CasinoCustomer customer=new CasinoCustomer("Zoi Kouvaka",50.00);
		Player player=new Player(customer);
		player.placeBet();
		player.getPlayer().printState();
		player.wantsToSplit();
		player.getPlayer().printState();
		player.wantsToDouble();
		player.getPlayer().printState();
		player.wins();
		player.getPlayer().printState();
		player.winsBlackJack();
		player.getPlayer().printState();
		player.loses();
		player.getPlayer().printState();
	}
}