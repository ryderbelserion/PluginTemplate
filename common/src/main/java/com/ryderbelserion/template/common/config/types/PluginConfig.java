package com.ryderbelserion.template.common.config.types;

import ch.jalu.configme.Comment;
import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.configurationdata.CommentsConfiguration;
import ch.jalu.configme.properties.Property;
import ch.jalu.configme.properties.PropertyInitializer;
import org.jetbrains.annotations.NotNull;

public class PluginConfig implements SettingsHolder {

    protected PluginConfig() {}

    @Override
    public void registerComments(@NotNull CommentsConfiguration conf) {
        String[] header = {
                "Support: https://discord.gg/badbones-s-live-chat-182615261403283459",
                "Github: https://github.com/ryderbelserion/PluginTemplate",
                "",
                "Issues: https://github.com/ryderbelserion/PluginTemplate/issues",
                "Features: https://github.com/ryderbelserion/PluginTemplate/issues",
                ""
        };

        String[] deprecation = {
                "",
                "Warning: This section is subject to change so it is considered deprecated.",
                "This is your warning before the change happens.",
                ""
        };

        conf.setComment("language", header);
    }

    @Comment({
            "Choose the language you prefer to use on your server!",
            "",
            "Currently Available:",
            " > en-US ( English )",
            ""
    })
    public static final Property<String> locale_file = PropertyInitializer.newProperty("language", "en-US");

    @Comment("Whether you want CrazyEnvoys to shut up or not, This option is ignored by errors.")
    public static final Property<Boolean> verbose_logging = PropertyInitializer.newProperty("verbose_logging", true);

    @Comment({
            "Sends anonymous statistics about how the plugin is used to bstats.org.",
            "bstats is a service for plugin developers to find out how the plugin being used,",
            "This information helps us figure out how to better improve the plugin."
    })
    public static final Property<Boolean> toggle_metrics = PropertyInitializer.newProperty("toggle_metrics", false);

    // black, dark_blue, dark_green, dark_aqua, dark_red, dark_purple, gold, gray, dark_gray, blue, green, aqua, red, light_purple, yellow, or white
    @Comment("The command prefix you want shown in front of commands!")
    public static final Property<String> command_prefix = PropertyInitializer.newProperty("command_prefix", "<dark_gray>[</dark_gray><light_purple>YourConsolePrefix</light_purple><dark_gray>]</dark_gray> ");

    @Comment("The console prefix you want shown when the logging messages show up!")
    public static final Property<String> console_prefix = PropertyInitializer.newProperty("console_prefix" ,"<dark_gray>[</dark_gray><red>YourConsolePrefix</red><dark_gray>]</dark_gray> ");

}