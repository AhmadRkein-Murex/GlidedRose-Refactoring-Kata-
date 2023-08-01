package com.gildedrose.Models;

abstract class ItemUpdater implements IItemUpdater {
    int MIN_QUALITY = 0;
    int MAX_QUALITY = 50;

    protected final Item item;

    protected ItemUpdater(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        processItem(-1);
    }

    void offsetQualityAndClamp(int offset) {
        item.quality += offset;
        item.quality = Math.max(MIN_QUALITY, item.quality);
        item.quality = Math.min(MAX_QUALITY, item.quality);
    }

    void processItem(int offset) {
        if (item.sellIn < 0)
            offset *= 2;

        offsetQualityAndClamp(offset);
        item.sellIn -= 1;
    }

}
