
public class Subset_Sum_OSUM_Space {
	public static void main(String[] args) {
		int A[]= {3,34,4,12,5,2};
		int sum=6;
		Subset_Sum_OSUM_Space s=new Subset_Sum_OSUM_Space();
		boolean b;
		b=s.OSUM_Space(A,sum);
		System.out.println(b);
	}
	public boolean OSUM_Space(int A[], int sum) {
		int i,j,k;
		boolean x,y;
		boolean out[][]=new boolean[2][sum+1];
		
		out[0][0]=true;
		out[0][1]=true;
		
		for(i=1;i<sum+1;i++) out[0][i]=false;
		
		for(i=1	;i<A.length+1;i++) {
			for(j=1;j<sum+1;j++) {
				if(j-A[i-1]<0) x=false;
				else x=out[(i+1)%2][j-A[i-1]];
				y=out[(i+1)%2][j];
				out[i%2][j]=x||y;
			}
			//for(k=0;k<sum+1;k++) System.out.print(out[i%2][k]+" ");
			//System.out.println();
		}
	
		return out[(i)%2][sum];
	}
}
