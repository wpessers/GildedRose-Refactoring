package com.gildedrose;

import static com.gildedrose.BaseItem.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        for (Item item : items) {
            BaseItem baseItem = create(item);
            baseItem.updateItem();
        }
    }
}
