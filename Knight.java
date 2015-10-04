/*
* Specifies the attributes and behavior or a Knight Chess Piece
*/

import Chess.*;
import java.util.*;

public class Knight extends ChessPiece
{
	// Constructor
	public Knight(Chessboard board, int rank, int file, int color) throws InvalidSpaceException
	{
		registerBoard(board, rank, file);
		currentPosition.rank = rank;
		currentPosition.file = file;
		this.color = color;
		validMoves = new ArrayList<CBPosition>();
	}
	
	// Constructor
	public Knight(Chessboard board, int rank, int file) throws InvalidSpaceException
	{
		this(board, rank, file, 0);
	}
	
	// Constructor
	public Knight(Chessboard board, CBPosition pos, int color) throws InvalidSpaceException
	{
		this(board, pos.rank, pos.file, color);
	}
	
	// Constructor
	public Knight(Chessboard board, CBPosition pos) throws InvalidSpaceException
	{
		this(board, pos.rank, pos.file);
	}
	
	// Determines all valid moves based on the Knight's current position and stores
	// them in validMoves Arraylist.
	private void generateValidMoves()
	{
		// Generate possible moves based on Knight movement rules
		CBPosition [] possibleMoves = new CBPosition[8];
		possibleMoves[0] = new CBPosition(currentPosition.rank + 2, currentPosition.file + 1);
		possibleMoves[1] = new CBPosition(currentPosition.rank + 2, currentPosition.file - 1);
		possibleMoves[2] = new CBPosition(currentPosition.rank - 2, currentPosition.file + 1);
		possibleMoves[3] = new CBPosition(currentPosition.rank - 2, currentPosition.file - 1);
		possibleMoves[4] = new CBPosition(currentPosition.rank + 1, currentPosition.file + 2);
		possibleMoves[5] = new CBPosition(currentPosition.rank + 1, currentPosition.file - 2);
		possibleMoves[6] = new CBPosition(currentPosition.rank - 1, currentPosition.file + 2);
		possibleMoves[7] = new CBPosition(currentPosition.rank - 1, currentPosition.file - 2);
		
		// Check with the registered board if possible moves are valid moves
		for (int i = 0; i < 8; i++)
		{
			if (registeredBoard.isValid(possibleMoves[i]))
				validMoves.add(possibleMoves[i]);
		}
	}
	
	// Registers a board, then generates valid moves based on the initial position
	// Throws an InvalidSpaceException if the initial placement of the piece is invalid
	public void registerBoard(Chessboard board, int rank, int file) throws InvalidSpaceException
	{
		if (!board.isValid(rank, file))
			throw new InvalidSpaceException();
		
		registeredBoard = board;
		generateValidMoves();
	}
	
	public boolean tryMove(CBPosition nextPosition)
	{
		return true;
	}
	
	public boolean tryMove(int file, int rank)
	{
		return true;
	}
	
	public CBPosition getPos()
	{
		return currentPosition;
	}
	
	public ArrayList<CBPosition> getValidMoves()
	{
		return validMoves;
	}
}