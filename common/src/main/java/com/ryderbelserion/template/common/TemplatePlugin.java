package com.ryderbelserion.template.common;

import com.ryderbelserion.cluster.api.RootPlugin;
import com.ryderbelserion.cluster.api.adventure.FancyLogger;
import com.ryderbelserion.template.common.api.AbstractPlugin;
import com.ryderbelserion.template.common.config.ConfigManager;
import com.ryderbelserion.template.common.config.types.PluginConfig;
import net.kyori.adventure.audience.Audience;
import org.jetbrains.annotations.NotNull;
import java.io.File;

public class TemplatePlugin extends AbstractPlugin {

    private final ConfigManager configManager;

    public TemplatePlugin(File dataFolder) {
        this.configManager = new ConfigManager(dataFolder);
    }

    public void enable(Audience audience) {
        this.configManager.load();

        RootPlugin.setConsole(audience);
        FancyLogger.setName(this.configManager.getPluginConfig().getProperty(PluginConfig.console_prefix));
    }

    public void disable() {
        this.configManager.reload();
    }

    @Override
    @NotNull
    public ConfigManager getConfigManager() {
        return this.configManager;
    }
}