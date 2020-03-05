package model;

public class Heater1 extends HeaterState
{
  @Override public void upClick(Heater heater)
  {
    heater.setState(new Heater2());
  }

  @Override public void downClick(Heater heater)
  {

  }

  @Override public String status()
  {
    return "Is Heating Low";
  }
}
