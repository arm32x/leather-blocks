package arm32x.minecraft.leatherblocks;

import arm32x.minecraft.leatherblocks.block.LeatherBlock;
import arm32x.minecraft.leatherblocks.block.LeatherBlockEntity;
import arm32x.minecraft.leatherblocks.item.LeatherBlockItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class LeatherBlocks implements ModInitializer {
	public static final LeatherBlock LEATHER_BLOCK = new LeatherBlock();
	public static final LeatherBlockItem LEATHER_BLOCK_ITEM = new LeatherBlockItem();

	public static final BlockEntityType<LeatherBlockEntity> LEATHER_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(LeatherBlockEntity::new, LEATHER_BLOCK).build(null);

	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier("leatherblocks", "leather_block"), LEATHER_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("leatherblocks", "leather_block"), LEATHER_BLOCK_ITEM);

		Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("leatherblocks", "leather_block"), LEATHER_BLOCK_ENTITY);
	}
}
