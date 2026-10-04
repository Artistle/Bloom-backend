package com.artistle.bloom.auth

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import java.time.Instant
import java.util.UUID

data class StartLoginRequest(
    @field:NotBlank
    @field:Size(max = 254)
    val identifier: String,
)

data class StartLoginResponse(
    val transactionId: UUID,
    val channel: DeliveryChannel,
    val expiresAt: Instant,
)