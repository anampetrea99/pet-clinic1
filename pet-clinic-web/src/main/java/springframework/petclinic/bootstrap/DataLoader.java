package springframework.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.petclinic.model.Owner;
import springframework.petclinic.model.Vet;
import springframework.petclinic.services.OwnerService;
import springframework.petclinic.services.VetService;


@Component //this becomes a spring bean
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {
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
