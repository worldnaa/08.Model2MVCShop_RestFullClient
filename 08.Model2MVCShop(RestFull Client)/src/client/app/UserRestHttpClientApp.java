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

import com.model2.mvc.service.domain.User;

public class UserRestHttpClientApp {
	
	// main Method
	public static void main(String[] args) throws Exception{
		
		// �ּ��� �ϳ��� ó���ذ��� �ǽ�

//		System.out.println("\n====================================\n");
//		// 1.1 Http Get ��� Request : JsonSimple lib ���
//		UserRestHttpClientApp.getUserTest_JsonSimple();
		
//		System.out.println("\n====================================\n");
//		// 1.2 Http Get ��� Request : CodeHaus lib ���
//		UserRestHttpClientApp.getUserTest_Codehaus();
		
//		System.out.println("\n====================================\n");
//		// 2.1 Http Post ��� Request : JsonSimple lib ���
//		UserRestHttpClientApp.LoginTest_JsonSimple();
		
//		System.out.println("\n====================================\n");
//		// 2.2 Http Post ��� Request : CodeHaus lib ���
//		UserRestHttpClientApp.LoginTest_Codehaus();
		
		System.out.println("\n====================================\n");
		// 3.1 Http Post ��� Request : JsonSimple lib ���
		UserRestHttpClientApp.addUserTest_JsonSimple();
		
//		System.out.println("\n====================================\n");
//		// 3.2 Http Post ��� Request : CodeHaus lib ���
//		UserRestHttpClientApp.addUserTest_Codehaus();		
	
	}
	
	//============================== < GET - getUser > ==================================//	

	//1.1 Http Protocol GET Request : JsonSimple 3rd party lib ���
	public static void getUserTest_JsonSimple() throws Exception{
		
		// HttpClient : Http Protocol �� client �߻�ȭ (=������ �ϳ� ����)
		HttpClient httpClient = new DefaultHttpClient();
		
		// Request URL Make (=�˻�â�� URL ġ��)
		String url= 	"http://127.0.0.1:8080/user/json/getUser/admin";
				
		// HttpGet : Http Protocol �� GET ��� Request (=GET ������� Header ����)
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");      //�ְ�޴� �����ʹ� json���� ��
		httpGet.setHeader("Content-Type", "application/json");//application ��
		
		// HttpResponse : Http Protocol ���� Message �߻�ȭ (=���͸� ���� �����ϱ�)
		// httpGet ������ ������ ���� ���ڸ��� HttpResponse�� ���� (�ȿ� json ����) 
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		//==> Response ��� Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		////////////////////// ���ݺ��ʹ� ���� ��� �����ϱ� /////////////////////////
		
		//==> Response �� entity(DATA) Ȯ�� (Response Header/Body �� Body �ޱ�)
		//==> HttpEntity : Http Protocol Body �߻�ȭ Bean
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> Server���� ���� Data �б����� HttpEntity�� ���� InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println("serverData : " + serverData);
		
		//==> �����б�(JSON Value Ȯ��)
		//==> Server���� ���� JSONData�� JSONObject ��ü�� �ٲ��� 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println("jsonobj : " + jsonobj);
		
		//�� JSON Simple�� JSONValue�� JSONObject�� �ٲ��ִ� ����
		//  - import org.json.simple.JSONObject;
		//  - import org.json.simple.JSONValue;
	}
	
	
	//1.2 Http Protocol GET Request : JsonSimple + codehaus 3rd party lib ���
	public static void getUserTest_Codehaus() throws Exception{
		
		// HttpClient : Http Protocol �� client �߻�ȭ (=������ �ϳ� ����)
		HttpClient httpClient = new DefaultHttpClient();
		
		// Request URL Make (=�˻�â�� URL ġ��)
		String url= 	"http://127.0.0.1:8080/user/json/getUser/admin";

		// HttpGet : Http Protocol �� GET ��� Request (=GET ������� Header ����)
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");
		
		// HttpResponse : Http Protocol ���� Message �߻�ȭ (=���͸� ���� �����ϱ�)
		// httpGet ������ ������ ���� ���ڸ��� HttpResponse�� ���� (�ȿ� json ����) 
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		//==> Response ��� Ȯ��
		System.out.println(httpResponse);
		System.out.println();
		
		//////////////////////���ݺ��ʹ� ���� ��� �����ϱ� /////////////////////////

		//==> Response �� entity(DATA) Ȯ�� (Response Header/Body �� Body �ޱ�)
		//==> HttpEntity : Http Protocol Body �߻�ȭ Bean
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> Server���� ���� Data �б����� HttpEntity�� ���� InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> �ٸ� ������� serverData ó�� 
		//System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);
		//JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		//System.out.println("jsonobj : " + jsonobj);
		
		//==> API Ȯ�� : Stream ��ü�� ���� ���� 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println("jsonobj : " + jsonobj);
		System.out.println("jsonobj�� DataType : " + jsonobj.getClass() +"\n");
		System.out.println("jsonobj.toString() : " + jsonobj.toString());
		System.out.println("jsonobj.toString()�� DataType : " + jsonobj.toString().getClass() +"\n");
	
		//Server ���� ���� JSONData �� Domain Object �� Binding�ϱ�
		//1. readValue() �޼��� ����� ���� ObjectMapper �ν��Ͻ� ����
		ObjectMapper objectMapper = new ObjectMapper();
		//2. readValue( ��ȯ�� ���(String Type) , ��ȯ��ų Data Type )  
		User user = objectMapper.readValue(jsonobj.toString(), User.class);
		System.out.println(user);
		
		//�� JSON CodeHaus�� JSONObject�� Domain ��ü�� Binding �ϴ� ����
	    //  - import org.json.simple.JSONObject;
	    //  - import org.json.simple.JSONValue;
		//  - import org.codehaus.jackson.map.ObjectMapper;
	}
	
