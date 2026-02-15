package com.nutrition.api.constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodDatabase {
    
    // Nutrition Info class
    public static class NutritionInfo {
        public final double calories;
        public final double protein;
        public final double carbs;
        public final double fat;
        public final Double fiber;

        public NutritionInfo(double calories, double protein, double carbs, double fat, Double fiber) {
            this.calories = calories;
            this.protein = protein;
            this.carbs = carbs;
            this.fat = fat;
            this.fiber = fiber;
        }

        public NutritionInfo(double calories, double protein, double carbs, double fat) {
            this(calories, protein, carbs, fat, null);
        }
    }

    // Food database with nutrition information per 100g
    public static final Map<String, NutritionInfo> FOOD_DATABASE = new HashMap<String, NutritionInfo>() {{
        // Fruits
        put("mela", new NutritionInfo(52.0, 0.3, 13.8, 0.2, 2.4));
        put("banana", new NutritionInfo(89.0, 1.1, 22.8, 0.3, 2.6));
        put("arancia", new NutritionInfo(47.0, 0.9, 11.8, 0.1, 2.4));
        put("mela verde", new NutritionInfo(50.0, 0.4, 13.7, 0.1, 2.1));
        put("fragola", new NutritionInfo(32.0, 0.7, 7.7, 0.3, 2.0));
        put("uva", new NutritionInfo(69.0, 0.7, 18.1, 0.2, 0.9));
        put("pesca", new NutritionInfo(39.0, 0.9, 9.5, 0.3, 1.5));
        put("albicocca", new NutritionInfo(48.0, 1.4, 11.1, 0.4, 2.0));
        put("ciliegia", new NutritionInfo(63.0, 1.1, 16.0, 0.2, 2.1));
        put("kiwi", new NutritionInfo(61.0, 1.1, 14.7, 0.5, 3.0));
        put("limone", new NutritionInfo(29.0, 1.1, 9.3, 0.3, 2.8));
        put("mandarino", new NutritionInfo(53.0, 0.8, 13.3, 0.3, 1.8));
        put("ananas", new NutritionInfo(50.0, 0.5, 13.1, 0.1, 1.4));
        put("melone", new NutritionInfo(34.0, 0.8, 8.2, 0.2, 0.9));
        put("anguria", new NutritionInfo(30.0, 0.6, 7.6, 0.2, 0.4));

        // Vegetables
        put("carota", new NutritionInfo(41.0, 0.9, 9.6, 0.2, 2.8));
        put("broccoli", new NutritionInfo(34.0, 2.8, 7.0, 0.4, 2.6));
        put("spinaci", new NutritionInfo(23.0, 2.9, 3.6, 0.4, 2.2));
        put("insalata", new NutritionInfo(15.0, 1.4, 2.9, 0.2, 1.3));
        put("pomodoro", new NutritionInfo(18.0, 0.9, 3.9, 0.2, 1.2));
        put("cetriolo", new NutritionInfo(16.0, 0.7, 3.6, 0.1, 0.5));
        put("peperone", new NutritionInfo(26.0, 1.0, 6.0, 0.3, 2.1));
        put("zucchina", new NutritionInfo(17.0, 1.2, 3.1, 0.3, 1.0));
        put("patata", new NutritionInfo(77.0, 2.0, 17.0, 0.1, 2.2));
        put("patata dolce", new NutritionInfo(86.0, 1.6, 20.1, 0.1, 3.0));
        put("cipolla", new NutritionInfo(40.0, 1.1, 9.3, 0.1, 1.7));
        put("aglio", new NutritionInfo(149.0, 6.4, 33.1, 0.5, 2.1));
        put("funghi", new NutritionInfo(22.0, 3.1, 3.3, 0.3, 2.5));
        put("ravanello", new NutritionInfo(16.0, 0.7, 3.4, 0.1, 1.6));
        put("sedano", new NutritionInfo(16.0, 0.7, 3.0, 0.2, 1.6));

        // Proteins
        put("pollo petto", new NutritionInfo(165.0, 31.0, 0.0, 3.6, 0.0));
        put("pollo coscia", new NutritionInfo(216.0, 26.1, 0.0, 13.5, 0.0));
        put("manzo magro", new NutritionInfo(250.0, 26.1, 0.0, 15.1, 0.0));
        put("manzo", new NutritionInfo(294.0, 26.1, 0.0, 21.1, 0.0));
        put("maiale", new NutritionInfo(242.0, 26.1, 0.0, 14.1, 0.0));
        put("salmone", new NutritionInfo(208.0, 20.4, 0.0, 13.4, 0.0));
        put("tonno", new NutritionInfo(132.0, 29.9, 0.0, 1.0, 0.0));
        put("sgombro", new NutritionInfo(167.0, 23.1, 0.0, 7.1, 0.0));
        put("uova", new NutritionInfo(155.0, 12.6, 1.1, 10.6, 0.0));
        put("formaggio parmigiano", new NutritionInfo(431.0, 38.1, 4.1, 29.1, 0.0));
        put("mozzarella", new NutritionInfo(280.0, 28.1, 3.1, 17.1, 0.0));
        put("formaggio fresco", new NutritionInfo(130.0, 11.1, 3.1, 7.1, 0.0));
        put("yogurt greco", new NutritionInfo(59.0, 10.0, 3.6, 0.4, 0.0));
        put("tonno in scatola", new NutritionInfo(132.0, 29.9, 0.0, 1.0, 0.0));

        // Grains and Carbs
        put("pasta", new NutritionInfo(131.0, 5.0, 25.0, 1.0, 1.3));
        put("riso bianco", new NutritionInfo(130.0, 2.7, 28.2, 0.3, 0.4));
        put("riso basmati", new NutritionInfo(121.0, 3.1, 26.1, 0.3, 0.8));
        put("pane bianco", new NutritionInfo(265.0, 9.0, 49.0, 3.2, 2.7));
        put("pane integrale", new NutritionInfo(247.0, 13.0, 41.0, 3.5, 7.0));
        put("fette biscottate", new NutritionInfo(420.0, 12.0, 68.0, 8.0, 4.0));
        put("avena", new NutritionInfo(389.0, 16.9, 66.3, 6.9, 10.6));
        put("quinoa", new NutritionInfo(120.0, 4.4, 21.3, 1.9, 2.8));
        put("farro", new NutritionInfo(127.0, 6.1, 26.1, 1.1, 4.1));
        put("orzo", new NutritionInfo(130.0, 4.7, 27.1, 1.1, 1.8));

        // Legumes (with only calorie info)
        put("fagioli borlotti", new NutritionInfo(132.0, 0.0, 0.0, 0.0, 0.0));
        put("lenticchie", new NutritionInfo(116.0, 0.0, 0.0, 0.0, 0.0));
        put("ceci", new NutritionInfo(164.0, 0.0, 0.0, 0.0, 0.0));
        put("fave", new NutritionInfo(110.0, 0.0, 0.0, 0.0, 0.0));

        // Nuts and Seeds
        put("mandorle", new NutritionInfo(579.0, 0.0, 0.0, 0.0, 0.0));
        put("noci", new NutritionInfo(654.0, 0.0, 0.0, 0.0, 0.0));
        put("nocciole", new NutritionInfo(628.0, 0.0, 0.0, 0.0, 0.0));
        put("pistacchi", new NutritionInfo(562.0, 0.0, 0.0, 0.0, 0.0));
        put("semi di girasole", new NutritionInfo(584.0, 0.0, 0.0, 0.0, 0.0));
        put("semi di zucca", new NutritionInfo(559.0, 0.0, 0.0, 0.0, 0.0));

        // Oils and Fats
        put("olio d'oliva", new NutritionInfo(884.0, 0.0, 0.0, 0.0, 0.0));
        put("burro", new NutritionInfo(717.0, 0.0, 0.0, 0.0, 0.0));
        put("olio di semi", new NutritionInfo(884.0, 0.0, 0.0, 0.0, 0.0));
        put("margarina", new NutritionInfo(717.0, 0.0, 0.0, 0.0, 0.0));

        // Dairy
        put("latte intero", new NutritionInfo(61.0, 0.0, 0.0, 0.0, 0.0));
        put("latte parzialmente scremato", new NutritionInfo(46.0, 0.0, 0.0, 0.0, 0.0));
        put("latte scremato", new NutritionInfo(34.0, 0.0, 0.0, 0.0, 0.0));
        put("formaggio grana", new NutritionInfo(431.0, 0.0, 0.0, 0.0, 0.0));
        put("ricotta", new NutritionInfo(174.0, 0.0, 0.0, 0.0, 0.0));

        // Sweets and Snacks
        put("cioccolato fondente", new NutritionInfo(546.0, 0.0, 0.0, 0.0, 0.0));
        put("cioccolato al latte", new NutritionInfo(535.0, 0.0, 0.0, 0.0, 0.0));
        put("biscotti", new NutritionInfo(450.0, 0.0, 0.0, 0.0, 0.0));
        put("patatine", new NutritionInfo(547.0, 0.0, 0.0, 0.0, 0.0));
        put("crackers", new NutritionInfo(420.0, 0.0, 0.0, 0.0, 0.0));

        // Beverages
        put("acqua", new NutritionInfo(0.0, 0.0, 0.0, 0.0, 0.0));
        put("caffè", new NutritionInfo(0.0, 0.0, 0.0, 0.0, 0.0));
        put("tè", new NutritionInfo(0.0, 0.0, 0.0, 0.0, 0.0));
        put("succo d'arancia", new NutritionInfo(45.0, 0.0, 0.0, 0.0, 0.0));
        put("bibita gassata", new NutritionInfo(42.0, 0.0, 0.0, 0.0, 0.0));
        put("birra", new NutritionInfo(43.0, 0.0, 0.0, 0.0, 0.0));
        put("vino rosso", new NutritionInfo(85.0, 0.0, 0.0, 0.0, 0.0));
        put("vino bianco", new NutritionInfo(82.0, 0.0, 0.0, 0.0, 0.0));

        // International Foods
        put("hamburger", new NutritionInfo(295.0, 0.0, 0.0, 0.0, 0.0));
        put("pizza margherita", new NutritionInfo(250.0, 0.0, 0.0, 0.0, 0.0));
        put("sushi", new NutritionInfo(135.0, 0.0, 0.0, 0.0, 0.0));
        put("ramen", new NutritionInfo(120.0, 0.0, 0.0, 0.0, 0.0));
        put("taco", new NutritionInfo(226.0, 0.0, 0.0, 0.0, 0.0));
        put("insalata cesar", new NutritionInfo(190.0, 0.0, 0.0, 0.0, 0.0));
        put("panino", new NutritionInfo(250.0, 0.0, 0.0, 0.0, 0.0));
        put("wraps", new NutritionInfo(220.0, 0.0, 0.0, 0.0, 0.0));

        // Breakfast Items
        put("cornflakes", new NutritionInfo(375.0, 0.0, 0.0, 0.0, 0.0));
        put("muesli", new NutritionInfo(380.0, 0.0, 0.0, 0.0, 0.0));
        put("fiocchi d'avena", new NutritionInfo(389.0, 0.0, 0.0, 0.0, 0.0));
        put("cereali", new NutritionInfo(370.0, 0.0, 0.0, 0.0, 0.0));
    }};

    // Categories for better organization
    public static final Map<String, List<String>> FOOD_CATEGORIES = new HashMap<String, List<String>>() {{
        put("frutta", List.of("mela", "banana", "arancia", "mela verde", "fragola", "uva", "pesca", "albicocca", "ciliegia", "kiwi", "limone", "mandarino", "ananas", "melone", "anguria"));
        put("verdura", List.of("carota", "broccoli", "spinaci", "insalata", "pomodoro", "cetriolo", "peperone", "zucchina", "patata", "patata dolce", "cipolla", "aglio", "funghi", "ravanello", "sedano"));
        put("proteine", List.of("pollo petto", "pollo coscia", "manzo magro", "manzo", "maiale", "salmone", "tonno", "sgombro", "uova", "formaggio parmigiano", "mozzarella", "formaggio fresco", "yogurt greco", "tonno in scatola"));
        put("cereali", List.of("pasta", "riso bianco", "riso basmati", "pane bianco", "pane integrale", "fette biscottate", "avena", "quinoa", "farro", "orzo"));
        put("legumi", List.of("fagioli borlotti", "lenticchie", "ceci", "fave"));
        put("frutta_secca", List.of("mandorle", "noci", "nocciole", "pistacchi", "semi di girasole", "semi di zucca"));
        put("grassi", List.of("olio d'oliva", "burro", "olio di semi", "margarina"));
        put("latticini", List.of("latte intero", "latte parzialmente scremato", "latte scremato", "formaggio grana", "ricotta"));
        put("dolci", List.of("cioccolato fondente", "cioccolato al latte", "biscotti", "patatine", "crackers"));
        put("bevande", List.of("acqua", "caffè", "tè", "succo d'arancia", "bibita gassata", "birra", "vino rosso", "vino bianco"));
        put("internazionale", List.of("hamburger", "pizza margherita", "sushi", "ramen", "taco", "insalata cesar", "panino", "wraps"));
        put("colazione", List.of("cornflakes", "muesli", "fiocchi d'avena", "cereali"));
    }};
}