package org.example.alphamodel.risorse;



    public enum CardColor {
        GREEN("\u001B[92m"),
        BLUE("\u001B[94m"),
        YELLOW("\u001B[93m"),
        PURPLE("\u001B[95m");
        final String RESET = "\u001B[0m";
        final int icon=9679;

        private String color;

        CardColor(String color) {
            this.color=color;
        }
        public String visualString(){
            return color+ (char)icon +RESET;
        }
    }


