package arm32x.minecraft.leatherblocks;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

public class LeatherBlocks {
	public static final String MOD_ID = "leatherblocks";
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registry.ITEM_KEY);
	public static final RegistrySupplier<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () ->
		new Item(new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

	public static void init() {
		ITEMS.register();
	}
}
