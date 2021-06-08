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
		
		// �ּ��� �ϳ��� ó���ذ��� �ǽ�

//		System.out.println("\n====================================\n");
//		// 1.1 Http Get ��� Request : JsonSimple lib ���
//		ProductRestHttpClientApp.getProductTest_JsonSimple();
//		
		System.out.println("\n====================================\n");
		// 1.2 Http Get ��� Request : CodeHaus lib ���
		ProductRestHttpClientApp.getProductTest_Codehaus();
		
//		System.out.println("\n====================================\n");
//		// 2.1 Http Post ��� Request : JsonSimple lib ���
//		ProductRestHttpClientApp.addProductTest_JsonSimple();
		
//		System.out.println("\n====================================\n");
//		// 2.2 Http Post ��� Request : CodeHaus lib ���
//		ProductRestHttpClientApp.addProductTest_Codehaus();		
		
//		System.out.println("\n====================================\n");
//		// 3.1 Http Get ��� Request : JsonSimple lib ���
//		ProductRestHttpClientApp.updateProductViewTest_JsonSimple();
		
//		System.out.println("\n====================================\n");
//		// 3.2 Http Get ��� Request : CodeHaus lib ���
//		ProductRestHttpClientApp.updateProductViewTest_Codehaus();
		
//		System.out.println("\n====================================\n");
//		// 4.1 Http Post ��� Request : JsonSimple lib ���
//		ProductRestHttpClientApp.updateProductTest_JsonSimple();
		
//		System.out.println("\n====================================\n");
//		// 4.2 Http Post ��� Request : CodeHaus lib ���
//		ProductRestHttpClientApp.updateProductTest_Codehaus();
		
//		System.out.println("\n====================================\n");
//		// 5.1 Http Post ��� Request : JsonSimple lib ���
//		ProductRestHttpClientApp.listProductTest_JsonSimple();
		
