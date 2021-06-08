package client.app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.User;

public class ProductRestHttpClientApp {
	
	// main Method
	public static void main(String[] args) throws Exception{
		
		// 주석을 하나씩 처리해가며 실습

//		System.out.println("\n====================================\n");
//		// 1.1 Http Get 방식 Request : JsonSimple lib 사용
//		ProductRestHttpClientApp.getProductTest_JsonSimple();
//		
		System.out.println("\n====================================\n");
		// 1.2 Http Get 방식 Request : CodeHaus lib 사용
		ProductRestHttpClientApp.getProductTest_Codehaus();
		
//		System.out.println("\n====================================\n");
//		// 2.1 Http Post 방식 Request : JsonSimple lib 사용
//		ProductRestHttpClientApp.addProductTest_JsonSimple();
		
//		System.out.println("\n====================================\n");
//		// 2.2 Http Post 방식 Request : CodeHaus lib 사용
//		ProductRestHttpClientApp.addProductTest_Codehaus();		
		
//		System.out.println("\n====================================\n");
//		// 3.1 Http Get 방식 Request : JsonSimple lib 사용
//		ProductRestHttpClientApp.updateProductViewTest_JsonSimple();
		
//		System.out.println("\n====================================\n");
//		// 3.2 Http Get 방식 Request : CodeHaus lib 사용
//		ProductRestHttpClientApp.updateProductViewTest_Codehaus();
		
//		System.out.println("\n====================================\n");
//		// 4.1 Http Post 방식 Request : JsonSimple lib 사용
//		ProductRestHttpClientApp.updateProductTest_JsonSimple();
		
//		System.out.println("\n====================================\n");
//		// 4.2 Http Post 방식 Request : CodeHaus lib 사용
//		ProductRestHttpClientApp.updateProductTest_Codehaus();
		
//		System.out.println("\n====================================\n");
//		// 5.1 Http Post 방식 Request : JsonSimple lib 사용
//		ProductRestHttpClientApp.listProductTest_JsonSimple();
		
//		System.out.println("\n====================================\n");
//		// 5.2 Http Post 방식 Request : CodeHaus lib 사용
//		ProductRestHttpClientApp.listProductTest_Codehaus();
	
	}
	
