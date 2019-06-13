
package com.lru.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lru.dto.NodeDTO;
import com.lru.service.LRUCacheService;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class LRUCacheController {
	
	@Autowired
	LRUCacheService service;
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<NodeDTO> get(@PathVariable("id") Integer id) { 
		NodeDTO dto = service.get(id);
		return new ResponseEntity<NodeDTO>(dto, new HttpHeaders(),
				dto != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/put/{id}", method = RequestMethod.PUT)
	public ResponseEntity<NodeDTO> addTransport(@PathVariable("id") Integer id,@RequestBody NodeDTO nodeDto) {
		NodeDTO dto = service.set(id, nodeDto.getValue());
		if(id == dto.getKey())
			dto = null;
		return new ResponseEntity<NodeDTO>(dto, HttpStatus.OK);
	}
	
	

}
