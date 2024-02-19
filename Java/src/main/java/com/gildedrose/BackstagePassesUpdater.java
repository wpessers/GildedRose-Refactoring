package com.gildedrose;

public class BackstagePassesUpdater extends ItemUpdater {
    public BackstagePassesUpdater(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        incrementQuality();

        if (item.sellIn < 11) {
            incrementQuality();
        }

        if (item.sellIn < 6) {
            incrementQuality();
        }
    }

    @Override
    void updateExpiredQuality() {
        item.quality = 0;
    }
}
