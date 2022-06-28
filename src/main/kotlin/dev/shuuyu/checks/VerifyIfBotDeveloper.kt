package dev.shuuyu.checks

import com.kotlindiscord.kord.extensions.checks.types.CheckContext
import com.kotlindiscord.kord.extensions.checks.userFor
import dev.kord.core.entity.User
import dev.kord.core.event.Event

suspend fun <T : Event> CheckContext<T>.VerifyBotDeveloper(user: User) {
    if (!passed) {
        return
    }

    val member = userFor(event)
}