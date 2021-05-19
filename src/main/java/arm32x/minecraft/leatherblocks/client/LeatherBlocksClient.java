package arm32x.minecraft.leatherblocks.client;

import arm32x.minecraft.leatherblocks.LeatherBlocks;
import arm32x.minecraft.leatherblocks.block.LeatherBlockEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;

@Environment(EnvType.CLIENT)
public final class LeatherBlocksClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> LeatherBlockEntity.getColor(world, pos), LeatherBlocks.LEATHER_BLOCK);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> LeatherBlocks.LEATHER_BLOCK_ITEM.getColor(stack), LeatherBlocks.LEATHER_BLOCK_ITEM);
	}
}
