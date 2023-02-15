package com.mysite.sbb2.users;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	//
	//regdate 컬럼 기준으로 desc 정렬
	//select * from users order by regdate desc;
	List<Users> findAllByOrderByRegdateDesc();
	
	Users findByIdx(int idx);
	
	//페이징 처리하기 위한 메소드 
	Page<Users> findAll(Pageable pageable);
	
	

	
}
