package com.gildedrose;

public class BackstagePasses extends BaseItem {
    public BackstagePasses(Item item) {
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
