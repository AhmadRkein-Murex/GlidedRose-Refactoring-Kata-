package com.gildedrose;

import com.gildedrose.Models.IItemUpdater;
import com.gildedrose.Models.Item;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            IItemUpdater itemUpdater = IItemUpdater.create(item);

            itemUpdater.update();
        }
    }
}
