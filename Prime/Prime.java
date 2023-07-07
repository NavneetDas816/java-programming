class Prime
{
public static char checkPrime(int num)
	{	
		for(int i=num-1;i>1;i--)
		{
			if(num%i==0)
			{
			return '0';
			}
		}
	return'1';
	}
public static void main(String ager[])
	{
	char check='1';
	for(int i=2;i<101;i++)
	{	
		check=checkPrime(i);	
		if(check=='1')
		{
			System.out.println(i+" is a prime number");
			check='0';
		}
	}	
	}
}