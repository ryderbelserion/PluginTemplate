package com.ryderbelserion.template.common.api;

import com.ryderbelserion.template.common.config.ConfigManager;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractPlugin {

    @NotNull
    public abstract ConfigManager getConfigManager();

}