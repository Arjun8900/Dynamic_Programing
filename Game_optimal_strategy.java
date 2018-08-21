
public class Game_optimal_strategy {
	public static void main(String[] args) {
		Game_optimal_strategy g=new Game_optimal_strategy();
		int arr[]= {2,2,2,2};

		int arr2[] = {10,34,15,32,56,77,87,132,75,89,23,67};
		int i=0,j=arr.length-1,sum;
		sum=g.my_func(arr2);
		System.out.println(sum);
	}
	public int my_func(int a[]) {
		int i=0,j=a.length-1;
		int sum=0;
		while(j>i+1) {
			if(a[i]+a[j-1] > a[i+1]+a[j]) {
				sum+=a[i];
				i++;
				if(a[i]>a[j])
					i++;
				else j--;
			}
			else {
				sum+=a[j];
				j--;
				if(a[i]>a[j])
					i++;
				else j--;
			}
		}
		if(a[i]>a[j])
			sum+=a[i];
		else sum+=a[j];
		return sum;
	}
	
}
