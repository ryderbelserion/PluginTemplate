package com.ryderbelserion.template.paper;

import com.ryderbelserion.cluster.api.adventure.FancyLogger;
import com.ryderbelserion.template.common.config.types.PluginConfig;
import com.ryderbelserion.template.paper.api.plugin.CrazyHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class PaperTemplate extends JavaPlugin {

    private CrazyHandler crazyHandler;

    @Override
    public void onEnable() {
        this.crazyHandler = new CrazyHandler(getDataFolder());
        this.crazyHandler.install();

        FancyLogger.info("Guten Tag!");
    }

    @Override
    public void onDisable() {
        FancyLogger.info("Gute Nacht!");
    }

    public boolean isLogging() {
        return this.crazyHandler.getConfigManager().getPluginConfig().getProperty(PluginConfig.verbose_logging);
    }
}