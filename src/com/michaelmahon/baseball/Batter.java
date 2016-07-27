package com.michaelmahon.baseball;

import java.util.*;

public class Batter
{

	Scanner scan = new Scanner(System.in);
	private float atBats;
	private float battingAvg;
	private float slugPrct;
	
	public Batter()
	{
		
	}
	
	private Batter(float atBats, float battingAvg, float slugPrct)
	{
		this.atBats = atBats;
		this.battingAvg = battingAvg;
		this.slugPrct = slugPrct;
	}
	
	//calculate the batting average and slugging percentage
	public Batter calculateStats()
	{
		float atBats = getAtBats();
		float atLeastOneBase = 0;
		float totalBases = 0;
		float battingAvg = 0.0f;
		float sluggingPrct = 0.0f;
		ArrayList<BattingRecord> records = new ArrayList<>();

		//make a batting record for each at bat
		for (int i = 0; i < atBats; i++)
		{
			BattingRecord record = buildNewRecord(i);
			
			if (record.bases > 0)
				atLeastOneBase++;

			totalBases += record.bases;
			
			records.add(record);
		}

		battingAvg = atLeastOneBase / atBats;
		sluggingPrct = totalBases / atBats;

		System.out.format("Your batting average is %.3f\n", battingAvg);
		System.out.format("Your slugging percentage is %.3f\n", sluggingPrct);
		
		return new Batter(atBats, battingAvg, sluggingPrct);

	}
	
	//get the number of at bats the user wants to input
	public int getAtBats()
	{
		int atBatInput = 0;

		//get the at bats you want to calculate for and make sure it is a valid number
		do
		{
			System.out.println("Enter the total at bats you would like to calculate");
			try{
				atBatInput = Integer.parseInt(scan.next());
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid input! Try again");
			}

		} while (atBatInput <= 0);

		return atBatInput;
	}
	
	public BattingRecord buildNewRecord(int atBatNum)
	{
		int basesInput = -1;

		do
		{
			System.out.format("Enter the number of bases earned for at bat %d\n", atBatNum + 1);
			
			try{
				basesInput = Integer.parseInt(scan.next());
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid input! Try again.");
			}

		} while (!BattingRecord.recordIsValid(basesInput));

		return new BattingRecord(basesInput);
	}

	public float getBattingAvg()
	{
		return battingAvg;
	}

	public float getSlugPrct()
	{
		return slugPrct;
	}
}
