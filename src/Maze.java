import java.util.ArrayList;
import java.util.Random;

public class Maze {
	
	MazeBlock[][] maze;
	Random rn;
	MazeBlock start;
	MazeBlock end;
	int removedNodes;
	
	// 0,1,2,3 for TOP, BOTTOM, LEFT, RIGHT
	int startWall;
	
	// This represents all the nodes we have explored (aka visited) whose neighbors are
	// not also all visited
	ArrayList<MazeBlock> unfinishedNodes;
	
	public Maze(int size)
	{
		rn = new Random();
		if (size == 0)
		{
			//Make 10x10 maze
			maze = new MazeBlock[10][10];
			this.init();
			this.build();
			this.setEnd();
			// For debugging purposes only
			// this.printMaze();
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
		while (removedNodes != maze.length * maze[0].length)
		{
			// Step 1: Get a random node
			int nodeIndex = rn.nextInt(unfinishedNodes.size());
			MazeBlock current = unfinishedNodes.get(nodeIndex);
			int curY = current.getY();
			int curX = current.getX();
			// Note: Don't remove yet, only remove if later on we find that we can't traverse
			
			// Keep track of which ways we attempted to traverse to
			boolean upAttempt = false;
			boolean downAttempt = false;
			boolean leftAttempt = false;
			boolean rightAttempt = false;
			
			// Keep track if we're successful
			boolean success = false;
			
			// Step 2: Build a path to a randomly selected neighboring unvisited node
			// As long as any of these are false, keep looping
			while (!success && (!upAttempt || !downAttempt || !leftAttempt || !rightAttempt))
			{
				int nextAttempt = rn.nextInt(4);
				switch (nextAttempt)
				{
				// Up
				case 0:
					upAttempt = true;
					if (curY > 0)
					{
						// Step 3: Add the node to the array
						if (!(maze[curY - 1][curX].isVisited()))
						{
							success = true;
							maze[curY - 1][curX].setVisited();
							unfinishedNodes.add(maze[curY - 1][curX]);
							current.open(0);
							maze[curY - 1][curX].open(1);
							//System.out.println("Building path from " + curX + ", " + curY + " to " + curX + " , " + (curY - 1));
						}
					}
					break;
				// Down
				case 1:
					downAttempt = true;
					if (curY < maze.length - 1)
					{
						if (!(maze[curY + 1][curX].isVisited()))
						{
							success = true;
							maze[curY + 1][curX].setVisited();
							unfinishedNodes.add(maze[curY + 1][curX]);
							current.open(1);
							maze[curY + 1][curX].open(0);
							//System.out.println("Building path from " + curX + ", " + curY + " to " + curX + " , " + (curY + 1));
						}
					}
					break;
				// Left
				case 2:
					leftAttempt = true;
					if (curX > 0)
					{
						if (!(maze[curY][curX - 1].isVisited()))
						{
							success = true;
							maze[curY][curX - 1].setVisited();
							unfinishedNodes.add(maze[curY][curX - 1]);
							current.open(2);
							maze[curY][curX - 1].open(3);
							//System.out.println("Building path from " + curX + ", " + curY + " to " + (curX - 1) + " , " + curY);
						}
					}
					break;
				// Right
				case 3:
					rightAttempt = true;
					if (curX < maze[0].length - 1)
					{
						if (!(maze[curY][curX + 1].isVisited()))
						{
							success = true;
							maze[curY][curX + 1].setVisited();
							unfinishedNodes.add(maze[curY][curX + 1]);
							current.open(3);
							maze[curY][curX + 1].open(2);
							//System.out.println("Building path from " + curX + ", " + curY + " to " + (curX + 1) + " , " + curY);
						}
					}
					break;
				}
			}
						
			// Step 4: If no unvisited neighbors, pop off the array
			if (upAttempt && downAttempt && leftAttempt && rightAttempt)
			{
				unfinishedNodes.remove(nodeIndex);
				++removedNodes;
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
		removedNodes = 0;
		unfinishedNodes = new ArrayList<MazeBlock>();
		
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
			startWall = 0;
			System.out.println("Pos on top wall at " + "0, " + randPos);
			break;
		// Bottom wall
		case 1:
			maze[maze.length - 1][randPos].setVisited();
			unfinishedNodes.add(maze[maze.length - 1][randPos]);
			start = maze[maze.length - 1][randPos];
			startWall = 1;
			System.out.println("Pos on bottom wall at " + (maze.length - 1) + ", " + randPos);
			break;
		// Left wall
		case 2:
			maze[randPos][0].setVisited();
			unfinishedNodes.add(maze[randPos][0]);
			start = maze[randPos][0];
			startWall = 2;
			System.out.println("Pos on left wall at " + randPos + ", 0");
			break;
		// Right wall
		case 3:
			maze[randPos][maze.length - 1].setVisited();
			unfinishedNodes.add(maze[randPos][maze.length - 1]);
			start = maze[randPos][maze.length - 1];
			startWall = 3;
			System.out.println("Pos on right wall at " + randPos + ", " + (maze.length - 1));
			break;
		}
	}
	
	// Sets the finish node based on the position of the start node
	private void setEnd()
	{
		int endPos = rn.nextInt(maze.length);
		switch(startWall)
		{
		// Start on top, end on bottom
		case 0:
			end = maze[maze.length - 1][endPos];
			break;
		// Start on bottom, end on top
		case 1:
			end = maze[0][endPos];
			break;
		// Start on left, end on right
		case 2:
			end = maze[maze.length - 1][endPos];
			break;
		// Start on right, end on left
		case 3:
			end = maze[0][endPos];
			break;
		}
		System.out.println("End is at position " + end.getY() + end.getX());

		// Handle the corner case where end == start because of a corner
		if (end.getY() == start.getY() && end.getX() == start.getX())
		{
			System.out.println("Reroll");
			this.setEnd();
		}
	}
	
	// Method for debugging, prints the maze in a vertical line for debugging purposes
	private void printMaze()
	{
		for (int i = 0; i < maze.length; i++)
		{
			for (int f = 0; f < maze[0].length; f++)
			{
				maze[i][f].printBlock();
			}
		}
	}
}
