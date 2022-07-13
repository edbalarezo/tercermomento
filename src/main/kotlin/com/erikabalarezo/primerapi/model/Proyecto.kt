package com.erikabalarezo.primerapi.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table (name = "proyecto")

class Proyecto {
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    @Column (updatable = false)

    var id: Long? = null
    var tema: String? = null
    var objetivos: String? = null


}