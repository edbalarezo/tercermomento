package com.erikabalarezo.primerapi.controller

import com.erikabalarezo.primerapi.model.Departamento
import com.erikabalarezo.primerapi.model.Proyecto
import com.erikabalarezo.primerapi.service.ProyectoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping ("/proyecto")

class ProyectoController {

    @Autowired
    lateinit var proyectoService: ProyectoService

    @GetMapping
    fun list (): List<Proyecto>{
        return proyectoService.list()
    }

    @GetMapping ("/tema/{tema}")
    fun listByTema (@PathVariable("tema") tema: String):List<Proyecto>? {
        return proyectoService.getByTema(tema)
    }

    @GetMapping ("/objetivos/{objetivos}")
    fun listByObjetivos (@PathVariable("objetivos") objetivos: String):List<Proyecto>? {
        return proyectoService.getByObjetivos(objetivos)
    }

    @GetMapping ("/{id}")
    fun listById (@PathVariable("id") id: Long): Proyecto? {
        return proyectoService.getById(id)
    }

    @PostMapping
    fun save(@RequestBody proyecto: Proyecto): Proyecto {
        return proyectoService.save(proyecto)
    }

    @PutMapping
    fun update (@RequestBody proyecto: Proyecto): Proyecto {
        return proyectoService.update(proyecto)
    }

    @PatchMapping
    fun updateName(@RequestBody proyecto: Proyecto): Proyecto {
        return  proyectoService.updateName(proyecto)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return proyectoService.delete(id)
    }
}