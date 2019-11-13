package action.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import action.RegisterAction;

class RegisterActionTest {
	RegisterAction action = new RegisterAction();
	
	@BeforeEach
	void setUp() throws Exception {
		action.setFirstName("");
		action.setLastName("");
		action.setContact("");
		action.setEmail("");
		action.setPassword("");

		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testExecute() {
		try {
			assertEquals("error", action.execute());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
