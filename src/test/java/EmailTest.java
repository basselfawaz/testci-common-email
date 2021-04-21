package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {

	private static final String[] TEST_EMAILS = {"cb@dc.com", "a.b@c.org", "abcdefghijklmnopqrst@abcdefghijklmnopqrst.com.bd"};
	private String[] Test_Names = {"basel", "lulu", "hello"};
	private String[] validChars = {" ", "a", "A", "\uc5ec", "0123456789", "01234567890123456789","\n" };
	
	private EmailConcrete email;
	
	@Before
	public void setUpEmailTest() throws Exception {
		
		email = new EmailConcrete();
	}
	
	@After
	public void tearDownEmailTest() throws Exception {
		
	}

	@Test
	public void addBCCTest() throws Exception {
		email.addBcc(TEST_EMAILS[1], "Basel");
		assertEquals(1, email.getBccAddresses().size());
	}
	@Test
	public void testAddCc() throws Exception {
		email.addCc(TEST_EMAILS[0]);
		assertEquals(1, email.getCcAddresses().size());
	}

	@Test
	public void addHeaderTest() throws Exception {
		
		email.addHeader(Test_Names[0] , validChars[3]);
		
		assertEquals(1, email.getHeaders().size());
	}

	@Test
	public void testAddReplyTo() throws Exception {
		
		email.addReplyTo(TEST_EMAILS[1], Test_Names[2]);
		
		assertEquals(1, email.getReplyToAddresses().size());
	}
	
	@Test
	public void hostNameTest() {
		
		email.setHostName("Local Host");
		String hostname = email.getHostName();
		
		assertEquals("LocalHost", hostname);
	}
	
	@Test
	public void testBuildMimeMessage() throws EmailException {
		
		email.setHostName("Local Host");
		email.setSmtpPort(8910);
		email.setFrom("abcde@fg.com");
		email.addTo("b@cd.com");
		email.setSubject("test email");
     	email.setContent("test content", "text/plain");
     	email.addReplyTo("helloreply@b.com");
     	
		email.buildMimeMessage();
	}

		@Test
	public void mailSession() throws EmailException {
		
		email.setHostName("testHost");
		email.setAuthentication("userName", "password");
		email.setBounceAddress("newbounce@p.com");
		
		email.getMailSession();
	}
	
	@Test
	public void getSentDate() {
		
		email.setSentDate(new Date(8));
		
		assertEquals(new Date(8), email.getSentDate());
	}

		@Test 
	public void getSentDateTestTwo() {
		email.getSentDate();
	}

	@Test
	public void testGetSocketConnectionTimeOut() {
		
		int time = 87;
		email.setSocketConnectionTimeout(time);
		
		assertEquals(time, email.getSocketConnectionTimeout());
	}
	@Test
	public void setFrom() throws Exception {
		
	email.setFrom("BaselFawaz@hoobly.com");
			
	}