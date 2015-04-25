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
 * An abstract class that all the types of pieces extend.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Piece extends Critter 
{    
    // true is white; false is black
    protected boolean team;
    // the piece's x coordinate
    protected int x;
    // the piece's y coordinate
    protected int y;
    //the grid that the board is located on
    protected Grid<Actor> grid;
    // the board that keeps track of the piece
    protected Board board;
    // Decides if the computer responds to whites move
    private final boolean computer = true;
    // Parameters are just the instance variables
    public Piece(int x, int y,boolean team,Board board)
    {
        this.team = team;
        this.x = x;
        this.y = y;
        // gets the grid from the board
        this.grid = board.getGrid();
        this.board = board;
    } 

    // returns the x value
    public int getX()
    {
        return x;
    }

    // returns the y value
    public int getY()
    {
        return y;
    }

    // returns the team
    public boolean getTeam()
    {
        return team;
    }

    // returns the legal moves; It is abstract because each piece has its own way to calculate legal moves
    public abstract ArrayList<Move> getLegalMoves();
   
    // parameters x2 and y2 are the ending coordinates of the piece
    // does the specified move if and only if the move is in the list of legal moves for this piece
    public void makeMove(int x2, int y2)
    {
        ArrayList<Move> moves = this.getLegalMoves();
        boolean flag = false;
        for(Move move: moves)
        {                        
            if(move.getX2() == x2 && move.getY2() == y2)
            {
                flag = true;                
            }
        }                

        if(flag)
        {
            grid.remove(new Location(x,y));
            x=x2;
            y=y2;
            board.remove((Piece)grid.remove(new Location(x2,y2)));
            grid.put(new Location(x2,y2), this);
            if(team && computer)
                board.makeMove();
        }
    }

    
}
