package mobilelele.mobilelele.service;

import mobilelele.mobilelele.model.view.BrandViewModel;

import java.util.List;

public interface BrandService {

    void initializeBrands();

    List<BrandViewModel> getAllBrands();
}
