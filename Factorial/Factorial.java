class Factorial
{
	public static void main(String ager[])
	{
		int facto=1,i,temp;
		int num=Integer.parseInt(ager[0]);
		temp=num;
		for(i=num ; i >1 ;i-- )
			{
				facto=facto*i;
			}
		System.out.println("the factoral of "+temp+" is "+facto);
	}
}