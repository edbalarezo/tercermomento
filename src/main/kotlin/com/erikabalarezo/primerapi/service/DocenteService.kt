package com.erikabalarezo.primerapi.service

import com.erikabalarezo.primerapi.dto.NuevaCiudad
import com.erikabalarezo.primerapi.model.Docente
import com.erikabalarezo.primerapi.repository.DepartamentoRepository
import com.erikabalarezo.primerapi.repository.DocenteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class DocenteService {

    @Autowired
    lateinit var docenteRepository: DocenteRepository

    @Autowired
    lateinit var departamentoRepository: DepartamentoRepository

    fun list ():List<Docente>{
        return docenteRepository.findAll()
    }

    fun getById (id: Long?): Docente?{
        return docenteRepository.findById(id)
    }

    fun getByEdad (edad: Long?):List<Docente>?{
        return docenteRepository.getListEdad(edad)
    }

    fun getByCedula (cedula: Long?):List<Docente>?{
        return docenteRepository.getListCedula(cedula)
    }

    fun getByTelefono (telefono: Long?):List<Docente>?{
        return docenteRepository.getListTelefono(telefono)
    }

    fun save(docente:Docente):Docente {
        try {
            docente.nombre?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("Nombre no debe ser vacio")

            departamentoRepository.findById(docente.departamentoId)
                    ?: throw Exception("El departamento no exite")

            return docenteRepository.save(docente)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)

        }
    }


    fun update (docente:Docente):Docente {
        try {
            docente.nombre?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("Nombre no debe ser vacio")
            return docenteRepository.save(docente)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)

        }
    }

    fun updateOtherCiudad (nuevaCiudad: NuevaCiudad): String? {
        val rows =  docenteRepository.setOtherCiudad (nuevaCiudad.ciudad, nuevaCiudad.nuevaCiudad)
        return "fueran afectadas " + rows
    }

    fun updateName (docente: Docente): Docente {
        try {

            val response = docenteRepository.findById(docente.id)
                    ?: throw Exception("El id ${docente.id} en docente no existe")
            response.apply {
                this.nombre = docente.nombre
            }
            return docenteRepository.save(docente)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun delete (id:Long): Boolean{
        docenteRepository.deleteById(id)
        return true
    }
}

