package stc21.smartmediator.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import stc21.smartmediator.repository.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class FillEntity {

    @Autowired
    private final UserStatusesRepository userStatusesRepository;

    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    private final UsersRolesRepository usersRolesRepository;

    @Autowired
    private final OrgStatusesRepository orgStatusesRepository;

    @Autowired
    private final OrganizationsRepository organizationsRepository;

    @Autowired
    private final UsersOrganizationsRepository usersOrganizationsRepository ;

    @Autowired
    private final SellersRepository sellersRepository;

    @Autowired
    private final BuyersRepository buyersRepository;

    public FillEntity(UserStatusesRepository userStatusesRepository,
                      UsersRepository usersRepository, UsersRolesRepository usersRolesRepository, OrgStatusesRepository orgStatusesRepository, OrganizationsRepository organizationsRepository, UsersOrganizationsRepository usersOrganizationsRepository, SellersRepository sellersRepository, BuyersRepository buyersRepository) {
        this.userStatusesRepository = userStatusesRepository;
        this.usersRepository = usersRepository;
        this.usersRolesRepository = usersRolesRepository;
        this.orgStatusesRepository = orgStatusesRepository;
        this.organizationsRepository = organizationsRepository;
        this.usersOrganizationsRepository = usersOrganizationsRepository;
        this.sellersRepository = sellersRepository;
        this.buyersRepository = buyersRepository;
    }

    public void clearData() {
        userStatusesRepository.deleteAll();
        usersRepository.deleteAll();
        usersRolesRepository.deleteAll();
        orgStatusesRepository.deleteAll();
        organizationsRepository.deleteAll();
    }

    public void fillData() {

        UserStatusesEntity verifyState = new UserStatusesEntity("confirm", "Подтверждён");

        List<UserStatusesEntity> statuses = new ArrayList<>();
        statuses.add(new UserStatusesEntity("new", "Новый"));
        statuses.add(new UserStatusesEntity("wait", "Ожидает"));
        statuses.add(verifyState);
        statuses.add(new UserStatusesEntity("ban", "Забанен"));
        userStatusesRepository.saveAll(statuses);

        List<OrgStatusesEntity> orgStatusesEntities = new ArrayList<>();
        OrgStatusesEntity orgStatusesEntity = new OrgStatusesEntity("new", "Новый");
        orgStatusesEntities.add(orgStatusesEntity);
        orgStatusesRepository.saveAll(orgStatusesEntities);

        List<UsersEntity> usersEntities = new ArrayList<>();
        UsersEntity admin = new UsersEntity("ema1@ema.ru", "123",
                "admin", verifyState.getId(), true);
        UsersEntity buy = new UsersEntity("ema2@ema.ru", "123",
                "buy", verifyState.getId(), true);
        UsersEntity sell = new UsersEntity("ema3@ema.ru", "123",
                "sell", verifyState.getId(), true);
        usersEntities.add(admin);
        usersEntities.add(buy);
        usersEntities.add(sell);
        usersRepository.saveAll(usersEntities);

        List<UsersRolesEntity> usersRolesEntities = new ArrayList<>();
        usersRolesEntities.add(new UsersRolesEntity(admin.getId(), "ADMIN"));
        usersRolesEntities.add(new UsersRolesEntity(buy.getId(), "BUYER"));
        usersRolesEntities.add(new UsersRolesEntity(sell.getId(), "SELLER"));
        usersRolesRepository.saveAll(usersRolesEntities);

        List<OrganizationsEntity> organizationsEntities = new ArrayList<>();
        OrganizationsEntity rogok = new OrganizationsEntity("AO Рожок",
                "AO Рожок", "1234599999011450",
                "Пр. Ленина 45", orgStatusesEntity.getId());

        OrganizationsEntity mag = new OrganizationsEntity("ООО Магнезит",
                "ООО Магнезит", "1234567891011450",
                "Ул. Мира 61", orgStatusesEntity.getId());

        OrganizationsEntity knopka = new OrganizationsEntity("ООО Кнопка",
                "ООО Кнопка", "6598465891011450",
                "Пр. Баумана 85", orgStatusesEntity.getId());

        organizationsEntities.add(rogok);
        organizationsEntities.add(mag);
        organizationsEntities.add(knopka);

        organizationsRepository.saveAll(organizationsEntities);

        List<UsersOrganizationsEntity> usersOrganizationsEntities = new ArrayList<>();
        usersOrganizationsEntities.add(new UsersOrganizationsEntity(admin.getId(), rogok.getId()));
        usersOrganizationsEntities.add(new UsersOrganizationsEntity(buy.getId(), mag.getId()));
        usersOrganizationsEntities.add(new UsersOrganizationsEntity(sell.getId(), knopka.getId()));
        usersOrganizationsRepository.saveAll(usersOrganizationsEntities);

        sellersRepository.save(new SellersEntity(rogok.getId()));

    }

}
