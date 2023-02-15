package com.mysite.sbb2.users;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UsersController {
	private final UsersService usersService;

	// 상세페이지
	@GetMapping("/")
	public String idex() {
		return "redirect:/users/list";
	}
	
	@GetMapping(value = "/users/detail/{idx}")
	public String detail(Model model, @PathVariable("idx") Integer idx, UsersForm usersForm) {
		
		//서비스 클래스의 메소드 호출 : 상세페이지 보기
		Users u = 
		this.usersService.getUsers(idx);
		       	
		//Model 객체에 담아서 클라이언트에게 전송
		model.addAttribute("users", u);
		
		return "users_detail"; //template : question_detail.html		
	}
	
	//페이지 리스트 출력 + 페이징 처리 
	@GetMapping("/users/list")
	public String list(Model model,@RequestParam(value="page", defaultValue="0") int page) {
		
		//비즈니스 로직 처리 :
		Page<Users> paging = 
			this.usersService.getList(page);
		
		//model객체에 결과로 받은 paging 객체를 Client로 전송
		model.addAttribute("paging", paging);
		return "users_list";
	}

	
	//List - 레파지토리를 이용한 리스트 출력 
//private final UsersRepository usersRepository;

	/*		@GetMapping("/users/list")
	@PostMapping("/users/list")
	public String list(Model model) {
		
		List<Users> usersList = this.usersRepository.findAll();
		
		model.addAttribute("usersList", usersList);
		
		return "users_list";

	}

	@GetMapping("/users/detail/{idx}")
	public String detail(Model model, @PathVariable("idx") Integer idx ) {

		Optional<Users> u = this.usersRepository.findById(idx);

		model.addAttribute("users", u.get());

		return "users_detail";

	}
*/	
	
	//값 저장 - service.
	@GetMapping("/users/registrate")
	public String usersreg(UsersForm usersForm) {
		return "users_form";
	}
	
	@PostMapping("/users/registrate")
	public String usersreg(@Valid UsersForm usersForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "users_form";
		}
	
		this.usersService.usersUpdate(usersForm.getName(),usersForm.getPass(),usersForm.getEmail());

		return "redirect:/users/list";
		
	}
	/*
	@GetMapping("/users/insert")
	public String insertUserPageOn() {
		return "users_insert";
	}

	@PostMapping("/users/update")
		public String usersupdate(@RequestParam String name, @RequestParam String pass, @RequestParam String email, @RequestParam int cnt) {

		Users users = new Users();
		users.setCnt(cnt);
		users.setRegdate(LocalDateTime.now());
		users.setEmail(email);
		users.setName(name);
		users.setPass(pass);

		this.usersRepository.save(users);

		return "redirect:/users/list";



	}*/

}