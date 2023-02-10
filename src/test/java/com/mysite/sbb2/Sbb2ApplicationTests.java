package com.mysite.sbb2;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb2.users.Users;
import com.mysite.sbb2.users.UsersRepository;

@SpringBootTest
class Sbb2ApplicationTests {

	@Autowired
	private UsersRepository usersRepository;
	
	
	/*더미 값 1000개 넣기 */
	
	@Test
	public void insert1000() {
		Users u = null;
		
		for(int i = 1 ; i<=1000; i++) {
			u = new Users();
			
			u.setName("이름 - "+i);
			u.setPass("pass"+i);
			u.setEmail("e"+i+"@mail.com");
			u.setRegdate(LocalDateTime.now());
			u.setCnt(i);
			
			this.usersRepository.save(u);
		}
	}
	
	/*
	//1. 임의의 값 5개 insert - insert 는 선언해줄 필요 없음.
	@Test
	void contextLoads() {

		// 값을 넣어줄때 u1,u2..이렇게 다 일일히 해주어야 하는지 아니면 Users u 로 해놓고 값 다르게 해서 넣어도 되는건지..?
	
		//1번 값
		Users u1 = new Users();
		
		u1.setName("이름1");
		u1.setPass("pass1");
		u1.setEmail("e1@mail.com");
		u1.setRegdate(LocalDateTime.now());
		u1.setCnt(10);
		
		this.usersRepository.save(u1);
	
		
	
		//2번 값
		Users u2 = new Users();
		
		u2.setName("이름2");
		u2.setPass("pass2");
		u2.setEmail("e2@mail.com");
		u2.setRegdate(LocalDateTime.now());
		u2.setCnt(20);
		
		this.usersRepository.save(u2);
		
		
		//3번 값
		Users u3 = new Users();
		
		u3.setName("이름3");
		u3.setPass("pass3");
		u3.setEmail("e3@mail.com");
		u3.setRegdate(LocalDateTime.now());
		u3.setCnt(30);
		
		this.usersRepository.save(u3);
	
	
		//4번 값
		
		Users u4 = new Users();
		
		u4.setName("이름4");
		u4.setPass("pass4");
		u4.setEmail("e4@mail.com");
		u4.setRegdate(LocalDateTime.now());
		u4.setCnt(40);
		
		this.usersRepository.save(u4);
	 // 
		
	
		//5번 값
		Users u5 = new Users();
		
		u5.setName("이름5");
		u5.setPass("pass5");
		u5.setEmail("e5@mail.com");
		u5.setRegdate(LocalDateTime.now());
		u5.setCnt(50);
		
		this.usersRepository.save(u5);
			
		 
	}	*/ 
	
	
		//2. regdate 컬럼 기준으로 Desc 정렬
	
		@Test
		public void regdatesbb2() {
				List<Users> reglist = this.usersRepository.findAllByOrderByRegdateDesc();
				
				for(Users u : reglist) {
					
					System.out.println(u.getIdx());
					System.out.println(u.getEmail());
					System.out.println(u.getName());
					System.out.println(u.getRegdate());
					System.out.println("====================");
					
					
					
				}
				
				System.out.println(reglist);
		}

	
		/*
		//3. idx 3번의 name과 email주소를 수정
		@Test
		public void modifysbb2() {
			Optional<Users> m = this.usersRepository.findById(3);
			
			Users u = m.get();
			u.setName("이름3-수정");
			u.setEmail("e4수정@mail.com");
			
			this.usersRepository.save(u);
	
		}
		*/
		/*
		//4. idx 4번의 값을 삭제 
		
		@Test
		public void deletesbb2() {
		
		Optional<Users> d = this.usersRepository.findById(4);
		
		Users u = d.get();
		
		this.usersRepository.delete(u);
		
		}*/
}

