import java.util.*;
import java.util.StringTokenizer;

public class Main{
    public static double max=-1.0;
    public static double [][] arr;
    public static double []memoryNumber;
    public static char [] memoryAlpha;
    public static int [] result;
    public static boolean flag=false;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int number=sc.nextInt();
        int totalNumber=sc.nextInt();
        arr= new double[totalNumber][14];
        memoryNumber=new double[totalNumber];
        memoryAlpha=new char[totalNumber];
        result=new int [totalNumber];

        for(int i=0;i<totalNumber;i++)
        {
            String str=sc.next();
            char al=str.charAt(0);
            double temp=sc.nextDouble();
            if(number*0.05>temp)
            {
                continue;
            }
            memoryAlpha[i]=al;
            memoryNumber[i]=temp;
        }

        for(int i=0;i<totalNumber;i++)
        {
            double temp=memoryNumber[i];
            for(int j=0;j<14;j++)
            {
                arr[i][j]=(temp/(double)(j+1));
            }
        }
        int count=0;
        int indexi=0;
        int indexj=0;
        while(true)
        {
            if(count>=14)
            {
                break;
            }
            for(int i=0;i<totalNumber;i++)
            {
                for(int j=0;j<14;j++)
                {
                    if(max<arr[i][j])
                    {
                        max=arr[i][j];
                        indexi=i;
                        indexj=j;
                    }
                }
            }
            result[indexi]++;
            arr[indexi][indexj]=-1.0;
            indexi=0;
            indexj=0;
            count++;
            max=-1.0;
        }
        for(int i=0;i<totalNumber;i++)
        {
            for(int j=0;j<totalNumber;j++)
            {
                if(memoryAlpha[i]<memoryAlpha[j])
                {
                    char temp=memoryAlpha[i];
                    memoryAlpha[i]=memoryAlpha[j];
                    memoryAlpha[j]=temp;
                    int tempNumber=result[i];
                    result[i]=result[j];
                    result[j]=tempNumber;

                }
            }
        }
        for(int i=0;i<totalNumber;i++)
        {
            if(memoryAlpha[i]>='A' && memoryAlpha[i]<='Z')
            {
                System.out.println(memoryAlpha[i]+" "+result[i]);
            }
        }
    }
}