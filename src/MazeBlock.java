
public class MazeBlock {

	boolean topOpen;
	boolean bottomOpen;
	boolean leftOpen;
	boolean rightOpen;
	
	boolean visited;
	
	public MazeBlock()
	{
		visited = false;
		topOpen = false;
		bottomOpen = false;
		leftOpen = false;
		rightOpen = false;
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
	
}