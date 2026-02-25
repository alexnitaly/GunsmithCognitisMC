
package net.mcreator.gunsmithcognitis.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.gunsmithcognitis.world.inventory.ResearchTableUIMenu;
import net.mcreator.gunsmithcognitis.procedures.ResearchTableTechNameProcedure;
import net.mcreator.gunsmithcognitis.procedures.ResearchTableTechDescriptionProcedure;
import net.mcreator.gunsmithcognitis.procedures.ResearchTableTechCostProcedure;
import net.mcreator.gunsmithcognitis.procedures.ResearchTableCurrentTechValueProcedure;
import net.mcreator.gunsmithcognitis.network.ResearchTableUIButtonMessage;
import net.mcreator.gunsmithcognitis.GunsmithCognitisMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ResearchTableUIScreen extends AbstractContainerScreen<ResearchTableUIMenu> {
	private final static HashMap<String, Object> guistate = ResearchTableUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_research;
	Button button_reprint;
	Button button_next;
	Button button_last;

	public ResearchTableUIScreen(ResearchTableUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 325;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("gunsmith_cognitis:textures/screens/research_table_ui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack,

				ResearchTableTechNameProcedure.execute(entity), 7, 35, -12829636);
		this.font.draw(poseStack,

				ResearchTableTechDescriptionProcedure.execute(entity), 7, 50, -12829636);
		this.font.draw(poseStack,

				ResearchTableTechCostProcedure.execute(entity), 7, 99, -12829636);
		this.font.draw(poseStack,

				ResearchTableCurrentTechValueProcedure.execute(entity), 7, 8, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.gunsmith_cognitis.research_table_ui.label_cost"), 7, 87, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.gunsmith_cognitis.research_table_ui.label_1_ink_paper"), 255, 126, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.gunsmith_cognitis.research_table_ui.label_ink_sack_and_paper"), 7, 110, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		button_research = new Button(this.leftPos + 126, this.topPos + 137, 67, 20, new TranslatableComponent("gui.gunsmith_cognitis.research_table_ui.button_research"), e -> {
			if (true) {
				GunsmithCognitisMod.PACKET_HANDLER.sendToServer(new ResearchTableUIButtonMessage(0, x, y, z));
				ResearchTableUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_research", button_research);
		this.addRenderableWidget(button_research);
		button_reprint = new Button(this.leftPos + 252, this.topPos + 137, 61, 20, new TranslatableComponent("gui.gunsmith_cognitis.research_table_ui.button_reprint"), e -> {
			if (true) {
				GunsmithCognitisMod.PACKET_HANDLER.sendToServer(new ResearchTableUIButtonMessage(1, x, y, z));
				ResearchTableUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_reprint", button_reprint);
		this.addRenderableWidget(button_reprint);
		button_next = new Button(this.leftPos + 271, this.topPos + 7, 46, 20, new TranslatableComponent("gui.gunsmith_cognitis.research_table_ui.button_next"), e -> {
			if (true) {
				GunsmithCognitisMod.PACKET_HANDLER.sendToServer(new ResearchTableUIButtonMessage(2, x, y, z));
				ResearchTableUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_next", button_next);
		this.addRenderableWidget(button_next);
		button_last = new Button(this.leftPos + 220, this.topPos + 7, 46, 20, new TranslatableComponent("gui.gunsmith_cognitis.research_table_ui.button_last"), e -> {
			if (true) {
				GunsmithCognitisMod.PACKET_HANDLER.sendToServer(new ResearchTableUIButtonMessage(3, x, y, z));
				ResearchTableUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_last", button_last);
		this.addRenderableWidget(button_last);
	}
}
