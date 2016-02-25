import java.util.ArrayList;
import java.util.Random;

public class Maze {
	
	MazeBlock[][] maze;
	Random rn;
	MazeBlock start;
	
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
			this.build();
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
	
	// Builds the actual maze
	public void build()
	{
		/* Modified version of Prim's MST algorithm, the basic steps are:
		 * 1. While there are unfinished nodes, get a random node
		 * 2. Build a path from that node to an unvisited node (select randomly)
		 * 3. Add the unvisited node to the array
		 * 4. If a unfinished node has no unvisited neighbors, pop it off the array
		 */
		while (unfinishedNodes.size() != 0)
		{
			// Keep track of which ways we attempted to traverse to
			boolean upAttempt = false;
			boolean downAttempt = false;
			boolean leftAttempt = false;
			boolean rightAttempt = false;
			
			// As long as any of these are false, keep looping
			while (!upAttempt || !downAttempt || !leftAttempt || !rightAttempt)
			{
				int nextAttempt = rn.nextInt(4);
				switch (nextAttempt)
				{
				// Up
				case 0:
					break;
				// Down
				case 1:
					break;
				// Left
				case 2:
					break;
				// Right
				case 3:
					break;
				}
			}
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
				maze[i][f] = new MazeBlock(i,f);
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
			start = maze[0][randPos];
			//System.out.println("Pos on top wall at " + "0, " + randPos);
			break;
		// Left wall
		case 1:
			maze[randPos][0].setVisited();
			unfinishedNodes.add(maze[randPos][0]);
			start = maze[randPos][0];
			//System.out.println("Pos on left wall at " + randPos + ", 0");
			break;
		// Right wall
		case 2:
			maze[randPos][maze.length - 1].setVisited();
			unfinishedNodes.add(maze[randPos][maze.length - 1]);
			start = maze[randPos][maze.length - 1];
			//System.out.println("Pos on right wall at " + randPos + ", " + (maze.length - 1));
			break;
		// Bottom wall
		case 3:
			maze[maze.length - 1][randPos].setVisited();
			unfinishedNodes.add(maze[maze.length - 1][randPos]);
			start = maze[maze.length - 1][randPos];
			//System.out.println("Pos on bottom wall at " + (maze.length - 1) + ", " + randPos);
			break;
		}
		
	}
}
