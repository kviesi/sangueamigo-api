package br.com.user.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.user.api.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	User findByEmail(String email);

}
