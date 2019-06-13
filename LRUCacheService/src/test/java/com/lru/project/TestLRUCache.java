package com.lru.project;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.lru.dto.NodeDTO;
import com.lru.serviceimpl.LRUCacheServiceImpl;

public class TestLRUCache {
	
	@InjectMocks
    LRUCacheServiceImpl service;
 
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testLRUCacheImplementation()
    {
    	NodeDTO node1 = service.set(1, 400);
    	assertEquals(1, node1.getKey());
    	assertEquals(400, node1.getValue());
    	
    	NodeDTO node2 = service.set(2, 800);
    	assertEquals(2, node2.getKey());
    	assertEquals(800, node2.getValue());
    	
    	NodeDTO getNode1 = service.get(1);
    	assertEquals(1, getNode1.getKey());
    	
    	NodeDTO node3 = service.set(3, 1200);
    	assertEquals(2, node3.getKey());
    	assertEquals(800, node3.getValue());
    	
    	NodeDTO getNode2 = service.get(2);
    	assertEquals(null, getNode2);
    	
    	NodeDTO node4 = service.set(4, 1600);
    	assertEquals(1, node4.getKey());
    	assertEquals(400, node4.getValue());
    	
    	NodeDTO getNode3 = service.get(1);
    	assertEquals(null, getNode3);
    	
    	NodeDTO getNode4 = service.get(3);
    	assertEquals(3, getNode4.getKey());
    	assertEquals(1200, getNode4.getValue());
    	
    	NodeDTO getNode5 = service.get(4);
    	assertEquals(4, getNode5.getKey());
    	assertEquals(1600, getNode5.getValue());
    }

}
