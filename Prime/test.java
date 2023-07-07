class opr
{
	opr(){
	String name = N/A;
	int age = NULL;
	}
	opr(Srting name,int age)
	{
	System.out.println("Name = " + name);
	System.out.println("age = " + age);
	}
	opr(Srting name, int age, int idcode)
	{
	System.out.println("Name = " + name);
	System.out.println("age = " + age);
	System.out.println("Emp id = " + idcode);
	}
	
}
class test{
	public static void main(String args[]){
	opr r = new opr();
	opr();
	opr("navneet",20);
	opr("rahul",12,123456);
	
	}
}