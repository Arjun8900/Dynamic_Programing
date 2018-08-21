
public class Coin_Exchange {
	public static void main(String[] args) {
		Coin_Exchange ce=new Coin_Exchange ();
		int i,j,n,V;
		int N[]= {1,2,7};
		n=N.length;
		V=12;
		int min=ce.Min_Coins(N, V);
		System.out.println(min);
	}
	public int Min_Coins(int[] N, int V) {
		int dp[][]=new int[V+1][N.length+1];
		int i,j;
		for(i=0;i<N.length+1;i++) {
			dp[0][i]=0;
		}
		for(i=0;i<V+1;i++) {
			dp[i][0]=0;
		}
		for(i=1;i<V+1;i++) {
			for(j=1;j<N.length+1;j++) {
				if(i<N[j-1]) {
					dp[i][j]=dp[i][j-1];
				}
				else if(i%N[j-1]==0) {
					dp[i][j]=i/N[j-1];
				}
				else {
					dp[i][j]=Math.min(1+dp[i-N[j-1]][j], dp[i][j-1]);
				}
				//System.out.print(dp[i][j]+" ");
			}
			//System.out.println();
			
		}
		return dp[V][N.length];
	}
}
