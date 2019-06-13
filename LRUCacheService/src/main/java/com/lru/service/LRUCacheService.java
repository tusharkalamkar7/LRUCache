package com.lru.service;

import org.springframework.data.repository.Repository;

import com.lru.core.Node;
import com.lru.dto.NodeDTO;
/**
 * 
 * @author Tushar
 *
 */
public interface LRUCacheService extends Repository<Node,Integer>{
	
	public NodeDTO get(int key);
	
	public NodeDTO set(int key, int value);

}
