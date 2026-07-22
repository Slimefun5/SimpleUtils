package io.github.mooy1.simpleutils.implementation;

import java.util.Arrays;

import javax.annotation.Nonnull;

import lombok.experimental.UtilityClass;

import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;

import io.github.mooy1.simpleutils.SimpleUtils;
import io.github.mooy1.simpleutils.implementation.blocks.Elevator;
import io.github.mooy1.simpleutils.implementation.blocks.Sieve;
import io.github.mooy1.simpleutils.implementation.blocks.Workbench;
import io.github.mooy1.simpleutils.implementation.tools.Wrench;
import io.github.mooy1.simpleutils.utils.MaterialCompat;
import io.github.thebusybiscuit.slimefun5.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun5.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun5.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun5.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun5.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun5.libraries.xseries.XMaterial;

@UtilityClass
public final class Items {

    // Names and lore live in languages/<lang>/items.yml (registered via the item translation service).
    public static final SlimefunItemStack WRENCH = new SlimefunItemStack(
            "SIMPLE_WRENCH",
            MaterialCompat.safe(XMaterial.IRON_HOE)
    );
    public static final SlimefunItemStack SIEVE = new SlimefunItemStack(
            "SIMPLE_SIEVE",
            MaterialCompat.safe(XMaterial.COMPOSTER)
    );
    public static final SlimefunItemStack ELEVATOR = new SlimefunItemStack(
            "SIMPLE_ELEVATOR",
            MaterialCompat.safe(XMaterial.QUARTZ_BLOCK)
    );
    public static final SlimefunItemStack WORKBENCH = new SlimefunItemStack(
            "SIMPLE_WORKBENCH",
            MaterialCompat.safe(XMaterial.CRAFTING_TABLE)
    );

    public static void setup(@Nonnull SimpleUtils plugin) {
        ItemGroup category = new ItemGroup(SimpleUtils.createKey("main"),
                CustomItemStack.create(MaterialCompat.safe(XMaterial.COMPOSTER), "&6Simple Utils"), 0);

        // Guide categories the auto-classifier heuristic can't infer from material/attributes.
        Workbench workbench = new Workbench(category, WORKBENCH, RecipeType.ENHANCED_CRAFTING_TABLE,
                Arrays.copyOf(new ItemStack[] {new ItemStack(MaterialCompat.safe(XMaterial.CRAFTING_TABLE))}, 9)
        );
        workbench.setGuideType("machines");
        workbench.register(plugin);

        Sieve sieve = new Sieve(category, SIEVE, new ItemStack[] {
                null, null, null,
                null, new ItemStack(MaterialCompat.safe(XMaterial.OAK_TRAPDOOR)), null,
                null, new ItemStack(MaterialCompat.safe(XMaterial.COMPOSTER)), null
        }, BlockFace.SELF);
        sieve.setGuideType("machines");
        sieve.register(plugin);

        Elevator elevator = new Elevator(category, ELEVATOR, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                new ItemStack(MaterialCompat.safe(XMaterial.QUARTZ_BLOCK)), new ItemStack(MaterialCompat.safe(XMaterial.QUARTZ_BLOCK)), new ItemStack(MaterialCompat.safe(XMaterial.QUARTZ_BLOCK)),
                new ItemStack(MaterialCompat.safe(XMaterial.QUARTZ_BLOCK)), new ItemStack(MaterialCompat.safe(XMaterial.ENDER_PEARL)), new ItemStack(MaterialCompat.safe(XMaterial.QUARTZ_BLOCK)),
                new ItemStack(MaterialCompat.safe(XMaterial.QUARTZ_BLOCK)), new ItemStack(MaterialCompat.safe(XMaterial.QUARTZ_BLOCK)), new ItemStack(MaterialCompat.safe(XMaterial.QUARTZ_BLOCK))
        });
        elevator.setGuideType("logistics");
        elevator.register(plugin);

        Wrench wrench = new Wrench(category, WRENCH, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                SlimefunItems.ALUMINUM_INGOT.item(), null, SlimefunItems.ALUMINUM_INGOT.item(),
                null, SlimefunItems.SILVER_INGOT.item(), null,
                null, SlimefunItems.ALUMINUM_INGOT.item(), null
        });
        wrench.setGuideType("tools");
        wrench.register(plugin);
    }

}
