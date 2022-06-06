package uz.texnopos.nasya.domain.usecase.util

interface MailMatcher {

    fun matches(mail: String): Boolean
}