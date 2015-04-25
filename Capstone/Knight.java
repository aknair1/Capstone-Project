import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;

/**
 * Knight
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knight extends Piece 
{

    // Parameters are equal to the instance variables of Piece
    public Knight(int x, int y, boolean team,Board board) 
    {
        super(x,y,team,board);
    }
    // Calculates the list of legal moves based on a standard Knight's L-shape
    public ArrayList<Move> getLegalMoves()
    {
        ArrayList<Move> moves = new ArrayList<Move>();
        for(int i = -1; i < 2; i+=2)
        {
            for(int j = -1; j < 2; j+=2)
            {
                int newX = x + i*2;
                int newY = y + j*1;

                if(newX >= 0 && newX< 8 && newY >= 0 && newY < 8 )
                {
                    Location loc = new Location(newX, newY);
                    Piece piece = (Piece)grid.get(loc);
                    if(piece == null || (piece.getTeam() != team))
                    {
                        moves.add(new Move(x,y,newX,newY));
                    }
                }
                int newX2 = x + i*1;
                int newY2 = y + j*2;

                if(newX2 >= 0 && newX2< 8 && newY2 >= 0 && newY2 < 8 )
                {
                    Location loc = new Location(newX2, newY2);
                    Piece piece = (Piece)grid.get(loc);
                    if(piece == null || (team != piece.getTeam()))
                    {
                        moves.add(new Move(x,y,newX2,newY2));
                    }
                }
            }
        }
        return moves;
    }
   

}
