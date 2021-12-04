package prog3;
import javax.swing.*;

// Ricardo Estrella
// PID: 6071900

public class FrameDisplay extends JFrame
{   
    private GraphDisplay panel;

    /**
     * Creates an initializes the window frame.
     * 
     * @param width frame width
     * @param height frame height
     * @param g geometric objects to be depicted in this frame
     */
    public FrameDisplay(int width, int height, GeometricObject[] g, GeometricObject r)
    {
        setTitle("Interactive Map");
        setSize(width, height);
        setResizable(false);

        panel = new GraphDisplay(g, r);
        add(panel);
    }
    
    public void repaint()
    {
        panel.repaint();
    }
}
