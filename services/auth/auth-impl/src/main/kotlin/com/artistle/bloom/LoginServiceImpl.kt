package com.artistle.bloom

import com.artistle.bloom.auth.DeliveryChannel
import com.artistle.bloom.auth.LoginStart
import con.artistle.bloom.LoginService
import org.springframework.stereotype.Service
import java.time.Clock
import java.time.Duration
import java.util.UUID

@Service
class LoginServiceImpl(
    private val clock: Clock,
) : LoginService {

    override fun start(identifier: String): LoginStart {

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