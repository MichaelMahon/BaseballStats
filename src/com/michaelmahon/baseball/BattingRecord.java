package com.michaelmahon.baseball;

public class BattingRecord
{

	int bases;
	
	public BattingRecord(int bases)
	{
		this.bases = bases;
	}
	
	public static boolean recordIsValid(int bases)
	{
		switch(bases)
		{
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
			return true;
		default:
			System.out.println("Enter a base number (1-4).");
			return false;
		}
	}
}
