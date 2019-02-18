package net.manmaed.cookies.items;

public class CookieTypes {
    public enum Shapes {
        ROUND(1, 1f),
        SQUARE(2, 2f),
        STAR(1, 1f);

        private int hungerRestored;
        private float station;

        Shapes(int hungerRestored, float station) {
            this.hungerRestored = hungerRestored;
            this.station = station;
        }

        public float getStation() {
            return station;
        }

        public int getHungerRestored() {
            return hungerRestored;
        }
    }

    public enum Types {
        PLAIN(2, 1f),
        SUGAR(1, 3),
        CHOCOLATE_CHIP(2, 2f),
        DOUBLE_CHOCOLATE_CHIP(3, 4f);


        private int hungerRestored;
        private float station;

        Types(int hungerRestored, float station) {
            this.hungerRestored = hungerRestored;
            this.station = station;
        }

        public int getHungerRestored() {
            return hungerRestored;
        }

        public float getStation() {
            return station;
        }
    }
}