	//============================== < GET - getProduct > ==================================//	

	
	//1.1 Http Protocol GET Request : JsonSimple 3rd party lib 사용
	public static void getProductTest_JsonSimple() throws Exception{
		
		// HttpClient : Http Protocol 의 client 추상화 (=브라우저 하나 열기)
		HttpClient httpClient = new DefaultHttpClient();
		
		// Request URL Make (=검색창에 URL 치기)
		String url= 	"http://127.0.0.1:8080/product/json/getProduct/10000";
				
		// HttpGet : Http Protocol 의 GET 방식 Request (=GET 방식으로 Header 구성)
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");      //주고받는 데이터는 json으로 함
		httpGet.setHeader("Content-Type", "application/json");//application 임
		
		// HttpResponse : Http Protocol 응답 Message 추상화 (=엔터를 눌러 실행하기)
		// httpGet 정보를 가지고 실행 하자마자 HttpResponse로 받음 (안에 json 있음) 
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		//==> Response 출력 확인
		System.out.println(httpResponse);
		System.out.println();

		////////////////////// 지금부터는 받은 결과 조작하기 /////////////////////////
		
		//==> Response 중 entity(DATA) 확인 (Response Header/Body 중 Body 받기)
		//==> HttpEntity : Http Protocol Body 추상화 Bean
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> Server에서 받은 Data 읽기위해 HttpEntity로 부터 InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println("serverData : " + serverData);
		
		//==> 내용읽기(JSON Value 확인)
		//==> Server에서 받은 JSONData를 JSONObject 객체로 바꿔줌 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println("jsonobj : " + jsonobj);
		
		//★ JSON Simple은 JSONValue를 JSONObject로 바꿔주는 역할
		//  - import org.json.simple.JSONObject;
		//  - import org.json.simple.JSONValue;
	}
	
	
	//1.2 Http Protocol GET Request : JsonSimple + codehaus 3rd party lib 사용
	public static void getProductTest_Codehaus() throws Exception{
		
		// HttpClient : Http Protocol 의 client 추상화 (=브라우저 하나 열기)
		HttpClient httpClient = new DefaultHttpClient();
		
		// Request URL Make (=검색창에 URL 치기)
		String url= 	"http://127.0.0.1:8080/product/json/getProduct/10000";

		// HttpGet : Http Protocol 의 GET 방식 Request (=GET 방식으로 Header 구성)
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol 응답 Message 추상화 (=엔터를 눌러 실행하기)
		// httpGet 정보를 가지고 실행 하자마자 HttpResponse로 받음 (안에 json 있음) 
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		//==> Response 출력 확인
		System.out.println(httpResponse);
		System.out.println();
		
		//////////////////////지금부터는 받은 결과 조작하기 /////////////////////////

		//==> Response 중 entity(DATA) 확인 (Response Header/Body 중 Body 받기)
		//==> HttpEntity : Http Protocol Body 추상화 Bean
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> Server에서 받은 Data 읽기위해 HttpEntity로 부터 InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> 다른 방법으로 serverData 처리 
		//System.out.println("[ Server 에서 받은 Data 확인 ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);
		//JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		//System.out.println("jsonobj : " + jsonobj);
		
		//==> API 확인 : Stream 객체를 직접 전달 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println("jsonobj : " + jsonobj);
		System.out.println("jsonobj의 DataType : " + jsonobj.getClass() +"\n");
		System.out.println("jsonobj.toString() : " + jsonobj.toString());
		System.out.println("jsonobj.toString()의 DataType : " + jsonobj.toString().getClass() +"\n");
	
		//Server 에서 받은 JSONData 를 Domain Object 로 Binding하기
		//1. readValue() 메서드 사용을 위해 ObjectMapper 인스턴스 생성
		ObjectMapper objectMapper = new ObjectMapper();
		//2. readValue( 변환할 대상(String Type) , 변환시킬 Data Type )  
		Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
		System.out.println(product);
		
		//★ JSON CodeHaus는 JSONObject를 Domain 객체로 Binding 하는 역할
	    //  - import org.json.simple.JSONObject;
	    //  - import org.json.simple.JSONValue;
		//  - import org.codehaus.jackson.map.ObjectMapper;
	}
	
	
	//============================== < POST - addProduct > ==================================//	
	
	
	//2.1 Http Protocol POST Request : FromData 전달 / JsonSimple 3rd party lib 사용
	public static void addProductTest_JsonSimple() throws Exception{
		
		// HttpClient : Http Protocol 의 client 추상화 (=브라우저 하나 열기)
		HttpClient httpClient = new DefaultHttpClient();
		
		// Request URL Make (=검색창에 URL 치기)
		String url = "http://127.0.0.1:8080/product/json/addProduct";
		
		// HttpPost : Http Protocol 의 Post 방식 Request (=Post 방식으로 Header 구성)
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
		//==> Post 방식은 Body에 Data 전송
		//==> QueryString 으로 전송하지 않고, JSONData 로 전송하기 위해 Data Make
		//[ 방법 2 : JSONObject 사용]
		JSONObject json = new JSONObject();
		json.put("prodName", "test01");
		json.put("prodDetail", "test01");
		json.put("manuDate", "20210605");
		json.put("price", 5000);
		json.put("fileName", "test01");
		
		//==> Request Header/Body 중 Body 만들기 (JSON을 Body에 붙여 보냄)
		//==> HttpEntity : Http Protocol Body 추상화 Bean
		HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
		httpPost.setEntity(httpEntity01);
		
		// HttpResponse : Http Protocol 응답 Message 추상화 (=엔터를 눌러 실행하기)
		// httpPost 정보를 가지고 Request를 실행 하자마자 HttpResponse로 받음 (안에 json 있음)
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response 출력 확인
		System.out.println(httpResponse);
		System.out.println();

		//////////////////////지금부터는 받은 결과 조작하기 /////////////////////////		
		
		//==> Response 중 entity(DATA) 확인 (Response Header/Body 중 Body 받기)
		//==> HttpEntity : Http Protocol Body 추상화 Bean
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> Server에서 받은 Data 읽기위해 HttpEntity로 부터 InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println("serverData : " + serverData);
		
		//==> 내용읽기(JSON Value 확인)
		//==> Server에서 받은 JSONData를 JSONObject 객체로 바꿔줌 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println("jsonobj : " + jsonobj);
	}
	
	
	//2.2 Http Protocol POST 방식 Request : FromData전달 / JsonSimple + codehaus 3rd party lib 사용
	public static void addProductTest_Codehaus() throws Exception{
		
		// HttpClient : Http Protocol 의 client 추상화 (=브라우저 하나 열기)
		HttpClient httpClient = new DefaultHttpClient();
		
		// Request URL Make (=검색창에 URL 치기)
		String url = "http://127.0.0.1:8080/product/json/addProduct";
		
		// HttpPost : Http Protocol 의 Post 방식 Request (=Post 방식으로 Header 구성)
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
		//==> Post 방식은 Body에 Data 전송
		//==> QueryString 으로 전송하지 않고, JSONData 로 전송하기 위해 Data Make	
		//[ 방법 3 : codehaus 사용]
		//Domain Object instance 'product01' 생성 후 ID/PW 셋팅
		Product product01 =  new Product();
		product01.setProdName("test02");
		product01.setProdDetail("test02");
		product01.setManuDate("20210608");
		product01.setPrice(5000);
		product01.setFileName("test02");
		
		ObjectMapper objectMapper01 = new ObjectMapper();
		
		//Domain Object ==> JSON Value 로 변환 (형식은 JSON이나 Type은 String)
		String jsonValue = objectMapper01.writeValueAsString(product01);
		
		//==> Request Header/Body 중 Body 만들기 (JSON을 Body에 붙여 보냄)
		//==> HttpEntity : Http Protocol Body 추상화 Bean
		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
		httpPost.setEntity(httpEntity01);
		
		// HttpResponse : Http Protocol 응답 Message 추상화 (=엔터를 눌러 실행하기)
		// httpPost 정보를 가지고 Request를 실행 하자마자 HttpResponse로 받음 (안에 json 있음)
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response 출력 확인
		System.out.println(httpResponse);
		System.out.println();
		
		//////////////////////지금부터는 받은 결과 조작하기 /////////////////////////

		//==> Response 중 entity(DATA) 확인 (Response Header/Body 중 Body 받기)
		//==> HttpEntity : Http Protocol Body 추상화 Bean
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> Server에서 받은 Data 읽기위해 HttpEntity로 부터 InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> 다른 방법으로 serverData 처리 
		//System.out.println("[ Server 에서 받은 Data 확인 ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);
		
		//==> API 확인 : Stream 객체를 직접 전달 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println("jsonobj : " + jsonobj);
		System.out.println("jsonobj의 DataType : " + jsonobj.getClass() +"\n");
		System.out.println("jsonobj.toString() : " + jsonobj.toString());
		System.out.println("jsonobj.toString()의 DataType : " + jsonobj.toString().getClass() +"\n");
		 
		//Server 에서 받은 JSONData 를 Domain Object 로 Binding하기
		//1. readValue() 메서드 사용을 위해 ObjectMapper 인스턴스 생성
		ObjectMapper objectMapper = new ObjectMapper();
		//2. readValue( 변환할 대상(String Type) , 변환시킬 Data Type )  
		Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
		System.out.println(product);
	}
	
	
	//============================== < GET - updateProductView > ==================================//	

	
	//3.1 Http Protocol GET Request : JsonSimple 3rd party lib 사용
	public static void updateProductViewTest_JsonSimple() throws Exception{
			
		// HttpClient : Http Protocol 의 client 추상화 (=브라우저 하나 열기)
		HttpClient httpClient = new DefaultHttpClient();

		// Request URL Make (=검색창에 URL 치기)
		String url = "http://127.0.0.1:8080/product/json/updateProductView/10000";

		// HttpGet : Http Protocol 의 GET 방식 Request (=GET 방식으로 Header 구성)
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json"); // 주고받는 데이터는 json으로 함
		httpGet.setHeader("Content-Type", "application/json");// application 임

		// HttpResponse : Http Protocol 응답 Message 추상화 (=엔터를 눌러 실행하기)
		// httpGet 정보를 가지고 실행 하자마자 HttpResponse로 받음 (안에 json 있음)
		HttpResponse httpResponse = httpClient.execute(httpGet);

		// ==> Response 출력 확인
		System.out.println(httpResponse);
		System.out.println();

		////////////////////// 지금부터는 받은 결과 조작하기 /////////////////////////

		// ==> Response 중 entity(DATA) 확인 (Response Header/Body 중 Body 받기)
		// ==> HttpEntity : Http Protocol Body 추상화 Bean
		HttpEntity httpEntity = httpResponse.getEntity();

		// ==> Server에서 받은 Data 읽기위해 HttpEntity로 부터 InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println("serverData : " + serverData);

		// ==> 내용읽기(JSON Value 확인)
		// ==> Server에서 받은 JSONData를 JSONObject 객체로 바꿔줌
		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println("jsonobj : " + jsonobj);

		// ★ JSON Simple은 JSONValue를 JSONObject로 바꿔주는 역할
		// - import org.json.simple.JSONObject;
		// - import org.json.simple.JSONValue;
	}
		
		
	//3.2 Http Protocol GET Request : JsonSimple + codehaus 3rd party lib 사용
	public static void updateProductViewTest_Codehaus() throws Exception{
			
		// HttpClient : Http Protocol 의 client 추상화 (=브라우저 하나 열기)
		HttpClient httpClient = new DefaultHttpClient();

		// Request URL Make (=검색창에 URL 치기)
		String url = "http://127.0.0.1:8080/product/json/updateProductView/10000";

		// HttpGet : Http Protocol 의 GET 방식 Request (=GET 방식으로 Header 구성)
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol 응답 Message 추상화 (=엔터를 눌러 실행하기)
		// httpGet 정보를 가지고 실행 하자마자 HttpResponse로 받음 (안에 json 있음)
		HttpResponse httpResponse = httpClient.execute(httpGet);

		// ==> Response 출력 확인
		System.out.println(httpResponse);
		System.out.println();

		////////////////////// 지금부터는 받은 결과 조작하기 /////////////////////////

		// ==> Response 중 entity(DATA) 확인 (Response Header/Body 중 Body 받기)
		// ==> HttpEntity : Http Protocol Body 추상화 Bean
		HttpEntity httpEntity = httpResponse.getEntity();

		// ==> Server에서 받은 Data 읽기위해 HttpEntity로 부터 InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		// ==> 다른 방법으로 serverData 처리
		// System.out.println("[ Server 에서 받은 Data 확인 ] ");
		// String serverData = br.readLine();
		// System.out.println(serverData);
		// JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		// System.out.println("jsonobj : " + jsonobj);

		// ==> API 확인 : Stream 객체를 직접 전달
		JSONObject jsonobj = (JSONObject) JSONValue.parse(br);
		System.out.println("jsonobj : " + jsonobj);
		System.out.println("jsonobj의 DataType : " + jsonobj.getClass() + "\n");
		System.out.println("jsonobj.toString() : " + jsonobj.toString());
		System.out.println("jsonobj.toString()의 DataType : " + jsonobj.toString().getClass() + "\n");

		// Server 에서 받은 JSONData 를 Domain Object 로 Binding하기
		// 1. readValue() 메서드 사용을 위해 ObjectMapper 인스턴스 생성
		ObjectMapper objectMapper = new ObjectMapper();
		// 2. readValue( 변환할 대상(String Type) , 변환시킬 Data Type )
		Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
		System.out.println(product);

		// ★ JSON CodeHaus는 JSONObject를 Domain 객체로 Binding 하는 역할
		// - import org.json.simple.JSONObject;
		// - import org.json.simple.JSONValue;
		// - import org.codehaus.jackson.map.ObjectMapper;
	}
		

