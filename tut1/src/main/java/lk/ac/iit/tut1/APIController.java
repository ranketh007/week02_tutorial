package lk.ac.iit.tut1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {
    @GetMapping("/home")
    public String home() {
        return "This is tutorial one";
    }

    @GetMapping("/login/{username}")
    public String login(@PathVariable String username) {
        if(username.equals("admin")){
            return "Welcome Admin";
        }else{
            return "Get lost.";
        }
    }
}
