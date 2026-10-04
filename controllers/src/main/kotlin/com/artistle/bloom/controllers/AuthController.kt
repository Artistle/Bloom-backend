package com.artistle.bloom.controllers

import com.artistle.bloom.auth.StartLoginRequest
import com.artistle.bloom.auth.StartLoginResponse
import con.artistle.bloom.LoginService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/auth")
class AuthController(
    private val loginService: LoginService,
) {

    @PostMapping
    fun start(@Valid @RequestBody request: StartLoginRequest): StartLoginResponse {
        val result = loginService.start(request.identifier)
        return StartLoginResponse(
            transactionId = result.transactionId,
            channel = result.channel,
            expiresAt = result.expiresAt,
        )
    }
}
