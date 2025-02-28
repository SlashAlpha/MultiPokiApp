package slash.code.table;

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
