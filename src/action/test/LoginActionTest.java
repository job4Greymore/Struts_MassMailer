package action.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import action.LoginAction;

class LoginActionTest {
	
	// this is for Junit Testing
	LoginAction action = new LoginAction();
	@BeforeEach
	void setUp() throws Exception {
		action.setEmail("dfs");
		action.setPassword("2342");
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testExecute() {
		assertEquals("error", action.execute());
	}

}
