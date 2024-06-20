package com.example.quiz;

public class Question {

    public String science(int number){
        String[] quest = {"The smallest unit of life that can carry on all the activities of life is a?",
        "The process by which green plants make their own food using sunlight, water, and carbon dioxide is called?",
        "The unit of measurement for electric current is?",
        "The force that attracts objects towards the earth's surface is called?",
        "Which of the following is NOT a state of matter?",
        "The study of weather patterns and climate is called?",
        "The pH scale is used to measure?",
        "Vaccines are used to prevent?",
        "The process of breaking down food into simpler substances is called?",
        "The largest bone in the human body is the?",
        "Which of the following is NOT a renewable resource?"
        };

        String sendquestion = quest[number];
        return sendquestion;
    }

    public String maths(int number){

        String[] quest = {"A bag contains 3 red marbles, 5 blue marbles, and 2 yellow marbles. What is the probability of drawing a green marble?",
        "If f(x) = 2x² + 3x - 1, what is the value of f(2)?",
        "Solve the system of equations: x + y = 5 and 2x - y = 1",
        "The volume of a cone is (1/3)πr²h. What is the volume of a cone with a radius of 4 cm and a height of 3 cm?",
        "Express the following complex number in rectangular form: 3 + 4i",
        "The derivative of the function f(x) = x³ is",
        "What is the limit of the sequence 1, ½, ¼, … as n approaches infinity?",
        "A function is continuous at x = 2 if the one-sided limits lim_(x->2⁻) f(x) and lim_(x->2⁺) f(x) exist and are equal. What additional condition must be met for the function to be continuous at x = 2?",
        "What is the inverse function of f(x) = 2x + 1?",
        "A die is rolled. What is the probability of rolling a number greater than 4?",
        "A line intersects the x-axis at point (2, 0) and the y-axis at point (0, 5). What is the equation of the line?"};

        String sendquestion = quest[number];
        return sendquestion;
    }

    public String Gk(int number){

        String[] quest = {"What is the largest ocean on Earth by surface area?",
        "Which country hosted the 2022 Winter Olympics?",
        "What is the name of the famous clock tower in London?",
        "What is the chemical symbol for gold?",
        "How many heart chambers does a human body have?",
        "Who wrote the famous play \"Hamlet\"?",
        "What is the tallest mountain in the world?",
        "What is the currency of Japan?",
        "What is the process of turning liquid water into vapor called?",
        "What is the name of the largest social media platform by monthly active users?",
        "What is the capital of Australia? "};

        String sendquestion = quest[number];
        return sendquestion;

    }

}
