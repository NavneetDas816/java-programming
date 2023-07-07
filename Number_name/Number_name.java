class Number_name
{
	public static void main(String num[])
	{
		String once[]={"","one","two","three","four","five","six","seven","eight","nine"};
		String spical[]={"","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","ninteen"};
		String additional[]={"","ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninty"};
		int[] places = new int[15];

		int n=Integer.parseInt(num[0]),reminder,i=0;
		if(n<0){
			System.out.println("Invalid!");
		}
		else if(n<=19 && n>=11){
				System.out.println(spical[n-10]);
			}
		else{
			while(n>0){
				reminder=n%10;
				n/=10;
				places[i]=reminder;
				i++;
			}
			for(int j=i-1;j>=0;j--){

				switch(i){
					case 1:
						System.out.print(once[places[j]]+" ");
						break;
					case 2:
						System.out.print(additional[places[j]]);
						break;
					case 3:
						System.out.print(once[places[j]]+"hundread ");
						break;
					case 4:
						System.out.print(once[places[j]]+" thousand ");
						break;
					case 5:
						System.out.print(additional[places[j]]);
						break;
					case 6:
						System.out.print(once[places[j]]+" lakh ");
						break;
					case 7:
						System.out.print(additional[places[j]]);
						break;
					case 8:
						System.out.print(once[places[j]]+" crore ");
						break;
					case 9:
						System.out.print(additional[places[j]]);
						break;
				}
				i--;
			}		
		}
	}
}