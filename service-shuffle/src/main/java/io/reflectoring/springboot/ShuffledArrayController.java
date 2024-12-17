package io.reflectoring.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/shuffle")
public class ShuffledArrayController {

    @Value("${service.log.url}") // Fetch URL from application.properties
    private String logServiceUrl;

    @GetMapping
    public List<Integer> generateShuffledArrayGet(@RequestParam int number) {
        return generateShuffledArray(number);
    }
    

    @PostMapping
    public List<Integer> generateShuffledArray(@RequestParam int number) {
        // Validate input number
        if (number < 1 || number > 1000) {
        	throw new IllegalArgumentException("Number must be between 1 and 1000");
        }

        // Generate a shuffled array
        List<Integer> array = IntStream.rangeClosed(1, number)
                .boxed()
                .collect(Collectors.toList());
Collections.shuffle(array);

RestTemplate restTemplate = new RestTemplate();
restTemplate.getForEntity(logServiceUrl + "?message=Generated array for number: " + number, String.class);

return array;
    }

}
