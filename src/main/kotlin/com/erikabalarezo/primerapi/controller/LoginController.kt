package com.erikabalarezo.primerapi.controller
import com.erikabalarezo.primerapi.dto.AuthenticationRequest
import com.erikabalarezo.primerapi.dto.AuthenticationResponse
import com.erikabalarezo.primerapi.security.JWTUtil
import com.erikabalarezo.primerapi.service.AppUserDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/jwt")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class LoginController {
    @Autowired
    lateinit var authenticationManager : AuthenticationManager

    @Autowired
    lateinit var gymUserDetailsService: AppUserDetailsService

    @Autowired
    lateinit var jwtUtil: JWTUtil


    @PostMapping("/auth")
    fun createToken(@RequestBody request: AuthenticationRequest): ResponseEntity<AuthenticationResponse> {
        try {
            authenticationManager.authenticate(UsernamePasswordAuthenticationToken(request.username, request.password))
            val userDetails: UserDetails = gymUserDetailsService.loadUserByUsername(request.username)
            val jwt: String = jwtUtil.generateToken(userDetails)
            return ResponseEntity(AuthenticationResponse(jwt), HttpStatus.OK)
        }
        catch (e:BadCredentialsException ){
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }
    }
}