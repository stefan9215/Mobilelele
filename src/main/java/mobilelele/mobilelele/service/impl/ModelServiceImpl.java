package mobilelele.mobilelele.service.impl;

import mobilelele.mobilelele.model.entity.Brand;
import mobilelele.mobilelele.model.entity.Model;
import mobilelele.mobilelele.model.entity.enums.Category;
import mobilelele.mobilelele.repository.BrandRepository;
import mobilelele.mobilelele.repository.ModelRepository;
import mobilelele.mobilelele.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public void initializeModels() {
        if (modelRepository.count() == 0) {
            Brand bmw = brandRepository.findByName("Bmw");
            Brand suzuki = brandRepository.findByName("Suzuki");

            Model touring = new Model()
                    .setName("gPower")
                    .setCategory(Category.CAR)
                    .setStartYear(2004)
                    .setImageUrl("https://s1.cdn.autoevolution.com/images/news/g-power-hurricane-rs-bmw-m5-touring-official-specs-and-images-31606_1.jpg")
                    .setBrand(bmw);

            Model gsxR = new Model()
                    .setName("gsxR1000")
                    .setCategory(Category.MOTORCYCLE)
                    .setStartYear(2010)
                    .setImageUrl("https://m.netinfo.bg/media/images/49132/49132792/1180-663-suzuki-gsx-r1000.jpg")
                    .setBrand(suzuki);

            modelRepository.saveAll(List.of(touring, gsxR));
        }
    }
}
