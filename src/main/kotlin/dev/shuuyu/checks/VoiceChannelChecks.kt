package dev.shuuyu.checks

import com.kotlindiscord.kord.extensions.ExtensibleBot
import com.kotlindiscord.kord.extensions.checks.types.CheckContext
import dev.kord.common.entity.Snowflake
import dev.kord.core.behavior.GuildBehavior
import dev.kord.core.event.Event
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

suspend fun <T: Event> CheckContext<T>.inVoiceChannelCheck(extensibleBot: ExtensibleBot) {

}

data class VoiceChannelContext(
    val VoiceChannel: Snowflake,
    val guildId: GuildBehavior,
)