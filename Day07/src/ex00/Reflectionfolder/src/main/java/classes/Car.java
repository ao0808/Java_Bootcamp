package ex00.Reflectionfolder.src.main.java.classes;

import java.util.StringJoiner;

public class Car {
    private String brandCar;
    private String modelCar;
    private Integer mileage;
    private Integer age;

    public Car(){
        brandCar = "Default brandCar Lastochka";
        modelCar = "Default modelCar Semerochka";
        mileage = 0;
        age = 15;
    }

    public Car(String brandCarIn, String modelCarIn, Integer mileageIn, Integer ageIn){
        brandCar = brandCarIn;
        modelCar = modelCarIn;
        mileage = mileageIn;
        age = ageIn;
    }

    public int updateAge(int value) {
        if (value >= 0){
            this.age = value;
        } else {
            System.out.println("Age change error, invalid negative value");
        }
        return age;
    }

    public int updateMileage(int value) {
        if (value >= 0) {
            this.mileage = value;
        } else {
            System.out.println("Mileage change error, invalid negative value");
        }
        return mileage;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
                .add("brandCar='" + brandCar + "'")
                .add("modelCar='" + modelCar + "'")
                .add("mileage=" + mileage + "'")
                .add("age=" + age)
                .toString();
    }
}


