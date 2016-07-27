package com.michaelmahon.baseball;

import java.util.*;

public class BattingCalculator
{
	Scanner scan = new Scanner(System.in);

	public void startCalculator()
	{
		Team baseballTeam = new Team();
		baseballTeam.addBatters();
		baseballTeam.printTeamResults();
	}

	public static void main(String[] args)
	{
		BattingCalculator batCalc = new BattingCalculator();
		batCalc.startCalculator();
	}
}
