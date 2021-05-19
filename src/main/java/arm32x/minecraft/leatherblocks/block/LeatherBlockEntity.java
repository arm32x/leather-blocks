package arm32x.minecraft.leatherblocks.block;

import arm32x.minecraft.leatherblocks.LeatherBlocks;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.fabricmc.fabric.api.rendering.data.v1.RenderAttachmentBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.NotNull;

public final class LeatherBlockEntity extends BlockEntity implements BlockEntityClientSerializable, RenderAttachmentBlockEntity {
	public static final int DEFAULT_COLOR = 0xA06540;
	public int color = DEFAULT_COLOR;

	public LeatherBlockEntity() {
		super(LeatherBlocks.LEATHER_BLOCK_ENTITY);
	}

	@Override
	public void fromTag(BlockState state, CompoundTag tag) {
		super.fromTag(state, tag);
		fromClientTag(tag);
	}

	@Override
	public void fromClientTag(CompoundTag tag) {
		color = tag.getInt("color");
	}

	@Override
	public CompoundTag toTag(CompoundTag tag) {
		super.toTag(tag);
		return toClientTag(tag);
	}

	@Override
	public CompoundTag toClientTag(CompoundTag tag) {
		tag.putInt("color", color);
		return tag;
	}

	@Override
	public @NotNull Integer getRenderAttachmentData() {
		return color;
	}

	public static int getColor(BlockView world, BlockPos pos) {
		if (world == null) {
			return LeatherBlockEntity.DEFAULT_COLOR;
		}
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity instanceof LeatherBlockEntity) {
			LeatherBlockEntity leatherBlockEntity = (LeatherBlockEntity)blockEntity;
			return leatherBlockEntity.getRenderAttachmentData();
		} else {
			return LeatherBlockEntity.DEFAULT_COLOR;
		}
	}
}