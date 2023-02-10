package com.mysite.sbb2.users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	
	//regdate 컬럼 기준으로 desc 정렬
	//select * from users order by regdate desc;
	List<Users> findAllByOrderByRegdateDesc();
	
	Users findByIdx(int idx);
	

	
}
