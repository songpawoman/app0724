package org.sp.app0724.openapi.xml;

public class ParseTest {
	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder();

		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<man>");
		sb.append("<name>철수</name>");
		sb.append("<age>28</age>");
		sb.append("<children>");
		sb.append("<pet>");
		sb.append("<type>고양이</type>");			
		sb.append("<age>2</age>	");		
		sb.append("<name>나비</name>");			
		sb.append("<color>검정</color>");			
		sb.append("</pet>");
		sb.append("<pet>");
		sb.append("<type>강아지</type>");			
		sb.append("<age>5</age>	");		
		sb.append("<name>뽀미</name>");			
		sb.append("<color>흰색</color>");			
		sb.append("</pet>");
		sb.append("</children>");
		sb.append("</man>");		
		
		System.out.println(sb.toString());
		
		//위의 xml 은 문자에 불과하므로, 의미있는 데이터를 접근하려면 파싱 과정이 필요하다 
		//XML은 json.보다 앞서 고전적으로 사용해왔던 포맷이므로, java기본 api에 xml파서가 
		//포함되어 있다... 
		
		//XML을 파싱하는 방법은 크게 2가지 방식이 있다. 
		
		//1) DOM 방식
		
		//2) SAX 방식 
		
	}
}










