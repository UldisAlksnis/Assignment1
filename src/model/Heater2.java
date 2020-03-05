package model;

public class Heater2 extends HeaterState
{
  @Override public void upClick(Heater heater)
  {
    heater.setState(new Heater3());
  }

  @Override public void downClick(Heater heater)
  {
    heater.setState(new Heater1());
  }

  @Override public String status()
  {
    return "Is heating medium";
  }
}
