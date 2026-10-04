package con.artistle.bloom

import com.artistle.bloom.auth.LoginStart

interface LoginService {

    fun start(identifier: String): LoginStart
}