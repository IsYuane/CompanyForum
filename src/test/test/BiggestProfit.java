package test;

public class BiggestProfit {
    public static int biggestProfit(int[] n){
        int profit=0,temp;
        for(int i=0;i<n.length;i++)
        {
            for(int j=i+1;j<n.length;j++)
            {
                temp = n[i] - n[j];
                if(temp>profit)
                    profit = temp;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] n = {7,5,2,4,1,2};
        System.out.println(biggestProfit(n));
    }
}
