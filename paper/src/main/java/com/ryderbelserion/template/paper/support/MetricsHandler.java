package com.ryderbelserion.template.paper.support;

import com.ryderbelserion.cluster.api.adventure.FancyLogger;
import com.ryderbelserion.template.paper.PaperTemplate;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class MetricsHandler {

    private final @NotNull PaperTemplate plugin = JavaPlugin.getPlugin(PaperTemplate.class);

    private Metrics metrics;

    public void start() {
        if (this.metrics != null) {
            if (this.plugin.isLogging()) FancyLogger.warn("Metrics is already enabled.");
            return;
        }

        //TODO() Put your own metrics id.
        this.metrics = new Metrics(this.plugin, 1224);

        if (this.plugin.isLogging()) FancyLogger.success("Metrics has been enabled.");
    }

    public void stop() {
        if (this.metrics == null) {
            if (this.plugin.isLogging()) FancyLogger.warn("Metrics isn't enabled so we do nothing.");
            return;
        }

        this.metrics.shutdown();
        this.metrics = null;

        if (this.plugin.isLogging()) FancyLogger.success("Metrics has been turned off.");
    }
}