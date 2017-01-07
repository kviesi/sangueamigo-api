package br.com.user.api.resources;

import java.util.HashMap;
import java.util.Map;

import org.springframework.hateoas.Resource;

import br.com.user.api.model.User;

public class UserResource extends Resource<Map<String, Object>> {
	
	public static UserResource getInstance_V1(User userEntity) {
		
		Map<String, Object> userAttributes = new HashMap<>();
		userAttributes.put("name", userEntity.getName());
		userAttributes.put("email", userEntity.getEmail());
		userAttributes.put("active", userEntity.isActive());
		userAttributes.put("id", userEntity.getId());
		
		UserResource userResource = new UserResource(userAttributes);
//		userResource.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(UserRestController.class).getUser_V1(userEntity.getId())).withSelfRel());

		return userResource;
	}
	
	public UserResource(Map<String, Object> userAttributes) {
		super(userAttributes);
	}

}
