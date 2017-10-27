/**
 * Created by Toll on 29.06.2017.
 */
public class Car implements Comparable<Car> {
    /**
     * Параметр имя модели
     */
    String ModelName;
    /**
     * Объем двигателя
     */
    Integer EngineVolume;

    public Car() {
    }

    public Car(String modelName, Integer engineVolume) {
        ModelName = modelName;
        EngineVolume = engineVolume;
    }

    /**
     * Метод1 работает
     * @return
     */
    public String getModelName() {
        return ModelName;
    }

    /**
     * Метод2 работает
     * @param modelName
     */
    public void setModelName(String modelName) {
        ModelName = modelName;
    }

    public Integer getEngineVolume() {
        return EngineVolume;
    }

    public void setEngineVolume(Integer engineVolume) {
        EngineVolume = engineVolume;
    }

    @Override
    public int compareTo(Car car) {
        return this.getEngineVolume() == car.getEngineVolume() ? 0 : this.getEngineVolume() > car.getEngineVolume() ? 1 : -1;

    }

    @Override
    public int hashCode() {

        return ModelName.hashCode();
    }

    @Override
    public String toString() {
        return getModelName() + getEngineVolume().toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj)  return true;
        if (!(obj instanceof Car)) return false;
        Car car = new Car();
        if (!this.ModelName.equals(car.ModelName)) return false;
        return true;
    }
}