	//============================== < POST - Login > ==================================//	
	
	//2.1 Http Protocol POST Request : FromData ���� / JsonSimple 3rd party lib ���
	public static void LoginTest_JsonSimple() throws Exception{
		
		// HttpClient : Http Protocol �� client �߻�ȭ (=������ �ϳ� ����)
		HttpClient httpClient = new DefaultHttpClient();
		
		// Request URL Make (=�˻�â�� URL ġ��)
		String url = "http://127.0.0.1:8080/user/json/login";
		
		// HttpPost : Http Protocol �� Post ��� Request (=Post ������� Header ����)
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
		//==> Post ����� Body�� Data ����
		//==> QueryString ���� �������� �ʰ�, JSONData �� �����ϱ� ���� Data Make
		
		//[ ��� 1 : String ���]
//		String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//		HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
		
		//[ ��� 2 : JSONObject ���]
		JSONObject json = new JSONObject();
		json.put("userId", "admin");
		json.put("password", "1234");
		
		//==> Request Header/Body �� Body ����� (JSON�� Body�� �ٿ� ����)
		//==> HttpEntity : Http Protocol Body �߻�ȭ Bean
		HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
		httpPost.setEntity(httpEntity01);
		
		// HttpResponse : Http Protocol ���� Message �߻�ȭ (=���͸� ���� �����ϱ�)
		// httpPost ������ ������ Request�� ���� ���ڸ��� HttpResponse�� ���� (�ȿ� json ����)
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response ��� Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//////////////////////���ݺ��ʹ� ���� ��� �����ϱ� /////////////////////////		
		
		//==> Response �� entity(DATA) Ȯ�� (Response Header/Body �� Body �ޱ�)
		//==> HttpEntity : Http Protocol Body �߻�ȭ Bean
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> Server���� ���� Data �б����� HttpEntity�� ���� InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println("serverData : " + serverData);
		
		//==> �����б�(JSON Value Ȯ��)
		//==> Server���� ���� JSONData�� JSONObject ��ü�� �ٲ��� 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println("jsonobj : " + jsonobj);
	
	}
	
	
	//2.2 Http Protocol POST ��� Request : FromData���� / JsonSimple + codehaus 3rd party lib ���
	public static void LoginTest_Codehaus() throws Exception{
		
		// HttpClient : Http Protocol �� client �߻�ȭ (=������ �ϳ� ����)
		HttpClient httpClient = new DefaultHttpClient();
		
		// Request URL Make (=�˻�â�� URL ġ��)
		String url = "http://127.0.0.1:8080/user/json/login";
		
		// HttpPost : Http Protocol �� Post ��� Request (=Post ������� Header ����)
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
		//==> Post ����� Body�� Data ����
		//==> QueryString ���� �������� �ʰ�, JSONData �� �����ϱ� ���� Data Make
		
//		//[ ��� 1 : String ���]
//		String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//		HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
	
//		//[ ��� 2 : JSONObject ���]
//		JSONObject json = new JSONObject();
//		json.put("userId", "admin");
//		json.put("password", "1234");
//		HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
		
		//[ ��� 3 : codehaus ���]
		//Domain Object instance 'user01' ���� �� ID/PW ����
		User user01 =  new User();
		user01.setUserId("admin");
		user01.setPassword("1234");
		
		ObjectMapper objectMapper01 = new ObjectMapper();
		
		//Domain Object ==> JSON Value �� ��ȯ (������ JSON�̳� Type�� String)
		String jsonValue = objectMapper01.writeValueAsString(user01);
		
		//==> Request Header/Body �� Body ����� (JSON�� Body�� �ٿ� ����)
		//==> HttpEntity : Http Protocol Body �߻�ȭ Bean
		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
		httpPost.setEntity(httpEntity01);
		
		// HttpResponse : Http Protocol ���� Message �߻�ȭ (=���͸� ���� �����ϱ�)
		// httpPost ������ ������ Request�� ���� ���ڸ��� HttpResponse�� ���� (�ȿ� json ����)
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response ��� Ȯ��
		System.out.println(httpResponse);
		System.out.println();
		
		//////////////////////���ݺ��ʹ� ���� ��� �����ϱ� /////////////////////////

		//==> Response �� entity(DATA) Ȯ�� (Response Header/Body �� Body �ޱ�)
		//==> HttpEntity : Http Protocol Body �߻�ȭ Bean
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> Server���� ���� Data �б����� HttpEntity�� ���� InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> �ٸ� ������� serverData ó�� 
		//System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);
		
		//==> API Ȯ�� : Stream ��ü�� ���� ���� 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println("jsonobj : " + jsonobj);
		System.out.println("jsonobj�� DataType : " + jsonobj.getClass() +"\n");
		System.out.println("jsonobj.toString() : " + jsonobj.toString());
		System.out.println("jsonobj.toString()�� DataType : " + jsonobj.toString().getClass() +"\n");
		 
		//Server ���� ���� JSONData �� Domain Object �� Binding�ϱ�
		//1. readValue() �޼��� ����� ���� ObjectMapper �ν��Ͻ� ����
		ObjectMapper objectMapper = new ObjectMapper();
		//2. readValue( ��ȯ�� ���(String Type) , ��ȯ��ų Data Type )  
		User user = objectMapper.readValue(jsonobj.toString(), User.class);
		System.out.println(user);
	}
	
