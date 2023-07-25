package org.sp.app0724.openapi.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//open api 서버로부터 데이터 가져오기 
public class OpenDAO {
	
	public List selectAll() {
		List<Store> list = new ArrayList<Store>();
		
		//URL
		BufferedReader buffr =null;
		
		try {
			URL url=new URL("https://api.odcloud.kr/api/15052408/v1/uddi:611c5470-ad94-49e8-8f72-973732c56304?page=1&perPage=10&serviceKey=TPK6sq5VdCOFrijK99CmJHQCEVer9GwK4sxLvP6ED6dBExrBc6FO298QjQadJsw7C4sDZ8yBXJfsYZ%2FVT6LG0A%3D%3D");
			
			URLConnection ucon=url.openConnection();
			
			//웹서버에 요청을 시도할 수 있는 객체
			HttpURLConnection con=(HttpURLConnection)ucon;
			con.setRequestMethod("GET"); //Http 프로토콜에서 정해진 규칙 중 
			//서버로부터 데이터를 가져올때 사용하는 방식을 Get 방식이라 한다..
			InputStream is =con.getInputStream();
			buffr = new BufferedReader(new InputStreamReader(is));
			
			String data=null;
			
			StringBuilder sb=new StringBuilder();
			
			while(true) {
				data = buffr.readLine();
				if(data==null)break;
				sb.append(data);
			}
			//System.out.println(sb.toString());
			
			//sb 모아진 문자열은 말그대로 문자열일 뿐이지, JSON 객체는 아니다..
			//하지만, 파싱을 수행하고 나면 객체처럼 취급할 수 있다.. 
			JSONParser jsonParser=new JSONParser(); //파서 인스턴스 생성 
			JSONObject obj=(JSONObject)jsonParser.parse(sb.toString());//파싱 시도
			
			System.out.println(obj.get("currentCount"));
			
			JSONArray array=(JSONArray)obj.get("data");
			
			for(int i=0;i<array.size();i++) {
				JSONObject json=(JSONObject)array.get(i);
				//json한건을 자바가 이해하는 객체의  표현방식인 DTO로 변환해보자 
				
				Store store = new Store(); //empty 상태의 인스턴스 생성 
				store.setLati(Double.parseDouble((String)json.get("위도"))); //
				store.setLongi(Double.parseDouble((String)json.get("경도")));
				store.setAddr((String)json.get("소재지(도로명)"));
				store.setName((String)json.get("업소명"));
				store.setType((String)json.get("업태"));
				store.setPhone((String)json.get("전화번호"));
				store.setMain((String)json.get("주취급음식"));
				
				list.add(store);
			}
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally {
			if(buffr!=null) {
				try {
					buffr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
		
	}
}
