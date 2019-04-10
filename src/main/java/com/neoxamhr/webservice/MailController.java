package com.neoxamhr.webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.neoxamhr.authen.AuthHelper;
import com.neoxamhr.authen.TokenResponse;
import com.neoxamhr.entities.Message;
import com.neoxamhr.entities.PagedResult;
import com.neoxamhr.services.OutlookService;
import com.neoxamhr.services.OutlookServiceBuilder;

@Controller
public class MailController {

	 public List<Message> lm = new ArrayList<Message>();

	@RequestMapping("/mail")
	public ResponseEntity<?> mail(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		HttpSession session = request.getSession();

		TokenResponse tokens = (TokenResponse) session.getAttribute("tokens");
		PagedResult<Message> messages;
		if (tokens == null) {
			// No tokens in session, user needs to sign in
			redirectAttributes.addFlashAttribute("error", "Please sign in to continue.");
			System.out.println("mail tokens" + session.getAttribute("tokens"));
			//return null;
		}

		String tenantId = (String) session.getAttribute("userTenantId");

		tokens = AuthHelper.ensureTokens(tokens, tenantId);

		String email = (String) session.getAttribute("userEmail");
		System.out.println("user email aa " + session.getAttribute("userEmail"));

		OutlookService outlookService = OutlookServiceBuilder.getOutlookService(tokens.getAccessToken(), email);

		// Retrieve messages from the inbox
		String folder = "inbox";
		// Sort by time received in descending order
		String sort = "receivedDateTime DESC";
		// Only return the properties we care about
		String properties = "receivedDateTime,from,isRead,subject,bodyPreview";
		// Return at most 10 messages
		Integer maxResults = 10;

		try {
			System.out.println("************");
			messages = outlookService.getMessages(folder, sort, properties, maxResults).execute().body();
			model.addAttribute("messages", messages.getValue());
			
		} catch (IOException e) {
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return null;
		}

		return ResponseEntity.ok(messages);
	}
	

}
