package com.neoxamhr.Services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

@Service
public class HashingMD5 {
	
	private String passwordToHash;
	
	
	public String getPasswordToHash() {
		return passwordToHash;
	}

	public void setPasswordToHash(String passwordToHash) {
		this.passwordToHash = passwordToHash;
	}

	public HashingMD5() {
		
	}
	
	public String MD5Hash(String pwd ) {
		 try {
	            // Create MessageDigest instance for MD5
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            //Add password bytes to digest
	            md.update(pwd.getBytes());
	            //Get the hash's bytes
	            byte[] bytes = md.digest();
	            //This bytes[] has bytes in decimal format;
	            //Convert it to hexadecimal format
	            StringBuilder sb = new StringBuilder();
	            for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
	            //Get complete hashed password in hex format
	            return sb.toString();
	        }
	        catch (NoSuchAlgorithmException e)
	        {
	            e.printStackTrace();
	            return null;
	        }
	}
	
}
