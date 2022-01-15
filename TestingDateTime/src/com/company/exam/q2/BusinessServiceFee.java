package com.company.exam.q2;

public class BusinessServiceFee extends ServiceFee{
    private Integer licenses;
    public BusinessServiceFee(String name,Double monthlyFee,Integer licenses){
        super(name,monthlyFee);
        this.licenses = licenses;
    }
    @Override
    public String calculateFee(Integer months){
        Double ans = 0.0;
        ans = months * getMonthlyFee() * licenses;

        if(licenses>=10){
            ans -= months * getMonthlyFee()*licenses * 0.2;
        }
        return ans.toString();
    }

    @Override
    public String toString() {
        return super.toString() + " Licenses :" + licenses;
    }
}
