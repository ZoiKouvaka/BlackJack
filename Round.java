import java.util.ArrayList;
import java.util.Scanner;
class Round
{
	private Dealer dealer=null;
	private ArrayList<Player> playerList=new ArrayList<Player>();
	private ArrayList<Player> settleList=new ArrayList<Player>();
	private boolean splitterIsOn=false;
	private boolean onePlayerLost=true;

	public Round(River river)
	{
		dealer=new Dealer(river);
	}

	public void addPlayer(CasinoCustomer customer)
	{
		Player player=new Player(customer);
		playerList.add(player);
	}

	public void playRound()
	{
	
		for (Player player:playerList)
		{
			player.placeBet();
			dealer.deal(player);
		}
		dealer.draw();
		System.out.println(dealer);
		for (Player player:playerList)
		{
			dealer.deal(player);
			System.out.println(player);
		}
		dealer.draw();
		if (dealer.getHand().isBlackJack())
		{
			for (Player player:playerList)
			{
				if(!(player.getHand().isBlackJack()))
				{
					player.loses();
				}
			}
		}
		else
		{
			for (Player player:playerList)
			{
				if (player.getHand().isBlackJack())
				{
					player.winsBlackJack();
				}
				else
				{
					System.out.println();
					System.out.println(player.getPlayer());
					this.playPlayer(player);
				}
			}
		}
		if(!onePlayerLost||splitterIsOn||settleList.size()!=0)
		{
			dealer.play();
			System.out.println(dealer);
			splitterIsOn=false;
			for (Player player:settleList)
			{
				dealer.settle(player);
			}
		}
	}


	private void playNormalHand(Player player)
	{
		while(true)
		{
			System.out.println("Hit? ");
			Scanner inputReader=new Scanner(System.in);
			String toHitOrNotToHit=inputReader.next();
			if (toHitOrNotToHit.equals("y"))
			{
				dealer.deal(player);
				System.out.println(player);
				if(player.getHand().isBust())
				{
					break;
				}
			}
			else
			{
				break;
			}
		}
		if(!player.getHand().isBust())
		{
			settleList.add(player);
		}
		else
		{
			player.loses();
			if(this.onePlayerMode())
			{
				onePlayerLost=true;
			}
		}
	}

	private void playDoubleHand(Player player)
	{
		player.doubleBet();
		dealer.deal(player);
		System.out.println(player);
		if(!player.getHand().isBust())
		{
			settleList.add(player);
		}
		else
		{
			player.loses();
		}
	}

	private void playSplitHand(Player player)
	{
			Hand[] handArray=player.getHand().split();
			//player.doubleBet();
			Hand hand1=handArray[0];
			Hand hand2=handArray[1];
			Player player1=new Player(player.getPlayer(),hand1,player.getBet());
			Player player2=new Player(player.getPlayer(),hand2,player.getBet());
			//playerlist.remove(player);
			//playerlist.addPlayer(player1);
			//playerlist.addPlayer(player2);
			splitterIsOn=true;
			this.playNormalHand(player1);
			this.playNormalHand(player2);

	}

	private void playPlayer(Player player)
	{
		if (player.wantsToSplit())
		{
			this.playSplitHand(player);
		}
		else if(player.wantsToDouble())
		{
			this.playDoubleHand(player);
		}
		else
		{
			this.playNormalHand(player);
		}
	}

	private boolean onePlayerMode()
	{
		if(playerList.size()==1)
		{
			onePlayerLost=false;
			return true;
		}
		return false;
	}

	public static void main(String[] args)
	{
		River river=new River(6);
		Round round=new Round(river);
		CasinoCustomer customer=new CasinoCustomer("Zoi Kouvaka",100.00);
		round.addPlayer(customer);
		round.playRound();
	}
}