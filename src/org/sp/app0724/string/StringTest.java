package org.sp.app0724.string;
/*
 *  String 수정될 수 없다. 즉 문자열 상수로 본다 
 *  수정될 수 없으므로, 다수의 문자열 처리시 주의해야 함 
 * */
public class StringTest {
	public static void main(String[] args) {
		String s1=new String("apple"); //명시적
		String s2=new String("apple");//명시적
		System.out.println(s1==s2);
		
		//암시적 - new 를 사용하지 않아도 인스턴스가 생성되었으므로, 
		//        즉 new 를 명시하지 않고 인스턴스를 생성했다고 묵시적,암시적
		//        생성법
		
		
		//암시적 생성법으로  String 객체의 인스턴스를 생성하면, 힙영역의 
		//Constant Pool에 생성되므로, 중복된 문자열 상수는 생성되지 않고
		//기존의 것을 이용한다...
		String m1="korea";
		String m2="korea";
		System.out.println(m1==m2); //두 레퍼런스 변수가 같은 문
		//자열 상수를 가리키므로, 즉 같은 주소를 가리키고 있다..
		
		System.out.println(m1.equals(m2));
		
		
		
	}
}





