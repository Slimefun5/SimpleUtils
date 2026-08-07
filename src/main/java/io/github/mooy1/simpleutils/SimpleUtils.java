package io.github.mooy1.simpleutils;

import java.io.File;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPluginLoader;

import io.github.mooy1.infinitylib.core.AbstractAddon;
import io.github.mooy1.simpleutils.implementation.Items;
import io.github.thebusybiscuit.slimefun5.implementation.Slimefun;

public final class SimpleUtils extends AbstractAddon {

    public SimpleUtils(JavaPluginLoader loader, PluginDescriptionFile description, File dataFolder, File file) {
        super(loader, description, dataFolder, file,
                "Mooy1", "SimpleUtils", "master", "auto-update");
    }

    public SimpleUtils() {
        super("Mooy1", "SimpleUtils", "master", "auto-update");
    }

    @Override
    protected void enable() {
        Items.setup(this);
        Slimefun.getItemTranslationService().registerTranslations(this);
    }

    @Override
    protected void disable() {

    }

}
