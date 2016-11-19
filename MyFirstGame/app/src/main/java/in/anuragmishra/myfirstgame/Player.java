package in.anuragmishra.myfirstgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by anuragmishra on 17/11/16.
 */

public class Player extends GameObject{
    private Bitmap spritesheet;
    private int score;

    private boolean up;
    private boolean playing;
    private Animation animation = new Animation();
    private long startTime;//this time will be used to calculate the score

    public Player(Bitmap res, int w, int h, int numFrames) {

        x = 100;
        y = GamePanel.HEIGHT / 2;
        dy = 0;
        score = 0;
        height = h;
        width = w;

        Bitmap[] image = new Bitmap[numFrames];//stores all the sprite for player state, for helicopter, 3 is numframes, for dino 8 etc
        spritesheet = res;

        for (int i = 0; i < image.length; i++)
        {
            image[i] = Bitmap.createBitmap(spritesheet, i*width, 0, width, height);//this creates bitmap for the sprite into three parts for helicopter
        }

        animation.setFrames(image);//this sets the image
        animation.setDelay(10);//this changes the image after every 10ms
        startTime = System.nanoTime();

    }

    public void setUp(boolean b){up = b;}

    public void update()
    {
        long elapsed = (System.nanoTime()-startTime)/1000000;
        if(elapsed>100)
        {
            score++;//in every 0.1 seconds the score increase by 1, so by 10 in 1 seconds
            startTime = System.nanoTime();
        }
        animation.update();

        if(up){
            dy -=1;//increase the acceleration by 1, if touched on screen

        }
        else{
            dy +=1;//decreases the acceleration by 1, if touched on screen
        }

        if(dy>14)dy = 14;
        if(dy<-14)dy = -14;

        y += dy;//this is what changes the y, when touched

    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(animation.getImage(),x,y,null);
    }
    public int getScore(){return score;}
    public boolean getPlaying(){return playing;}
    public void setPlaying(boolean b){playing = b;}
    public void resetDY(){dy = 0;}
    public void resetScore(){score = 0;}
}