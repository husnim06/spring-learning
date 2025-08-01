package ru.husnim.spring_learning;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserTable, Long> {

	List<UserTable> findByUsername(String username);

	UserTable findById(long id);
}