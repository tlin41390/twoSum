public class twoSum{
    //Moves the order of the numbers in a list.
    public void swap(int [] numList , int num1, int num2 )
    {
        int temp = numList[num1];
        numList[num1]=numList[num2];
        numList[num2]=temp;
    }
    //Finds the smallest value in an array.
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
    //This method will go through the array and then order the array from smallest number to greatest number.
    public void sort(int [] numList)

    {
        //will find the smallest number and then move it around.
        for(int i =0;i<numList.length-1;i++)
        {
            swap(numList,i,findSmallest(numList,i));
        }   
    }
    //This program invokes binarySearch to find the value in a array.
    public int search(int [] sum, int value)
    {
        return binarySearch(sum, 0, sum.length-1,value);
    }
    public int binarySearch(int[] sum, int lowerBound, int upperBound, int value)
    {
        //if the number is not there, then return -1.
        if(lowerBound>upperBound)
        {
            return -1;
        }
        int midPoint = (lowerBound+upperBound)/2;
        //returns the midpoint if it equals to the goal.
        if(sum[midPoint] == value)
        {
            return midPoint;
        }
        //will use recursion to invoke binary search if midpoint was not the target value.
        else if(value>sum[midPoint])
        {
            return binarySearch(sum,midPoint+1,upperBound,value);
        }
        else 
        {
            return binarySearch(sum,lowerBound,midPoint-1,value);
        }
    }
    //program that will find the two indexes that will solve the sum.
    public int [] twoSum(int [] sum, int value)
    {
        
        for(int i=0;i<sum.length;i++)
        {
            twoSum binary = new twoSum();
            //the goal will be the sum minus the first value of an array. If no result, then move on to next number in array.
            int goal = value-sum[i];
            //will try to find other index of value that will make up the sum.
            int answer = binary.search(sum, goal);
            if(answer!=-1&&sum[i]!=goal)
            {
                return new int [] {i,answer};
            }
            
        }
        //will return this if there is no numbers that will make up the sum
        return new int [] {-1,-1};
    }
    public static void main(String args[])
    {
        twoSum select = new twoSum();
        int[] numList = {5,5,2,4,3};
        select.sort(numList);
        //prints out list of numbers.
        for(int i=0;i<numList.length;i++)
        {
            System.out.print(numList[i]);
            System.out.print(" ");
        }
        System.out.println();
        //will try to find the two indexes that make up the number.
        int [] result = select.twoSum(numList,7);
        System.out.println("Index:"+ "["+ result[0]+ ","+result[1]+"]");
    }
}
