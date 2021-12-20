package arm32x.minecraft.leatherblocks.forge;

import arm32x.minecraft.leatherblocks.LeatherBlocks;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(LeatherBlocks.MOD_ID)
public class LeatherBlocksForge {
	public LeatherBlocksForge() {
		// Submit our event bus to let Architectury register our content on the right time
		EventBuses.registerModEventBus(LeatherBlocks.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
		LeatherBlocks.init();
	}
}
