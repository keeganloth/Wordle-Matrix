import java.util.Scanner;



public class Wordle

{
	public static final String RESET  = "\u001B[0m";
	public static final String GREEN  = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String GRAY   = "\u001B[90m";
	static String[] letters = {" ", " ", " ", " ", " "};
	static String wordOfDay = "";
	static boolean keepPlaying = true;
	static String [][] board = {{" "," "," "," "," "}, {" "," "," "," "," "}, {" "," "," "," "," "},{" "," "," "," "," "}, {" "," "," "," "," "}, {" "," "," "," "," "}};
	static int track = 0;
	public static void main(String[] args)
		{

			System.out.println();
			randomWord();
			System.out.println("Enter your first word");
			//System.out.println(wordOfDay);
			while (keepPlaying = true)
				{
					wordIntoArray(); 
					displayBoard();
					track ++;
					lookForWin();
				}
		}
	private static void lookForWin() {
		String currentGuess = String.join("", letters);
		if(currentGuess.equalsIgnoreCase(wordOfDay))
			{
				System.out.println("Congrats you won in " + track + " tries!");
				keepPlaying = false;
			}
		else if(track == 6)
			{
				System.out.println("You lost the word was " + wordOfDay);
				keepPlaying = false;
			}
	}
	private static void wordIntoArray()
	
	{
		String guess = askForWord();
		letters = guess.split("");
		String[] answer = wordOfDay.split("");
	    for (int i = 0; i < letters.length; i++) 
	        {
	        	String currentLetter = letters[i];
	            if (currentLetter.equalsIgnoreCase(answer[i]))
	            	{
	            		board[track][i] = GREEN + currentLetter.toUpperCase() + RESET;
	            	} 
	           else if (wordOfDay.toLowerCase().contains(currentLetter.toLowerCase())) 
	        	   {
	        		   board[track][i] = YELLOW + currentLetter.toUpperCase() + RESET;
	        	   }
	           else 
	        	   {
	        		   board[track][i] = GRAY + currentLetter.toUpperCase() + RESET;
	        	   }
	        }
	}
	private static String askForWord()
		{
			Scanner userStringInput= new Scanner(System.in);
			String guess = userStringInput.nextLine();
			return guess;
		}
	
	private static void randomWord()
		{
			int randNum = (int)(Math.random()*WordBank.list.length);
			wordOfDay = WordBank.list[randNum];
		}
	private static void displayBoard()
		{
			System.out.println(" ---   ---   ---   ---   ---");
			System.out.println("| " + board[0][0] + " | | "+ board[0][1] +" | | "+ board[0][2] +" | | "+ board[0][3] +" | | "+ board[0][4] +" | ");
			System.out.println(" ---   ---   ---   ---   ---");
			System.out.println("| " + board[1][0] + " | | "+ board[1][1] +" | | "+ board[1][2] +" | | "+ board[1][3] +" | | "+ board[1][4] +" | ");
			System.out.println(" ---   ---   ---   ---   ---");
			System.out.println("| " + board[2][0] + " | | "+ board[2][1] +" | | "+ board[2][2] +" | | "+ board[2][3] +" | | "+ board[2][4] +" | ");
			System.out.println(" ---   ---   ---   ---   ---");
			System.out.println("| " + board[3][0] + " | | "+ board[3][1] +" | | "+ board[3][2] +" | | "+ board[3][3] +" | | "+ board[3][4] +" | ");
			System.out.println(" ---   ---   ---   ---   ---");
			System.out.println("| " + board[4][0] + " | | "+ board[4][1] +" | | "+ board[4][2] +" | | "+ board[4][3] +" | | "+ board[4][4] +" | ");
			System.out.println(" ---   ---   ---   ---   ---");
			System.out.println("| " + board[5][0] + " | | "+ board[5][1] +" | | "+ board[5][2] +" | | "+ board[5][3] +" | | "+ board[5][4] +" | ");
			System.out.println(" ---   ---   ---   ---   ---");
		}

}