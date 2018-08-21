import java.util.ArrayList;

public class Ugly_Number {
	public static void main(String[] args) {
		Ugly_Number u =new Ugly_Number();
		int ugly=u.findUgly(15);
		System.out.println(ugly);
		
	}
	public int findUgly(int n) {
		int i=0,j=0,k=0;
		ArrayList<Integer> arr=new ArrayList<Integer>();
		arr.add(1);
		int l=0,min;
		for(l=1;l<n;l++) {
			min=smallest(i+1,j+1,k+1);
			if(min==2) {
				i++;
				if(arr.get(arr.size()-1)!=i*2)
					arr.add(i*2);
				else n++;
			}
			else if(min==3) {
				j++;
				if(arr.get(arr.size()-1)!=j*3)
					arr.add(j*3);
				else n++;
			}
			else {
				k++;
				if(arr.get(arr.size()-1)!=k*5)
					arr.add(k*5);
				else n++;
			}
			//System.out.print(arr.get(arr.size()-1)+" ");
			//System.out.print(min+" ");
		}
		
		return arr.get(arr.size()-1);
	}
	public int smallest(int i,int j, int k) {
		
		int min=-12345;
		if(i*2<j*3) {
			min=2;
			if(i*2>k*5) min=5;
		}
		else {
			min=3;
			if(j*3>k*5) min=5;
		}
		return min;
	}
}
