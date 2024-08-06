package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medic.MedicRecord;
import med.voll.api.model.Medic;
import med.voll.api.repository.MedicRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping(value="/medics")
public class MedicController implements Serializable {
    @Autowired
    private MedicRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity<Medic> insert(@RequestBody @Valid MedicRecord medic){
        return ResponseEntity.ok().body(repository.save(new Medic(medic)));
    }
}
