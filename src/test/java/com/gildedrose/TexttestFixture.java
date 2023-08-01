package com.gildedrose;

import com.gildedrose.Models.Item;

import static com.gildedrose.Models.Items.*;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[]{
            new Item(Dexterity_Vest, 10, 20), //
            new Item(AGED_BRIE, 2, 0), //
            new Item(Mongoose_Elixir, 5, 7), //
            new Item(SULFURAS, 0, 80), //
            new Item(SULFURAS, -1, 80),
            new Item(BACKSTAGE_PASSES, 15, 20),
            new Item(BACKSTAGE_PASSES, 10, 49),
            new Item(BACKSTAGE_PASSES, 5, 49),
            // this conjured item does not work properly yet
            new Item(CONJURED, 3, 6)};

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
