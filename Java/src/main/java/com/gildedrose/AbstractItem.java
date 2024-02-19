package com.gildedrose;

public class AbstractItem {

    private final Item item;

    public AbstractItem(Item item) {
        this.item = item;
    }

    protected void updateItem() {
        updateQuality();
        updateSellIn();
        updateExpiredQuality();
    }

    protected void updateQuality() {
        if (item.name.equals("Aged Brie")) {
            incrementQuality();
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            incrementQuality();

            if (item.sellIn < 11) {
                incrementQuality();
            }

            if (item.sellIn < 6) {
                incrementQuality();
            }
        } else if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            decrementQuality();
        }
    }

    protected void updateSellIn() {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn--;
    }

    protected void updateExpiredQuality() {
        if (item.sellIn < 0) {
            if (item.name.equals("Aged Brie")) {
                incrementQuality();
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                item.quality = 0;
            } else if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                decrementQuality();
            }
        }
    }

    private void decrementQuality() {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void incrementQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
