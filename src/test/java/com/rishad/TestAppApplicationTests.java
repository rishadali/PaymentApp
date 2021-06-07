package com.rishad;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.icegreen.greenmail.junit5.GreenMailExtension;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetupTest;
import com.rishad.dao.AccountRepo;
import com.rishad.model.Account;
import com.rishad.model.Transaction;
import com.rishad.service.impl.TransactionServiceImpl;

@SpringBootTest
class TestAppApplicationTests {

	@Autowired
	private TransactionServiceImpl trans;
	
	@Autowired
	private AccountRepo accRepo;
	
	@Test
	void makePayemntTest() {
		
		Account acc1 = new Account("rishad",1000,"mrishadali@gmail.com");
		Account acc2 = new Account("ali",2000,"mrishadali@hotmail.com");
		accRepo.save(acc1);
		accRepo.save(acc2);
		
		Transaction t1 = new Transaction("rishad", "ali", 500);
		
		trans.makePayment(t1);
		
		assertThat(accRepo.findById(acc1.getName()).get().getBalance()).isEqualTo(500);
		assertThat(accRepo.findById(acc2.getName()).get().getBalance()).isEqualTo(2500);
		
		
	}
	
	
	
	@RegisterExtension
	static GreenMailExtension greenMail = new GreenMailExtension(ServerSetupTest.SMTP);

	@Test
	@DisplayName("Send test")
	void testSend() {
	    GreenMailUtil.sendTextEmailTest("mrishadali@gmail.com", "mrishadali@gmail.com", "Test Email", "This is a test email.");
	    final MimeMessage[] receivedMessages = greenMail.getReceivedMessages();
	    final MimeMessage receivedMessage = receivedMessages[0];
	    assertEquals("This is a test email.", GreenMailUtil.getBody(receivedMessage));
	}

	
}
