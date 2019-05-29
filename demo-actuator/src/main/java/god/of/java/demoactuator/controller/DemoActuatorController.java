package god.of.java.demoactuator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoActuatorController
 */
@RestController
@RequestMapping("api/v1")
public class DemoActuatorController {

    @GetMapping("anything")
    public String anithyng(){
        return "alguma coisa";
    }
    
}