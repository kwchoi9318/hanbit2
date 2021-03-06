package com.hanbit.web.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hanbit.web.subject.SubjectMemberVO;

@Controller
@SessionAttributes({"user","context","js","css","img"})
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberServiceImpl serviceSample;
	
	@RequestMapping("/search")
	public String find(@RequestParam("keyword") String keyword,
			@RequestParam("search_option")String option,
			Model model){
		logger.info("MemberController ! findById : {}","??");
		System.out.println("검색어 :"+keyword );
		System.out.println("검색어 :"+option );
		MemberVO member =  (MemberVO)serviceSample.findBy("keyword");
		System.out.println("NAME :"+member.getName());
		model.addAttribute("member",member);
		return "admin:member/detail.tiles";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("id") String id,@RequestParam("context") String context,
			@RequestParam("pw") String pw,Model model) {
		logger.info("TO LOGIN ID IS {}",id);
		logger.info("TO LOGIN ID IS {}",pw);
		logger.info("CONTEXT IS {}"+context);
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPw(pw);
		SubjectMemberVO sm = serviceSample.login(member);
		model.addAttribute("user",sm);
		model.addAttribute("context",context);
		model.addAttribute("js",context+"/resources/js");
		model.addAttribute("css",context+"/resources/css");
		model.addAttribute("img",context+"/resources/img");
		
		
		return "user:user/content.tiles";
	}
		

		
	@RequestMapping("/main")
	public String moveMain() {
		logger.info("GO TO {}","main");	
		return "admin:member/content.tiles";
	}
	@RequestMapping("/regist")
	public String moveRegist() {
		logger.info("GO TO {}","regist");
		return "public:member/regist.tiles";
	}
	@RequestMapping("/a_detail")
	public String moveDetail(@RequestParam("key")String key) {
		logger.info("GO TO {}","a_detail");
		logger.info("KEY IS {}",key);
		return "user:member/a_detail.tiles";
	}
	@RequestMapping("/detail")
	public String moveDetail() {
		logger.info("GO TO {}","detail");
		return "user:member/detail.tiles";
	}
	@RequestMapping("/update")
	public String moveUpdate() {
		logger.info("GO TO {}","update");
		return "user:member/update.tiles";
	}
	@RequestMapping("/delete")
	public String moveDelete() {
		logger.info("GO TO {}","delete");
		return "member/delete.tiles";
	}
	@RequestMapping("/login/")
	public String moveLogin() {
		logger.info("GO TO {}","login");
		return "public:member/login.tiles";
	}
	@RequestMapping("/logout")
	public String moveLogout() {
		logger.info("GO TO {}","logout");
		return "member/logout.tiles";
	}
	@RequestMapping("/list")
	public String moveList() {
		logger.info("GO TO {}","list");
		return "admin:member/list.tiles";
	}
	@RequestMapping("/find")
	public String moveFindBy() {
		logger.info("GO TO {}","find");
		return "admin:member/find_by.tiles";
	}
	@RequestMapping("/count")
	public String moveCount() {
		logger.info("GO TO {}","count");
		return "admin:member/count.tiles";
	}
	@RequestMapping("/kaup")
	public String moveKaup() {
		logger.info("GO TO {}","kaup");
		return "user:user/kaup.tiles";
	}
	@RequestMapping("/content")
	public String moveUserContent() {
		logger.info("GO TO {}","content");
		return "user:user/kaup.tiles";
	}
	@RequestMapping("/rock_sissor_paper")
	public String moveRockSissorPaper() {
		logger.info("GO TO {}","rock_sissor_paper");
		return "user:user/rock_sissor_paper.tiles";
	}
	@RequestMapping("/lotto")
	public String moveLotto() {
		logger.info("GO TO {}","lotto");
		return "user:user/lotto.tiles";
	}
}