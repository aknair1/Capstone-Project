import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.awt.Color;


/**
 * A board that keeps tracks of pieces with gridworld and has the ability to randomly select legal moves for black
 *
 */
public class Board
{
    // the world comprised of the grid that displays the graphics for the game
    private ActorWorld world;

    // the game board will have 8 rows and 8 columns
    private final int ROWS = 8;
    private final int COLS = 8;
    // the lists for the black and white pieces; the white arralist is currently not used but it could be useful if you wanted 2 computers to play against each other
    private ArrayList<Piece> white = new ArrayList<Piece>();
    private ArrayList<Piece> black = new ArrayList<Piece>();
    /**
     * Default constructor for objects of class GameOfLife
     * 
     * @post    the game will be initialized and populated with the initial state of cells
     * 
     */
    public Board()
    {
        // create the grid, of the specified size, that contains Actors
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(ROWS, COLS);

        // create a world based on the grid
        world = new ActorWorld(grid);

        // populate the game
        populateGame();

        // display the newly constructed and populated world
        world.show();

    }

    /**
     * Creates the actors and inserts them into their initial starting positions in the grid
     *
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    private void populateGame()
    {
        // the grid of Actors that maintains the state of the game
        //  (alive cells contains actors; dead cells do not)
        Grid<Actor> grid = world.getGrid();

        // create and add pieces (a type of Actor) to the lists of teams
        black.add(new Rook(0,0,false,this));
        black.add(new Rook(0,7,false,this));
        black.add(new Bishop(0,2,false,this));
        black.add(new Bishop(0,5,false,this));
        black.add(new Knight(0,1,false,this));
        black.add(new Knight(0,6,false,this));
        black.add(new King(0,4,false,this));
        black.add(new Queen(0,3,false,this));
        black.add(new Pawn(1,0,false,this));
        black.add(new Pawn(1,1,false,this));
        black.add(new Pawn(1,2,false,this));
        black.add(new Pawn(1,3,false,this));
        black.add(new Pawn(1,4,false,this));
        black.add(new Pawn(1,5,false,this));
        black.add(new Pawn(1,6,false,this));
        black.add(new Pawn(1,7,false,this));

        white.add(new Rook(7,0,true,this));
        white.add(new Rook(7,7,true,this));
        white.add(new Bishop(7,2,true,this));
        white.add(new Bishop(7,5,true,this));
        white.add(new Knight(7,1,true,this));
        white.add(new Knight(7,6,true,this));
        white.add(new King(7,4,true,this));
        white.add(new Queen(7,3,true,this));
        white.add(new Pawn(6,0,true,this));
        white.add(new Pawn(6,1,true,this));
        white.add(new Pawn(6,2,true,this));
        white.add(new Pawn(6,3,true,this));
        white.add(new Pawn(6,4,true,this));
        white.add(new Pawn(6,5,true,this));
        white.add(new Pawn(6,6,true,this));
        white.add(new Pawn(6,7,true,this));

        // adds the pieces to the grid
        for(int i = 0; i < 16; i++)
        {
            grid.put(new Location(white.get(i).getX(),white.get(i).getY()), white.get(i));
            grid.put(new Location(black.get(i).getX(),black.get(i).getY()), black.get(i));          
            black.get(i).setDirection(180);
        }       

    }

    // removes the piece from whichever team's list it is in; piece can be in only one list and the remove method does nothing for the other list since the piece isn't already in it
    public void remove(Piece piece)
    {
        white.remove(piece);
        black.remove(piece);
    }

    // makes a randomly generated move for black; it is only called if the computer constant is set to true in the piece abstract class
    public void makeMove()
    {   
        Piece piece;
        // picks a random piece that has legal moves
        do{            
            int random = (int)(Math.random() * black.size());            
            piece = black.get(random);    
                    
        }while(piece.getLegalMoves().size() == 0);
        // performs a random move from the list of the selected piece's moves
        Move move = piece.getLegalMoves().get((int)(Math.random() * piece.getLegalMoves().size()));
        piece.makeMove(move.getX2(),move.getY2());
    }


    /**
     * Returns the grid 
     *

     */
    public Grid<Actor> getGrid()
    {
        return world.getGrid();
    }

    public static void main(String[] args)
    {
        new Board();
    }
}
