package com.funkymonk.stradew_valley_crop_api;


import com.funkymonk.stradew_valley_crop_api.CropsRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CropsController {

    private final CropsRepository repository;

     CropsController(CropsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/crops")
    //hier
    CollectionModel<EntityModel<Crops>> all() {

        List<EntityModel<Crops>> crops = repository.findAll().stream()
                .map(crop -> EntityModel.of(crop,
                        linkTo(methodOn(CropsController.class).one(crop.getId())).withSelfRel(),
                        linkTo(methodOn(CropsController.class).all()).withRel("crops")))
                .collect(Collectors.toList());

        return CollectionModel.of(crops, linkTo(methodOn(CropsController.class).all()).withSelfRel());
    }
    @PostMapping("/crops")
    Crops newCrop(@RequestBody Crops crop) {
         return repository.save(crop);
    }
    // Single Item

    @GetMapping("/crops/{id}")
    EntityModel<Crops> one(@PathVariable Long id) {

        Crops crop = repository.findById(id) //
                .orElseThrow(() -> new CropNotFoundException(id));

        return EntityModel.of(crop, //
                linkTo(methodOn(CropsController.class).one(id)).withSelfRel(),
                linkTo(methodOn(CropsController.class).all()).withRel("crops"));
    }
    @PutMapping("/crops/{id}")
    Crops replaceCrop(@RequestBody Crops newCrop, @PathVariable Long id) {
         return repository.findById(id)
                 .map(crop->{
                     crop.setCrop(newCrop.getCrop());
                     crop.setSeasons(newCrop.getSeasons());
                     crop.setGrowthTime(newCrop.getGrowthTime());
                     crop.setSellPrice(newCrop.getSellPrice());
                     return repository.save(crop);
                 })
                 .orElseGet(()->{
                     return repository.save(newCrop);
                 });

    }
    @DeleteMapping("/crops/{id}")
    void deleteCrop(@PathVariable Long id) {
        repository.deleteById(id);
    }



}


