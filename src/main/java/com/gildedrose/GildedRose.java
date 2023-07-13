package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured Mana Cake";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals(SULFURAS))
                continue;

            int offset = getQualityOffset(item);

            if (item.sellIn < 0)
                offset *= 2;

            setQualityAndClamp(item, offset);

            item.sellIn -= 1;
        }
    }

    private static int getQualityOffset(Item item) {
        int offset = -1;

        switch (item.name) {
            case AGED_BRIE:
                offset = 1;
                break;
            case BACKSTAGE_PASSES:
                if (item.sellIn <= 0) {
                    offset = item.quality * -1;
                    break;
                }

                offset = 1;
                if (item.sellIn < 11)
                    offset++;
                if (item.sellIn < 6)
                    offset++;
                break;
            case CONJURED:
                offset *= 2;
                break;
        }
        return offset;
    }

    private static void setQualityAndClamp(Item item, int offset) {
        item.quality += offset;
        item.quality = Math.max(0, item.quality);
        item.quality = Math.min(50, item.quality);
    }
}
