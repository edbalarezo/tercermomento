package com.erikabalarezo.primerapi.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "docente")

class Docente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombre: String? = null
    var cedula: Long? = null
    var edad: Long? = null
    var telefono: Long? = null
    var ciudad: String? = null

    @Column(name="departamento_id")
    var departamentoId: Long? = null

    @Column(name="proyecto_id")
    var proyectoId: Long? = null



}