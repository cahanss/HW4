package model;


public interface ConvDTO {

    
    double getRate();

    ConversionKey getKey();
    
    double convert(double amount);
    
    
    
}