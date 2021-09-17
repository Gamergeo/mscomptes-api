package com.project.mscomptes.business.api;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.mscomptes.model.Asset;
import com.project.mscomptes.model.AssetType;
import com.project.mscomptes.model.OHLC;
import com.project.mscomptes.technical.ApplicationException;

@Service("apiService")
public class ApiServiceImpl implements ApiService {
	
	@Override
	public List<OHLC> call(Asset asset) throws URISyntaxException, IOException {
		
		if (AssetType.CRYPTO.equals(asset.getType())) {
			return callCrypto(asset);
		} else {
			throw new ApplicationException("Non crypto pas encore implémenté");
		}
	}
	
	private List<OHLC> callCrypto(Asset asset) throws URISyntaxException, IOException {

		String pair = asset.getCode() + "eur";
		
		// TODO gerer bnb / beth
		String uri = "https://api.cryptowat.ch/markets/kraken/" + pair + "/ohlc";
		
	    List<NameValuePair> parameters = new ArrayList<NameValuePair>();
	    parameters.add(new BasicNameValuePair("periods","86400"));
	    
	    String result = call(uri, parameters);
	    
	    ObjectMapper mapper = new ObjectMapper();
		JsonNode resultNode = mapper.readTree(result).findValue("86400");
		
		List<OHLC> ohlcList = new ArrayList<OHLC>();
		
		Iterator<JsonNode> iterator = resultNode.elements();
		
		while(iterator.hasNext()) {
			JsonNode line = iterator.next();
			
			OHLC ohlc = new OHLC(asset.getCode().toUpperCase());
			ohlc.setDate(line.get(0).asLong());
			ohlc.setOpenPrice(line.get(1).asDouble());
			ohlc.setHighPrice(line.get(2).asDouble());
			ohlc.setLowPrice(line.get(3).asDouble());
			ohlc.setClosePrice(line.get(4).asDouble());
			
			ohlcList.add(ohlc);
		}
		
		return ohlcList;
	}
	
	public String call(String uri, List<NameValuePair> parameters) throws URISyntaxException, IOException {
		return call(uri, parameters, null);
	}
	
	public String call(String uri, List<NameValuePair> parameters, String apiKey) throws URISyntaxException, IOException {
		 String response_content = "";
	
	    URIBuilder query = new URIBuilder(uri);
	    query.addParameters(parameters);

	    CloseableHttpClient client = HttpClients.createDefault();
	    HttpGet request = new HttpGet(query.build());

	    request.setHeader(HttpHeaders.ACCEPT, "application/json");
	    
	    if (!StringUtils.isEmpty(apiKey)) {
	    	request.addHeader("X-CMC_PRO_API_KEY", apiKey);
	    }

	    CloseableHttpResponse response = client.execute(request);

	    try {
	    	System.out.println(response.getStatusLine());
	    	HttpEntity entity = response.getEntity();
	    	response_content = EntityUtils.toString(entity);
	    	EntityUtils.consume(entity);
	    } finally {
	    	response.close();
	    }

	    return response_content;
	}

}
