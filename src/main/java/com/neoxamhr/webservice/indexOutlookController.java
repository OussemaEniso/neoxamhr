package com.neoxamhr.webservice;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neoxamhr.authen.AuthHelper;

@Controller
public class indexOutlookController {
	
	@GetMapping("/index")
	public String index(Model model, HttpServletRequest request) {
	  UUID state = UUID.randomUUID();
	  UUID nonce = UUID.randomUUID();
	  List<String> ls=new ArrayList<String>();
	  
	  HttpSession session = request.getSession();
	  session.setAttribute("expected_state", state);
	  session.setAttribute("expected_nonce", nonce);

	  String loginUrl = AuthHelper.getLoginUrl(state, nonce);
	  System.out.println(loginUrl);
	  model.addAttribute("loginUrl", loginUrl);
	  ls.add(loginUrl);
	  ls.add(state.toString());
	  ls.add(nonce.toString());
	  
	  return "index.html" ;
	}

}
