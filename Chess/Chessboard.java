/*
*	Provide Representation of Chessboard
*	as a collection of Spaces.
*/

package Chess;

public class Chessboard
{
	class Space
	{
		CBPosition position;
		boolean occupied;
		String piece;
		int color;
		
		Space(int rank, int file)
		{
			position = new CBPosition(rank, file);
			occupied = false;
			piece = "";
			color = 0;
		}
	}
	
	private int width;
	private int height;
	private Space[][] position;
	
	public Chessboard(int numRanks, int numFiles)
	{
		width = numFiles;
		height = numRanks;
		
		position = new Space[height][width];
		newBoard();
	}
	
	private void newBoard()
	{
		for (int x = 0; x < height; x++)
			for (int y = 0; y < width; y++)
			{
				position[x][y] = new Space(x, y);
			}
	}
	
	public void clearBoard()
	{
		for (int x = 0; x < height; x++)
			for (int y = 0; y < width; y++)
			{
				position[x][y].occupied = false;
				position[x][y].piece = "";
			}
	}
	
	public boolean isValid(int rank, int file)
	{
		if (position[rank - 1][file - 1].occupied)
			return false;
		else
			return true;
	}
	
	public boolean isValid(CBPosition position)
	{
		return isValid(position.rank, position.file);
	}
	
	public void addPiece(String piece, int rank, int file) throws InvalidSpaceException
	{
		if (isValid(rank, file))
		{
			System.out.println("Space is unoccupied.  Adding piece...");
			position[rank - 1][file - 1].occupied = true;
			position[rank - 1][file - 1].piece = piece;
		}
		else
			throw new InvalidSpaceException();
	}
	
	public void addPiece(String piece, CBPosition position) throws InvalidSpaceException
	{
		addPiece(piece, position.rank, position.file);
	}
	
	public String getPiece(int rank, int file)
	{
		if (!isValid(rank, file))
			return position[rank - 1][file - 1].piece;
		else
		{
			return "Empty";
		}
	}
	
	public String getPiece(CBPosition position)
	{
		return getPiece(position.rank, position.file);
	}
}