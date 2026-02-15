package com.nutrition.api.dto;

public class CalculateBmrResponse {
    private double bmr;
    private double tdee;
    private GoalsSuggestionResponse goalsSuggestion;

    // Getters and setters
    public double getBmr() { return bmr; }
    public void setBmr(double bmr) { this.bmr = bmr; }
    public double getTdee() { return tdee; }
    public void setTdee(double tdee) { this.tdee = tdee; }
    public GoalsSuggestionResponse getGoalsSuggestion() { return goalsSuggestion; }
    public void setGoalsSuggestion(GoalsSuggestionResponse goalsSuggestion) { this.goalsSuggestion = goalsSuggestion; }
}

class GoalsSuggestionResponse {
    private double mantenimentoPeso;
    private double perditaPeso;
    private double aumentoMassa;

    // Getters and setters
    public double getMantenimentoPeso() { return mantenimentoPeso; }
    public void setMantenimentoPeso(double mantenimentoPeso) { this.mantenimentoPeso = mantenimentoPeso; }
    public double getPerditaPeso() { return perditaPeso; }
    public void setPerditaPeso(double perditaPeso) { this.perditaPeso = perditaPeso; }
    public double getAumentoMassa() { return aumentoMassa; }
    public void setAumentoMassa(double aumentoMassa) { this.aumentoMassa = aumentoMassa; }
}