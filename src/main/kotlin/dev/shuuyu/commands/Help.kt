package dev.shuuyu.commands

import com.kotlindiscord.kord.extensions.checks.anyGuild
import com.kotlindiscord.kord.extensions.checks.hasPermission
import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.publicSlashCommand
import dev.kord.common.entity.Permission
import io.github.qbosst.kordex.commands.hybrid.publicHybridCommand

class Help : Extension() {
    override val name: String = "help"

    override suspend fun setup() {
        publicHybridCommand {
            name = "help"
            description = "Shows all of the commands you can execute"

            check {
                anyGuild()
                hasPermission(Permission.SendMessages)

            }

            action {
                val paginator = respondingPaginator {

                    // Page 1
                    page {
                        title = "Music Related Commands"
                        field {
                            name = "**disconnect**"
                            value = "Disconnects the bot from the voice channel."
                        }
                        field {
                            name = "**play**"
                            value = "Plays the specified link or video from Youtube or Spotify."
                        }
                        field {
                            name = "**skip**"
                            value = "Skips the specified amount of songs."
                        }
                    }

                    // Page 2
                    page {
                        title = "General Commands"
                        field {
                            name = "**ping**"
                            value = "Checks your latency between you and the bot"
                        }
                        field {

                        }
                    }

                    // Page 3
                    page {
                        title = "Configurations"
                        field {
                            name = "**config**"
                            value = "Sets all configurations to be set in a specific area."
                        }
                    }
                }

                paginator.send()
            }
        }
    }
}