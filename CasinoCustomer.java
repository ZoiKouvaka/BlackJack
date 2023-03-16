//Zoi Kouvaka  4706

class CasinoCustomer
{
	private String name="";
	private double budget=0.00;
	
	public CasinoCustomer(String name,double budget)
	{
		this.name=name;
		this.budget=budget;
	}

	public void payBet(double lostBet)
	{
		budget-=lostBet;
	}

	public void collectBet(double wonBet)
	{
		budget+=wonBet;
	}

	public boolean canCover(double wannaBet)
	{
		if(budget>=wannaBet)
		{
			return true;
		}
		return false;
	}

	public boolean isBroke()
	{
		if(budget<=1.00)
		{
			return true;
		}
		return false;
	}

	public String toString()
	{
		return name;
	}

	public void printState()
	{
		System.out.println(name+": "+budget);

	}

	public double getBudget()
	{
		return budget;
	}


}
