package com.neoxamhr.webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.neoxamhr.authen.AuthHelper;
import com.neoxamhr.authen.IdToken;
import com.neoxamhr.authen.TokenResponse;
import com.neoxamhr.dao.OutlookService;
import com.neoxamhr.dao.OutlookServiceBuilder;
import com.neoxamhr.entities.OutlookUser;
import com.neoxamhr.authen.AuthHelper;

@Controller
public class authOutlookController {
	
	 @RequestMapping(value="/authorize", method=RequestMethod.POST)
	  public String authorize(
	      @RequestParam("code") String code,
	      @RequestParam("id_token") String idToken,
	      @RequestParam("state") UUID state,
	      HttpServletRequest request) { 
		 
		 System.out.println("code is "+code);
		 
	    // Get the expected state value from the session
	    HttpSession session = request.getSession();
	    UUID expectedState = (UUID) session.getAttribute("expected_state");
	    UUID expectedNonce = (UUID) session.getAttribute("expected_nonce");
	    
	    System.out.println(state + " " +  session.getAttribute("expected_state"));

	    // Make sure that the state query parameter returned matches
	    // the expected state
	    if (state.equals(expectedState)) {
	    	IdToken idTokenObj = IdToken.parseEncodedToken(idToken, expectedNonce.toString());
	    	if (idTokenObj != null) {
	    	  TokenResponse tokenResponse = AuthHelper.getTokenFromAuthCode(code, idTokenObj.getTenantId());
	    	  session.setAttribute("tokens", tokenResponse);
	    	  System.out.println("tokens is "+session.getAttribute("tokens"));
	    	  session.setAttribute("userConnected", true);
	    	  session.setAttribute("userName", idTokenObj.getName());
	    	// Get user info
	    	  OutlookService outlookService = OutlookServiceBuilder.getOutlookService(tokenResponse.getAccessToken(), null);
	    	  OutlookUser user;
	    	  try {
	    	    user = outlookService.getCurrentUser().execute().body();
	    	    session.setAttribute("userEmail", user.getMail());
	    	    System.out.println("user email "+session.getAttribute("userEmail"));
	    	  } catch (IOException e) {
	    	    session.setAttribute("error", e.getMessage());
	    	  }
	    	  session.setAttribute("userTenantId", idTokenObj.getTenantId());
	    	} else {
	    	  session.setAttribute("error", "ID token failed validation.");
	    	}
	    }
	    else {
	      session.setAttribute("error", "Unexpected state returned from authority.");
	    }
	    return "auth.html";
	  }

}
