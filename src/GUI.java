import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 400;
	private static final int HEIGHT = 100;
	private JLabel fromLabel, toLabel;
	private JTextField fromFeild, toFeild;
	private JButton changeButton;
	private ChangeButtonHandler Handler;

	public GUI()
	{
		setTitle("Minecraft Offline Username Changer");
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(3, 2));
		fromLabel = new JLabel("Enter the original username: ", SwingConstants.RIGHT);
		toLabel = new JLabel("Enter the new username: ", SwingConstants.RIGHT);
		fromFeild = new JTextField(10);
		toFeild = new JTextField(10);
		changeButton = new JButton("Change Name!");
		Handler = new ChangeButtonHandler();
		changeButton.addActionListener(Handler);

		pane.add(fromLabel);
		pane.add(fromFeild);
		pane.add(toLabel);
		pane.add(toFeild);
		pane.add(new JLabel(""));
		pane.add(changeButton);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class ChangeButtonHandler implements ActionListener
	    {
	       public void actionPerformed(ActionEvent e)
	        {
	    	   if(fromFeild.getText().isEmpty()||toFeild.getText().isEmpty()){  
	    	   }else
	            Main.setNewUser(fromFeild.getText(), toFeild.getText());
	    	   	fromFeild.setText("");
	    	   	toFeild.setText("");
	        }}
	    }

