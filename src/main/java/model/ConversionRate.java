/*
 * The MIT License
 *
 * Copyright 2017 Leif Lindbäck <leifl@kth.se>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * A persistent representation of an account.
 */
@Entity
public class ConversionRate implements ConvDTO, Serializable {
    
    ConversionKey key;
    double rate;
    
    @EmbeddedId
    public ConversionKey getKey() {
        return key;
    }
        
    public void setKey(ConversionKey key) {
        this.key = key;
    }


    public double getRate(){
      return rate;
    }
    
    public void setRate(double rate) {
      this.rate = rate;
    }
    
        @Override
    public double convert(double amount){
        return rate * amount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        return (int) Double.valueOf(rate).hashCode() + key.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ConversionRate)) {
            return false;
        }
        ConversionRate other = (ConversionRate) object;
        return this.key == other.key;
    }

    @Override
    public String toString() {
        return "Currencyrate {rate=" + rate + ", toCurrency= " + key.getToCurrency() + ", fromCurrency= " + key.getFromCurrency() + '}';
    }

}
