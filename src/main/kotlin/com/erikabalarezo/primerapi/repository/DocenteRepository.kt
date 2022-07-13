package com.erikabalarezo.primerapi.repository

import com.erikabalarezo.primerapi.dto.NuevaCiudad
import com.erikabalarezo.primerapi.model.Docente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import javax.transaction.Transactional

interface DocenteRepository: JpaRepository <Docente, Long>{

    fun findById (id:Long?): Docente?

    @Query(nativeQuery = true)
    fun getListEdad ( @Param("edad") edad:Long?) : List <Docente>?

    @Query(nativeQuery = true)
    fun getListCedula ( @Param("cedula") cedula:Long?) : List <Docente>?

    @Query(nativeQuery = true)
    fun getListTelefono ( @Param("telefono") telefono:Long?) : List <Docente>?

    @Transactional
    @Modifying
    @Query(nativeQuery = true)
    fun setOtherCiudad ( @Param("ciudad") ciudad: String?,  @Param("nuevaCiudad") nuevaCiudad: String?): Int?

}