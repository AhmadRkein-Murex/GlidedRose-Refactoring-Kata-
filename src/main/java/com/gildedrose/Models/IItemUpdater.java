package com.gildedrose.Models;

import static com.gildedrose.Models.Items.*;

public interface IItemUpdater {
    static ItemUpdater create(Item item) {
        switch (item.name) {
            case SULFURAS:
                return new SulfurasUpdater(item);
            case AGED_BRIE:
                return new AgedBrieUpdater(item);
            case BACKSTAGE_PASSES:
                return new BackstagePassesUpdater(item);
            case CONJURED:
                return new ConjuredUpdater(item);
            default:
                return new GenericItemUpdater(item);
        }
    }

    void update();
}
