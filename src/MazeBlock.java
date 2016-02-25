
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
		if (!this.topOpen)
		{
			System.out.println("***");
		}
		else
		{
			System.out.println("* *");
		}
		if (!this.leftOpen)
		{
			System.out.print("* ");
		}
		if (!this.rightOpen)
		{
			System.out.println("*");
		}
		else
		{
			System.out.println("");
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
}
