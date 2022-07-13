package com.erikabalarezo.primerapi.service

import com.erikabalarezo.primerapi.model.Departamento
import com.erikabalarezo.primerapi.model.Docente
import com.erikabalarezo.primerapi.repository.DepartamentoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class DepartamentoService {

    @Autowired
    lateinit var departamentoRepository: DepartamentoRepository

    fun list ():List<Departamento>{
        return departamentoRepository.findAll()
    }

    fun getById (id: Long?): Departamento? {
        return departamentoRepository.findById(id)
    }

    fun getByArea (area: String?):List<Departamento>?{
        return departamentoRepository.getListArea(area)
    }

    fun save(departamento: Departamento):Departamento {
        try {
            departamento.area?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("Area no debe ser vacio")
            return departamentoRepository.save(departamento)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)

        }
    }

    fun update (departamento: Departamento): Departamento {
        departamentoRepository.findById(departamento.id) ?: throw Exception ()
        return departamentoRepository.save(departamento)
    }

    fun updateName (departamento: Departamento ): Departamento {
        try {

            val response = departamentoRepository.findById(departamento.id)
                    ?: throw Exception("El id ${departamento.id} en departamento no existe")
            response.apply {
                this.area = departamento.area
            }
            return departamentoRepository.save(departamento)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun delete (id:Long): Boolean{
        departamentoRepository.deleteById(id)
        return true
    }
}