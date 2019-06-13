package com.lru.mapper;

import com.lru.core.Node;
import com.lru.dto.NodeDTO;

public class NodeMapper {
	
	public static NodeDTO mapModelToDTO(Node node) {
		NodeDTO dto = new NodeDTO();
		dto.setKey(node.getKey());
		dto.setValue(node.getValue());
		return dto;
	}
	
	public static Node mapDtoToModel(NodeDTO dto) {
		Node node = new Node(dto.getKey(),dto.getValue());
		return node;		
		
	}
	

}
