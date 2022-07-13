package com.erikabalarezo.primerapi.repository

import com.erikabalarezo.primerapi.model.Departamento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface DepartamentoRepository: JpaRepository <Departamento, Long> {

    fun findById (id:Long?): Departamento?
    @Query(nativeQuery = true)
    fun getListArea ( @Param("area") area:String?) : List <Departamento>?


}