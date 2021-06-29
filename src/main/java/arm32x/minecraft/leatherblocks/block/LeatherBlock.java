package arm32x.minecraft.leatherblocks.block;

import arm32x.minecraft.leatherblocks.LeatherBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public final class LeatherBlock extends Block implements BlockEntityProvider {
	public LeatherBlock() {
		super(FabricBlockSettings.of(Material.WOOD));
	}

	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new LeatherBlockEntity(pos, state);
	}

	@Override
	public BlockSoundGroup getSoundGroup(BlockState state) {
		return BlockSoundGroup.WOOD;
	}

	@Override
	public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
		ItemStack stack = super.getPickStack(world, pos, state);
		int color = LeatherBlockEntity.getColor(world, pos);
		if (color != LeatherBlockEntity.DEFAULT_COLOR) {
			LeatherBlocks.LEATHER_BLOCK_ITEM.setColor(stack, color);
		}
		return stack;
	}

}
