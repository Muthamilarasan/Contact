package com.muthamil.contact.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.muthamil.contact.utils.ServiceInvoker;

@RestController
@RequestMapping("Contact")
public class ContactController {
	
	@Autowired
	ServiceInvoker serviceInvoker;
	
	@RequestMapping(value = "/getAll", method=RequestMethod.GET)
	public ResponseEntity<List<JSONObject>> getContactList() {
		List<JSONObject> json = serviceInvoker.getContactList();
		return new ResponseEntity<List<JSONObject>>(json, HttpStatus.OK);
	}

}
