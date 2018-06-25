
package tempest;

import java.awt.*;
import javax.swing.*;


public class Tempest extends JApplet
{
    
	private static final long serialVersionUID = 1L;
	private Container mainPanel;
    int[] levelXOuter = {1180,1151,1068,945,800,654,531,448,420,448,531,654,799,945,1068,1151};
    int[] levelYOuter = {400,545,668,751,780,751,668,545,400,254,131,48,20,48,131,254};
    int[] levelXInner = {838,835,826,814,800,785,773,764,762,764,773,785,800,814,826,835};
    int[] levelYInner = {400,414,426,435,438,435,426,414,400,385,373,364,362,364,373,385};
    
    int enemyXIndex;
    int enemyYIndex;
    
    int enemyX;
    int enemyY;
    int enemySize = 15;
    double dX;
    double dY;
    
    

    
    
    
    
    boolean justStarted = true;
    //for debugging, remove when done
    boolean enemyMoved = false;
    public void init()
    {
       setBackground(Color.black);
        mainPanel = getContentPane();
        mainPanel.setLayout(new FlowLayout());
        
        //test drawing of enemy
        enemyXIndex = (int) (Math.random() * levelXOuter.length);
        enemyYIndex = (int) (Math.random() * levelXOuter.length);

         //determine slope of path
       dX = levelXOuter[enemyXIndex] - levelXInner[enemyXIndex];
       dY = levelYOuter[enemyXIndex] - levelYInner[enemyXIndex]; 
    }
    
    
    
    
    public void paint (Graphics g)
    {
    	setBackground(Color.black);
        
        g.setColor(Color.blue);
        g.drawPolygon(levelXOuter, levelYOuter, levelXOuter.length);
        g.drawPolygon(levelXInner, levelYInner, levelXOuter.length);
        
        
        for(int i = 0; i <levelXOuter.length; i++ )
        {
            g.drawLine(levelXOuter[i], levelYOuter[i], levelXInner[i], levelYInner[i]);
        }
        g.setColor(Color.red);
        
        //test draw enemy
        enemyX = levelXInner[enemyXIndex];
        enemyY = levelYInner[enemyXIndex];
        
        g.fillOval(enemyX, enemyY, enemySize, enemySize);

    }
    
}