package arm32x.minecraft.leatherblocks;

import arm32x.minecraft.leatherblocks.block.LeatherBlock;
import arm32x.minecraft.leatherblocks.block.LeatherBlockEntity;
import arm32x.minecraft.leatherblocks.item.LeatherBlockItem;
import me.shedaniel.architectury.platform.Platform;
import me.shedaniel.architectury.registry.ColorHandlers;
import me.shedaniel.architectury.registry.DeferredRegister;
import me.shedaniel.architectury.registry.RegistrySupplier;
import me.shedaniel.architectury.utils.Env;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class LeatherBlocks {
	public static final String MOD_ID = "leatherblocks";

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(MOD_ID, Registry.BLOCK_KEY);
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(MOD_ID, Registry.BLOCK_ENTITY_TYPE_KEY);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registry.ITEM_KEY);

	public static final RegistrySupplier<LeatherBlock> LEATHER_BLOCK = BLOCKS.register("leather_block", LeatherBlock::new);
	public static final RegistrySupplier<BlockEntityType<LeatherBlockEntity>> LEATHER_BLOCK_ENTITY_TYPE = BLOCK_ENTITY_TYPES.register("leather_block", () ->
		BlockEntityType.Builder.create(LeatherBlockEntity::new, LEATHER_BLOCK.get()).build(null));
	public static final RegistrySupplier<LeatherBlockItem> LEATHER_BLOCK_ITEM = ITEMS.register("leather_block", LeatherBlockItem::new);


	public static void init() {
		BLOCKS.register();
		BLOCK_ENTITY_TYPES.register();
		ITEMS.register();
		if (Platform.getEnvironment() == Env.CLIENT) {
			initClient();
		}
	}

	@Environment(EnvType.CLIENT)
	public static void initClient() {
		ColorHandlers.registerBlockColors(((state, world, pos, tintIndex) -> LeatherBlockEntity.getColor(world, pos)), LeatherBlocks.LEATHER_BLOCK);
		ColorHandlers.registerItemColors(((stack, tintIndex) -> LeatherBlocks.LEATHER_BLOCK_ITEM.get().getColor(stack)), LeatherBlocks.LEATHER_BLOCK_ITEM);
	}
}
