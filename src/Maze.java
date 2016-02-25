import java.util.ArrayList;
import java.util.Random;

public class Maze {
	
	MazeBlock[][] maze;
	Random rn;
	
	// This represents all the nodes we have explored (aka visited) whose neighbors are
	// not also all visited
	ArrayList<MazeBlock> unfinishedNodes;
	
	public Maze(int size)
	{
		unfinishedNodes = new ArrayList<MazeBlock>();
		rn = new Random();
		if (size == 0)
		{
			//Make 10x10 maze
			maze = new MazeBlock[10][10];
			this.init();
		}
		else if (size == 1)
		{
			//TODO
		}
		else if (size == 2)
		{
			//TODO
		}
	}
	
	// Picks a random node on the edge to be a start
	// Will also reset the maze to be clean
	public void init()
	{
		// Reset the maze to be clean
		for (int i = 0; i < maze.length; i++)
		{
			for (int f = 0; f < maze[0].length; f++)
			{
				maze[i][f] = new MazeBlock();
			}
		}
		
		// First, pick a wall (Top, Left, Right, Bottom)
		int randWall = rn.nextInt(4);
		
		// Next, pick a space in the wall from 0 to length exclusive
		int randPos = rn.nextInt(maze.length);
		
		switch (randWall)
		{
		// Top wall
		// maze[y][x]
		case 0:
			maze[0][randPos].setVisited();
			unfinishedNodes.add(maze[0][randPos]);
			break;
		// Left wall
		case 1:
			maze[randPos][0].setVisited();
			unfinishedNodes.add(maze[randPos][0]);
			break;
		// Right wall
		case 2:
			maze[randPos][maze.length - 1].setVisited();
			unfinishedNodes.add(maze[randPos][maze.length - 1]);
			break;
		// Bottom wall
		case 3:
			maze[maze.length - 1][randPos].setVisited();
			unfinishedNodes.add(maze[maze.length - 1][randPos]);
			break;
		}
		
	}
}
