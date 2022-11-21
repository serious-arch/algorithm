package com.seriousarch.designpattern.creational.builder.builders;

import com.seriousarch.designpattern.creational.builder.cars.CarType;
import com.seriousarch.designpattern.creational.builder.components.Engine;
import com.seriousarch.designpattern.creational.builder.components.GPSNavigator;
import com.seriousarch.designpattern.creational.builder.components.Transmission;
import com.seriousarch.designpattern.creational.builder.components.TripComputer;

/**
 * 通用生成器接口
 */
public interface Builder {

    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);

}
