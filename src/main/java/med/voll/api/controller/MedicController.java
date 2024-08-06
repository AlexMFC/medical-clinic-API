package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.address.Address;
import med.voll.api.medic.MedicDataList;
import med.voll.api.medic.MedicRecord;
import med.voll.api.medic.MedicUpdateRecord;
import med.voll.api.model.Medic;
import med.voll.api.repository.MedicRepository;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping
    public Page<MedicDataList> listAll(@PageableDefault(size=10, sort ={"name"}) Pageable pagination){
        return repository.findAllByActiveTrue(pagination).map(MedicDataList::new);
    }

    @PutMapping
    @Transactional
    public void updateMedic(@RequestBody @Valid MedicUpdateRecord medic){
        var medicData = repository.getReferenceById(medic.id());
        medicData.updateData(medic);
        //repository.save(medicData); nao necessario por causa do transactional
        //return ResponseEntity.ok().body(medicData);
    }

    //Exclusao total
    //@DeleteMapping(value={"/id"})
    //@Transactional
    //public void delete(@PathVariable Long id){
    //    repository.deleteById(id);
    //}

    @DeleteMapping(value={"/id"})
    @Transactional
    public void delete(@PathVariable Long id){
        var medicData = repository.getReferenceById(id);
        medicData.logicDelete();
    }
}
