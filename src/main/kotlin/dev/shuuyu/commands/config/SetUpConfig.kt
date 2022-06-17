package dev.shuuyu.commands.config

import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.publicSubCommand
import com.kotlindiscord.kord.extensions.commands.converters.impl.channel
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission
import dev.kord.common.entity.Permissions

class SetUpConfig : Extension() {
    override val name: String = "config"

    override suspend fun setup() {
        publicSlashCommand {
            name = "config"
            description = "Configurations for your server"

            publicSubCommand(::SetUpConfigArguments) {
                name = "set"
                description = "Sets a configuration"

                check {
                    hasPermission(Permission.ManageChannels)
                    requireBotPermissions(Permission.SendMessages)
                }

                action {

                }
            }
        }
    }

    inner class SetUpConfigArguments : Arguments() {
        val musicLog by channel {
            name = "musicLog"
            description = "Past music logs"
        }

        val joinChannelLog by channel {
            name = "joinChannelLog"
            description = "Your joins will create an embed here"
        }

        val leaveChannelLog by channel {
            name = "leaveChannelLog"
            description = "Your leaves will create an embed here"
        }
    }
}