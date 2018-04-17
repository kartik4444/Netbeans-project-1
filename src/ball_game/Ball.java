/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ball_game;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Kartik
 */
public class Ball {
    private int x=0;
    private int y=0;
    private int xa=1;
    private int ya=1;
    private static final int DIAMETER=30;
    private Game2 game;
    public Ball(Game2 game){
        this.game=game;
    }
   void move(){
        if(x+xa<0)
            xa=game.speed;
        if(x+xa>game.getWidth()-30)
            xa=-game.speed;
        if(y+ya<0)ya=game.speed;
       if (y + ya > game.getHeight() - DIAMETER)
			game.gameOver();
       if(collision()){
           ya=-game.speed;
           y=game.rq.getTopy()-DIAMETER;
           game.speed++;
       }
       x=x+xa;
       y=y+ya;
        
    }
    public void paintBall(Graphics2D g){
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }
    public boolean collision(){
       
        return game.rq.getBounds().intersects(getBounds());
        
        
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,DIAMETER,DIAMETER);
    }
    
}
