package com.artistle.bloom

import com.artistle.bloom.auth.StartLoginRequest
import com.artistle.bloom.auth.StartLoginResponse
import com.artistle.bloom.exceptions.InvalidIdentifierException
import com.artistle.bloom.identifiers.EmailAddress
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
        val email = EmailAddress.parseOrNull(request.identifier)
            ?: throw InvalidIdentifierException()

        val result = loginService.start(email)

        return StartLoginResponse(
            transactionId = result.transactionId,
            channel = result.channel,
            expiresAt = result.expiresAt,
        )
    }
}