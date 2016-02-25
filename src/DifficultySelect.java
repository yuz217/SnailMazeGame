import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Menu which prompts the user for a difficulty to play the game on (maze size)
public class DifficultySelect implements ActionListener{
	JButton easy, medium, hard;
	JFrame difficultyFrame;
	JPanel difficultyPanel;
	// 0 for easy, 1 for medium, 2 for hard
	
	// Create a menu with 3 options
	public DifficultySelect()
	{
		difficultyFrame = new JFrame("Select Difficulty");
		difficultyFrame.setSize(400, 400);
		difficultyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		difficultyPanel = new JPanel(new GridLayout(3,1));
		
		easy = new JButton("Easy 10x10");
		medium = new JButton("Medium 20x20");
		hard = new JButton("Hard 40x40");
		
		easy.addActionListener(this);
		medium.addActionListener(this);
		hard.addActionListener(this);
		
		difficultyPanel.add(easy);
		difficultyPanel.add(medium);
		difficultyPanel.add(hard);
		
		difficultyFrame.add(difficultyPanel);
		
		difficultyFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Create new game with whatever maze size we selected
		if (e.getSource().equals(easy))
		{
			new Maze(0);
		}
		else if (e.getSource().equals(medium))
		{
			
		}
		else if (e.getSource().equals(hard))
		{
			
		}
		
	}
}
