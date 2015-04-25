import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.awt.Color;

/**
 * Pawn
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pawn extends Piece 
{
    // Parameters are equal to the instance variables of Piece
    public Pawn(int x, int y, boolean team,Board board) 
    {
        super(x,y,team,board);
        if(team)
        {
            this.setColor(Color.BLUE);
        }
    }

    // Calculates the list of legal moves based on a pawn's move forward but take diagonal pattern(Can also move two forward if the pawn is still in it's starting location)
    public ArrayList<Move> getLegalMoves()
    {
        ArrayList<Move> moves = new ArrayList<Move>();
        if(team)
        {
            if(x-1 >= 0 && grid.get(new Location(x-1,y)) == null)
            {
                moves.add(new Move(x,y,x-1,y));
                if(x==6 && (grid.get(new Location(x-2,y)) == null))
                {
                    moves.add(new Move(x,y,x-2,y));
                }
            }
            if(x-1>= 0 && y-1>=0 && y-1<=7 && grid.get(new Location(x-1,y-1)) != null && ((Piece)grid.get(new Location(x-1,y-1))).getTeam() != team)
            {
                moves.add(new Move(x,y,x-1,y-1));
            }
            if(x-1>= 0 && y-1>=0 && y+1<=7 && grid.get(new Location(x-1,y+1)) != null && ((Piece)grid.get(new Location(x-1,y+1))).getTeam() != team)
            {
                moves.add(new Move(x,y,x-1,y+1));
            }
        }
        else
        {
            if(x+1 > 0 && grid.get(new Location(x+1,y)) == null)
            {
                moves.add(new Move(x,y,x+1,y));
                if((grid.get(new Location(x+2,y)) == null))
                {
                    moves.add(new Move(x,y,x+2,y));
                }
            }
            if(x+1>= 0 && y-1>=0 && y-1<=7 && grid.get(new Location(x+1,y-1)) != null && ((Piece)grid.get(new Location(x+1,y-1))).getTeam() != team)
            {
                moves.add(new Move(x,y,x+1,y-1));
            }
            if(x+1>= 0 && y-1>=0 && y+1<=7 && grid.get(new Location(x+1,y+1)) != null && ((Piece)grid.get(new Location(x+1,y+1))).getTeam() != team)
            {
                moves.add(new Move(x,y,x+1,y+1));
            }
        }
        return moves;
    }

}
