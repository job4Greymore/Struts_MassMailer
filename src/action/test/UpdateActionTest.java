package action.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import action.UpdateAction;

class UpdateActionTest {
	UpdateAction action = new UpdateAction();

	@BeforeEach
	void setUp() throws Exception {
		action.setFirstName("fname");
		action.setLastName("lname");
		action.setEmail("email");
		action.setContact("123");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testExecute() throws SQLException, Exception {
		assertEquals("error", action.execute());
	}

}
