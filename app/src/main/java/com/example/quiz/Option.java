package com.example.quiz;

public class Option {

    public String[] science(int number){

        String[][] opt = {{"Cell", "Tissue", "Organ", "System"},
                {"Respiration", "Photosynthesis", "Transpiration", "Digestion"},
                {"Volt", "Ampere", "Ohm", "Watt"},
                {"Gravity", "Magnetism", "Friction", "Buoyancy"},
                {"Solid", "Liquid", "Plasma", "Light"},
                {"Biology", "Chemistry", "Meteorology", "Physics"},
                {"Temperature", "Length", "Acidity or basicity", "Light intensity"},
                {"Bacterial infections", "Viral infections", "Both (a) and (b)", " Fungal infections"},
                {"Digestion", "Absorption", "Assimilation", "Excretion"},
                {"Femur", "Tibia", "Fibula", "Humerus"},
                {"Solar energy", "Fossil fuels", "Wind energy", "Hydroelectric power"}};

        String[] send = opt[number];
        return send;
    }

    public String[] maths(int number){

        String[][] opt = {{"1/5", "3/10", "1/2", "Impossible"},
                {"7", "9", "11", "13"},
                {"x = 2, y = 3", "x = 3, y = 2", "x = 1, y = 4", "No solution"},
                {"12π cm³", "16π cm³", "20π cm³", "24π cm³"},
                {"3 - 4i", "3 + 4", "4i + 3", "i(3 + 4)"},
                {"3x²", "x²", "2x", "1"},
                {"0", "1", "Does not exist", "Infinity"},
                {"The function must be defined at x = 2", "The derivative of the function must exist at x = 2.", "The function must be differentiable at x = 2.", "The function must be continuous for all real numbers."},
                {"g(x) = (x - 1)/2", "g(x) = 2x - 1", "There is no inverse function.", "g(x) = 1/x"},
                {"1/3", "1/2", "2/3", "5/6"},
                {"y = (5/2)x", "y = (2/5)x", "x = 2y", "x + y = 7"}};

        String[] send = opt[number];
        return send;
    }

    public String[] gk(int number){

        String[][] opt = {{"Atlantic Ocean", "Pacific Ocean", "Indian Ocean", "Arctic Ocean"},
                {"Japan", "China", "South Korea", "Canada"},
                {"Big Ben", "Buckingham Palace", "Tower Bridge", "London Eye"},
                {"Ag", "Fe", "Au", "Cu"},
                {"2", "3", "4", "5"},
                {"William Shakespeare", "Charles Dickens", "ane Austen", "J.R.R. Tolkien"},
                {"Mount Everest", "K2", "Kangchenjunga", "Lhotse"},
                {"Euro", "US Dollar", "Yuan", "Yen"},
                {"Condensation", "Evaporation", "Precipitation", "Sublimation"},
                {"Twitter", "Instagram", "Facebook", "TikTok"},
                {"Sydney", "Melbourne", "Canberra", "Brisbane"}};

        String[] send = opt[number];
        return send;
    }

}
