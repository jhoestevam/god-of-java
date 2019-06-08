package god.of.java.demoactuator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> anithyng(){
        final String any = new String("alguma coisa");
        return new ResponseEntity<String>(any, HttpStatus.OK);
    }
    
}