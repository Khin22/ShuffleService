package io.reflectoring.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/log")
public class LogController {

	
	@GetMapping
    public ResponseEntity<String> logMessage(@RequestParam String message) {
        // Log the message (console log for this example)
        System.out.println("Logged message: " + message);

        // Return a response confirming the log
        return ResponseEntity.ok("Message logged: " + message);
    }
	
	
	@PostMapping
    public ResponseEntity<String> logPostMessage(@RequestBody String message) {
        // Log the message (console log for this example)
        System.out.println("Logged POST message: " + message);

        // Return a response confirming the log
        return ResponseEntity.ok("POST Message logged: " + message);
    }
}
