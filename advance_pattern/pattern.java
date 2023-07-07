import java.util.*;

class pattern{
    public static void main(String[] args) {
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(i==0 || j==0 || i==3 || j==4)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<i+1;j++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
        System.out.println("-------------------------------------------------------------------------------");
        for(int i=0;i<4;i++)
        {
            for(int j=4;j>i;j--)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
        System.out.println("-------------------------------------------------------------------------------");
        for(int i=0;i<4;i++)
        {
            for(int j=3;j>i;j-- )
            {
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
        System.out.println("-------------------------------------------------------------------------------");
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<=i;j++)
            {
                System.out.print(j+1);
            }
            System.out.println("");
        }
        System.out.println("-------------------------------------------------------------------------------");
        for(int i=4;i>=1;i--)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print(j);
            }
            System.out.println("");
        }
    }


}