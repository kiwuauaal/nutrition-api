package com.nutrition.api.model

// Data class for nutrition information
data class NutritionInfo(
    val calories: Double,
    val protein: Double,
    val carbs: Double,
    val fat: Double,
    val fiber: Double? = null
)

// Food database with nutrition information per 100g
val FOOD_DATABASE = mapOf(
    // Fruits
    "mela" to NutritionInfo(52.0, 0.3, 13.8, 0.2, 2.4),
    "banana" to NutritionInfo(89.0, 1.1, 22.8, 0.3, 2.6),
    "arancia" to NutritionInfo(47.0, 0.9, 11.8, 0.1, 2.4),
    "mela verde" to NutritionInfo(50.0, 0.4, 13.7, 0.1, 2.1),
    "fragola" to NutritionInfo(32.0, 0.7, 7.7, 0.3, 2.0),
    "uva" to NutritionInfo(69.0, 0.7, 18.1, 0.2, 0.9),
    "pesca" to NutritionInfo(39.0, 0.9, 9.5, 0.3, 1.5),
    "albicocca" to NutritionInfo(48.0, 1.4, 11.1, 0.4, 2.0),
    "ciliegia" to NutritionInfo(63.0, 1.1, 16.0, 0.2, 2.1),
    "kiwi" to NutritionInfo(61.0, 1.1, 14.7, 0.5, 3.0),
    "limone" to NutritionInfo(29.0, 1.1, 9.3, 0.3, 2.8),
    "mandarino" to NutritionInfo(53.0, 0.8, 13.3, 0.3, 1.8),
    "ananas" to NutritionInfo(50.0, 0.5, 13.1, 0.1, 1.4),
    "melone" to NutritionInfo(34.0, 0.8, 8.2, 0.2, 0.9),
    "anguria" to NutritionInfo(30.0, 0.6, 7.6, 0.2, 0.4),

    // Vegetables
    "carota" to NutritionInfo(41.0, 0.9, 9.6, 0.2, 2.8),
    "broccoli" to NutritionInfo(34.0, 2.8, 7.0, 0.4, 2.6),
    "spinaci" to NutritionInfo(23.0, 2.9, 3.6, 0.4, 2.2),
    "insalata" to NutritionInfo(15.0, 1.4, 2.9, 0.2, 1.3),
    "pomodoro" to NutritionInfo(18.0, 0.9, 3.9, 0.2, 1.2),
    "cetriolo" to NutritionInfo(16.0, 0.7, 3.6, 0.1, 0.5),
    "peperone" to NutritionInfo(26.0, 1.0, 6.0, 0.3, 2.1),
    "zucchina" to NutritionInfo(17.0, 1.2, 3.1, 0.3, 1.0),
    "patata" to NutritionInfo(77.0, 2.0, 17.0, 0.1, 2.2),
    "patata dolce" to NutritionInfo(86.0, 1.6, 20.1, 0.1, 3.0),
    "cipolla" to NutritionInfo(40.0, 1.1, 9.3, 0.1, 1.7),
    "aglio" to NutritionInfo(149.0, 6.4, 33.1, 0.5, 2.1),
    "funghi" to NutritionInfo(22.0, 3.1, 3.3, 0.3, 2.5),
    "ravanello" to NutritionInfo(16.0, 0.7, 3.4, 0.1, 1.6),
    "sedano" to NutritionInfo(16.0, 0.7, 3.0, 0.2, 1.6),

    // Proteins
    "pollo petto" to NutritionInfo(165.0, 31.0, 0.0, 3.6, 0.0),
    "pollo coscia" to NutritionInfo(216.0, 26.1, 0.0, 13.5, 0.0),
    "manzo magro" to NutritionInfo(250.0, 26.1, 0.0, 15.1, 0.0),
    "manzo" to NutritionInfo(294.0, 26.1, 0.0, 21.1, 0.0),
    "maiale" to NutritionInfo(242.0, 26.1, 0.0, 14.1, 0.0),
    "salmone" to NutritionInfo(208.0, 20.4, 0.0, 13.4, 0.0),
    "tonno" to NutritionInfo(132.0, 29.9, 0.0, 1.0, 0.0),
    "sgombro" to NutritionInfo(167.0, 23.1, 0.0, 7.1, 0.0),
    "uova" to NutritionInfo(155.0, 12.6, 1.1, 10.6, 0.0),
    "formaggio parmigiano" to NutritionInfo(431.0, 38.1, 4.1, 29.1, 0.0),
    "mozzarella" to NutritionInfo(280.0, 28.1, 3.1, 17.1, 0.0),
    "formaggio fresco" to NutritionInfo(130.0, 11.1, 3.1, 7.1, 0.0),
    "yogurt greco" to NutritionInfo(59.0, 10.0, 3.6, 0.4, 0.0),
    "tonno in scatola" to NutritionInfo(132.0, 29.9, 0.0, 1.0, 0.0),

    // Grains and Carbs
    "pasta" to NutritionInfo(131.0, 5.0, 25.0, 1.0, 1.3),
    "riso bianco" to NutritionInfo(130.0, 2.7, 28.2, 0.3, 0.4),
    "riso basmati" to NutritionInfo(121.0, 3.1, 26.1, 0.3, 0.8),
    "pane bianco" to NutritionInfo(265.0, 9.0, 49.0, 3.2, 2.7),
    "pane integrale" to NutritionInfo(247.0, 13.0, 41.0, 3.5, 7.0),
    "fette biscottate" to NutritionInfo(420.0, 12.0, 68.0, 8.0, 4.0),
    "avena" to NutritionInfo(389.0, 16.9, 66.3, 6.9, 10.6),
    "quinoa" to NutritionInfo(120.0, 4.4, 21.3, 1.9, 2.8),
    "farro" to NutritionInfo(127.0, 6.1, 26.1, 1.1, 4.1),
    "orzo" to NutritionInfo(130.0, 4.7, 27.1, 1.1, 1.8),

    // Legumes
    "fagioli borlotti" to 132.0,
    "lenticchie" to 116.0,
    "ceci" to 164.0,
    "fave" to 110.0,

    // Nuts and Seeds
    "mandorle" to 579.0,
    "noci" to 654.0,
    "nocciole" to 628.0,
    "pistacchi" to 562.0,
    "semi di girasole" to 584.0,
    "semi di zucca" to 559.0,

    // Oils and Fats
    "olio d'oliva" to 884.0,
    "burro" to 717.0,
    "olio di semi" to 884.0,
    "margarina" to 717.0,

    // Dairy
    "latte intero" to 61.0,
    "latte parzialmente scremato" to 46.0,
    "latte scremato" to 34.0,
    "formaggio grana" to 431.0,
    "ricotta" to 174.0,

    // Sweets and Snacks
    "cioccolato fondente" to 546.0,
    "cioccolato al latte" to 535.0,
    "biscotti" to 450.0,
    "patatine" to 547.0,
    "crackers" to 420.0,

    // Beverages
    "acqua" to 0.0,
    "caffè" to 0.0,
    "tè" to 0.0,
    "succo d'arancia" to 45.0,
    "bibita gassata" to 42.0,
    "birra" to 43.0,
    "vino rosso" to 85.0,
    "vino bianco" to 82.0,

    // International Foods
    "hamburger" to 295.0,
    "pizza margherita" to 250.0,
    "sushi" to 135.0,
    "ramen" to 120.0,
    "taco" to 226.0,
    "insalata cesar" to 190.0,
    "panino" to 250.0,
    "wraps" to 220.0,

    // Breakfast Items
    "cornflakes" to 375.0,
    "muesli" to 380.0,
    "fiocchi d'avena" to 389.0,
    "cereali" to 370.0
).mapValues { entry ->
    if (entry.value is Double) {
        NutritionInfo(entry.value, 0.0, 0.0, 0.0, 0.0)
    } else {
        entry.value as NutritionInfo
    }
}

