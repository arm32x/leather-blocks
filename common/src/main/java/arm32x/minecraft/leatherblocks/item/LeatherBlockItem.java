package arm32x.minecraft.leatherblocks.item;

import arm32x.minecraft.leatherblocks.LeatherBlocks;
import arm32x.minecraft.leatherblocks.block.LeatherBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;

public final class LeatherBlockItem extends BlockItem implements DyeableItem {
	public LeatherBlockItem() {
		super(LeatherBlocks.LEATHER_BLOCK.get(), new Item.Settings().group(ItemGroup.BUILDING_BLOCKS));
	}

	@Override
	public ActionResult place(ItemPlacementContext context) {
		ActionResult result = super.place(context);
		BlockEntity blockEntity = context.getWorld().getBlockEntity(context.getBlockPos());
		if (blockEntity instanceof LeatherBlockEntity leatherBlockEntity) {
			leatherBlockEntity.color = getColor(context.getStack());
		}
		return result;
	}
}
