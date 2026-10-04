package com.artistle.bloom

import com.artistle.bloom.auth.DeliveryChannel
import com.artistle.bloom.auth.LoginStart
import com.artistle.bloom.identifiers.EmailAddress
import org.springframework.stereotype.Service
import java.time.Clock
import java.time.Duration
import java.util.*

@Service
class LoginService(
    private val clock: Clock,
) {

    fun start(email: EmailAddress): LoginStart {

        return LoginStart(
            transactionId = UUID.randomUUID(),
            channel = DeliveryChannel.EMAIL,
            expiresAt = clock.instant().plus(CODE_TTL),
        )
    }

    private companion object {
        val CODE_TTL: Duration = Duration.ofMinutes(10)
    }
}