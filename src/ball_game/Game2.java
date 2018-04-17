/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ball_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Kartik
 */
public class Game2  extends JPanel{
    Ball ball=new Ball(this);
    Racquet rq=new Racquet(this);
    int speed=1;
    public Game2(){
    addKeyListener(new KeyListener(){
        @Override
        public void keyTyped(KeyEvent ke) {
            
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            System.out.println("key pressed "+KeyEvent.getKeyText(ke.getExtendedKeyCode()));
            rq.keyPressed(ke);
        }

        @Override
        public void keyReleased(KeyEvent ke) {
      
        System.out.println("key released "+KeyEvent.getKeyText(ke.getExtendedKeyCode()));
        rq.keyReleased(ke);
        }
        
    });
    
		setFocusable(true);
    }
    public void gameOver(){
        JOptionPane.showMessageDialog(this,"Game over");
        System.exit(ABORT);
    }
    public void move(){
        ball.move();
        rq.move();
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d=(Graphics2D)g;
        g2d.setColor(Color.black);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paintBall(g2d);
        rq.paint_rack(g2d);
	
    }
    public static void main(String args[]) throws InterruptedException{
        JFrame frame=new JFrame();
        Game2 game=new Game2();
        frame.setTitle("Mini tetris");
        frame.add(game);
        frame.setSize(300,300);
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true){
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
        
    }
    
}
