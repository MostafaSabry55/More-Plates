package ms55.moreplates.common.item;

import java.util.Random;

import javax.annotation.Nonnull;

import ms55.moreplates.MorePlates;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HammerItem extends Item {

    private static final Random RAND = new Random();

	public HammerItem() {
		super(new Item.Properties()
				.group(MorePlates.ITEMGROUP)
                .maxStackSize(1)
                .maxDamage(150) //Should use config
                .setNoRepair());
	}

    @Override
    public int getMaxDamage(ItemStack stack) {
        return 150;
    }

	/*@Override
    public int getDamage(ItemStack stack) {
        return !stack.hasTag() ? getMaxDamage(stack) : stack.getOrCreateTag().getInt("Damage");
    }*/

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
    	ItemStack container = stack.copy();
		if (container.attemptDamageItem(1, RAND, null)) {
			return ItemStack.EMPTY;
		} else {
			return container;
		}
    }

    @Override
	public boolean isEnchantable(@Nonnull ItemStack stack) {
		return true;
	}

    @Override
    public int getItemEnchantability() {
        return 14;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment == Enchantments.UNBREAKING || enchantment == Enchantments.MENDING;
    }
}