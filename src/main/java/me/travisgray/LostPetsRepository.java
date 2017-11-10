package me.travisgray;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by ${TravisGray} on 11/9/2017.
 */
public interface LostPetsRepository extends CrudRepository<PetDetails, Long> {
}
