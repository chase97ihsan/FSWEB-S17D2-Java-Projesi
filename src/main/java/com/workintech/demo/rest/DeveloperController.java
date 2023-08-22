package com.workintech.demo.rest;

import com.workintech.demo.model.*;
import com.workintech.demo.tax.DeveloperTax;
import com.workintech.demo.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/developers")
public class DeveloperController {

    Map<Integer, Developer> developers;

    Taxable taxable;


    @PostConstruct
    public void init() {
        developers = new HashMap<>();
    }

    @Autowired
    public DeveloperController(@Qualifier("developerTax") Taxable taxable) {
        this.taxable = taxable;
    }

    @GetMapping("/")
    public List<Developer> get() {
        return developers.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Developer get(@PathVariable int id) {
        if (id < 0) {
            //TODO is not valid.
        }
        if (developers.get(id) == null) {
            //TODO this value is null.
        }
        if (!developers.containsKey(id)) {
            //TODO this key does not exist.
        }
        return developers.get(id);
    }

    @PostMapping("/")
    public Developer post(@RequestBody Developer developer) {
        Developer developer2 = DeveloperFactory.createDeveloper(developer, taxable);
        if (developer2 == null) {
            //TODO is null.
        }
        developers.put(developer2.getId(), developer2);
        return developers.get(developer2.getId());
    }

    @PutMapping("/{id}")

    public Developer put(@PathVariable int id, @RequestBody Developer developer) {
        if (!developers.containsKey(id)) {
            //TODO there is no such a key.
        }
        developers.put(id, DeveloperFactory.createDeveloper(developer, taxable));
        return developers.get(id);
    }

    @DeleteMapping("/{id}")
    public Developer delete(@PathVariable int id) {
        if (!developers.containsKey(id)) {
            //TODO there is no such a key.
        }
        if (id < 0) {
            //TODO id is not valid.
        }
        return developers.remove(id);
    }


}
