package com.michaelmahon.baseball;

import java.util.*;

public class Team
{

	ArrayList<Batter> team = new ArrayList<>();
	Scanner scan = new Scanner(System.in);

	public Team()
	{
	}
	
	//add a batter to the team
	public void addBatters()
	{	
		do
		{
			team.add(new Batter().calculateStats());

			System.out.println("\nCalculate another batters average? <y/n>");

		} while (scan.next().equalsIgnoreCase("Y"));
	}
	
	//print the batting avg and slugging percentage of all batters on the team
	public void printTeamResults()
	{
		int currentPlayer = 1;
		
		for(Batter batter : team)
		{
			System.out.format("Player %d's batting average is %.3f and slugging percentage is %.3f\n", currentPlayer, batter.getBattingAvg(), batter.getSlugPrct());
			currentPlayer++;
		}
	}
}
