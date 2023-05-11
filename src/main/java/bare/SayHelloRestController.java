package bare;

import bare.db.Config;
import bare.db.ConfigRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloRestController {

    @Autowired
    ConfigRepository configRepository;

    @GetMapping("/sayhello")
    public List<Config> get() {
        return configRepository.findAll();
    }
}