package net.mcreator.gunsmithcognitis;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraftforge.client.model.BakedModelWrapper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;

import java.util.Map;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ThirdPersonTagFix {

    // Tags
    public static final TagKey<Item> PISTOL_TAG = ItemTags.create(new ResourceLocation("gunsmith_cognitis", "pistol"));
    public static final TagKey<Item> RIFLE_TAG = ItemTags.create(new ResourceLocation("gunsmith_cognitis", "rifle"));
    public static final TagKey<Item> LONGRIFLE_TAG = ItemTags.create(new ResourceLocation("gunsmith_cognitis", "long_rifle"));

    @SubscribeEvent
    public static void onModelBake(ModelBakeEvent event) {
        Map<ResourceLocation, BakedModel> modelRegistry = event.getModelRegistry();
        
        for (ResourceLocation location : modelRegistry.keySet()) {
            if (location.getNamespace().equals("gunsmith_cognitis")) {
                BakedModel originalModel = modelRegistry.get(location);
                modelRegistry.put(location, new GunModelWrapper(originalModel));
            }
        }
    }

    // Wrapper to handle the item overrides (needed to get the specific ItemStack)
    private static class GunModelWrapper extends BakedModelWrapper<BakedModel> {
        public GunModelWrapper(BakedModel original) {
            super(original);
        }

        @Override
        public ItemOverrides getOverrides() {
            return new GunOverridesWrapper(super.getOverrides());
        }
    }

    private static class GunOverridesWrapper extends ItemOverrides {
        private final ItemOverrides original;

        public GunOverridesWrapper(ItemOverrides original) {
            this.original = original;
        }

        @Override
        public BakedModel resolve(BakedModel model, ItemStack stack, net.minecraft.client.multiplayer.ClientLevel level, net.minecraft.world.entity.LivingEntity entity, int seed) {
            BakedModel resolved = original.resolve(model, stack, level, entity, seed);
            if (resolved == null) return null;
            return new GunStackModelWrapper(resolved, stack);
        }
    }

    private static class GunStackModelWrapper extends BakedModelWrapper<BakedModel> {
        private final ItemStack stack;

        public GunStackModelWrapper(BakedModel original, ItemStack stack) {
            super(original);
            this.stack = stack;
        }

        @Override
        public BakedModel handlePerspective(TransformType transformType, PoseStack poseStack) {
            // Check for Third Person (Right or Left hand)
            if (transformType == TransformType.THIRD_PERSON_RIGHT_HAND || transformType == TransformType.THIRD_PERSON_LEFT_HAND) {
                
                if (stack.is(PISTOL_TAG)) {
                    poseStack.translate(0.0D, 0.15D, -0.25D); 
                    poseStack.scale(0.85F, 0.85F, 0.85F);
                    poseStack.mulPose(Vector3f.XP.rotationDegrees(5)); // this is for rotation.
                } 
                
                else if (stack.is(RIFLE_TAG)) {
                    poseStack.translate(0.0D, 0.12D, -0.4D); 
                }
                
                else if (stack.is(LONGRIFLE_TAG)) {
                    poseStack.translate(0.0D, 0.13D, -0.42D); 
                    poseStack.scale(1.25F, 1.25F, 1.25F);
                }
            }
            
            // Return the model with the applied transformations
            return super.handlePerspective(transformType, poseStack);
        }
    }
}
