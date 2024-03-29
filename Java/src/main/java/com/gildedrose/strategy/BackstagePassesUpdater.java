package com.gildedrose.strategy;

import com.gildedrose.Item;

public class BackstagePassesUpdater extends ItemUpdater {
    public BackstagePassesUpdater(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        incrementQuality();

        if (item.sellIn < 11) {
            incrementQuality();
        }

        if (item.sellIn < 6) {
            incrementQuality();
        }
    }

    @Override
    protected void updateExpiredQuality() {
        item.quality = 0;
    }
}
