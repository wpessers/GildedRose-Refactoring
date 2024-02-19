package com.gildedrose;

public class ConjuredUpdater extends ItemUpdater {
    public ConjuredUpdater(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        item.quality -= 2;
    }

    @Override
    void updateExpiredQuality() {
        item.quality -= 2;
    }
}
