package com.example.quiz;

public class Answer {

    public String science(int number){

        String[] ans = {"Cell",
                "Photosynthesis",
                "Ampere",
                "Gravity",
                "Light",
                "Meteorology",
                "Acidity or basicity",
                "Both (a) and (b)",
                "Digestion",
                "Femur",
                "Fossil fuels"};

        String send = ans[number];
        return send;
    }

    public String maths(int number){

        String[] ans = {"1/5",
                "7",
                "x = 2, y = 3",
                "12π cm³",
                "3 + 4",
                "3x²",
                "0",
                "The function must be defined at x = 2",
                "g(x) = (x - 1)/2",
                "1/3",
                "y = (5/2)x"};

        String send = ans[number];
        return send;
    }

    public String gk(int number){

        String[] ans = {"Pacific Ocean",
                "China",
                "Big Ben",
                "Au",
                "4",
                "William Shakespeare",
                "Mount Everest",
                "Yen",
                "Evaporation",
                "Facebook",
                "Canberra"};

        String send = ans[number];
        return send;
    }
}
