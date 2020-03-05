package view;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import viewmodel.ThermometerViewModel;

import java.awt.*;

public class ThermometerViewController
{
  @FXML private Label t1label;
  @FXML private Label t2label;
  @FXML private Label t3label;
  @FXML private Label hlabel;
  @FXML private TextField max;
  @FXML private TextField min;

  private Region root;
  private ThermometerViewModel viewModel;
  private ViewHandler viewHandler;

  public void init(ThermometerViewModel viewModel, ViewHandler viewHandler, Region root)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
    this.root = root;
  }

  public void reset()
  {
//    viewModel.clear();
  }

  public Region getRoot()
  {
    return root;
  }

  @FXML public void upPressed()
  {
        viewHandler.openView("thermometer");
  }

  @FXML public void downPressed()
  {
    viewHandler.openView("thermometer");
  }

  @FXML public void details()
  {
    viewHandler.openView("details");
  }
}
