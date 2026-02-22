package net.mcreator.gunsmithcognitis.procedures;

import net.minecraft.world.entity.Entity;

public class TechbuttonnextProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("gui_tech_page") >= 3) {
			entity.getPersistentData().putDouble("gui_tech_page", 0);
		} else if (entity.getPersistentData().getDouble("gui_tech_page") < 0) {
			entity.getPersistentData().putDouble("gui_tech_page", 3);
		} else {
			entity.getPersistentData().putDouble("gui_tech_page", (entity.getPersistentData().getDouble("gui_tech_page") + 1));
		}
	}
}
