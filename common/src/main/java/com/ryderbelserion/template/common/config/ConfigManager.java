package com.ryderbelserion.template.common.config;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.SettingsManagerBuilder;
import com.ryderbelserion.template.common.config.types.PluginConfig;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class ConfigManager {

    private final File dataFolder;

    public ConfigManager(File dataFolder) {
        this.dataFolder = dataFolder;
    }

    private SettingsManager pluginConfig;

    public void load() {
        // Create the plugin-config.yml file.
        File pluginConfigFile = new File(this.dataFolder, "plugin-config.yml");

        // Bind it to settings manager
        this.pluginConfig = SettingsManagerBuilder
                .withYamlFile(pluginConfigFile)
                .useDefaultMigrationService()
                .configurationData(PluginConfig.class)
                .create();
    }

    public void reload() {
        // Reload plugin-config.yml
        this.pluginConfig.reload();
    }

    @NotNull
    public SettingsManager getPluginConfig() {
        return this.pluginConfig;
    }
}