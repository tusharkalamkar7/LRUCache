
package com.lru.serviceimpl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lru.core.Node;
import com.lru.dto.NodeDTO;
import com.lru.mapper.NodeMapper;
import com.lru.service.LRUCacheService;

@Service
public class LRUCacheServiceImpl implements LRUCacheService{
	
	private HashMap<Integer, Node> map; 
	private int count; 
	//@Value("2")
	private int capicity=2;
	
	private Node head, tail; 
	
	@Autowired
	public LRUCacheServiceImpl() 
    { 
        map = new HashMap<>(); 
        head = new Node(0, 0); 
        tail = new Node(0, 0); 
        head.next = tail; 
        tail.pre = head; 
        head.pre = null; 
        tail.next = null; 
        count = 0; 
    } 
	
	public void deleteNode(Node node) 
    { 
        node.pre.next = node.next; 
        node.next.pre = node.pre; 
    } 
  
    public void addToHead(Node node) 
    { 
        node.next = head.next; 
        node.next.pre = node; 
        node.pre = head; 
        head.next = node; 
    } 
    
    @Override
    public NodeDTO get(int key) 
    { 
        if (map.get(key) != null) { 
            Node node = map.get(key); 
            int result = node.value; 
            deleteNode(node); 
            addToHead(node); 
            System.out.println("Got the value : " + 
                  result + " for the key: " + key); 
            return NodeMapper.mapModelToDTO(node); 
        } 
        System.out.println("Did not get any value" + 
                            " for the key: " + key); 
        return null; 
    } 
    
    @Override 
    public NodeDTO set(int key, int value) 
    { 
        System.out.println("Going to set the (key, "+  
             "value) : (" + key + ", " + value + ")"); 
        if (map.get(key) != null) { 
            Node node = map.get(key); 
            node.value = value; 
            deleteNode(node); 
            addToHead(node); 
            return NodeMapper.mapModelToDTO(node);
        } 
        else { 
            Node node = new Node(key, value); 
            map.put(key, node); 
            if (count < capicity) { 
                count++; 
                addToHead(node); 
            } 
            else { 
                map.remove(tail.pre.key); 
                //create the invalidated node
                Node invalidatedNode = new Node(tail.pre.key, tail.pre.value); 
                deleteNode(tail.pre); 
                addToHead(node); 
                return NodeMapper.mapModelToDTO(invalidatedNode);
            } 
            return NodeMapper.mapModelToDTO(node);
        } 
    } 


}
