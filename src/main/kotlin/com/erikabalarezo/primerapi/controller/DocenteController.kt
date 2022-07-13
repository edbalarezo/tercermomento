package com.erikabalarezo.primerapi.controller

import com.erikabalarezo.primerapi.dto.NuevaCiudad
import com.erikabalarezo.primerapi.model.Departamento
import com.erikabalarezo.primerapi.model.Docente
import com.erikabalarezo.primerapi.service.DocenteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping ("/docente")

class DocenteController {

    @Autowired
    lateinit var docenteService: DocenteService

    @GetMapping
    fun list(): List<Docente>{
        return docenteService.list()
    }

    @GetMapping ("/{id}")
    fun listById (@PathVariable("id") id: Long): Docente? {
        return docenteService.getById(id)
    }

    @GetMapping ("/edad/{edad}")
    fun listByEdad (@PathVariable("edad") edad: Long):List<Docente>? {
        return docenteService.getByEdad(edad)
    }

    @GetMapping ("/cedula/{cedula}")
    fun listByCedula (@PathVariable("cedula") cedula: Long):List<Docente>? {
        return docenteService.getByCedula(cedula)
    }

    @GetMapping ("/telefono/{telefono}")
    fun listByTelefono (@PathVariable("telefono") telefono: Long):List<Docente>? {
        return docenteService.getByTelefono(telefono)
    }

    @PostMapping ("/change/ciudad")
    fun updateOtherCiudad (@RequestBody nuevaCiudad: NuevaCiudad): String? {
        return docenteService.updateOtherCiudad (nuevaCiudad)
    }

    @PostMapping
    fun save(@RequestBody docente:Docente): Docente {
        return docenteService.save(docente)
    }

    @PutMapping
    fun update (@RequestBody docente: Docente): Docente {
        return docenteService.update(docente)
    }

    @PatchMapping
    fun updateName(@RequestBody docente: Docente): Docente {
        return docenteService.updateName(docente)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return docenteService.delete(id)
    }
}