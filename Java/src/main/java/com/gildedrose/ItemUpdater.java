package com.gildedrose;

public class ItemUpdater {
    final Item item;

    public ItemUpdater(Item item) {
        this.item = item;
    }

    void updateItem() {
        updateQuality();
        updateSellIn();
        if (item.sellIn < 0) {
            updateExpiredQuality();
        }
    }

    protected void updateQuality() {
        decrementQuality();
    }

    protected void updateSellIn() {
        item.sellIn--;
    }

    protected void updateExpiredQuality() {
        decrementQuality();
    }

    protected void incrementQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    protected void decrementQuality() {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
