package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class findDisjoint {
	
	static ArrayList<Integer[]> cardList = new ArrayList<Integer[]>();	
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter full file name(with extensions) : ");
		String fileName = in.nextLine();
		parse(fileName);
	}

	/*
	 * This method takes in a text file of cards
	 * and returns an array of card arrays
	 */
	public static void parse(String name){
		File file = new File(name);
		BufferedReader reader = null;
		int count = 0;
		try {
			reader = new BufferedReader(new FileReader(file));
			count = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (int i = 1; i <= count; i++){
			String line = null;
			try {
				line = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cardList.add(convert(line));
		}

	}

	/*
	 * This converts a given string into an array 
	 * of length 4. The first position corresponds to the color,
	 * the second to the symbol, the third to the shading,
	 * and the fourth to the number of symbols.
	 */
	public static Integer[] convert(String raw){
		Integer[] out = new Integer[4];
		String[] split = raw.split("\\s+");


		/*
		 * Convert the color to an int value
		 * and store in a card array.
		 */
		if (split[0].equals("yellow")){
			out[0] = 1;
		} else if (split[0].equals("blue")){
			out[0] = 2;
		} else {
			out[0] = 3;
		}

		/*
		 * Get the symbol and convert it to an int value
		 * and store it in card array position 1 and get
		 * the shading and convert it to an int and store in
		 * position 2
		 */

		if (split[1].substring(0, 1).equalsIgnoreCase("a") || split[1].substring(0, 1).equals("@")){
			out[1] = 1;
			if (split[1].substring(0, 1).equals("a")){
				out[2] = 1; 				
			} else if (split[1].substring(0, 1).equals("A")){
				out[2] = 2;
			} else {
				out[2] = 3;
			}
		} else if (split[1].substring(0, 1).equalsIgnoreCase("s") || split[1].substring(0, 1).equals("$")){
			out[1] = 2;
			if (split[1].substring(0, 1).equals("s")){
				out[2] = 1; 				
			} else if (split[1].substring(0, 1).equals("S")){
				out[2] = 2;
			} else {
				out[2] = 3;
			}
		} else {
			out[1] = 3;
			if (split[1].substring(0, 1).equals("h")){
				out[2] = 1; 				
			} else if (split[1].substring(0, 1).equals("H")){
				out[2] = 2;
			} else {
				out[2] = 3;
			}
		}
		
		out[3] = split[1].length();
//		System.out.println(out[0] + "," + out[1] + "," + out[2] + "," +out[3]);
		return out;
	}
	
	/*
	 * Check if 2 cards are the same, i.e. have the same color,
	 * symbol, shading and number.
	 */
	public static boolean sameCard(Integer[] card1, Integer[] card2){
		return Arrays.equals(card1, card2);		
	}

	/*
	 * Check if 3 cards are the same in all attributes,
	 * and thus make a set
	 */
	public static boolean sameCard(Integer[] card1, Integer[] card2, Integer[] card3){
		return Arrays.equals(card1, card2) && Arrays.equals(card2, card3);		
	}
}
