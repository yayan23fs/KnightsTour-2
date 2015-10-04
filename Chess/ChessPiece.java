/*
* Provide Base Class for all Chess pieces.
*/

package Chess;
import java.util.*;

abstract public class ChessPiece
{
	protected Chessboard registeredBoard;
	protected CBPosition currentPosition;
	protected int color;
	protected ArrayList<CBPosition> validMoves;
	
	abstract public boolean tryMove(CBPosition nextPosition);
	abstract public boolean tryMove(int xpos, int ypos);
	abstract public CBPosition getPos();
	abstract public ArrayList<CBPosition> getValidMoves();
	abstract protected void registerBoard(Chessboard board, int rank, int file) throws InvalidSpaceException;
}