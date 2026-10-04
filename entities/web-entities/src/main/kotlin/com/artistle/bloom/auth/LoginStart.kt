package com.artistle.bloom.auth

import java.time.Instant
import java.util.UUID

data class LoginStart(
    val transactionId: UUID,
    val channel: DeliveryChannel,
    val expiresAt: Instant,
)
