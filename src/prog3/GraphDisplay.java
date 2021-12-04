package prog3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// Ricardo Estrella
// PID: 6071900

public class GraphDisplay extends JPanel implements MouseMotionListener
{
    GeometricObject[] gArray; //geometric objects
    GeometricObject rectangle;
    private BufferedImage image; //background image
    String description; //description of map element
    
    /**
     * Parameterized constructor.
     */
    public GraphDisplay(GeometricObject[] g, GeometricObject r)
    {
        this.gArray = g;
        this.rectangle = r;
        addMouseMotionListener(this);
        
        try
        {
            image = ImageIO.read(new File("C:\\Users\\rickj\\Documents\\NetBeansProjects\\Prog3\\src\\prog3\\office-floor-plan.png"));
        }
        catch (IOException ex)
        {
            System.out.println("Image file not found!");
        }        
        
        description = "";
    }
    
    public void mouseDragged(MouseEvent e)
    {
    }

    /**
     * Captures mouse movement events.
     * 
     * @param e contains current location of mouse
     */
    public void mouseMoved(MouseEvent e)
    {
        //only for coordinates lookup; remove after project completion
        System.out.println("(" + e.getPoint().x + ", " +
                           e.getPoint().y + ")");
        
        //is current mouse location inside a geometric object?
        //Set description accordingly
        int x = e.getPoint().x;
        int y = e.getPoint().y;
        Point p = new Point(e.getPoint().x, e.getPoint().y);
        
        repaint();
    }
    
    /**
     * Paints this panel; the system invokes it every time
     * it deems necessary to redraw the panel.
     */
    @Override
    public void paint(Graphics g)
    {        
        super.paint(g); //clears window
        
        //draws background image
        Dimension d = getSize();
        g.drawImage(image, 0, 0, d.width, d.height, this);
        
        if(rectangle != null) {
            rectangle.draw(g);
        }
    }
}