	//============================== < POST - updateProduct > ==================================//	
	
	//4.1 Http Protocol POST Request : FromData 전달 / JsonSimple 3rd party lib 사용
	public static void updateProductTest_JsonSimple() throws Exception {

		// HttpClient : Http Protocol 의 client 추상화 (=브라우저 하나 열기)
		HttpClient httpClient = new DefaultHttpClient();

		// Request URL Make (=검색창에 URL 치기)
		String url = "http://127.0.0.1:8080/product/json/updateProduct";

		// HttpPost : Http Protocol 의 Post 방식 Request (=Post 방식으로 Header 구성)
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		// ==> Post 방식은 Body에 Data 전송
		// ==> QueryString 으로 전송하지 않고, JSONData 로 전송하기 위해 Data Make
		// [ 방법 2 : JSONObject 사용]
		JSONObject json = new JSONObject();
		json.put("prodName", "test03");
		json.put("prodDetail", "test03");
		json.put("manuDate", "20210303");
		json.put("price", 3000);
		json.put("fileName", "test03");

		// ==> Request Header/Body 중 Body 만들기 (JSON을 Body에 붙여 보냄)
		// ==> HttpEntity : Http Protocol Body 추상화 Bean
		HttpEntity httpEntity01 = new StringEntity(json.toString(), "utf-8");
		httpPost.setEntity(httpEntity01);

		// HttpResponse : Http Protocol 응답 Message 추상화 (=엔터를 눌러 실행하기)
		// httpPost 정보를 가지고 Request를 실행 하자마자 HttpResponse로 받음 (안에 json 있음)
		HttpResponse httpResponse = httpClient.execute(httpPost);

		// ==> Response 출력 확인
		System.out.println(httpResponse);
		System.out.println();

		////////////////////// 지금부터는 받은 결과 조작하기 /////////////////////////

		// ==> Response 중 entity(DATA) 확인 (Response Header/Body 중 Body 받기)
		// ==> HttpEntity : Http Protocol Body 추상화 Bean
		HttpEntity httpEntity = httpResponse.getEntity();

		// ==> Server에서 받은 Data 읽기위해 HttpEntity로 부터 InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println("serverData : " + serverData);

		// ==> 내용읽기(JSON Value 확인)
		// ==> Server에서 받은 JSONData를 JSONObject 객체로 바꿔줌
		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println("jsonobj : " + jsonobj);
	}
		
		
	// 4.2 Http Protocol POST 방식 Request : FromData전달 / JsonSimple + codehaus 3rd
	// party lib 사용
	public static void updateProductTest_Codehaus() throws Exception {

		// HttpClient : Http Protocol 의 client 추상화 (=브라우저 하나 열기)
		HttpClient httpClient = new DefaultHttpClient();

		// Request URL Make (=검색창에 URL 치기)
		String url = "http://127.0.0.1:8080/product/json/updateProduct";

		// HttpPost : Http Protocol 의 Post 방식 Request (=Post 방식으로 Header 구성)
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		// ==> Post 방식은 Body에 Data 전송
		// ==> QueryString 으로 전송하지 않고, JSONData 로 전송하기 위해 Data Make
		// [ 방법 3 : codehaus 사용]
		// Domain Object instance 'product01' 생성 후 ID/PW 셋팅
		Product product01 = new Product();
		product01.setProdName("test04");
		product01.setProdDetail("test04");
		product01.setManuDate("20210604");
		product01.setPrice(4000);
		product01.setFileName("test04");

		ObjectMapper objectMapper01 = new ObjectMapper();

		// Domain Object ==> JSON Value 로 변환 (형식은 JSON이나 Type은 String)
		String jsonValue = objectMapper01.writeValueAsString(product01);

		// ==> Request Header/Body 중 Body 만들기 (JSON을 Body에 붙여 보냄)
		// ==> HttpEntity : Http Protocol Body 추상화 Bean
		HttpEntity httpEntity01 = new StringEntity(jsonValue, "utf-8");
		httpPost.setEntity(httpEntity01);

		// HttpResponse : Http Protocol 응답 Message 추상화 (=엔터를 눌러 실행하기)
		// httpPost 정보를 가지고 Request를 실행 하자마자 HttpResponse로 받음 (안에 json 있음)
		HttpResponse httpResponse = httpClient.execute(httpPost);

		// ==> Response 출력 확인
		System.out.println(httpResponse);
		System.out.println();

		////////////////////// 지금부터는 받은 결과 조작하기 /////////////////////////

		// ==> Response 중 entity(DATA) 확인 (Response Header/Body 중 Body 받기)
		// ==> HttpEntity : Http Protocol Body 추상화 Bean
		HttpEntity httpEntity = httpResponse.getEntity();

		// ==> Server에서 받은 Data 읽기위해 HttpEntity로 부터 InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		// ==> 다른 방법으로 serverData 처리
		// System.out.println("[ Server 에서 받은 Data 확인 ] ");
		// String serverData = br.readLine();
		// System.out.println(serverData);

		// ==> API 확인 : Stream 객체를 직접 전달
		JSONObject jsonobj = (JSONObject) JSONValue.parse(br);
		System.out.println("jsonobj : " + jsonobj);
		System.out.println("jsonobj의 DataType : " + jsonobj.getClass() + "\n");
		System.out.println("jsonobj.toString() : " + jsonobj.toString());
		System.out.println("jsonobj.toString()의 DataType : " + jsonobj.toString().getClass() + "\n");

		// Server 에서 받은 JSONData 를 Domain Object 로 Binding하기
		// 1. readValue() 메서드 사용을 위해 ObjectMapper 인스턴스 생성
		ObjectMapper objectMapper = new ObjectMapper();
		// 2. readValue( 변환할 대상(String Type) , 변환시킬 Data Type )
		Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
		System.out.println(product);
	}
			
	
	//============================== < POST - listProduct > ==================================//	
	
