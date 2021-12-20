package arm32x.minecraft.leatherblocks.block;

import arm32x.minecraft.leatherblocks.LeatherBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public final class LeatherBlockEntity extends BlockEntity {
	public static final int DEFAULT_COLOR = 0xA06540;
	public int color = DEFAULT_COLOR;

	public LeatherBlockEntity(BlockPos pos, BlockState state) {
		super(LeatherBlocks.LEATHER_BLOCK_ENTITY_TYPE.get(), pos, state);
	}

	@Override
	public void readNbt(NbtCompound nbt) {
		super.readNbt(nbt);
		color = nbt.getInt("color");
	}

	@Override
	protected void writeNbt(NbtCompound nbt) {
		super.writeNbt(nbt);
		nbt.putInt("color", color);
	}

	@Override
	public NbtCompound toInitialChunkDataNbt() {
		return createNbt();
	}

	public static int getColor(BlockView world, BlockPos pos) {
		if (world == null) {
			return LeatherBlockEntity.DEFAULT_COLOR;
		}
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity instanceof LeatherBlockEntity leatherBlockEntity) {
			return leatherBlockEntity.color;
		} else {
			return LeatherBlockEntity.DEFAULT_COLOR;
		}
	}
}
