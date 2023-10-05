package com.ryderbelserion.template.paper.api.plugin;

import com.ryderbelserion.cluster.api.adventure.FancyLogger;
import com.ryderbelserion.cluster.bukkit.BukkitPlugin;
import com.ryderbelserion.template.common.TemplatePlugin;
import com.ryderbelserion.template.common.config.ConfigManager;
import com.ryderbelserion.template.common.config.types.PluginConfig;
import com.ryderbelserion.template.paper.PluginTemplate;
import com.ryderbelserion.template.paper.support.MetricsHandler;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import java.io.File;

public class CrazyHandler extends TemplatePlugin {

    private final @NotNull PluginTemplate plugin = JavaPlugin.getPlugin(PluginTemplate.class);

    private BukkitPlugin bukkitPlugin;
    private MetricsHandler metrics;

    public CrazyHandler(File dataFolder) {
        super(dataFolder);
    }

    public void install() {
        // Enable cluster bukkit api.
        this.bukkitPlugin = new BukkitPlugin(this.plugin);
        this.bukkitPlugin.enable();

        // Enable our api.
        super.enable(this.plugin.getServer());

        // Enable metrics.
        boolean metrics = getConfigManager().getPluginConfig().getProperty(PluginConfig.toggle_metrics);

        this.metrics = new MetricsHandler();
        if (metrics) this.metrics.start();
    }

    public void uninstall() {
        // Disable our api.
        super.disable();

        // Disable cluster bukkit api.
        this.bukkitPlugin.disable();
    }

    @NotNull
    public MetricsHandler getMetrics() {
        return this.metrics;
    }

    /**
     * Inherited methods.
     */
    @Override
    @NotNull
    public ConfigManager getConfigManager() {
        return super.getConfigManager();
    }
}