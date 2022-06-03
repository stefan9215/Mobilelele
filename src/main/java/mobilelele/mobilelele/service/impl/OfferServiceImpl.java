package mobilelele.mobilelele.service.impl;

import mobilelele.mobilelele.model.entity.Offer;
import mobilelele.mobilelele.model.service.OfferAddServiceModel;
import mobilelele.mobilelele.repository.OfferRepository;
import mobilelele.mobilelele.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addOffer(OfferAddServiceModel offerAddServiceModel) {
        Offer offerToAdd = modelMapper.map(offerAddServiceModel, Offer.class);

//        offerRepository.findByModelName(offerAddServiceModel.getMo)

//        offerToAdd
//                .setModel()
    }
}
