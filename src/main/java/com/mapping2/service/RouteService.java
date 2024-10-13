package com.mapping2.service;

import com.mapping2.entity.Bus;
import com.mapping2.entity.BusStops;
import com.mapping2.entity.Stop;
import com.mapping2.payload.BusDto;
import com.mapping2.repository.BusRepository;
import com.mapping2.repository.BusStopsRepository;
import com.mapping2.repository.StopRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
@Service
public class RouteService {
    private BusRepository busRepository;
    private StopRepository stopRepository;
    private BusStopsRepository busStopsRepository;

    public RouteService(BusRepository busRepository, StopRepository stopRepository, BusStopsRepository busStopsRepository) {
        this.busRepository = busRepository;
        this.stopRepository = stopRepository;
        this.busStopsRepository = busStopsRepository;
    }


    public BusStops addRoutes(long busId, long stopId, Integer orderId) {
        Optional<Bus> busOptional = busRepository.findById(busId);
        if(!busOptional.isPresent()){
            return null;
        }
        Optional<Stop> stopOptional = stopRepository.findById(stopId);
        if(!stopOptional.isPresent()){
            return null;
        }
        Bus bus = busOptional.get();
        Stop stop = stopOptional.get();
        BusStops busStops = new BusStops();
        busStops.setBus(bus);
        busStops.setStop(stop);
        busStops.setOrder_id(orderId);
        return busStopsRepository.save(busStops);
    }

//    @GetMapping
//    public List<Bus> getBussDetails() {
//        List<Bus> bs = busRepository.findAll();
//        return bs;
//    }
}
