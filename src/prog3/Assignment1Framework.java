package prog3;
import java.awt.Color;
import javax.swing.*;

// Ricardo Estrella
// PID: 6071900

public class Assignment1Framework
{
    public static void main(String[] args)
    {
        new Assignment1Framework();
    }
    
    public Assignment1Framework()
    {        
        //Defining the geometric objects that represent the problem data
        SimplePolygon[] rpArray = new SimplePolygon[7];
        
        Point p = new Point(10, 25);
        Point q = new Point(25, 10);
        Rectangle rectangle = new Rectangle(p, q);
        rectangle.setInteriorColor(Color.yellow);
        
        Point k = new Point(159, 390);
        Point j = new Point(205, 340);
        Point r = new Point(159, 340);
        Point s = new Point(205, 390);
        rpArray[0] = new SimplePolygon(4);
        rpArray[0].addVertex(k);
        rpArray[0].addVertex(j);
        rpArray[0].addVertex(r);
        rpArray[0].addVertex(s);
        
        k = new Point(258, 74);
        j = new Point(286, 43);
        r = new Point(258,43);
        s = new Point(286, 74);
        rpArray[1] = new SimplePolygon(4);
        rpArray[1].addVertex(k);
        rpArray[1].addVertex(j);
        rpArray[1].addVertex(r);
        rpArray[1].addVertex(s);
        
        k = new Point(125, 136);
        j = new Point(151, 110);
        r = new Point(125, 110);
        s = new Point(151, 136);
        rpArray[2] = new SimplePolygon(4);
        rpArray[2].addVertex(k);
        rpArray[2].addVertex(j);
        rpArray[2].addVertex(r);
        rpArray[2].addVertex(s);
        
        k = new Point(329, 78);
        j = new Point(357, 44);
        r = new Point(329, 44);
        s = new Point(357, 78);
        rpArray[3] = new SimplePolygon(4);
        rpArray[3].addVertex(k);
        rpArray[3].addVertex(j);
        rpArray[3].addVertex(r);
        rpArray[3].addVertex(s);
        
        k = new Point(317, 328);
        j = new Point(339, 302);
        r = new Point(317, 302);
        s = new Point(339, 328);
        rpArray[4] = new SimplePolygon(4);
        rpArray[4].addVertex(k);
        rpArray[4].addVertex(j);
        rpArray[4].addVertex(r);
        rpArray[4].addVertex(s);
        
        k = new Point(293, 74);
        j = new Point(318, 47);
        r = new Point(293, 47);
        s = new Point(318, 74);
        rpArray[5] = new SimplePolygon(4);
        rpArray[5].addVertex(k);
        rpArray[5].addVertex(j);
        rpArray[5].addVertex(r);
        rpArray[5].addVertex(s);
        
        k = new Point(319, 287);
        j = new Point(339, 264);
        r = new Point(319, 264);
        s = new Point(339, 287);
        rpArray[6] = new SimplePolygon(4);
        rpArray[6].addVertex(k);
        rpArray[6].addVertex(j);
        rpArray[6].addVertex(r);
        rpArray[6].addVertex(s);
        
        //graphing
        FrameDisplay frame = new FrameDisplay(450, 450, rpArray, rectangle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        for(int i = 0; i <= 25; i++) {
            delay(50);
            
            p.setX(p.getX() + (double)i);
            rectangle.setBegin(p);
            q.setX(q.getX() + (double)i);
            rectangle.setEnd(q);
            frame.repaint();
        }
    }
    
    public void delay(int ms)
    {
        try
        {
            Thread.sleep(ms);
        } catch (InterruptedException e) { }
    }
}
