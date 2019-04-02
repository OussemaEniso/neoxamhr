package com.neoxamhr.webservice;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.neoxamhr.entities.OutlookUser;
import com.neoxamhr.services.OutlookService;
import com.neoxamhr.services.OutlookServiceBuilder;
import com.neoxamhr.authen.AuthHelper;

@Controller
public class authOutlookController {
	
	@RequestMapping("/index")
	public String index(Model model, HttpServletRequest request) {
	  UUID state = UUID.randomUUID();
	  UUID nonce = UUID.randomUUID();

	  // Save the state and nonce in the session so we can
	  // verify after the auth process redirects back
	  HttpSession session = request.getSession();
	  session.setAttribute("expected_state", state);
	  session.setAttribute("expected_nonce", nonce);

	  String loginUrl = AuthHelper.getLoginUrl(state, nonce);
	  model.addAttribute("loginUrl", loginUrl);
	  // Name of a definition in WEB-INF/defs/pages.xml
	  return "index.html";
	}
	
	 @RequestMapping(value="/authorize", method=RequestMethod.POST)
	  public String authorize(
	      @RequestParam("code") String code,
	      @RequestParam("id_token") String idToken,
	      @RequestParam("state") UUID state,
	      HttpServletRequest request) { 
	    // Get the expected state value from the session
	    HttpSession session = request.getSession();
	    UUID expectedState = (UUID) session.getAttribute("expected_state");
	    UUID expectedNonce = (UUID) session.getAttribute("expected_nonce");

	    // Make sure that the state query parameter returned matches
	    // the expected state
	    if (state.equals(expectedState)) {
	    	IdToken idTokenObj = IdToken.parseEncodedToken(idToken, expectedNonce.toString());
	    	if (idTokenObj != null) {
	    	  TokenResponse tokenResponse = AuthHelper.getTokenFromAuthCode(code, idTokenObj.getTenantId());
	    	  session.setAttribute("tokens", tokenResponse);
	    	  session.setAttribute("userConnected", true);
	    	  session.setAttribute("userName", idTokenObj.getName());
	    	// Get user info
	    	  OutlookService outlookService = OutlookServiceBuilder.getOutlookService(tokenResponse.getAccessToken(), null);
	    	  OutlookUser user;
	    	  try {
	    	    user = outlookService.getCurrentUser().execute().body();
	    	    session.setAttribute("userEmail", user.getMail());
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
	    return "mail";
	  }

}
