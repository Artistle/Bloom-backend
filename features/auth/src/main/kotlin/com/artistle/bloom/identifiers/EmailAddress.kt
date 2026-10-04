package com.artistle.bloom.identifiers

import java.net.IDN

@JvmInline
value class EmailAddress private constructor(val value: String) {

    override fun toString(): String {
        val at = value.indexOf('@')
        return "${value.first()}***${value.substring(at)}"
    }

    companion object {
        private const val MAX_LENGTH = 254
        private const val MAX_LOCAL_LENGTH = 64
        private const val MAX_LABEL_LENGTH = 63
        private const val LOCAL_SPECIAL_CHARS = "!#$%&'*+/=?^_`{|}~-"

        fun parseOrNull(raw: String): EmailAddress? {
            val trimmed = raw.trim()
            val at = trimmed.indexOf('@')
            if (at <= 0 || at != trimmed.lastIndexOf('@')) return null

            val local = normalizeLocalPart(trimmed.substring(0, at)) ?: return null
            val domain = normalizeDomain(trimmed.substring(at + 1)) ?: return null

            val normalized = "$local@$domain"
            return if (normalized.length <= MAX_LENGTH) EmailAddress(normalized) else null
        }

        private fun normalizeLocalPart(local: String): String? {
            if (local.length > MAX_LOCAL_LENGTH) return null
            if (local.startsWith('.') || local.endsWith('.') || ".." in local) return null
            if (!local.all { it.isAsciiLetterOrDigit() || it == '.' || it in LOCAL_SPECIAL_CHARS }) return null
            return local.lowercase()
        }

        private fun normalizeDomain(domain: String): String? {
            val ascii = try {
                IDN.toASCII(domain, IDN.USE_STD3_ASCII_RULES).lowercase()
            } catch (_: IllegalArgumentException) {
                return null
            }

            val labels = ascii.split('.')
            if (labels.size < 2) return null

            val allLabelsValid = labels.all { label ->
                label.length in 1..MAX_LABEL_LENGTH &&
                    !label.startsWith('-') &&
                    !label.endsWith('-') &&
                    label.all { it.isAsciiLetterOrDigit() || it == '-' }
            }
            return if (allLabelsValid) ascii else null
        }

        private fun Char.isAsciiLetterOrDigit(): Boolean =
            this in 'a'..'z' || this in 'A'..'Z' || this in '0'..'9'
    }
}