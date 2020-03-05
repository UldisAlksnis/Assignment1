package model;

public class HeaterOff extends HeaterState
{
  @Override public void upClick(Heater heater)
  {
    heater.setState(new Heater1());
  }

  @Override public void downClick(Heater heater)
  {
    heater.status();
  }

  @Override public String status()
  {
    return "Heater is Off";
  }
}
