package paint;
import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PaintMyJFrame extends JFrame
{
	PaintMyJPanel mjp;
	public PaintMyJFrame ()
	{
		super ("a drawing example");
//------------------------------------------------------
// Create components
    	mjp = new PaintMyJPanel();
//------------------------------------------------------
// Choose a Layout for JFrame and 
// add Jpanel to JFrame according to layout    	
		getContentPane().setLayout(new BorderLayout());
                getContentPane().add(mjp,"Center");
//NOTE FROM STICKERS: don't worry about layouts for now, they're usually a separate lesson entirely, 
//and you can do a null layout and simply position the components at coordinates.  
//------------------------------------------------------
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (800, 600);
		setVisible(true);
	}
}
