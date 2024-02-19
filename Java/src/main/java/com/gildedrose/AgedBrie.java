package com.gildedrose;

public class AgedBrie extends BaseItem {
    public AgedBrie(Item item) {
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
