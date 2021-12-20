package arm32x.minecraft.leatherblocks.fabric;

import arm32x.minecraft.leatherblocks.LeatherBlocks;
import net.fabricmc.api.ModInitializer;

public class LeatherBlocksFabric implements ModInitializer {
	@Override
	public void onInitialize() {
		LeatherBlocks.init();
	}
}
