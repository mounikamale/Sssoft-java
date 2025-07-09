package com.example.ConsultantApp.Controller;

import com.example.ConsultantApp.Entity.Consultant;
import com.example.ConsultantApp.Service.ConsultantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/code")
@CrossOrigin
public class ConsultantController {

    private final ConsultantService service;

    public ConsultantController(ConsultantService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Consultant> create(@RequestBody Consultant consultant) {
        return ResponseEntity.ok(service.save(consultant));
    }

    @GetMapping
    public List<Consultant> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consultant> getById(@PathVariable Long id) {
        Consultant consultant = service.findById(id);
        return consultant != null ? ResponseEntity.ok(consultant) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consultant> update(@PathVariable Long id, @RequestBody Consultant updatedConsultant) {
        Consultant existing = service.findById(id);

        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

          existing.setName(updatedConsultant.getName());
          existing.setEmail(updatedConsultant.getEmail());
          existing.setPhoneNumber(updatedConsultant.getPhoneNumber());

        Consultant saved = service.save(existing);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
