package dev.shuuyu.commands

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.extensions.Extension
import dev.kord.common.entity.Permission
import dev.schlaubi.lavakord.kord.lavakord
import io.github.qbosst.kordex.commands.hybrid.publicHybridCommand

class Ping : Extension() {
    override val name: String = "ping"

    override suspend fun setup() {
        publicHybridCommand {
            name = "ping"
            description = "Shows the latency between you and the bot"

            check {
                anyGuild()
                hasPermission(Permission.SendMessages)
            }

            action {
                val latency = kord
            }
        }
    }
}