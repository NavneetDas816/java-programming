class Armstrong
{
	public static void main(String ager[])
	{
		int temp,r,sum=0;
		int num= Integer.parseInt(ager[0]);
		temp=num;
		while(num>0)
		{
			r=num%10;
			sum=sum+(r*r*r);
			num=num/10;
		}
		if(temp==sum)
		{
			System.out.println("yes it "+temp+" an arm strong number");
		}
		else
		{
			System.out.print("no "+sum+" is not equae to "+temp);
		}
	}
}