public class Move
{    
    // ending coordinates of the move
    protected int y2;
    protected int x2;
    // starting coordinates of the move
    protected int x;
    protected int y;
    public Move(int x, int y,int x2, int y2)
    {
        
        this.x2 = x2;
        this.y2 = y2;
        this.x = x;
        this.y = y;
    } 
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getY2()
    {
        return y2;
    }
    public int getX2()
    {
        return x2;
    }
}