	//4.1 Http Protocol POST Request : FromData 전달 / JsonSimple 3rd party lib 사용
	public static void listProductTest_JsonSimple() throws Exception {

		// HttpClient : Http Protocol 의 client 추상화 (=브라우저 하나 열기)
		HttpClient httpClient = new DefaultHttpClient();

		// Request URL Make (=검색창에 URL 치기)
		String url = "http://127.0.0.1:8080/product/json/listProduct";

		// HttpPost : Http Protocol 의 Post 방식 Request (=Post 방식으로 Header 구성)
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		// ==> Post 방식은 Body에 Data 전송
		// ==> QueryString 으로 전송하지 않고, JSONData 로 전송하기 위해 Data Make
		// [ 방법 2 : JSONObject 사용]
		JSONObject json = new JSONObject();
		json.put("searchCondition", "1");
		json.put("searchKeyword", "자전거");

		// ==> Request Header/Body 중 Body 만들기 (JSON을 Body에 붙여 보냄)
		// ==> HttpEntity : Http Protocol Body 추상화 Bean
		HttpEntity httpEntity01 = new StringEntity(json.toString(), "utf-8");
		httpPost.setEntity(httpEntity01);

		// HttpResponse : Http Protocol 응답 Message 추상화 (=엔터를 눌러 실행하기)
		// httpPost 정보를 가지고 Request를 실행 하자마자 HttpResponse로 받음 (안에 json 있음)
		HttpResponse httpResponse = httpClient.execute(httpPost);

		// ==> Response 출력 확인
		System.out.println(httpResponse);
		System.out.println();

		////////////////////// 지금부터는 받은 결과 조작하기 /////////////////////////

		// ==> Response 중 entity(DATA) 확인 (Response Header/Body 중 Body 받기)
		// ==> HttpEntity : Http Protocol Body 추상화 Bean
		HttpEntity httpEntity = httpResponse.getEntity();

		// ==> Server에서 받은 Data 읽기위해 HttpEntity로 부터 InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server 에서 받은 Data 확인 ] ");
		String serverData = br.readLine();
		System.out.println("serverData : " + serverData);

		// ==> 내용읽기(JSON Value 확인)
		// ==> Server에서 받은 JSONData를 JSONObject 객체로 바꿔줌
		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println("jsonobj : " + jsonobj);
	}
			
			
	// 4.2 Http Protocol POST 방식 Request : FromData전달 / JsonSimple + codehaus 3rd
	// party lib 사용
	public static void listProductTest_Codehaus() throws Exception {

		// HttpClient : Http Protocol 의 client 추상화 (=브라우저 하나 열기)
		HttpClient httpClient = new DefaultHttpClient();

		// Request URL Make (=검색창에 URL 치기)
		String url = "http://127.0.0.1:8080/product/json/listProduct";

		// HttpPost : Http Protocol 의 Post 방식 Request (=Post 방식으로 Header 구성)
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		// ==> Post 방식은 Body에 Data 전송
		// ==> QueryString 으로 전송하지 않고, JSONData 로 전송하기 위해 Data Make
		// [ 방법 3 : codehaus 사용]
		// Domain Object instance 'product01' 생성 후 ID/PW 셋팅
		Search search01 = new Search();
		search01.setSearchCondition("");
		search01.setSearchKeyword("");
//		search01.setPageSize(5);
//		search01.setCurrentPage(1);

		ObjectMapper objectMapper01 = new ObjectMapper();

		// Domain Object ==> JSON Value 로 변환 (형식은 JSON이나 Type은 String)
		String jsonValue = objectMapper01.writeValueAsString(search01);

		// ==> Request Header/Body 중 Body 만들기 (JSON을 Body에 붙여 보냄)
		// ==> HttpEntity : Http Protocol Body 추상화 Bean
		HttpEntity httpEntity01 = new StringEntity(jsonValue, "utf-8");
		httpPost.setEntity(httpEntity01);

		// HttpResponse : Http Protocol 응답 Message 추상화 (=엔터를 눌러 실행하기)
		// httpPost 정보를 가지고 Request를 실행 하자마자 HttpResponse로 받음 (안에 json 있음)
		HttpResponse httpResponse = httpClient.execute(httpPost);

		// ==> Response 출력 확인
		System.out.println(httpResponse);
		System.out.println();

		////////////////////// 지금부터는 받은 결과 조작하기 /////////////////////////

		// ==> Response 중 entity(DATA) 확인 (Response Header/Body 중 Body 받기)
		// ==> HttpEntity : Http Protocol Body 추상화 Bean
		HttpEntity httpEntity = httpResponse.getEntity();

		// ==> Server에서 받은 Data 읽기위해 HttpEntity로 부터 InputStream 생성
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		// ==> 다른 방법으로 serverData 처리
		// System.out.println("[ Server 에서 받은 Data 확인 ] ");
		// String serverData = br.readLine();
		// System.out.println(serverData);

		// ==> API 확인 : Stream 객체를 직접 전달
		JSONObject jsonobj = (JSONObject) JSONValue.parse(br);
		System.out.println("jsonobj : " + jsonobj.get("list"));
//		System.out.println("jsonobj의 DataType : " + jsonobj.getClass() + "\n");
//		System.out.println("jsonobj.toString() : " + jsonobj.toString());
//		System.out.println("jsonobj.toString()의 DataType : " + jsonobj.toString().getClass() + "\n");

		// Server 에서 받은 JSONData 를 Domain Object 로 Binding하기
		// 1. readValue() 메서드 사용을 위해 ObjectMapper 인스턴스 생성
		//System.out.println(product);
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}