//		System.out.println("\n====================================\n");
//		// 5.2 Http Post ��� Request : CodeHaus lib ���
//		ProductRestHttpClientApp.listProductTest_Codehaus();
	
	}
	
	//============================== < GET - getProduct > ==================================//	

	
	//1.1 Http Protocol GET Request : JsonSimple 3rd party lib ���
	public static void getProductTest_JsonSimple() throws Exception{
		
		// HttpClient : Http Protocol �� client �߻�ȭ (=������ �ϳ� ����)
		HttpClient httpClient = new DefaultHttpClient();
		
		// Request URL Make (=�˻�â�� URL ġ��)
		String url= 	"http://127.0.0.1:8080/product/json/getProduct/10000";
				
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
	public static void getProductTest_Codehaus() throws Exception{
		
		// HttpClient : Http Protocol �� client �߻�ȭ (=������ �ϳ� ����)
		HttpClient httpClient = new DefaultHttpClient();
		
		// Request URL Make (=�˻�â�� URL ġ��)
		String url= 	"http://127.0.0.1:8080/product/json/getProduct/10000";

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
		Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
		System.out.println(product);
		
		//�� JSON CodeHaus�� JSONObject�� Domain ��ü�� Binding �ϴ� ����
	    //  - import org.json.simple.JSONObject;
	    //  - import org.json.simple.JSONValue;
		//  - import org.codehaus.jackson.map.ObjectMapper;
	}
	
	
	//============================== < POST - addProduct > ==================================//	
	
	
	//2.1 Http Protocol POST Request : FromData ���� / JsonSimple 3rd party lib ���
	public static void addProductTest_JsonSimple() throws Exception{
		
		// HttpClient : Http Protocol �� client �߻�ȭ (=������ �ϳ� ����)
		HttpClient httpClient = new DefaultHttpClient();
		
		// Request URL Make (=�˻�â�� URL ġ��)
		String url = "http://127.0.0.1:8080/product/json/addProduct";
		
		// HttpPost : Http Protocol �� Post ��� Request (=Post ������� Header ����)
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
		//==> Post ����� Body�� Data ����
		//==> QueryString ���� �������� �ʰ�, JSONData �� �����ϱ� ���� Data Make
		//[ ��� 2 : JSONObject ���]
		JSONObject json = new JSONObject();
		json.put("prodName", "test01");
		json.put("prodDetail", "test01");
		json.put("manuDate", "20210605");
		json.put("price", 5000);
		json.put("fileName", "test01");
		
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
	public static void addProductTest_Codehaus() throws Exception{
		
		// HttpClient : Http Protocol �� client �߻�ȭ (=������ �ϳ� ����)
		HttpClient httpClient = new DefaultHttpClient();
		
		// Request URL Make (=�˻�â�� URL ġ��)
		String url = "http://127.0.0.1:8080/product/json/addProduct";
		
		// HttpPost : Http Protocol �� Post ��� Request (=Post ������� Header ����)
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		
		//==> Post ����� Body�� Data ����
		//==> QueryString ���� �������� �ʰ�, JSONData �� �����ϱ� ���� Data Make	
		//[ ��� 3 : codehaus ���]
		//Domain Object instance 'product01' ���� �� ID/PW ����
		Product product01 =  new Product();
		product01.setProdName("test02");
		product01.setProdDetail("test02");
		product01.setManuDate("20210608");
		product01.setPrice(5000);
		product01.setFileName("test02");
		
		ObjectMapper objectMapper01 = new ObjectMapper();
		
		//Domain Object ==> JSON Value �� ��ȯ (������ JSON�̳� Type�� String)
		String jsonValue = objectMapper01.writeValueAsString(product01);
		
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
		Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
		System.out.println(product);
	}
	
	
	//============================== < GET - updateProductView > ==================================//	

	
	//3.1 Http Protocol GET Request : JsonSimple 3rd party lib ���
	public static void updateProductViewTest_JsonSimple() throws Exception{
			
		// HttpClient : Http Protocol �� client �߻�ȭ (=������ �ϳ� ����)
		HttpClient httpClient = new DefaultHttpClient();

		// Request URL Make (=�˻�â�� URL ġ��)
		String url = "http://127.0.0.1:8080/product/json/updateProductView/10000";

		// HttpGet : Http Protocol �� GET ��� Request (=GET ������� Header ����)
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json"); // �ְ�޴� �����ʹ� json���� ��
		httpGet.setHeader("Content-Type", "application/json");// application ��

		// HttpResponse : Http Protocol ���� Message �߻�ȭ (=���͸� ���� �����ϱ�)
		// httpGet ������ ������ ���� ���ڸ��� HttpResponse�� ���� (�ȿ� json ����)
		HttpResponse httpResponse = httpClient.execute(httpGet);

		// ==> Response ��� Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		////////////////////// ���ݺ��ʹ� ���� ��� �����ϱ� /////////////////////////

		// ==> Response �� entity(DATA) Ȯ�� (Response Header/Body �� Body �ޱ�)
		// ==> HttpEntity : Http Protocol Body �߻�ȭ Bean
		HttpEntity httpEntity = httpResponse.getEntity();

		// ==> Server���� ���� Data �б����� HttpEntity�� ���� InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println("serverData : " + serverData);

		// ==> �����б�(JSON Value Ȯ��)
		// ==> Server���� ���� JSONData�� JSONObject ��ü�� �ٲ���
		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println("jsonobj : " + jsonobj);

		// �� JSON Simple�� JSONValue�� JSONObject�� �ٲ��ִ� ����
		// - import org.json.simple.JSONObject;
		// - import org.json.simple.JSONValue;
	}
		
		
	//3.2 Http Protocol GET Request : JsonSimple + codehaus 3rd party lib ���
	public static void updateProductViewTest_Codehaus() throws Exception{
			
		// HttpClient : Http Protocol �� client �߻�ȭ (=������ �ϳ� ����)
		HttpClient httpClient = new DefaultHttpClient();

		// Request URL Make (=�˻�â�� URL ġ��)
		String url = "http://127.0.0.1:8080/product/json/updateProductView/10000";

		// HttpGet : Http Protocol �� GET ��� Request (=GET ������� Header ����)
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "application/json");
		httpGet.setHeader("Content-Type", "application/json");

		// HttpResponse : Http Protocol ���� Message �߻�ȭ (=���͸� ���� �����ϱ�)
		// httpGet ������ ������ ���� ���ڸ��� HttpResponse�� ���� (�ȿ� json ����)
		HttpResponse httpResponse = httpClient.execute(httpGet);

		// ==> Response ��� Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		////////////////////// ���ݺ��ʹ� ���� ��� �����ϱ� /////////////////////////

		// ==> Response �� entity(DATA) Ȯ�� (Response Header/Body �� Body �ޱ�)
		// ==> HttpEntity : Http Protocol Body �߻�ȭ Bean
		HttpEntity httpEntity = httpResponse.getEntity();

		// ==> Server���� ���� Data �б����� HttpEntity�� ���� InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		// ==> �ٸ� ������� serverData ó��
		// System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		// String serverData = br.readLine();
		// System.out.println(serverData);
		// JSONObject jsonobj = (JSONObject)JSONValue.parse(serverData);
		// System.out.println("jsonobj : " + jsonobj);

		// ==> API Ȯ�� : Stream ��ü�� ���� ����
		JSONObject jsonobj = (JSONObject) JSONValue.parse(br);
		System.out.println("jsonobj : " + jsonobj);
		System.out.println("jsonobj�� DataType : " + jsonobj.getClass() + "\n");
		System.out.println("jsonobj.toString() : " + jsonobj.toString());
		System.out.println("jsonobj.toString()�� DataType : " + jsonobj.toString().getClass() + "\n");

		// Server ���� ���� JSONData �� Domain Object �� Binding�ϱ�
		// 1. readValue() �޼��� ����� ���� ObjectMapper �ν��Ͻ� ����
		ObjectMapper objectMapper = new ObjectMapper();
		// 2. readValue( ��ȯ�� ���(String Type) , ��ȯ��ų Data Type )
		Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
		System.out.println(product);

		// �� JSON CodeHaus�� JSONObject�� Domain ��ü�� Binding �ϴ� ����
		// - import org.json.simple.JSONObject;
		// - import org.json.simple.JSONValue;
		// - import org.codehaus.jackson.map.ObjectMapper;
	}
		

	//============================== < POST - updateProduct > ==================================//	
	
	//4.1 Http Protocol POST Request : FromData ���� / JsonSimple 3rd party lib ���
	public static void updateProductTest_JsonSimple() throws Exception {

		// HttpClient : Http Protocol �� client �߻�ȭ (=������ �ϳ� ����)
		HttpClient httpClient = new DefaultHttpClient();

		// Request URL Make (=�˻�â�� URL ġ��)
		String url = "http://127.0.0.1:8080/product/json/updateProduct";

		// HttpPost : Http Protocol �� Post ��� Request (=Post ������� Header ����)
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		// ==> Post ����� Body�� Data ����
		// ==> QueryString ���� �������� �ʰ�, JSONData �� �����ϱ� ���� Data Make
		// [ ��� 2 : JSONObject ���]
		JSONObject json = new JSONObject();
		json.put("prodName", "test03");
		json.put("prodDetail", "test03");
		json.put("manuDate", "20210303");
		json.put("price", 3000);
		json.put("fileName", "test03");

		// ==> Request Header/Body �� Body ����� (JSON�� Body�� �ٿ� ����)
		// ==> HttpEntity : Http Protocol Body �߻�ȭ Bean
		HttpEntity httpEntity01 = new StringEntity(json.toString(), "utf-8");
		httpPost.setEntity(httpEntity01);

		// HttpResponse : Http Protocol ���� Message �߻�ȭ (=���͸� ���� �����ϱ�)
		// httpPost ������ ������ Request�� ���� ���ڸ��� HttpResponse�� ���� (�ȿ� json ����)
		HttpResponse httpResponse = httpClient.execute(httpPost);

		// ==> Response ��� Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		////////////////////// ���ݺ��ʹ� ���� ��� �����ϱ� /////////////////////////

		// ==> Response �� entity(DATA) Ȯ�� (Response Header/Body �� Body �ޱ�)
		// ==> HttpEntity : Http Protocol Body �߻�ȭ Bean
		HttpEntity httpEntity = httpResponse.getEntity();

		// ==> Server���� ���� Data �б����� HttpEntity�� ���� InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println("serverData : " + serverData);

		// ==> �����б�(JSON Value Ȯ��)
		// ==> Server���� ���� JSONData�� JSONObject ��ü�� �ٲ���
		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println("jsonobj : " + jsonobj);
	}
		
		
	// 4.2 Http Protocol POST ��� Request : FromData���� / JsonSimple + codehaus 3rd
	// party lib ���
	public static void updateProductTest_Codehaus() throws Exception {

		// HttpClient : Http Protocol �� client �߻�ȭ (=������ �ϳ� ����)
		HttpClient httpClient = new DefaultHttpClient();

		// Request URL Make (=�˻�â�� URL ġ��)
		String url = "http://127.0.0.1:8080/product/json/updateProduct";

		// HttpPost : Http Protocol �� Post ��� Request (=Post ������� Header ����)
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		// ==> Post ����� Body�� Data ����
		// ==> QueryString ���� �������� �ʰ�, JSONData �� �����ϱ� ���� Data Make
		// [ ��� 3 : codehaus ���]
		// Domain Object instance 'product01' ���� �� ID/PW ����
		Product product01 = new Product();
		product01.setProdName("test04");
		product01.setProdDetail("test04");
		product01.setManuDate("20210604");
		product01.setPrice(4000);
		product01.setFileName("test04");

		ObjectMapper objectMapper01 = new ObjectMapper();

		// Domain Object ==> JSON Value �� ��ȯ (������ JSON�̳� Type�� String)
		String jsonValue = objectMapper01.writeValueAsString(product01);

		// ==> Request Header/Body �� Body ����� (JSON�� Body�� �ٿ� ����)
		// ==> HttpEntity : Http Protocol Body �߻�ȭ Bean
		HttpEntity httpEntity01 = new StringEntity(jsonValue, "utf-8");
		httpPost.setEntity(httpEntity01);

		// HttpResponse : Http Protocol ���� Message �߻�ȭ (=���͸� ���� �����ϱ�)
		// httpPost ������ ������ Request�� ���� ���ڸ��� HttpResponse�� ���� (�ȿ� json ����)
		HttpResponse httpResponse = httpClient.execute(httpPost);

		// ==> Response ��� Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		////////////////////// ���ݺ��ʹ� ���� ��� �����ϱ� /////////////////////////

		// ==> Response �� entity(DATA) Ȯ�� (Response Header/Body �� Body �ޱ�)
		// ==> HttpEntity : Http Protocol Body �߻�ȭ Bean
		HttpEntity httpEntity = httpResponse.getEntity();

		// ==> Server���� ���� Data �б����� HttpEntity�� ���� InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		// ==> �ٸ� ������� serverData ó��
		// System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		// String serverData = br.readLine();
		// System.out.println(serverData);

		// ==> API Ȯ�� : Stream ��ü�� ���� ����
		JSONObject jsonobj = (JSONObject) JSONValue.parse(br);
		System.out.println("jsonobj : " + jsonobj);
		System.out.println("jsonobj�� DataType : " + jsonobj.getClass() + "\n");
		System.out.println("jsonobj.toString() : " + jsonobj.toString());
		System.out.println("jsonobj.toString()�� DataType : " + jsonobj.toString().getClass() + "\n");

		// Server ���� ���� JSONData �� Domain Object �� Binding�ϱ�
		// 1. readValue() �޼��� ����� ���� ObjectMapper �ν��Ͻ� ����
		ObjectMapper objectMapper = new ObjectMapper();
		// 2. readValue( ��ȯ�� ���(String Type) , ��ȯ��ų Data Type )
		Product product = objectMapper.readValue(jsonobj.toString(), Product.class);
		System.out.println(product);
	}
			
	
	//============================== < POST - listProduct > ==================================//	
	
	//4.1 Http Protocol POST Request : FromData ���� / JsonSimple 3rd party lib ���
	public static void listProductTest_JsonSimple() throws Exception {

		// HttpClient : Http Protocol �� client �߻�ȭ (=������ �ϳ� ����)
		HttpClient httpClient = new DefaultHttpClient();

		// Request URL Make (=�˻�â�� URL ġ��)
		String url = "http://127.0.0.1:8080/product/json/listProduct";

		// HttpPost : Http Protocol �� Post ��� Request (=Post ������� Header ����)
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		// ==> Post ����� Body�� Data ����
		// ==> QueryString ���� �������� �ʰ�, JSONData �� �����ϱ� ���� Data Make
		// [ ��� 2 : JSONObject ���]
		JSONObject json = new JSONObject();
		json.put("searchCondition", "1");
		json.put("searchKeyword", "������");

		// ==> Request Header/Body �� Body ����� (JSON�� Body�� �ٿ� ����)
		// ==> HttpEntity : Http Protocol Body �߻�ȭ Bean
		HttpEntity httpEntity01 = new StringEntity(json.toString(), "utf-8");
		httpPost.setEntity(httpEntity01);

		// HttpResponse : Http Protocol ���� Message �߻�ȭ (=���͸� ���� �����ϱ�)
		// httpPost ������ ������ Request�� ���� ���ڸ��� HttpResponse�� ���� (�ȿ� json ����)
		HttpResponse httpResponse = httpClient.execute(httpPost);

		// ==> Response ��� Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		////////////////////// ���ݺ��ʹ� ���� ��� �����ϱ� /////////////////////////

		// ==> Response �� entity(DATA) Ȯ�� (Response Header/Body �� Body �ޱ�)
		// ==> HttpEntity : Http Protocol Body �߻�ȭ Bean
		HttpEntity httpEntity = httpResponse.getEntity();

		// ==> Server���� ���� Data �б����� HttpEntity�� ���� InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		String serverData = br.readLine();
		System.out.println("serverData : " + serverData);

		// ==> �����б�(JSON Value Ȯ��)
		// ==> Server���� ���� JSONData�� JSONObject ��ü�� �ٲ���
		JSONObject jsonobj = (JSONObject) JSONValue.parse(serverData);
		System.out.println("jsonobj : " + jsonobj);
	}
			
			
	// 4.2 Http Protocol POST ��� Request : FromData���� / JsonSimple + codehaus 3rd
	// party lib ���
	public static void listProductTest_Codehaus() throws Exception {

		// HttpClient : Http Protocol �� client �߻�ȭ (=������ �ϳ� ����)
		HttpClient httpClient = new DefaultHttpClient();

		// Request URL Make (=�˻�â�� URL ġ��)
		String url = "http://127.0.0.1:8080/product/json/listProduct";

		// HttpPost : Http Protocol �� Post ��� Request (=Post ������� Header ����)
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");

		// ==> Post ����� Body�� Data ����
		// ==> QueryString ���� �������� �ʰ�, JSONData �� �����ϱ� ���� Data Make
		// [ ��� 3 : codehaus ���]
		// Domain Object instance 'product01' ���� �� ID/PW ����
		Search search01 = new Search();
		search01.setSearchCondition("");
		search01.setSearchKeyword("");
//		search01.setPageSize(5);
//		search01.setCurrentPage(1);

		ObjectMapper objectMapper01 = new ObjectMapper();

		// Domain Object ==> JSON Value �� ��ȯ (������ JSON�̳� Type�� String)
		String jsonValue = objectMapper01.writeValueAsString(search01);

		// ==> Request Header/Body �� Body ����� (JSON�� Body�� �ٿ� ����)
		// ==> HttpEntity : Http Protocol Body �߻�ȭ Bean
		HttpEntity httpEntity01 = new StringEntity(jsonValue, "utf-8");
		httpPost.setEntity(httpEntity01);

		// HttpResponse : Http Protocol ���� Message �߻�ȭ (=���͸� ���� �����ϱ�)
		// httpPost ������ ������ Request�� ���� ���ڸ��� HttpResponse�� ���� (�ȿ� json ����)
		HttpResponse httpResponse = httpClient.execute(httpPost);

		// ==> Response ��� Ȯ��
		System.out.println(httpResponse);
		System.out.println();

		////////////////////// ���ݺ��ʹ� ���� ��� �����ϱ� /////////////////////////

		// ==> Response �� entity(DATA) Ȯ�� (Response Header/Body �� Body �ޱ�)
		// ==> HttpEntity : Http Protocol Body �߻�ȭ Bean
		HttpEntity httpEntity = httpResponse.getEntity();

		// ==> Server���� ���� Data �б����� HttpEntity�� ���� InputStream ����
		InputStream is = httpEntity.getContent();
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

		// ==> �ٸ� ������� serverData ó��
		// System.out.println("[ Server ���� ���� Data Ȯ�� ] ");
		// String serverData = br.readLine();
		// System.out.println(serverData);

		// ==> API Ȯ�� : Stream ��ü�� ���� ����
		JSONObject jsonobj = (JSONObject) JSONValue.parse(br);
		System.out.println("jsonobj : " + jsonobj.get("list"));
//		System.out.println("jsonobj�� DataType : " + jsonobj.getClass() + "\n");
//		System.out.println("jsonobj.toString() : " + jsonobj.toString());
//		System.out.println("jsonobj.toString()�� DataType : " + jsonobj.toString().getClass() + "\n");

		// Server ���� ���� JSONData �� Domain Object �� Binding�ϱ�
		// 1. readValue() �޼��� ����� ���� ObjectMapper �ν��Ͻ� ����
		//System.out.println(product);
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}