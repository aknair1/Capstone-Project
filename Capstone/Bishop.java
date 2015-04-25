
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
 * Bishop
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bishop extends Piece 
{
    // Parameters are equal to the instance variables of Piece
    public Bishop(int x, int y, boolean team,Board board) 
    {
        super(x,y,team,board);
    }

    // Calculates the list of legal moves based on a bishop's diagonal pattern
    public ArrayList<Move> getLegalMoves()
    {
        ArrayList<Move> moves = new ArrayList<Move>();
        for(int i = -1; i < 2; i+=2)
        {
            for(int j = -1; j < 2; j+=2)
            {
                boolean flag = true;
                int q = 1;
                while(flag && x+i*q >=0 && x+i*q <=7 && y+j*q >= 0 && y+j*q <= 7)
                {
                    int newX = x+i*q;
                    int newY = y+j*q;                                       
                    Location loc = new Location(newX, newY);
                    Piece piece = (Piece)grid.get(loc);
                    if(piece == null)
                    {
                        moves.add(new Move(x,y,newX,newY));
                    }
                    else
                    {                        
                        flag = false;
                        if(piece.getTeam() != team)
                        {
                            moves.add(new Move(x,y,newX,newY));
                        }
                    }
                    q++;
                }
            }            
        }  
            
        return moves;
    }

}
