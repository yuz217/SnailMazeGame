import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameMain implements ActionListener{
	JButton start, help, credits;
	JFrame frame;
	JPanel menuPanel;
	
	// Initialize the main game menu
	public static void main(String [] args)
	{
		new GameMain();
	}

	public GameMain()
	{
		frame = new JFrame("Snail Maze Game");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuPanel = new JPanel(new GridLayout(3,1));
		
		start = new JButton("Start New Game");
		help = new JButton("Help");
		credits = new JButton("Credits");
		
		start.addActionListener(this);
		help.addActionListener(this);
		credits.addActionListener(this);
		
		menuPanel.add(start);
		menuPanel.add(help);
		menuPanel.add(credits);
		
		frame.add(menuPanel);
		
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
