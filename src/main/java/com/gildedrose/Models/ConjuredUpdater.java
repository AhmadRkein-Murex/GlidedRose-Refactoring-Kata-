package com.gildedrose.Models;

class ConjuredUpdater extends ItemUpdater {
    protected ConjuredUpdater(Item item) {
        super(item);
    }

    @Override
    public void update() {
        super.update();
        super.update();
    }
}
