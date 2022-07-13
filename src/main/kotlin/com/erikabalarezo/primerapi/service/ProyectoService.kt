package com.erikabalarezo.primerapi.service

import com.erikabalarezo.primerapi.model.Departamento
import com.erikabalarezo.primerapi.model.Docente
import com.erikabalarezo.primerapi.model.Proyecto
import com.erikabalarezo.primerapi.repository.ProyectoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ProyectoService {

    @Autowired
    lateinit var proyectoRepository: ProyectoRepository

    fun list(): List<Proyecto> {
        return proyectoRepository.findAll()
    }

    fun getById (id: Long?): Proyecto? {
        return proyectoRepository.findById(id)
    }

    fun getByTema (tema: String?):List<Proyecto>?{
        return proyectoRepository.getListTema(tema)
    }

    fun getByObjetivos (objetivos: String?):List<Proyecto>?{
        return proyectoRepository.getListObjetivos(objetivos)
    }

    fun save(proyecto: Proyecto): Proyecto {
        try {
            proyecto.tema?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("Tema no debe ser vacio")
            return proyectoRepository.save(proyecto)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)

        }
    }

    fun update ( proyecto: Proyecto): Proyecto {
        proyectoRepository.findById(proyecto.id) ?: Exception ()
        return proyectoRepository.save(proyecto)
    }

    fun updateName (proyecto: Proyecto): Proyecto {
        try {

            val response = proyectoRepository.findById(proyecto.id)
                    ?: throw Exception("El id ${proyecto.id} en proyecto no existe")
            response.apply {
                this.tema = proyecto.tema
            }
            return proyectoRepository.save(proyecto)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun delete (id:Long): Boolean{
        proyectoRepository.deleteById(id)
        return true
    }






}