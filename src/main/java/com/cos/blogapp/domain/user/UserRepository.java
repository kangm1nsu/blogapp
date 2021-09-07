package com.cos.blogapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//save() 인서트,업데이트 primary key가 중복일때  업데이트해줌
//findById(1)   한건 셀렉트
//findAll()     전체 셀렉트
//deleteById(1) 한건 삭제
//DAO
//@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(value = "insert into user ( username, password,  email) values (:username, :password, :email)", nativeQuery = true)
	void join(String username, String password, String email);
	
	@Query(value = "select * from user where username = :username and password = :password", nativeQuery = true)
	User mLogin(String username, String password);//자동완성시 m이라고 쓰면 내가직접작성한걸다 볼수있음, 오브젝트를넣을수없음
}
