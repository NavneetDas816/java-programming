class FebonacciSeries
{
public static void main(String ager[])
	{	
		int a=0,b=1,c;
		for(int i=0 ; i<15 ; i++)
			{
				System.out.println(a);
				c=a+b;
				a=b;
				b=c;
			}	
	}
}