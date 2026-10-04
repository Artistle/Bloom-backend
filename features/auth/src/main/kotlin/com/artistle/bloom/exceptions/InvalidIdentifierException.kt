package com.artistle.bloom.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.ErrorResponseException
import java.net.URI

class InvalidIdentifierException : ErrorResponseException(
    HttpStatus.BAD_REQUEST,
    ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Identifier is not a valid email address").apply {
        type = URI.create("urn:bloom:problem:invalid-identifier")
        title = "Invalid identifier"
    },
    null,
)