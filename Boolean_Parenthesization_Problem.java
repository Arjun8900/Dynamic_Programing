import java.util.ArrayList;

public class Boolean_Parenthesization_Problem {
	public static void main(String[] args) {
		Boolean_Parenthesization_Problem b=new Boolean_Parenthesization_Problem ();
		char a1[]= {'T','F','T'};
		char a2[]= {'^','&'};
		ArrayList<Character> temp=new ArrayList<Character>();
		ArrayList<ArrayList<Character>> out=new ArrayList<ArrayList<Character>>();
		int A1[]=new int[a1.length];
		int A2[]=new int[a2.length];
		b.parenth(a1,a2,0,0,0,A1,A2,temp,out);
		for(int i=0;i<out.size();i++) {
			for(int j=0;j<out.get(i).size();j++) {
				System.out.print(out.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
	public void parenth(char a1[],char a2[],int i, int j,int x,int A1[], int A2[],ArrayList<Character> temp,ArrayList<ArrayList<Character>> out ) {
		if(i==a1.length) {
			out.add(new ArrayList<Character>(temp));
			return;
		}
		if(x==0) {
			for(int l=0;l<a1.length;l++) {
				if(A1[l]==1) continue;
				A1[l]=1;
				temp.add(a1[l]);
				parenth(a1,a2,i+1,j,1,A1,A2,temp,out);
				temp.remove(temp.size()-1);
				A1[l]=0;
			}
		}
		if(x==1) {
			for(int m=0;m<a2.length;m++) {
				if(A2[m]==1) continue;
				A2[m]=1;
				temp.add(a2[m]);
				parenth(a1,a2,i,j+1,0,A1,A2,temp,out);
				temp.remove(temp.size()-1);
				A2[m]=0;
			}
		}
	}
	
	
}
