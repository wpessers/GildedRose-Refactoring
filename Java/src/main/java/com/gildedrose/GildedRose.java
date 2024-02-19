package com.gildedrose;

import static com.gildedrose.ItemUpdaterFactory.create;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        for (Item item : items) {
            ItemUpdater itemUpdater = create(item);
            itemUpdater.updateItem();
        }
    }
}
