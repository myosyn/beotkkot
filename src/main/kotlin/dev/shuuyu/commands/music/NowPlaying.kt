package dev.shuuyu.commands.music

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.extensions.Extension
import dev.kord.common.entity.Permission
import io.github.qbosst.kordex.commands.hybrid.publicHybridCommand

class NowPlaying : Extension() {
    override val name: String = "nowPlaying"

    override suspend fun setup() {
        publicHybridCommand {
            name = "nowplaying"
            description = "Shows the song that is being played"

            check {
                anyGuild()
                hasPermission(Permission.SendMessages)
                requirePermissions(Permission.SendMessages)
            }

            action {

            }
        }
    }
}