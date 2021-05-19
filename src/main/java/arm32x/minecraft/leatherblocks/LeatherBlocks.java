package arm32x.minecraft.leatherblocks;

import arm32x.minecraft.leatherblocks.block.LeatherBlock;
import arm32x.minecraft.leatherblocks.block.LeatherBlockEntity;
import arm32x.minecraft.leatherblocks.item.LeatherBlockItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class LeatherBlocks implements ModInitializer {
	public static final LeatherBlock LEATHER_BLOCK = new LeatherBlock();
	public static final LeatherBlockItem LEATHER_BLOCK_ITEM = new LeatherBlockItem();

	public static final BlockEntityType<LeatherBlockEntity> LEATHER_BLOCK_ENTITY = BlockEntityType.Builder.create(LeatherBlockEntity::new, LEATHER_BLOCK).build(null);

	@Override
	public void onInitialize() {
		Registry.register(Registry.BLOCK, new Identifier("leatherblocks", "leather_block"), LEATHER_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("leatherblocks", "leather_block"), LEATHER_BLOCK_ITEM);

		Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("leatherblocks", "leather_block"), LEATHER_BLOCK_ENTITY);

		ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> LeatherBlockEntity.getColor(world, pos), LEATHER_BLOCK);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> LEATHER_BLOCK_ITEM.getColor(stack), LEATHER_BLOCK_ITEM);
	}
}
