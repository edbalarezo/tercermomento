package com.erikabalarezo.primerapi.repository
import com.erikabalarezo.primerapi.model.Proyecto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface ProyectoRepository: JpaRepository <Proyecto, Long> {

    fun findById (id:Long?): Proyecto?

    @Query(nativeQuery = true)
    fun getListTema ( @Param("tema") tema:String?) : List <Proyecto>?

    @Query(nativeQuery = true)
    fun getListObjetivos ( @Param("objetivos") objetivos:String?) : List <Proyecto>?
}