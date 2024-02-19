package com.gildedrose;

public class AgedBrieUpdater extends ItemUpdater {
    public AgedBrieUpdater(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        incrementQuality();
    }

    @Override
    void updateExpiredQuality() {
        incrementQuality();
    }
}
