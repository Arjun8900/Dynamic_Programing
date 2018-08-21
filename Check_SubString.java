
public class Check_SubString {
	public static void main(String[] args) {
		Check_SubString cs=new Check_SubString();
		String s1="axy";
		String s2="yadxcy";
		boolean c=cs.check(s1,s2);
		System.out.println(c);
	}
	public boolean check(String s1, String s2) {
		int m=s1.length(),n=s2.length();
		
		int dp[][]=new int[m+1][n+1];
		int i,j;
		for(i=1;i<=m;i++) {
			for(j=i;j<=n;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1]+1;
				}
				else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		if(dp[m][n]==m)
			return true;
		return false;
	}
}
