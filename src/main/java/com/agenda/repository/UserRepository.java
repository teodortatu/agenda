package com.agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.agenda.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

	@Query(value = "Select * from utilizatori", nativeQuery = true)
	List<User> gasesteTotiUtilizatorii();
	
}
