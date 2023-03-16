//Zoi Kouvaka  4706

import java.util.Scanner;
class BlackjackTable
{
	private River river =new River(6);
	private CasinoCustomer[] customerArray={};
	private int numberOfPlayers=0;

	public BlackjackTable(int numberOfPlayers)
	{
		this.numberOfPlayers=numberOfPlayers;
		customerArray=new CasinoCustomer[numberOfPlayers]; 
		for(int i=0;i<numberOfPlayers;i++)
		{
			CasinoCustomer customer=this.createCasinoCustomer();
			customerArray[i]=customer;
		}
	}


	private CasinoCustomer createCasinoCustomer()
	{
		Scanner inputReader=new Scanner(System.in);
		System.out.print("Player's name: ");
		String name=inputReader.next();
		System.out.print("Player's budget: ");
		double budget=inputReader.nextDouble();
		CasinoCustomer customer=new CasinoCustomer(name,budget);
		return customer;
	}

	public void play()
	{
		if(river.shouldRestart())
		{
			river.restart();
		}
		Round newRound=new Round(river);
		int counter=0;
		for(CasinoCustomer customer:customerArray)
		{
			if (customer.canCover(1.00))
			{
				newRound.addPlayer(customer);
				counter++;
			}
		}
		if (counter!=0)
		{
			newRound.playRound();
			this.play();
		}
	}

}