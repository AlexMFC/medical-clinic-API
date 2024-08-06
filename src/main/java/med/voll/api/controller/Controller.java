package med.voll.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/clinics")
public class Controller {

    @GetMapping
    public ResponseEntity<String> findAll(){
        return  ResponseEntity.ok().body("AQUI ESTAO AS CLINICAS");
    }
}
