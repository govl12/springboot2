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
// 레파지토리 ㅇㅇ 
	//List 
	private final UsersService usersService;
	//private final UsersRepository usersRepository;
	
	
	@GetMapping("/users/list")
	public String list(Model model,@RequestParam(value="page", defaultValue="0") int page) {
		
		Page<Users> paging = this.usersService.getList(page);
		
		model.addAttribute("paging", paging);
		
		return "users_list";
	
	}
	
	@GetMapping("/users/detail/{idx}")
	public String detail(Model model, @PathVariable("idx") Integer idx ) {
		
		//Optional<Users> u = this.usersRepository.findById(idx);
		
		model.addAttribute("users", this.usersService.getUsers(idx));
		
		return "users_detail";
		
	}
	
	@GetMapping("/users/insert")
	public String usersUpdate(UsersForm usersForm) {
		return "users_form";
	}
	
	@PostMapping("/users/insert")
		public String usersUpdate(
		@Valid UsersForm usersForm, BindingResult bindingResult
		) {
			if (bindingResult.hasErrors()) {//subject, content가 비어있을 때 
				return "users_form";
			}
			System.out.println(bindingResult.hasErrors());
	
		this.usersService.usersUpdate(usersForm.getName(),usersForm.getPass(),usersForm.getEmail(),usersForm.getCnt());	
		return "redirect:/users/list";
	}

	
	
	
}
