package com.artistle.bloom.controllers

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/echo")
class EchoController {

    @PostMapping
    fun echo(@RequestBody request: EchoRequest): EchoResponse =
        EchoResponse(received = request.text, length = request.text.length)
}

data class EchoRequest(val text: String)
data class EchoResponse(val received: String, val length: Int)