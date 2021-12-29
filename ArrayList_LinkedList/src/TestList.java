import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestList {

	// ArrayList vs LinkedList
	// ArrayList 의 장점
	// 1. 배열구조라서 데이터를 읽는데 걸리는 시간이 짧다.
	// 단점
	// 1. 크기를 변경할 수 없다 -> 크기를 변경해야 하는경우 새로운 배열을 생성후 데이터를 복사해야함(메모리 낭비)
	// 2. 비순차적인 데이터의 추가 , 삭제에 시간이 많이 걸린다.
	// 데이터를 추가하거나 삭제하는데 다른 데이터를 옮겨야 함. 그러나 순차적인 데이터의 추가(끝에 추가 , 끝부터 삭제) 는 빠르다.
	
	// LinkedList 의 장점
	// 1. 배열의 단점을 보완
	// 불연속적으로 존재하는 데이터를 연결해줌
	// 데이터를 삭제하는데 한번의 참조변경으로만으로도 가능
	// 데이터를 추가하는데 한번의 Node객체생성과 두번의 참조변경만으로 가능
	
	// 단점
	// 데이터 접근성이 나쁘다 (단방향이기 때문에)
	// 이를 보완하기 위해 doubly linked list 를 사용
	// 여기서 더 보완한것이 doubly circular linked list 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 예제
		ArrayList al = new ArrayList(2000000);
		LinkedList ll = new LinkedList();
		
		
		System.out.println("= 순차적으로 추가하기 =");
		System.out.println("ArrayList : "+add1(al));
		System.out.println("LinkedList : "+add1(ll));
		System.out.println();
		
		System.out.println("= 중간에 추가하기 =");
		System.out.println("ArrayList : "+add2(al));
		System.out.println("LinkedList : "+add2(ll));
		System.out.println();
		
		System.out.println("= 중간에서 삭제하기 =");
		System.out.println("ArrayList : "+remove2(al));
		System.out.println("LinkedList : "+remove2(ll));
		System.out.println();
		
		System.out.println("= 순차적으로 삭제하기 =");
		System.out.println("ArrayList : "+remove1(al));
		System.out.println("LinkedList : "+remove1(ll));
		System.out.println();
		
	}

	private static long remove1(List list) {
		long start = System.currentTimeMillis();
		for(int i= list.size()-1 ; i>= 0 ; i--)
			list.remove(i);
		long end = System.currentTimeMillis();
		return end - start;
	}

	private static long remove2(List list) {
		long start = System.currentTimeMillis();
		for(int i=0; i<10000; i++)
			list.remove(i);
		long end = System.currentTimeMillis();
		return end - start;
	}

	private static long add2(List list) {
		long start = System.currentTimeMillis();
		for(int i = 0; i< 10000; i++)
			list.add(500 , "X");
		long end = System.currentTimeMillis();
		return end - start;
	}

	private static long add1(List list) {
		long start = System.currentTimeMillis();
		for(int i =0; i<1000000; i++) {
			list.add(i+"");
		}
		long end = System.currentTimeMillis();
		return end - start;
	}

}
