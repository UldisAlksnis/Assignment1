package model;

public abstract class HeaterState
{
  public abstract void upClick(Heater heater);
  public abstract void downClick(Heater heater);

  public String status()
  {
    return getClass().getSimpleName();
  }
}
