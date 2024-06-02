package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.data.RouteRepository;
import bg.softuni.pathfinder.model.Picture;
import bg.softuni.pathfinder.model.Route;
import bg.softuni.pathfinder.service.dto.RouteShortInfoDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class RouteService {
    private RouteRepository routeRepository;
    private ModelMapper modelMapper;
    private Random random;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
        this.modelMapper = new ModelMapper ();
        this.random = new Random ();
    }
    @Transactional
    public RouteShortInfoDTO getRandomRoute (){
        long routeCount = routeRepository.count ();
        long randomId = random.nextLong (routeCount) + 1;

        Optional<Route> route = routeRepository.findById (randomId);

        if (route.isEmpty ()){
           // throw exception; return empty
        }

        RouteShortInfoDTO dto = modelMapper.map (route.get (), RouteShortInfoDTO.class);
        Optional<Picture> first = route.get ().getPictures ().stream ().findFirst ();
        dto.setImageUrl (first.get ().getUrl ());

        return dto;
    }
}
