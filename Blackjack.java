//Zoi Kouvaka  4706

import java.util.Scanner;
class Blackjack
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to blackjack!\nPlease write 'y' for your positive answers and 'n' for your negavite ones.\nGood luck!");
		System.out.print("How many players will play?  ");
		Scanner inputReader=new Scanner(System.in);
		int numberOfPlayers=inputReader.nextInt();
		BlackjackTable blackjackTable=new BlackjackTable(numberOfPlayers);
		blackjackTable.play();
	}
}