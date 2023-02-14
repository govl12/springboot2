package com.mysite.sbb2.users;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mysite.sbb2.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsersService {

	private final UsersRepository usersRepository;
	
	public List<Users> getList(){
		return this.usersRepository.findAll();
	}
	
	public Users getUsers(Integer idx) {
		
		Optional<Users> op = this.usersRepository.findById(idx);
		
		if (op.isPresent()) {
			return op.get();
		}else {
			throw new DataNotFoundException("요청한 파일을 찾지 못했습니다.");
		}
		
		
	}
	
	public String usersUpdate(String name,String pass,String email,String cnt) {
		
	Users u = new Users();
	u.setCnt(cnt);
	u.setRegdate(LocalDateTime.now());
	u.setEmail(email);
	u.setName(name);
	u.setPass(pass);
	
	this.usersRepository.save(u);
	
	return "redirect:/users/list";
}
public Page<Users> getList(int page){
		
	Pageable pageable = PageRequest.of(page,10);

	return this.usersRepository.findAll(pageable);
	
	}
}