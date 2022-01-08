package arm32x.minecraft.leatherblocks.block;

import arm32x.minecraft.leatherblocks.LeatherBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public final class LeatherBlockEntity extends BlockEntity {
	public static final int DEFAULT_COLOR = 0xA06540;
	public int color = DEFAULT_COLOR;

	public LeatherBlockEntity() {
		super(LeatherBlocks.LEATHER_BLOCK_ENTITY_TYPE.get());
	}

	@Override
	public void fromTag(BlockState state, NbtCompound nbt) {
		super.fromTag(state, nbt);
		color = nbt.getInt("color");
	}

	@Override
	public NbtCompound writeNbt(NbtCompound nbt) {
		super.writeNbt(nbt);
		nbt.putInt("color", color);
		return nbt;
	}

	@Override
	public NbtCompound toInitialChunkDataNbt() {
		return writeNbt(new NbtCompound());
	}

	public static int getColor(BlockView world, BlockPos pos) {
		if (world == null) {
			return LeatherBlockEntity.DEFAULT_COLOR;
		}
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity instanceof LeatherBlockEntity) {
			// Java 14 (i think?) patterns save so much boilerplate
			LeatherBlockEntity leatherBlockEntity = (LeatherBlockEntity)blockEntity;
			return leatherBlockEntity.color;
		} else {
			return LeatherBlockEntity.DEFAULT_COLOR;
		}
	}
}
