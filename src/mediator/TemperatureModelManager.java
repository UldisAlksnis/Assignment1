package mediator;

import model.Heater;
import model.TemperatureList;
import model.Temperature;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureModelManager implements TemperatureModel
{
  private TemperatureList temperatureList;
  private PropertyChangeSupport property;
  private Heater heater;

  public TemperatureModelManager()
  {
    this.heater = new Heater();
    this.property = new PropertyChangeSupport(this);
    temperatureList = new TemperatureList();
  }

  @Override public synchronized void addTemperature(String id, double value)
  {
    Temperature temperature = new Temperature(id, value);
    Temperature old = getLastInsertedTemperature(id);
    this.temperatureList.addTemperature(temperature);
    if (old != null && old.getValue() != temperature.getValue())
    {
      System.out.println("-->" + temperature + " (from: " + old + ")");
      property.firePropertyChange("Temperature", old, temperature);
    }
  }

  @Override public synchronized Temperature getLastInsertedTemperature()
  {
    return temperatureList.getLastTemperature(null);
  }

  @Override public synchronized Temperature getLastInsertedTemperature(
      String id)
  {
    return temperatureList.getLastTemperature(id);
  }

  @Override public void addListener(String propertyName,
      PropertyChangeListener listener)
  {
    if (propertyName == null) // all events
    {
      property.addPropertyChangeListener(listener);
    }
    else // a specific event
    {
      property.addPropertyChangeListener(propertyName, listener);
    }
  }

  @Override public void removeListener(String propertyName,
      PropertyChangeListener listener)
  {
    if (propertyName == null) // all events
    {
      property.removePropertyChangeListener(listener);
    }
    else // a specific event
    {
      property.removePropertyChangeListener(propertyName, listener);
    }
  }

  // and maybe other methods...
}
