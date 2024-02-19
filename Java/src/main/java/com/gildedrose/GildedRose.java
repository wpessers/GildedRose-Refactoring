package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private static void updateItem(Item item) {
        updateQuality(item);
        updateSellIn(item);
        updateExpiredQuality(item);
    }

    private static void updateQuality(Item item) {
        if (item.name.equals("Aged Brie")) {
            incrementQuality(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            incrementQuality(item);

            if (item.sellIn < 11) {
                incrementQuality(item);
            }

            if (item.sellIn < 6) {
                incrementQuality(item);
            }
        } else if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            decrementQuality(item);
        }
    }

    private static void updateSellIn(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn--;
    }

    private static void updateExpiredQuality(Item item) {
        if (item.sellIn < 0) {
            if (item.name.equals("Aged Brie")) {
                incrementQuality(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                item.quality = 0;
            } else if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                decrementQuality(item);
            }
        }
    }

    private static void decrementQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private static void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
