package dev.shuuyu.commands

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicMessageCommand
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.cache.api.data.description
import dev.kord.common.entity.Permission
import io.github.qbosst.kordex.commands.hybrid.publicHybridCommand

class Disconnect : Extension() {
    override val name: String = "Disconnect"

    override suspend fun setup() {
        publicHybridCommand {
            name = "disconnect"
            description = "Disconnects the bot from the voice channel"

            check {

            }

            action {
                val targetVoiceChannel = member
            }
        }
    }
}