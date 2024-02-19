package com.gildedrose;

public class ItemUpdater {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured Mana Cake";
    final Item item;

    public ItemUpdater(Item item) {
        this.item = item;
    }

    public static ItemUpdater create(Item item) {
        switch (item.name) {
            case AGED_BRIE:
                return new AgedBrieUpdater(item);
            case BACKSTAGE_PASSES:
                return new BackstagePassesUpdater(item);
            case SULFURAS:
                return new SulfurasUpdater(item);
            case CONJURED:
                return new ConjuredUpdater(item);
            default:
                return new ItemUpdater(item);
        }
    }

    void updateItem() {
        updateQuality();
        updateSellIn();
        if (item.sellIn < 0) {
            updateExpiredQuality();
        }
    }

    void updateQuality() {
        decrementQuality();
    }

    void updateSellIn() {
        item.sellIn--;
    }

    void updateExpiredQuality() {
        decrementQuality();
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
