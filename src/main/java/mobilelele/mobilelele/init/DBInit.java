package mobilelele.mobilelele.init;

import mobilelele.mobilelele.service.BrandService;
import mobilelele.mobilelele.service.ModelService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {
    private final BrandService brandService;
    private final ModelService modelService;

    public DBInit(BrandService brandService, ModelService modelService) {
        this.brandService = brandService;
        this.modelService = modelService;
    }

    @Override
    public void run(String... args) throws Exception {
        brandService.initializeBrands();
        modelService.initializeModels();
    }
}