// Categories for better organization
val FOOD_CATEGORIES = mapOf(
    "frutta" to listOf("mela", "banana", "arancia", "mela verde", "fragola", "uva", "pesca", "albicocca", "ciliegia", "kiwi", "limone", "mandarino", "ananas", "melone", "anguria"),
    "verdura" to listOf("carota", "broccoli", "spinaci", "insalata", "pomodoro", "cetriolo", "peperone", "zucchina", "patata", "patata dolce", "cipolla", "aglio", "funghi", "ravanello", "sedano"),
    "proteine" to listOf("pollo petto", "pollo coscia", "manzo magro", "manzo", "maiale", "salmone", "tonno", "sgombro", "uova", "formaggio parmigiano", "mozzarella", "formaggio fresco", "yogurt greco", "tonno in scatola"),
    "cereali" to listOf("pasta", "riso bianco", "riso basmati", "pane bianco", "pane integrale", "fette biscottate", "avena", "quinoa", "farro", "orzo"),
    "legumi" to listOf("fagioli borlotti", "lenticchie", "ceci", "fave"),
    "frutta_secca" to listOf("mandorle", "noci", "nocciole", "pistacchi", "semi di girasole", "semi di zucca"),
    "grassi" to listOf("olio d'oliva", "burro", "olio di semi", "margarina"),
    "latticini" to listOf("latte intero", "latte parzialmente scremato", "latte scremato", "formaggio grana", "ricotta"),
    "dolci" to listOf("cioccolato fondente", "cioccolato al latte", "biscotti", "patatine", "crackers"),
    "bevande" to listOf("acqua", "caffè", "tè", "succo d'arancia", "bibita gassata", "birra", "vino rosso", "vino bianco"),
    "internazionale" to listOf("hamburger", "pizza margherita", "sushi", "ramen", "taco", "insalata cesar", "panino", "wraps"),
    "colazione" to listOf("cornflakes", "muesli", "fiocchi d'avena", "cereali")
)