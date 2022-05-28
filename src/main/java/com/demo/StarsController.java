package com.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class StarsController {

  private final StarsRepository repository;

  StarsController(StarsRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/stars")
  List<Stars> all() {
    return repository.findAll();
  }

  @PostMapping("/stars")
  Stars newStars(@RequestBody Stars newStars) {
    return repository.save(newStars);
  }
  
  @GetMapping("/stars/{id}")
  Stars one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new NotFoundException(id));
  }

  @PutMapping("/stars/{id}")
  Stars replaceStarsModel(@RequestBody Stars newStars, @PathVariable Long id, String name, String scientificName, String constellation, String age, String type, String distanceEarth) {
    
    return repository.findById(id)
      .map(stars -> {
        stars.setName(newStars.getName());
        stars.setScientificName(newStars.getScientificName());
        stars.setConstellation(newStars.getConstellation());
        stars.setAge(newStars.getAge());
        stars.setType(newStars.getType());
        stars.setDistanceEarth(newStars.getDistanceEarth());
        return repository.save(stars);
      })
      .orElseGet(() -> {
    	  newStars.setId(id);
        return repository.save(newStars);
      });
  }

  @DeleteMapping("/stars/{id}")
  void deleteStars(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
