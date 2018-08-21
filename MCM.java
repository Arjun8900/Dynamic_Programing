
public class MCM {
	public static void main(String[] args) {
		MCM mcm=new MCM();
		int l[]= {2,3,5,20};
		int m[]= {3,5,20,1};
		int dp[][]=new int[l.length][l.length];
		int i,j;
		for(i=0;i<l.length;i++) {
			for(j=0;j<l.length;j++) {
				dp[i][j]=1234567;
			}
		}
		int min1=mcm.func(l,m,0,l.length-1,dp);
		int min2=mcm.dp_matrix(l,m,dp);
		System.out.println(min2);
		
	}
	public int func(int l[], int m[], int i, int j, int dp[][]) {
		if(i==j) return 0;
		int min=123456;
		if(dp[i][j]!=0) return dp[i][j];
		for(int k=i;k<j;k++) {
			min=Math.min(min,func(l,m,i,k,dp)+ func(l,m,k+1,j,dp));
			
		}
		System.out.println(min+l[i]*m[i]*m[j]);
		dp[i][j]=min + l[i]*m[i]*m[j];
		return dp[i][j];
	}
	public int dp_matrix(int l[], int m[], int dp[][]) {
		int i,j,k;
		for(i=l.length-1;i>=0;i--) {
			for(j=0;j<l.length;j++) {
				if(i==j) {
					dp[i][j]=0;
					continue;
				}
				if(i>j) continue;
				for(k=i;k<j;k++) {
					dp[i][j]=Math.min(dp[i][j], dp[i][k]+dp[k+1][j]);
					
				}
				dp[i][j]=dp[i][j] + l[i]*m[i]*m[j];
				
			}
		}
		
		return dp[0][l.length-1];
	}
}
