package com.gildedrose.strategy;

import com.gildedrose.Item;

public class ConjuredUpdater extends ItemUpdater {
    public ConjuredUpdater(Item item) {
        super(item);
    }

    @Override
    protected void decrementQuality() {
        item.quality = Math.max(item.quality - 2, 0);
    }
}
