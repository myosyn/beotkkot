package dev.shuuyu.commands

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicMessageCommand
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import com.kotlindiscord.kord.extensions.types.respond
import dev.kord.common.entity.Permission

class Disconnect : Extension() {
    override val name: String = "Disconnect"

    override suspend fun setup() {
        publicMessageCommand {
            name = "disconnect"
            check {
                anyGuild()
                hasPermission(Permission.Administrator)
            }

            action {

            }
        }
        publicSlashCommand {
            name = "disconnect"
            description = "Disconnects the bot from the Voice Channel."

            check {
                anyGuild()
                hasPermission(Permission.Administrator)
            }

            action {

            }
        }
    }
}