package paint;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import javax.swing.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class PaintMyJPanel extends JPanel implements MouseMotionListener, ActionListener, ChangeListener
{
    JButton bRed,bGreen,bBlue,bBlack,bErase;
    JPanel p1;
    Point[] ps = new Point[10000];
    Color[] c = new Color[10000];
    int[] size = new int[10000];
    Color colorCurrent;
    Color bkgColor;
    int index = 0;
    JSlider js1;
    int drawSize = 5;
    public PaintMyJPanel()
    {
        bkgColor = new Color(0,255,255);
        setBackground(bkgColor);

        p1 = new JPanel();
        p1.setLayout(null);

        bRed = new JButton();
        bGreen = new JButton();
        bBlue = new JButton();
        bBlack = new JButton();
        bErase = new JButton();
        js1 = new JSlider(JSlider.HORIZONTAL,0,50,5);

        add(p1);
        add(bRed);
        add(bGreen);
        add(bBlue);
        add(bBlack);
        add(bErase);
        add(js1);
        
        bRed.setText("red");
        bGreen.setText("green");
        bBlue.setText("blue");
        bBlack.setText("black");
        bErase.setText("Erase");

        bRed.setBounds(new Rectangle(170,50,100,50));
        bGreen.setBounds(new Rectangle(230,50,100,50));
        bBlue.setBounds(new Rectangle(290,50,100,50));
        bBlack.setBounds(new Rectangle(350,50,100,50));
        bErase.setBounds(new Rectangle(410,50,100,50));
        
        bRed.addActionListener(this);
        bGreen.addActionListener(this);
        bBlue.addActionListener(this);
        bErase.addActionListener(this);
        bBlack.addActionListener(this);
        
        addMouseMotionListener(this);
        js1.addChangeListener(this);
        colorCurrent = new Color(0,0,0);
    }
    public void mouseMoved(MouseEvent evt) 
    {
        Point pt = evt.getPoint();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(int k=0;k<index;k++)
        {
            g.setColor(c[k]);
            drawSize=size[k];
            g.fillRect(ps[k].x, ps[k].y,drawSize,drawSize);
        }
    }
    public void mouseDragged(MouseEvent evt) 
    {
        Point pt = evt.getPoint();
        Graphics gg = getGraphics();
        gg.setColor(colorCurrent);
        gg.fillRect((int)pt.getX(),(int)pt.getY(),drawSize,drawSize);
        ps[index]=pt;
        c[index] = colorCurrent;
        size[index] = drawSize;
        index = index+1;
    }
    public void actionPerformed(ActionEvent evt)
    {
        Object obj = evt.getSource();
        if (obj==bRed)
        {
            colorCurrent = new Color(255,0,0);
        }
        if (obj==bGreen)
        {
            colorCurrent = new Color(0,255,0);
        }
        if (obj==bBlue)
        {
            colorCurrent = new Color(0,0,255);
        }
        if (obj==bBlack)
        {
            colorCurrent = new Color(0,0,0);
        }
        if (obj==bErase)
        {
            colorCurrent = bkgColor;
        }
    }
    public void stateChanged(ChangeEvent e)
    {
        JSlider obj = (JSlider)e.getSource();
        int count = obj.getValue();
        if (obj == js1)
        {
            drawSize = obj.getValue();
        }
    } 
}
  