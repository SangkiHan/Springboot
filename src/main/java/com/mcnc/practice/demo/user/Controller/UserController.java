package com.mcnc.practice.demo.user.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcnc.practice.demo.Exception.CustomException;
import com.mcnc.practice.demo.Exception.ErrorCode;
import com.mcnc.practice.demo.Exception.TestException;
import com.mcnc.practice.demo.user.Service.userServiceimpl;
import com.mcnc.practice.demo.user.domain.UserVo;
import com.mcnc.practice.demo.view.Controller.ViewController;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	userServiceimpl userServiceimpl;
	
	@Autowired
    private userServiceimpl userService;

    /**
     * localhost:8080 시 login 으로 redirect
     * @return
     */
    @GetMapping
    public String root() {
        return "redirect:/login";
    }

    /**
     * 로그인 폼
     * @return
     */
    @GetMapping("/login")
    public String login(){
    	
        return "login";
    }
    
    @RequestMapping(value = "/login_proc", method = RequestMethod.GET)
    public void login_proc(){
    	
    	int a = 0;
    	
//        return "login";
    }

    /**
     * 로그인 실패 폼
     * @return
     */
    @GetMapping("/access_denied")
    @ResponseBody
    public String accessDenied() {
//    	
//    	userServiceimpl.
//    	
        return "fail";
    }

    /**
     * 유저 페이지
     * @param model
     * @param authentication
     * @return
     */
    @GetMapping("/user_access")
    public String userAccess(Model model, Authentication authentication) {
        //Authentication 객체를 통해 유저 정보를 가져올 수 있다.
//        UserVo userVo = (UserVo) authentication.getPrincipal();  //userDetail 객체를 가져옴
//        model.addAttribute("info", userVo.getUserId() +"의 "+ userVo.getUserName()+ "님");      //유저 아이디
        return "user_access";
    }
    
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
    
    @GetMapping(value = "/err/denied-page")
    public String accessAdminDenied(){
        return "AdmindeniedPage";
    }
    
}
