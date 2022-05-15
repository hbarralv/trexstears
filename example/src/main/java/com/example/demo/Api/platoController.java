package com.example.demo.Api;

import java.util.List;

import com.example.demo.platos.plato;
import com.example.demo.platos.platoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("sec/api")

public class platoController {
  @Autowired
  private platoRepository platosRepository;

  @GetMapping("/platos")
  public List<plato> findAll() {
    return platosRepository.findAll();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/platos/{platosId}")
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

  @RequestMapping(method = RequestMethod.DELETE, value = "/borrarplato/{platosId}")
  public void delete(@PathVariable Long platosId) {
    platosRepository.delete(platosId);
  }

}

