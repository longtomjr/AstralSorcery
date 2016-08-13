package hellfirepvp.astralsorcery.client.util.item;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * This class is part of the Astral Sorcery Mod
 * The complete source code for this mod can be found on github.
 * Class: ItemRendererTESR
 * Created by HellFirePvP
 * Date: 31.07.2016 / 10:04
 */
public class ItemRendererTESR<T extends TileEntity> implements IItemRenderer {

    private final TileEntitySpecialRenderer<T> tesr;
    private final T tile;

    public ItemRendererTESR(TileEntitySpecialRenderer<T> tesr, T tile) {
        this.tesr = tesr;
        this.tile = tile;
    }

    @Override
    public void render(ItemStack stack) {
        tesr.renderTileEntityAt(tile, 0, 0, 0, 0, 0);
    }

}