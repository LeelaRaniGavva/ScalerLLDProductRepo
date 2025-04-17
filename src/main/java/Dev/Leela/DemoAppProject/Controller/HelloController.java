package Dev.Leela.DemoAppProject.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hellowrold()
    {
        return "Hello world";
    }

}
