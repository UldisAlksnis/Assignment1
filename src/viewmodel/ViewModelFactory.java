package viewmodel;

import mediator.TemperatureModel;

public class ViewModelFactory
{
    private ThermometerViewModel thermometerViewModel;
    private DetailsViewModel detailsViewModel;

    public ViewModelFactory(TemperatureModel model){
        this.thermometerViewModel = new ThermometerViewModel(model);
        this.detailsViewModel = new DetailsViewModel(model);
    }

}
