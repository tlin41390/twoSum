public class twoSum{

    public void swap(int [] numList , int num1, int num2 )
    {
        int temp = numList[num1];
        numList[num1]=numList[num2];
        numList[num2]=temp;
    }

    public int findSmallest (int [] numList, int tiny)
    {
        int smallest = tiny;
        for (int i = smallest+1;i<numList.length-1;i++)
        {
            if (numList[i]<numList[smallest])
            {
                smallest = i;
            }
        }
        return smallest;
    }

    public void sort(int [] numList)

    {
        for(int i =0;i<numList.length-1;i++)
        {
            swap(numList,i,findSmallest(numList,i));
        }   
    }

    public int search(int [] sum, int value)
    {
        return binarySearch(sum, 0, sum.length-1,value);
    }

    public int binarySearch(int[] sum, int lowerBound, int upperBound, int value)
    {
        if(lowerBound>upperBound)
        {
            return -1;
        }
        int midPoint = (lowerBound+upperBound)/2;

        if(sum[midPoint] == value)
        {
            return midPoint;
        }
        else if(value>sum[midPoint])
        {
            return binarySearch(sum,midPoint+1,upperBound,value);
        }
        else 
        {
            return binarySearch(sum,lowerBound,midPoint-1,value);
        }
    }

    public int [] twoSum(int [] sum, int value)
    {
        
        for(int i=0;i<sum.length;i++)
        {
            twoSum binary = new twoSum();
            int goal = value-sum[i];
            int answer = binary.search(sum, goal);
            if(answer!=-1&&sum[i]!=goal)
            {
                return new int [] {i,answer};
            }
            
        }
        return new int [] {-1,-1};
    }
    public static void main(String args[])
    {
        twoSum select = new twoSum();
        int[] numList = {5,5,2,4,3};
        select.sort(numList);
        for(int i=0;i<numList.length;i++)
        {
            System.out.print(numList[i]);
            System.out.print(" ");
        }
        System.out.println();
        int [] result = select.twoSum(numList,7);
        System.out.println("Index:"+ "["+ result[0]+ ","+result[1]+"]");
    }
}