package com.erikabalarezo.primerapi.service

import com.erikabalarezo.primerapi.dto.NuevaCiudad
import com.erikabalarezo.primerapi.dto.NuevoUsuario
import com.erikabalarezo.primerapi.model.Usuario
import com.erikabalarezo.primerapi.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.stereotype.Service

@Service
class UsuarioService {

    @Autowired
    lateinit var usuarioRepository: UsuarioRepository

    fun save (usuario: Usuario): Usuario {
        return usuarioRepository.save(usuario)
    }

    fun updateOtherUsername (nuevoUsername: NuevoUsuario): String? {
        val rows =  usuarioRepository.setOtherUsuario (nuevoUsername.username, nuevoUsername.nuevoUsername)
        return "se cambia el usuario " + rows
    }

    fun updateOtherPassword (nuevoPassword: NuevoUsuario): String? {
        val rows =  usuarioRepository.setOtherUsuario (nuevoPassword.password, nuevoPassword.nuevoPassword)
        return "se cambia password " + rows
    }

}