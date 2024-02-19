package com.gildedrose;

public class ConjuredUpdater extends ItemUpdater {
    public ConjuredUpdater(Item item) {
        super(item);
    }

    @Override
    void decrementQuality() {
        item.quality = Math.max(item.quality - 2, 0);
    }
}
