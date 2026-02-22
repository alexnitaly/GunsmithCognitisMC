package net.mcreator.gunsmithcognitis.villager;

import net.mcreator.gunsmithcognitis.init.GunsmithCognitisModBlocks; // Make sure this matches your mod's init package
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.sounds.SoundEvents;
import com.google.common.collect.ImmutableSet;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GunsmithVillager {

    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, "gunsmith_cognitis");
    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, "gunsmith_cognitis");

    public static final RegistryObject<PoiType> POI = POI_TYPES.register("gunsmith", () -> 
        new PoiType("gunsmith", PoiType.getBlockStates(GunsmithCognitisModBlocks.RESEARCH_TABLE.get()), 1, 1));

    public static final RegistryObject<VillagerProfession> PROFESSION = PROFESSIONS.register("gunsmith", () -> 
        new VillagerProfession("gunsmith", POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_WEAPONSMITH));

    @SubscribeEvent
    public static void init(FMLConstructModEvent event) {
        POI_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        PROFESSIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}