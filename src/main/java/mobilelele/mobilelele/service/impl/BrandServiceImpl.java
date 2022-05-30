package mobilelele.mobilelele.service.impl;

import mobilelele.mobilelele.model.entity.Brand;
import mobilelele.mobilelele.model.entity.Model;
import mobilelele.mobilelele.model.view.BrandViewModel;
import mobilelele.mobilelele.model.view.ModelViewModel;
import mobilelele.mobilelele.repository.BrandRepository;
import mobilelele.mobilelele.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initializeBrands() {
        if (brandRepository.count() == 0) {
            Brand bmw = new Brand()
                    .setName("Bmw");

            Brand suzuki = new Brand()
                    .setName("Suzuki");

            brandRepository.save(bmw);
            brandRepository.save(suzuki);
        }
    }

    @Override
    @Transactional
    public List<BrandViewModel> getAllBrands() {
        return brandRepository.findAll()
                .stream()
                .map(brandEntity -> {
                    BrandViewModel brandViewModel = new BrandViewModel()
                            .setName(brandEntity.getName());

                    brandViewModel.setModels(
                            brandEntity.getModels()
                                    .stream()
                                    .map(this::map)
                                    .collect(Collectors.toList()));

                    return brandViewModel;
                }).collect(Collectors.toList());
    }

    private ModelViewModel map(Model model) {
        return modelMapper.map(model, ModelViewModel.class);
    }
}
