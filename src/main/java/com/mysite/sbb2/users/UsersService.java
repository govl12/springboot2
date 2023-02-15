package com.mysite.sbb2.users;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mysite.sbb2.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsersService {
	
	//JPA 레파지토리 사용 
	private final UsersRepository usersRepository;
	
	/*
	public List<Users> getList(){
		return this.usersRepository.findAll();
	}*/
	
	//3. 리스트 출력 서비스 
	//controller 에서 getList메소드로 호출 시 출력할 page번호를 매개변수로 받음 : 0,1,2,3
		public Page<Users> getList(int page){
			
			//sort를 사용해서 최신글을 먼저 출력하도록 설정
			List<Sort.Order> sorts = new ArrayList();
			sorts.add(Sort.Order.desc("regdate"));
			
			
			//pageable 객체에 2개의 값을 담아서 매개 변수로 던짐. 10: 출력할 레코드 수 
			Pageable pageable = PageRequest.of(page, 10,Sort.by(sorts));
			
			return this.usersRepository.findAll(pageable);
		}
	
	
	
	
	//2. 상세 페이지 서비스 
	public Users getUsers(Integer idx) {
		
		Optional<Users> op = this.usersRepository.findById(idx);
		
		if (op.isPresent()) {
			return op.get();
		}else {
			throw new DataNotFoundException("요청한 파일을 찾지 못했습니다.");
		}
		
		
	}
	
	//1. 값을 저장하는 서비스 생성
	public String usersUpdate(String name,String pass,String email) {
		
	Users u = new Users();
	u.setRegdate(LocalDateTime.now());
	u.setEmail(email);
	u.setName(name);
	u.setPass(pass);
	
	this.usersRepository.save(u);
	
	return "redirect:/users/list";
}
	
}