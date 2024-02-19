package com.gildedrose;

public class ItemUpdaterFactory {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured Mana Cake";

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
}
