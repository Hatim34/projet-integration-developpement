package be.iccbxl.pid.reservationsspringboot.api.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import be.iccbxl.pid.reservationsspringboot.api.controller.ArtistApiController;
import be.iccbxl.pid.reservationsspringboot.model.Artist;

@Component
public class ArtistModelAssembler implements RepresentationModelAssembler<Artist, EntityModel<Artist>> {
    @Override
    public EntityModel<Artist> toModel(Artist artist) {
        return EntityModel.of(artist,
            linkTo(methodOn(ArtistApiController.class).one(artist.getId())).withSelfRel(),
            linkTo(methodOn(ArtistApiController.class).all()).withRel("artists"));
    }
}
