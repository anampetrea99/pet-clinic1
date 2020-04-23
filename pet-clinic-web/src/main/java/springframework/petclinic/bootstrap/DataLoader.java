package springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.petclinic.model.Owner;
import springframework.petclinic.model.PetType;
import springframework.petclinic.model.Vet;
import springframework.petclinic.services.OwnerService;
import springframework.petclinic.services.PetTypeService;
import springframework.petclinic.services.VetService;


@Component //this becomes a spring bean
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Jordan");

        ownerService.save(owner1);

        System.out.println("Loaded owner...");

        Vet vet = new Vet();
        vet.setFirstName("Mike");
        vet.setLastName("Ross");

        vetService.save(vet);

        System.out.println("Loaded vets....");
    }
}
