package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.data.RouteRepository;
import bg.softuni.pathfinder.model.Picture;
import bg.softuni.pathfinder.model.Route;
import bg.softuni.pathfinder.service.dto.RouteShortInfoDTO;
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

    public RouteShortInfoDTO getRandomRoute (){
        long routeCount = routeRepository.count ();
        long randomId = random.nextLong (routeCount) + 1;
        Optional<Route> byId = routeRepository.findById (randomId);

        if (byId.isEmpty ()){
           // throw exception; return empty
        }

        RouteShortInfoDTO dto = modelMapper.map (byId.get (), RouteShortInfoDTO.class);
        Optional<Picture> first = byId.get ().getPictures ().stream ().findFirst ();
        dto.setImageUrl (first.get ().getUrl ());

        return dto;
    }
}
