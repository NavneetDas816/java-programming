class Palendrome
{
	public static int Reverse(int number)
	{
		int r,sum=0;
		while(number>0)
		{
			r=number%10;
			sum=(sum*10)+r;
			number/=10;
		}
		return sum;
	}
	public static void main(String ager[])
	{
		int num=Integer.parseInt(ager[0]);
		int rev=Reverse(num);
		if(num==rev)
		{
			System.out.println("yes "+num+" is a palendrome number");
		}
		else	
		{
			System.out.println("no "+num+" is not a palendrome number");
		}
	}
}