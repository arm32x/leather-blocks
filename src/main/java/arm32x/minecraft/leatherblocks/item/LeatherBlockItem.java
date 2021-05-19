package arm32x.minecraft.leatherblocks.item;

import arm32x.minecraft.leatherblocks.LeatherBlocks;
import arm32x.minecraft.leatherblocks.block.LeatherBlockEntity;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.ActionResult;

public final class LeatherBlockItem extends BlockItem implements DyeableItem {
	public LeatherBlockItem() {
		super(LeatherBlocks.LEATHER_BLOCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
	}

	@Override
	public ActionResult place(ItemPlacementContext context) {
		ActionResult result = super.place(context);
		BlockEntity blockEntity = context.getWorld().getBlockEntity(context.getBlockPos());
		if (blockEntity instanceof LeatherBlockEntity) {
			LeatherBlockEntity leatherBlockEntity = (LeatherBlockEntity)blockEntity;
			leatherBlockEntity.color = getColor(context.getStack());
		}
		return result;
	}
}
