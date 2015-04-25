
import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
/**
 * King
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class King extends Piece
{
    // Parameters are equal to the instance variables of Piece
    public King(int x, int y, boolean team,Board board) 
    {
        super(x,y,team,board);
    }
    // Calculates the list of legal moves based on a standard one in any direction patern
    public ArrayList<Move> getLegalMoves()
    {
        ArrayList<Move> moves = new ArrayList<Move>();
        for(int i = -1; i < 2; i++)
        {
            for(int j = -1; j < 2; j++)
            {
                int newX = x + i;
                int newY = y + j;
                if(newX >= 0 && newX <= 7 && newY>=0 && newY<=7 && (i!=0 || j!=0))
                {                 

                    Location loc = new Location(newX, newY);
                    Piece piece = (Piece)grid.get(loc);
                    if(piece == null || (piece.getTeam() != team))
                    {
                        moves.add(new Move(x,y,newX,newY));
                    }

                }
            }            
        }  
        return moves;
    }

    
}
