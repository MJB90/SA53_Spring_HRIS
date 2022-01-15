package com.company.exam.q2;

public class ServiceFee {
    private String name;
    private Double monthlyFee;

    public ServiceFee(String name,Double monthlyFee){
        this.name = name;
        this.monthlyFee = monthlyFee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(Double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }
    public String calculateFee(Integer months){
        Double ans = 0.0;
        ans = months * getMonthlyFee();
        return ans.toString();
    }

    @Override
    public String toString() {
        return "ServiceFee{" +
                "name='" + name + '\'' +
                ", monthlyFee=" + monthlyFee +
                '}';
    }
}
