package slash.code.dealer.cards;

import lombok.AllArgsConstructor;


public class Card {
    final String color;
    final  Integer value;
    final  Integer faceVal;
    final  String description;


    public Card(String color, Integer value,Integer faceVal,String description) {
        this.color = color;
        this.value = value;
        this.faceVal=faceVal;
        this.description=description;

    }

    @Override
    public String toString() {
        if (description!=""){
            return description+" of "+color;}
        else{return value+" of " +color;}
    }

    public String stringify(){
        String card=this.value+"/"+this.color+"/"+this.description+"/"+this.faceVal;
        return card;
    }

    public Integer getValue() {
        return value;
    }


    public Integer getFaceVal() {
        return faceVal;
    }


    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }
}
