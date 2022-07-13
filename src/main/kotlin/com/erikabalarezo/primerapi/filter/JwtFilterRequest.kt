package com.erikabalarezo.primerapi.filter

import com.erikabalarezo.primerapi.security.JWTUtil
import com.erikabalarezo.primerapi.service.AppUserDetailsService
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtFilterRequest : OncePerRequestFilter(){
    @Autowired
    lateinit var jwtUtil: JWTUtil

    @Autowired
    lateinit var gymUserDetailsService: AppUserDetailsService

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val authorizationHeader:String? = request.getHeader("Authorization")
        authorizationHeader?.let {aut ->
            aut.startsWith("Bearer").let {
                val jwt: String = aut.substring(7)
                val username: String = jwtUtil.extractUsername(jwt)
                SecurityContextHolder.getContext().authentication ?: run {
                    val userDetails: UserDetails = gymUserDetailsService.loadUserByUsername(username)
                    jwtUtil.validateToken(jwt, userDetails).let {
                        val authToken: UsernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
                        authToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                        SecurityContextHolder.getContext().authentication = authToken
                    }

                }
            }
        }

        filterChain.doFilter(request,response)
    }



}