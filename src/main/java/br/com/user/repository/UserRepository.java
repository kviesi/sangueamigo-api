package br.com.user.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.user.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
