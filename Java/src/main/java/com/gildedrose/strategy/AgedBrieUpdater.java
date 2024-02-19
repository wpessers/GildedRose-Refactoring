package com.gildedrose.strategy;

import com.gildedrose.Item;

public class AgedBrieUpdater extends ItemUpdater {
    public AgedBrieUpdater(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        incrementQuality();
    }

    @Override
    protected void updateExpiredQuality() {
        incrementQuality();
    }
}
