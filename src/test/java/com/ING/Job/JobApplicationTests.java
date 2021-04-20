package com.ING.Job;

import com.ING.Job.exceptions.InvalidNameException;
import com.ING.Job.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
public class JobApplicationTests {
    @ParameterizedTest
    @Test
    public void testNullUsernameException() {
        UserService userService = new UserService();
        try {
            String username = userService.getUsername("");
            fail();
        } catch (InvalidNameException inv) {
            String message = inv.getMessage();
            assertEquals("invalid name!", message);
        }
    }

}
