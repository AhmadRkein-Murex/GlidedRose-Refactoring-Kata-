package com.gildedrose.Models;

class AgedBrieUpdater extends ItemUpdater {
    protected AgedBrieUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        processItem(1);
    }
}
