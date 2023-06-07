package bare;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloRestController {

    @GetMapping("/sayhello")
    public String get() {
        return "hello\n";
    }
}