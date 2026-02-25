package net.mcreator.gunsmithcognitis.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class ResearchTableBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((new Object() {
			public Direction getDirection(BlockPos pos) {
				BlockState _bs = world.getBlockState(pos);
				Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (property != null && _bs.getValue(property) instanceof Direction _dir)
					return _dir;
				property = _bs.getBlock().getStateDefinition().getProperty("axis");
				if (property != null && _bs.getValue(property) instanceof Direction.Axis _axis)
					return Direction.fromAxisAndDirection(_axis, Direction.AxisDirection.POSITIVE);
				return Direction.NORTH;
			}
		}.getDirection(new BlockPos(x, y, z))) == Direction.NORTH) {
			if (!((world.getBlockState(new BlockPos(x - 1, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:replaceable_plants"))) || (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.AIR)) {
				{
					BlockPos _pos = new BlockPos(x, y, z);
					Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			} else {
				world.setBlock(new BlockPos(x, y + 1, z), Blocks.BARRIER.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x - 1, y, z), Blocks.BARRIER.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x - 1, y + 1, z), Blocks.BARRIER.defaultBlockState(), 3);
			}
		} else if ((new Object() {
			public Direction getDirection(BlockPos pos) {
				BlockState _bs = world.getBlockState(pos);
				Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (property != null && _bs.getValue(property) instanceof Direction _dir)
					return _dir;
				property = _bs.getBlock().getStateDefinition().getProperty("axis");
				if (property != null && _bs.getValue(property) instanceof Direction.Axis _axis)
					return Direction.fromAxisAndDirection(_axis, Direction.AxisDirection.POSITIVE);
				return Direction.NORTH;
			}
		}.getDirection(new BlockPos(x, y, z))) == Direction.SOUTH) {
			if (!((world.getBlockState(new BlockPos(x + 1, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:replaceable_plants"))) || (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.AIR)) {
				{
					BlockPos _pos = new BlockPos(x, y, z);
					Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			} else {
				world.setBlock(new BlockPos(x, y + 1, z), Blocks.BARRIER.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x + 1, y, z), Blocks.BARRIER.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x + 1, y + 1, z), Blocks.BARRIER.defaultBlockState(), 3);
			}
		} else if ((new Object() {
			public Direction getDirection(BlockPos pos) {
				BlockState _bs = world.getBlockState(pos);
				Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (property != null && _bs.getValue(property) instanceof Direction _dir)
					return _dir;
				property = _bs.getBlock().getStateDefinition().getProperty("axis");
				if (property != null && _bs.getValue(property) instanceof Direction.Axis _axis)
					return Direction.fromAxisAndDirection(_axis, Direction.AxisDirection.POSITIVE);
				return Direction.NORTH;
			}
		}.getDirection(new BlockPos(x, y, z))) == Direction.WEST) {
			if (!((world.getBlockState(new BlockPos(x, y, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:replaceable_plants"))) || (world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.AIR)) {
				{
					BlockPos _pos = new BlockPos(x, y, z);
					Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			} else {
				world.setBlock(new BlockPos(x, y + 1, z), Blocks.BARRIER.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y, z + 1), Blocks.BARRIER.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y + 1, z + 1), Blocks.BARRIER.defaultBlockState(), 3);
			}
		} else if ((new Object() {
			public Direction getDirection(BlockPos pos) {
				BlockState _bs = world.getBlockState(pos);
				Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (property != null && _bs.getValue(property) instanceof Direction _dir)
					return _dir;
				property = _bs.getBlock().getStateDefinition().getProperty("axis");
				if (property != null && _bs.getValue(property) instanceof Direction.Axis _axis)
					return Direction.fromAxisAndDirection(_axis, Direction.AxisDirection.POSITIVE);
				return Direction.NORTH;
			}
		}.getDirection(new BlockPos(x, y, z))) == Direction.EAST) {
			if (!((world.getBlockState(new BlockPos(x, y, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:replaceable_plants"))) || (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.AIR)) {
				{
					BlockPos _pos = new BlockPos(x, y, z);
					Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			} else {
				world.setBlock(new BlockPos(x, y + 1, z), Blocks.BARRIER.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y, z - 1), Blocks.BARRIER.defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y + 1, z - 1), Blocks.BARRIER.defaultBlockState(), 3);
			}
		}
	}
}