	//============================== < POST - addUser > ==================================//	
	
	//3.1 Http Protocol POST Request : FromData ���� / JsonSimple 3rd party lib ���
	public static void addUserTest_JsonSimple() throws Exception{
		
		// HttpClient : Http Protocol �� client �߻�ȭ (=������ �ϳ� ����)
		HttpClient httpClient = new DefaultHttpClient();
		
		// Request URL Make (=�˻�â�� URL ġ��)
		String url = "http://127.0.0.1:8080/user/json/addUser";
		
		// HttpPost : Http Protocol �� Post ��� Request (=Post ������� Header ����)
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
		//==> Post ����� Body�� Data ����
		//==> QueryString ���� �������� �ʰ�, JSONData �� �����ϱ� ���� Data Make
		
		//[ ��� 1 : String ���]
//		String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//		HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
		
		//[ ��� 2 : JSONObject ���]
		JSONObject json = new JSONObject();
		json.put("userId", "test02");
		json.put("userName", "test02");
		json.put("password", "0101");
		json.put("ssn", "1234567891234");
		json.put("phone", "010-0101-0101");
		json.put("addr", "����");
		json.put("email", "test01@naver.com");
		
		//==> Request Header/Body �� Body ����� (JSON�� Body�� �ٿ� ����)
		//==> HttpEntity : Http Protocol Body �߻�ȭ Bean
		HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
		httpPost.setEntity(httpEntity01);
		
		// HttpResponse : Http Protocol ���� Message �߻�ȭ (=���͸� ���� �����ϱ�)
		// httpPost ������ ������ Request�� ���� ���ڸ��� HttpResponse�� ���� (�ȿ� json ����)
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response ��� Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		//////////////////////���ݺ��ʹ� ���� ��� �����ϱ� /////////////////////////		
		
		//==> Response �� entity(DATA) Ȯ�� (Response Header/Body �� Body �ޱ�)
		//==> HttpEntity : Http Protocol Body �߻�ȭ Bean
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> Server���� ���� Data �б����� HttpEntity�� ���� InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println("serverData : " + serverData);
		
		//==> �����б�(JSON Value Ȯ��)
		//==> Server���� ���� JSONData�� JSONObject ��ü�� �ٲ��� 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		System.out.println("jsonobj : " + jsonobj);
	}
	
	
	//3.2 Http Protocol POST ��� Request : FromData���� / JsonSimple + codehaus 3rd party lib ���
	public static void addUserTest_Codehaus() throws Exception{
		
		// HttpClient : Http Protocol �� client �߻�ȭ (=������ �ϳ� ����)
		HttpClient httpClient = new DefaultHttpClient();
		
		// Request URL Make (=�˻�â�� URL ġ��)
		String url = "http://127.0.0.1:8080/user/json/login";
		
		// HttpPost : Http Protocol �� Post ��� Request (=Post ������� Header ����)
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
		//==> Post ����� Body�� Data ����
		//==> QueryString ���� �������� �ʰ�, JSONData �� �����ϱ� ���� Data Make
		
//		//[ ��� 1 : String ���]
//		String data =  "{\"userId\":\"admin\",\"password\":\"1234\"}";
//		HttpEntity httpEntity01 = new StringEntity(data,"utf-8");
	
//		//[ ��� 2 : JSONObject ���]
//		JSONObject json = new JSONObject();
//		json.put("userId", "admin");
//		json.put("password", "1234");
//		HttpEntity httpEntity01 = new StringEntity(json.toString(),"utf-8");
		
		//[ ��� 3 : codehaus ���]
		//Domain Object instance 'user01' ���� �� ID/PW ����
		User user01 =  new User();
		user01.setUserId("admin");
		user01.setPassword("1234");
		
		ObjectMapper objectMapper01 = new ObjectMapper();
		
		//Domain Object ==> JSON Value �� ��ȯ (������ JSON�̳� Type�� String)
		String jsonValue = objectMapper01.writeValueAsString(user01);
		
		//==> Request Header/Body �� Body ����� (JSON�� Body�� �ٿ� ����)
		//==> HttpEntity : Http Protocol Body �߻�ȭ Bean
		HttpEntity httpEntity01 = new StringEntity(jsonValue,"utf-8");
		httpPost.setEntity(httpEntity01);
		
		// HttpResponse : Http Protocol ���� Message �߻�ȭ (=���͸� ���� �����ϱ�)
		// httpPost ������ ������ Request�� ���� ���ڸ��� HttpResponse�� ���� (�ȿ� json ����)
		HttpResponse httpResponse = httpClient.execute(httpPost);
		
		//==> Response ��� Ȯ��
		System.out.println(httpResponse);
		System.out.println();
		
		//////////////////////���ݺ��ʹ� ���� ��� �����ϱ� /////////////////////////

		//==> Response �� entity(DATA) Ȯ�� (Response Header/Body �� Body �ޱ�)
		//==> HttpEntity : Http Protocol Body �߻�ȭ Bean
		HttpEntity httpEntity = httpResponse.getEntity();
		
		//==> Server���� ���� Data �б����� HttpEntity�� ���� InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		//==> �ٸ� ������� serverData ó�� 
		//System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		//String serverData = br.readLine();
		//System.out.println(serverData);
		
		//==> API Ȯ�� : Stream ��ü�� ���� ���� 
		JSONObject jsonobj = (JSONObject)JSONValue.parse(br);
		System.out.println("jsonobj : " + jsonobj);
		System.out.println("jsonobj�� DataType : " + jsonobj.getClass() +"\n");
		System.out.println("jsonobj.toString() : " + jsonobj.toString());
		System.out.println("jsonobj.toString()�� DataType : " + jsonobj.toString().getClass() +"\n");
		 
		//Server ���� ���� JSONData �� Domain Object �� Binding�ϱ�
		//1. readValue() �޼��� ����� ���� ObjectMapper �ν��Ͻ� ����
		ObjectMapper objectMapper = new ObjectMapper();
		//2. readValue( ��ȯ�� ���(String Type) , ��ȯ��ų Data Type )  
		User user = objectMapper.readValue(jsonobj.toString(), User.class);
		System.out.println(user);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}