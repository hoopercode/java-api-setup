package com.nology.Apiintro.rest;

import com.nology.Apiintro.entity.Surfer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class SurferController {

    List<Surfer> fakeSurferDatabase = new ArrayList(Arrays.asList(
            new Surfer(1, "Ollie", 9),
            new Surfer(2, "Rob", 2),
            new Surfer(3, "Sarah", 3),
            new Surfer(4, "Phil", 5),
            new Surfer(5, "John", 7),
            new Surfer(6, "Istvan", 7))
    );
    //Index
    @GetMapping("/surfers")
    public ResponseEntity<List<Surfer>> getSurfers(){
        return ResponseEntity.status(200).body(fakeSurferDatabase) ;
    }
    //Show Route
    @GetMapping("/surfers/{id}")
    public ResponseEntity<Surfer> getSurfer(@PathVariable int id) {
        return ResponseEntity.status(200).body(fakeSurferDatabase.get(id-1));
    };
    //Post Mapping
    @PostMapping("/surfers")
    public ResponseEntity<Surfer> createSurfer(@RequestBody Map newSurfer) {
        String name = (String) newSurfer.get("name");
        int gnarliness = (int) newSurfer.get("gnarliness");
        int id = (int)newSurfer.get("id");
        Surfer newSurferB = new Surfer(id, name, gnarliness);
        fakeSurferDatabase.add((Surfer) newSurfer);

        return ResponseEntity.status(201).body(newSurferB);
    }
    //Update
    @PutMapping("surfers/{id}")
    public ResponseEntity<Surfer> updateSurfer(@PathVariable int id, @RequestBody Map newSurfer) {
        Surfer currentSurfer = fakeSurferDatabase.get(id-1);
        currentSurfer.setId((int) newSurfer.get("id"));
        currentSurfer.setName((String) newSurfer.get("name"));
        currentSurfer.setGnarliness((int) newSurfer.get("gnarliness"));
        fakeSurferDatabase.set(id-1, currentSurfer);
        return ResponseEntity.status(201).body(currentSurfer);

    }

    @DeleteMapping("/surfers/{id}")
    public ResponseEntity<List<Surfer>> deleteSurfer(@PathVariable int id) {

        int toRemove = -1;

        for (int i = 0; i < fakeSurferDatabase.size(); i++) {
            if (fakeSurferDatabase.get(i).getId() == id) {
                toRemove = i;
            }
        }

        fakeSurferDatabase.remove(toRemove);

        return ResponseEntity.status(200).body(fakeSurferDatabase);
    }

}
