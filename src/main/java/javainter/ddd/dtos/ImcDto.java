package javainter.ddd.dtos;


public class ImcDto {

    private String userName;
    private double corpulanceWeight;
    private double corpulanceHeight;
    private double value;
    private String interpretation;

    public ImcDto(String userName, double corpulanceWeight, double corpulanceHeight, double value, String interpretation) {
        this.userName = userName;
        this.corpulanceWeight = corpulanceWeight;
        this.corpulanceHeight = corpulanceHeight;
        this.value = value;
        this.interpretation = interpretation;
    }

    public ImcDto() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getCorpulanceWeight() {
        return corpulanceWeight;
    }

    public void setCorpulanceWeight(double corpulanceWeight) {
        this.corpulanceWeight = corpulanceWeight;
    }

    public double getCorpulanceHeight() {
        return corpulanceHeight;
    }

    public void setCorpulanceHeight(double corpulanceHeight) {
        this.corpulanceHeight = corpulanceHeight;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(String interpretation) {
        this.interpretation = interpretation;
    }
}
