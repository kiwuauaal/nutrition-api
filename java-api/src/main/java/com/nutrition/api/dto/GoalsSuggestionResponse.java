package com.nutrition.api.dto;

public class GoalsSuggestionResponse {
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