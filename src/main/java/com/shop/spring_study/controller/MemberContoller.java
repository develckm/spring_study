package com.shop.spring_study.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shop.spring_study.repository.MemberRepository;
import com.shop.spring_study.vo.MemberVo;

@Controller
@RequestMapping("/mem")
public class MemberContoller {
	@Autowired //spring jpa container 에서 객체를 주입받는다. 
	MemberRepository mr;
	
	@GetMapping("/list.do")
	public String list(Model model) {
		Iterable<MemberVo> memList=mr.findAllByOrderBySignupTimeDesc();
		model.addAttribute("memList", memList);
		model.addAttribute("test", 10);
		return "mem/list";
	}
	
	
	@GetMapping(value="/login")
	public String login() {
		
		return "mem/login";
	}
	@PostMapping("/login")
	public String login(
			String id,
			String pw,
			HttpSession session){
		//톰캣서버에 필요한 객체가 있다면 매개변수로 작성하면 사용가능
		System.out.println(id);
		System.out.println(pw);
		MemberVo memVo=mr.findByIdAndPw(id, pw);
		System.out.println(memVo);
		if(memVo!=null) {
			session.setAttribute("memVo", memVo);
			return "redirect:/";			
		}else {
			return "redirect:/mem/login";
		}
	}
//	@GetMapping("/signup")
//	public ModelAndView signup(ModelAndView model) {
//		model.addObject("state", 1);
//		model.setViewName("mem/signup");
//		return model; 
//	}
	@GetMapping("/signup")
	public String signup(Model model) {
		//req.setAttribute("state",1);
		//req.requestDispatcher("mem/signup").forward(req,resp);
		model.addAttribute("state", 1);
		return "mem/signup"; 
	}

	
	@PostMapping("/signup")
	public String signup(MemberVo memVo,HttpSession session) {
		boolean insert=false;
		
		try {
			//기본으로 제공되는 함수
			Optional<MemberVo> memOption=mr.findById(memVo.getId());
			//있는지 검사해서 없을때만 저장 
			if(memOption.isEmpty()) {
				MemberVo insertMem=mr.save(memVo);			
				System.out.println(insertMem);
				if(insertMem!=null) {insert=true;}				
			}else {
				session.setAttribute("msg", "존재하는 아이디 입니다.");
			}
		}catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("msg", "Email이나 phone이 존재합니다. ");
		}
		if(insert) {
			return "redirect:/mem/list.do";			
		}else {
			return "redirect:/mem/signup";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/ajax/findId/{id}")
	public @ResponseBody Optional<MemberVo> findId(@PathVariable String id) {
		return mr.findById(id);
	}
	@GetMapping("/ajax/findPhone/{phone}")
	public @ResponseBody Optional<MemberVo> findPhone(@PathVariable String phone){
		return mr.findByPhone(phone);
	}
	@GetMapping("/ajax/findEmail/{email}")
	public @ResponseBody Optional<MemberVo> findEmail(@PathVariable String email){
		//return mr.selectByEmail(email); 
		return mr.selectJPQLByEmail(email);
	}
}