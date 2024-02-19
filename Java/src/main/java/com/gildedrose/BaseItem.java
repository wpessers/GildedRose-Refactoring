package com.gildedrose;

public class BaseItem {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    final Item item;

    public BaseItem(Item item) {
        this.item = item;
    }

    public static BaseItem create(Item item) {
        switch (item.name) {
            case AGED_BRIE:
                return new AgedBrie(item);
            case BACKSTAGE_PASSES:
                return new BackstagePasses(item);
            case SULFURAS:
                ;
            default:
                return new BaseItem(item);
        }
    }

    protected void updateItem() {
        updateQuality();
        updateSellIn();
        if (item.sellIn < 0) {
            updateExpiredQuality();
        }
    }

    protected void updateQuality() {
        if (!item.name.equals(SULFURAS)) {
            decrementQuality();
        }
    }

    protected void updateSellIn() {
        if (item.name.equals(SULFURAS)) {
            return;
        }
        item.sellIn--;
    }

    protected void updateExpiredQuality() {
        if (!item.name.equals(SULFURAS)) {
            decrementQuality();
        }
    }

    void incrementQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    void decrementQuality() {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
