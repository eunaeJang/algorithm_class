package array;

//static void insert(int[] a, int index, int value) 메소드를 구현하라.
//배열 a에서 index 위치 뒤의 값들을 한 칸씩 뒤로 밀고 (반복문으로 구현)
//index 위치에 value를 넣어라.
//출력 -> 0 1 2 3 4 -99 5 6 7 8

public class Example1 {

	static void print(int[] a) {
		for (int i : a)
			System.out.printf("%d ", i);
	}
	//<반복>
	//	static void insert(int[] a, int index, int value) {
	//
	//		for(int i = a.length-1; i > a.length - index; i --) {
	//			a[i] = a[i-1];
	//		}
	//		a[index] = value;
	//	}
	
	//<재귀>
	static void insert(int[] a, int index, int value) {
        insert(a, index, value, a.length-1);
    }
	static void insert(int[] a, int index, int value,int i) {
		if(a[index] == value) return;
		if(i != index) {
			a[i] = a[i-1];
			insert(a,index,value,i-1);
		}
			a[index] = value;
		
	}



	public static void main(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < a.length; ++i)
			a[i] = i;

		insert(a, 5, -99);
		

		print(a);
	}

}
