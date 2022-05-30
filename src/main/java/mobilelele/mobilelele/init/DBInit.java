package mobilelele.mobilelele.init;

import mobilelele.mobilelele.service.BrandService;
import mobilelele.mobilelele.service.ModelService;
import mobilelele.mobilelele.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final BrandService brandService;
    private final ModelService modelService;
    private final UserService userService;

    public DBInit(BrandService brandService, ModelService modelService, UserService userService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        brandService.initializeBrands();
        modelService.initializeModels();
        userService.initializeUsers();
    }
}
