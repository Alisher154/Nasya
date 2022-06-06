package uz.texnopos.nasya.utils

import android.util.Patterns
import uz.texnopos.nasya.domain.usecase.util.MailMatcher

class AndroidMailMatcher : MailMatcher {

    override fun matches(mail: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(mail).matches()
    }
}