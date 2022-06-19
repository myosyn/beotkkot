package dev.shuuyu.checks

import com.kotlindiscord.kord.extensions.ExtensibleBot
import com.kotlindiscord.kord.extensions.checks.types.CheckContext
import dev.kord.common.entity.Snowflake
import dev.kord.core.behavior.GuildBehavior
import dev.kord.core.event.Event
import mu.KotlinLogging


private val logger = KotlinLogging.logger("dev.shuuyu.beotkkot.checks.VoiceChannelChecks")

suspend fun <T: Event> CheckContext<T>.inVoiceChannelCheck(extensibleBot: ExtensibleBot) {

}

private suspend fun <T : Event> CheckContext<T>.checkAbstractionMusic(ignoreDjRole: Boolean = false) {
    if (!passed) {
        return
    }

    val guild = null
}

data class VoiceChannelContext(
    val VoiceChannel: Snowflake,
    val guildId: GuildBehavior,
)