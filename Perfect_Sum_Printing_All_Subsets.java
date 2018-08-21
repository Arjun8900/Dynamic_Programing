import java.util.ArrayList;

public class Perfect_Sum_Printing_All_Subsets {
	public static void main(String[] args) {
		int A[]= {1,2,3,4,5};
		int sum=5;
		Perfect_Sum_Printing_All_Subsets s=new Perfect_Sum_Printing_All_Subsets();
		
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
			System.out.println();
			for(j=0;j<sum+1;j++) {
				System.out.print(out[i][j]+" ");
			}
		}
		if(out[A.length][sum]==false) return false;
		
		ArrayList<Integer> temp=new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> o=new ArrayList<ArrayList<Integer>>();
		printSubsets(A, sum,A.length-1, out,temp,o);
		for(i=0;i<o.size();i++) {
			for(j=0;j<o.get(i).size();j++) {
				System.out.print(o.get(i).get(j)+" ");
			}
			System.out.println("as");
		}
		return out[A.length][sum];
	}
	public void printSubsets(int A[], int sum, int i, boolean[][] out,ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> o) {
		if(i==0 && sum==0) {
			o.add(new ArrayList<Integer>(temp));
			return;
		}
		if(i==0 && sum!=0 && out[i][sum]==true) {
			temp.add(A[i]);
			o.add(new ArrayList<Integer>(temp));
			return;
		}
		
		if(out[i-1][sum]==true) {
			temp.add(A[i]);
			printSubsets(A,sum,i-1,out,temp,o);
		}
		if(sum>=A[i] && out[i-1][sum-A[i]]==true) {
			//temp.add(A[i]);
			printSubsets(A,sum-A[i],i-1,out,temp,o);
		}
		//temp.remove(temp.size()-1);
		
	}
}
