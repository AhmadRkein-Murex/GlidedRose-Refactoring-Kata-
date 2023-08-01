package com.gildedrose.Models;

class BackstagePassesUpdater extends ItemUpdater {
    protected BackstagePassesUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        int offset;
        if (item.sellIn <= 0) {
            offset = item.quality * -1;
        } else {
            offset = 1;
            if (item.sellIn < 6) {
                offset += 2;
            } else if (item.sellIn < 11) {
                offset++;
            }
        }

        processItem(offset);
    }
}
