package dev.shuuyu.commands

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission

class Ping : Extension() {
    override val name: String = "ping"

    override suspend fun setup() {
        publicSlashCommand {
            name = "ping"
            description = "Shows the latency between you and the bot"

            check {
                anyGuild()
                hasPermission(Permission.SendMessages)
            }

            action {

            }
        }
    }
}