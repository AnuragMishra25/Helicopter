package in.anuragmishra.myfirstgame;

import android.graphics.Rect;

/**
 * Created by anuragmishra on 17/11/16.
 */

public abstract class GameObject {//basic class, superclass for player etc
    protected int x;
    protected int y;
    protected int dy;
    protected int dx;
    protected int width;
    protected int height;

    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
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
    public int getHeight()
    {
        return height;
    }
    public int getWidth()
    {
        return width;
    }
    public Rect getRectangle()
    {
        //this method return the rectangle for a particular object in game
        return new Rect(x, y, x+width, y+height);
    }

}
