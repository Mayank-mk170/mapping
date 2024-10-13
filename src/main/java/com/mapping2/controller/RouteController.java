package com.mapping2.controller;

import com.mapping2.entity.Bus;
import com.mapping2.entity.BusStops;
import com.mapping2.entity.Stop;
import com.mapping2.payload.BusDto;
import com.mapping2.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/routes")
public class RouteController {
    private RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }
//    @GetMapping
//    public ResponseEntity<List<BusDto>> getBus(){
//        List<BusDto> bus = RouteService.getBussDetails();
//        return  new ResponseEntity<>(bus, HttpStatus.OK);
//    }
    @PostMapping
    public ResponseEntity<String> addRoute(
            @RequestParam long busId,
            @RequestParam long stopId,
            @RequestParam Integer orderId
    ){
        BusStops bus = routeService.addRoutes(busId,stopId,orderId);
        if(bus == null){
            return  new ResponseEntity<>("Bus Or Stop not found",HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Bus stop add successfully",HttpStatus.CREATED);

    }
}
