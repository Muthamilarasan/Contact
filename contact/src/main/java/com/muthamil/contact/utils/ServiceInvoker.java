package com.muthamil.contact.utils;

import java.net.URI;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;



@Component
@EnableDiscoveryClient
public class ServiceInvoker {
	
	@Autowired
	RestTemplate restTemplate;

	public List<JSONObject> getContactList() {
		// TODO Auto-generated method stub
		
		//StringBuilder builder = new StringBuilder("/MYCONTACT/MYCONTACT/listall");
		
		//return (List<JSONObject>) restTemplate.getForObject("//MYCONTACT/listall", List.class);
		
		URI uri = UriComponentsBuilder.fromUriString("//mycontact/listall").build().toUri();
		
		System.out.println("aaaaaaaa" + uri.toString());
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("qqqq", "ttetttt");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		
		List<JSONObject> results = restTemplate.getForObject("//mycontact/listAll", List.class);
		
//		List<JSONObject> results = (List<JSONObject>) restTemplate.exchange(uri, HttpMethod.GET,entity, List.class).getBody();
//		return (List<JSONObject>) restTemplate.exchange(builder.toString(), HttpMethod.GET, entity, List.class);
		return results;
		//return restTemplate.exchange(builder.toString(), HttpMethod.GET, List.class);
	}
	
	
	

}
