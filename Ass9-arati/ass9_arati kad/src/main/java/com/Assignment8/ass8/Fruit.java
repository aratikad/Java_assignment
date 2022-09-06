package com.Assignment8.ass8;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component   //@ Entity ?
public class Fruit {

    String FruitName;
    int FruitPrice;
    String FruitType;
    
}
