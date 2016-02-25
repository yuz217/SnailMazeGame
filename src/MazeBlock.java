
public class MazeBlock {

	private boolean topOpen;
	private boolean bottomOpen;
	private boolean leftOpen;
	private boolean rightOpen;
	
	private boolean visited;
	
	private int x;
	private int y;
	
	public MazeBlock(int y,int x)
	{
		visited = false;
		topOpen = false;
		bottomOpen = false;
		leftOpen = false;
		rightOpen = false;
		this.y = y;
		this.x = x;
	}
	
	public void printBlock()
	{
		System.out.println("At x =" + this.x + " and y = " + this.y);
		if (!this.topOpen)
		{
			System.out.println("***");
		}
		else
		{
			System.out.println("* *");
		}
		if (!this.leftOpen && this.rightOpen)
		{
			System.out.println("*  ");
		}
		else if (!this.rightOpen && this.leftOpen)
		{
			System.out.println("  *");
		}
		else if (this.rightOpen && this.leftOpen)
		{
			System.out.println("");
		}
		else
		{
			System.out.println("* *");
		}
		if (!this.bottomOpen)
		{
			System.out.println("***");
		}
		else
		{
			System.out.println("* *");
		}
	}
	
	public void setVisited()
	{
		this.visited = true;
	}
	
	public boolean isVisited()
	{
		return this.visited;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	// 0 = top, 1 = bottom, 2 = left, 3 = right
	public void open(int dir)
	{
		switch (dir)
		{
		case 0:
			this.topOpen = true;
			break;
		case 1:
			this.bottomOpen = true;
			break;
		case 2:
			this.leftOpen = true;
			break;
		case 3:
			this.rightOpen = true;
			break;
		}
	}
}
