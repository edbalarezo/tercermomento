package com.erikabalarezo.primerapi.controller

import com.erikabalarezo.primerapi.model.Departamento
import com.erikabalarezo.primerapi.model.Docente
import com.erikabalarezo.primerapi.service.DepartamentoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping ("/departamento")

class DepartamentoController {

    @Autowired
    lateinit var departamentoService: DepartamentoService

    @GetMapping
    fun list(): List<Departamento>{
        return departamentoService.list()
    }

    @GetMapping ("/area/{area}")
    fun listByArea (@PathVariable("area") area: String):List<Departamento>? {
        return departamentoService.getByArea(area)
    }

    @GetMapping ("/{id}")
    fun listById (@PathVariable("id") id: Long): Departamento? {
        return departamentoService.getById(id)
    }

    @PostMapping
    fun save(@RequestBody departamento:Departamento): Departamento {
        return departamentoService.save(departamento)
    }

    @PutMapping
    fun update (@RequestBody departamento: Departamento): Departamento {
        return departamentoService.update(departamento)
    }

    @PatchMapping
    fun updateName(@RequestBody departamento: Departamento): Departamento {
        return  departamentoService.updateName(departamento)
    }

    @DeleteMapping ("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return departamentoService.delete(id)
    }

}