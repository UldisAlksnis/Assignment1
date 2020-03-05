package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mediator.TemperatureModel;
import model.HeaterState;
import model.Temperature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ThermometerViewModel implements PropertyChangeListener
{
    private DoubleProperty t1;
    private DoubleProperty t2;
    private DoubleProperty t3;
    private StringProperty h1;
    private TemperatureModel model;
    private SimpleStringProperty thermometerID;
    private HeaterState state;

    public ThermometerViewModel(TemperatureModel model)
    {
        this.t1 = new SimpleDoubleProperty();
        this.t2 = new SimpleDoubleProperty();
        this.t3 = new SimpleDoubleProperty();
        this.h1 = new SimpleStringProperty();
        this.model = model;

        model.addListener("Temperature", this);
    }

    public DoubleProperty getT1()
    {
        return t1;
    }

    public DoubleProperty getT2()
    {
        return t2;
    }

    public DoubleProperty getT3()
    {
        return t3;
    }

    public StringProperty getH1()
    {
        return h1;
    }

    @Override public void propertyChange(PropertyChangeEvent evt)
    {
        Platform.runLater(() -> {
            switch (evt.getPropertyName())
            {
                case "Temperature":
                    Temperature incomingTemperature = (Temperature) evt.getNewValue();
                    switch (incomingTemperature.getId())
                    {
                        case "t1":
                            t1.set(incomingTemperature.getValue());
                            break;
                        case "t2":
                            t2.set(incomingTemperature.getValue());
                            break;
                        case "t3":
                            t3.set(incomingTemperature.getValue());
                            break;
                    }
            }
        });
    }
}