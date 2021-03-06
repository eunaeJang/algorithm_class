package array;
//배열 이진 탐색
//<search1 메소드 분석>
//search1 메소드는 배열 선형 탐색을 구현하였다.
//이 메소드 수행 시간을 점근적 분석하라.
//
//<search2 메소드 분석>
//search2 메소드는 배열 이진 탐색을 구현하였다.
//이 메소드의 수행 시간을 점근적 분석하라.
//
//<search3 메소드 구현>
//배열 이진 탐색을 재귀 호출로 구현하라.
//search2 메소드의 구현을 조금만 수정화면 재귀호출로 수정할 수 있다.

import java.util.Arrays;
import java.util.Random;

public class Example4 {

	static void swap(int[] a, int i, int j) {
		int t = a[j];
		a[j] = a[i];
		a[i] = t;
	}

	static void sort(int[] a) {
		for (int i = 0; i < a.length - 1; ++i)
			for (int j = i + 1; j < a.length; ++j)
				if (a[i] > a[j])
					swap(a, i, j);
	}

	static int search1(int[] a, int value) {
		for (int i = 0; i < a.length; ++i)
			if (a[i] == value) return i;
		return -1;
	}

	//O(logn)
	static int search2(int[] a, int value) {
		int start = 0;
		int end = a.length - 1;
		while (start <= end) {
			int middle = (start + end) / 2;
			if (a[middle] < value) start = middle + 1;
			else if (a[middle] > value) end = middle - 1;
			else return middle;
		}
		return -1;
	}

	static int search3(int[] a, int value) {
		return search3(a, value, 0, a.length-1);
	}

	static int search3(int[] a, int value, int start, int end) {
		int middle = (start + end) / 2;
		
		if(start > end) return -1;
		
		if (a[middle] < value) start = middle + 1;
		else if (a[middle] > value) end = middle - 1;
		else return middle;
		
		return search3(a,value,start,end);

	}

	public static void main(String[] args) {
		Random random = new Random();
		int[] a = new int[10];
		for (int i = 0; i < a.length; ++i)
			a[i] = random.nextInt(20);

		sort(a);
		System.out.println(Arrays.toString(a));

		for (int i = 0; i < 30; ++i) {
			int value = random.nextInt(20);
			int i1 = search1(a, value);
			int i2 = search2(a, value);
			int i3 = search3(a, value);
			if ((i1 == -1 && i2 == -1 && i3 == -1) ||
					(value == a[i1] && value == a[i2] && value == a[i3])) {
				System.out.printf("Ok: value=%d, i1=%d, i2=%d i3=%d\n", value, i1, i2, i3);
			} else {
				System.out.printf("Error: value=%d, i1=%d, i2=%d i3=%d\n", value, i1, i2, i3);
				break;
			}
		}

		System.out.println("done");
	}
}

