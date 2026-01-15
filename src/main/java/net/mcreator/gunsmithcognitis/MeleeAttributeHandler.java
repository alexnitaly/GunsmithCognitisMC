package net.mcreator.gunsmithcognitis;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.TickEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.TagKey;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import java.util.UUID;

@Mod.EventBusSubscriber
public class MeleeAttributeHandler {

    // Unique UUID for the reach modifier to prevent conflicts
    // Hopefully
    private static final UUID REACH_MODIFIER_UUID = UUID.fromString("7827e13d-8517-4753-87e2-1c0000000000");
    private static final UUID PIKE_PENALTY_UUID = UUID.fromString("b292e13d-8517-4753-87e2-1c0000000001");

    @SubscribeEvent
    public static void onItemAttributes(ItemAttributeModifierEvent event) {
        TagKey<Item> LONG_REACH = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "melee_long_reach"));
        TagKey<Item> VERY_LONG_REACH = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "melee_pike"));

        if (event.getSlotType() == EquipmentSlot.MAINHAND) {
            if (event.getItemStack().is(LONG_REACH)) {
                
                // The Reach attribute itself: 1.0 is the added Modifier to the 3.0 Standard.
                event.addModifier(ForgeMod.REACH_DISTANCE.get(), new AttributeModifier(
                    REACH_MODIFIER_UUID, 
                    "Weapon reach modifier", 
                    1.0, 
                    AttributeModifier.Operation.ADDITION
                ));
            }
            else if (event.getItemStack().is(VERY_LONG_REACH)) {

                //THE PIKE AND SHOT ERA IS REAL, +4 over +1
                event.addModifier(ForgeMod.REACH_DISTANCE.get(), new AttributeModifier(
                    REACH_MODIFIER_UUID, 
                    "Weapon reach modifier", 
                    4.0, 
                    AttributeModifier.Operation.ADDITION
                ));
            }
        }
    }

    //This handles attack speed if holding something in the off-hand.
     @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            
            TagKey<Item> MELEE_PIKE = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("gunsmith_cognitis", "melee_pike"));

            ItemStack mainHand = player.getMainHandItem();
            ItemStack offHand = player.getOffhandItem();

            if (mainHand.is(MELEE_PIKE) && !offHand.isEmpty()) {
                
                // Adds a -0.4 penality to weapons tagged "pike" IF off-hand isn't empty
                if (player.getAttribute(Attributes.ATTACK_SPEED).getModifier(PIKE_PENALTY_UUID) == null) {
                    player.getAttribute(Attributes.ATTACK_SPEED).addTransientModifier(new AttributeModifier(
                        PIKE_PENALTY_UUID, 
                        "Off-hand encumbrance penalty", 
                        -0.4, 
                        AttributeModifier.Operation.MULTIPLY_TOTAL
                    ));
                }
            } else {
                // Remove the penalty if the conditions are no longer met
                if (player.getAttribute(Attributes.ATTACK_SPEED).getModifier(PIKE_PENALTY_UUID) != null) {
                    player.getAttribute(Attributes.ATTACK_SPEED).removeModifier(PIKE_PENALTY_UUID);
                }
            }
        }
    }
}
