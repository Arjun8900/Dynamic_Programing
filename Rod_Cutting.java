
public class Rod_Cutting {
	public static void main(String[] args) {
		int length[]= {1,2,3,4,5,6,7,8};
		int price[]= {1,5,8,9,10,17,17,20};
		Rod_Cutting rod=new Rod_Cutting();
		int dp[]=new int[length.length];
		int cost=rod.rodCostUtil(length.length,price, dp);
		System.out.println(cost);
		//for(int i=0;i<dp.length;i++) System.out.println(dp[i]+" ");
	}
	public int rodCostUtil(int n, int price[],int dp[]) {
		int max=-12345,i,x=0,y;
		if(n<=0) return 0;
		if(dp[n-1]!=0) return dp[n-1];
		for(i=1;i<=n;i++) {
			
			x=price[i-1]+rodCostUtil(n-i,price,dp);
			max=(int)Math.max(max, x);
		}

		dp[n-1]=max;
		return max;
	}
}
