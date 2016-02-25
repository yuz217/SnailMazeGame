
public class Maze {
	
	MazeBlock[][] maze;
	
	public Maze(int size)
	{
		if (size == 0)
		{
			//Make 10x10 maze
			maze = new MazeBlock[10][10];
			for (int i = 0; i < maze.length; i++)
			{
				for (int f = 0; f < maze[0].length; f++)
				{
					maze[i][f] = new MazeBlock();
				}
			}			
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
}
