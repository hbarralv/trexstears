package com.example.demo.platos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/platos")
public class platoRestController {

    @Autowired
    private platoRepository platosRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<plato> findAll() {
        return platosRepository.findAll();
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/{platosId}")
    public plato findOne(@PathVariable Long platosId) {
        return platosRepository.findOne(platosId);
    }
//
//	@RequestMapping(method = RequestMethod.POST)
//    public plato add(@RequestBody platos platos) {
//        return platosRepository.save(plato);
//    }
//
//	@RequestMapping(method = RequestMethod.PUT)
//    public plato update(@RequestBody platos platos) {
//        return platosRepository.save(plato);
//    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{platosId}")
    public void delete(@PathVariable Long platosId) {
        platosRepository.delete(platosId);
    }
	
}

