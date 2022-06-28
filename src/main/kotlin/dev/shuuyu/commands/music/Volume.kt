package dev.shuuyu.commands.music

import com.kotlindiscord.kord.extensions.DiscordRelayedException
import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.commands.Arguments
import com.kotlindiscord.kord.extensions.commands.application.slash.publicSubCommand
import com.kotlindiscord.kord.extensions.commands.converters.impl.int
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.shuuyu.constants.MusicConfig.MAX_VOLUME
import dev.shuuyu.constants.MusicConfig.MIN_VOLUME

class Volume : Extension() {
    override val name: String = "volume"

    override suspend fun setup() {
        publicSlashCommand(::VolumeArguments) {
            name = "Volume"
            description = "Increases or decreases the volume"

            publicSubCommand {
                name = "reset"
                description = "Resets the volume back to the default configuration (100)."

                check {
                    anyGuild()
                }

                action {

                }
            }

            publicSubCommand(::VolumeArguments) {
                name = "set"
                description = "Sets the volume to the specified amount (0-100)"

                check {
                    anyGuild()
                }

                action {
                    val configuredVolume = arguments.volume


                }
            }
        }
    }

    inner class VolumeArguments : Arguments() {
        val volume by int {
            name = "volume"
            description = "Changes the volume"

            validate {
                if (value > MAX_VOLUME) {
                    fail("Do you want to blast your ears or something? Are you insane?")
                    return@validate
                }
                if (value < MIN_VOLUME) {
                    fail("You cannot set your volume to be negative.")
                    return@validate
                }
            }
        }
    }
}