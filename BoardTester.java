/*
* Used to test chessboard Class
*/
import java.util.Scanner;
import Chess.*;

class BoardTester
{
	public static void main(String args[])
		throws java.io.IOException
	{
		int width = 0;
		int height = 0;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Create a new chessboard!");
		System.out.print("Board width: ");
		width = in.nextInt();
		System.out.print("Board height: ");
		height = in.nextInt();
		System.out.println();
		
		Chessboard board = new Chessboard(width, height);
		
		System.out.println("Your chessboard has been created!");
		
		char selection;
		int xpos = 0;
		int ypos = 0;
		String piece = "";
		
		do
		{
			System.out.println("\nHere are the things you can do now.");
			System.out.println("\nEnter 1: Add a new chesspiece");
			System.out.println("Enter 2: Determine which piece is in a location");
			System.out.println("Enter 3: Determine if a space is occupied");
			System.out.println("Enter q: To quit");
			System.out.print("\nMake your selection: ");
			
			selection = (char) System.in.read();
			
			switch (selection)
			{
				case '1':
					System.out.println("\nOk, let's place a piece on the board!");
					System.out.println("Enter the position you'd like to place your piece.");
					System.out.print("Horizontal position: ");
					xpos = in.nextInt();
					in.nextLine();
					System.out.print("Vertical position: ");
					ypos = in.nextInt();
					in.nextLine();
					System.out.print("Name of piece: ");
					piece = in.nextLine();
					System.out.println();
					try
					{
						board.addPiece(piece, xpos, ypos);
					}
					catch (InvalidSpaceException e)
					{
					}
					break;
				case '2':
					System.out.println("\nEnter the position you'd like to check.");
					System.out.print("Horizontal position: ");
					xpos = in.nextInt();
					in.nextLine();
					System.out.print("Vertical position: ");
					ypos = in.nextInt();
					in.nextLine();
					piece = board.getPiece(xpos, ypos);
					System.out.println("The piece at that location is: " + piece);
					break;
				case '3':
					System.out.println("\nEnter the position you'd like to check.");
					System.out.print("Horizontal position: ");
					xpos = in.nextInt();
					in.nextLine();
					System.out.print("Vertical position: ");
					ypos = in.nextInt();
					in.nextLine();
					
					if (board.isValid(xpos, ypos))
						System.out.println("\nThat space is not occupied!");
					else
						System.out.println("\nThat space is occupied!");
					break;
			}
		} while (selection != 'q');
	}
}