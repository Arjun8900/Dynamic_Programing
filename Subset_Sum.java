
public class Subset_Sum {
	public static void main(String[] args) {
		int A[]= {1,2,3,4,5};
		int sum=10;
		Subset_Sum s=new Subset_Sum();
		
		boolean b= s.subset_sum(A, sum);
		System.out.println(b);
	}
	public boolean subset_sum(int A[], int sum) {
		boolean out[][]=new boolean[A.length+1][sum+1];
		int i,j;
		boolean x,y;
		for(i=0;i<sum+1;i++) out[0][i]=false;
		for(i=0;i<A.length+1;i++) out[i][0]=true;
			for(i=1;i<A.length+1;i++) 
				for(j=1;j<sum+1;j++) {
				if(j-A[i-1] <0) x=false;
				else x=out[i-1][j-A[i-1]];
				y=out[i-1][j];
				out[i][j]=x|y;
			}
		
		for(i=0;i<A.length+1;i++) {
			//System.out.println();
			for(j=0;j<sum+1;j++) {
				//System.out.print(out[i][j]+" ");
			}
		}
		return out[A.length][sum];
	}
}
