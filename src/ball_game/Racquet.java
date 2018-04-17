/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ball_game;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author Kartik
 */
public class Racquet {
    private int x=0;
    private int xa=0;
    private static final int Y = 200;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
    
    
    private Game2 game;
    public Racquet(Game2 game){
        this.game=game;
    }
    public void move(){
        if(x+xa>0 && x+xa<game.getWidth()-60){
            x=x+xa;
        }
    }
    public void paint_rack(Graphics2D g){
        g.fillRect(x, Y,WIDTH,HEIGHT);
    }
    public int getTopy(){
        return Y-HEIGHT;
    }
    public Rectangle getBounds(){
        return new Rectangle(x,Y,WIDTH,HEIGHT);
    }
    public void keyReleased(KeyEvent e){
        xa=0;
    }
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_LEFT)
            xa=-game.speed;
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
            xa=game.speed;
    }
}
