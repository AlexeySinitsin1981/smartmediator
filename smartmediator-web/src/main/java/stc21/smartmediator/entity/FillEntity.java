package stc21.smartmediator.entity;

import org.springframework.stereotype.Component;
import stc21.smartmediator.repository.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class FillEntity {

    private final UserStatusesRepository userStatusesRepository;
    private final UsersRepository usersRepository;
    private final UsersRolesRepository usersRolesRepository;
    private final OrgStatusesRepository orgStatusesRepository;
    private final OrganizationsRepository organizationsRepository;
    private final UsersOrganizationsRepository usersOrganizationsRepository;
    private final SellersRepository sellersRepository;
    private final BuyersRepository buyersRepository;
    private final PricePatternsRepository pricePatternsRepository;
    private final ProductsTypesRepository productsTypesRepository;
    private final ProductsRepository productsRepository;
    private final UnitsRepository unitsRepository;
    private final PricesRepository pricesRepository;
    private final OrderStatusesRepository orderStatusesRepository;
    private final DeliveryTypesRepository deliveryTypesRepository;
    private final LogisticsPointsRepository logisticsPointsRepository;
    private final OrdersRepository ordersRepository;

    public FillEntity(UserStatusesRepository userStatusesRepository,
                      UsersRepository usersRepository, UsersRolesRepository usersRolesRepository, OrgStatusesRepository orgStatusesRepository, OrganizationsRepository organizationsRepository, UsersOrganizationsRepository usersOrganizationsRepository, SellersRepository sellersRepository, BuyersRepository buyersRepository, PricePatternsRepository pricePatternsRepository, ProductsTypesRepository productsTypesRepository, ProductsRepository productsRepository, UnitsRepository unitsRepository, PricesRepository pricesRepository, OrderStatusesRepository orderStatusesRepository, DeliveryTypesRepository deliveryTypesRepository, LogisticsPointsRepository logisticsPointsRepository, OrdersRepository ordersRepository) {
        this.userStatusesRepository = userStatusesRepository;
        this.usersRepository = usersRepository;
        this.usersRolesRepository = usersRolesRepository;
        this.orgStatusesRepository = orgStatusesRepository;
        this.organizationsRepository = organizationsRepository;
        this.usersOrganizationsRepository = usersOrganizationsRepository;
        this.sellersRepository = sellersRepository;
        this.buyersRepository = buyersRepository;
        this.pricePatternsRepository = pricePatternsRepository;
        this.productsTypesRepository = productsTypesRepository;
        this.productsRepository = productsRepository;
        this.unitsRepository = unitsRepository;
        this.pricesRepository = pricesRepository;
        this.orderStatusesRepository = orderStatusesRepository;
        this.deliveryTypesRepository = deliveryTypesRepository;
        this.logisticsPointsRepository = logisticsPointsRepository;
        this.ordersRepository = ordersRepository;
    }

    public void clearData() {

    }

    public void fillData() {

        UserStatusesEntity verifyState = new UserStatusesEntity("confirm", "Подтверждён");

        DeliveryTypesEntity supply = new DeliveryTypesEntity("supply", "Доставка");
        deliveryTypesRepository.save(supply);

        List<OrderStatusesEntity> orderStatusesEntities = new ArrayList<>();

        OrderStatusesEntity oNew = new OrderStatusesEntity("new", "Новый");
        OrderStatusesEntity oConfirm = new OrderStatusesEntity("confirm", "Подтвержден");
        OrderStatusesEntity oCancel = new OrderStatusesEntity("cancel", "Отменен");
        OrderStatusesEntity oDelivered = new OrderStatusesEntity("delivered", "Доставлен");

        orderStatusesEntities.add(oNew);
        orderStatusesEntities.add(oConfirm);
        orderStatusesEntities.add(oCancel);
        orderStatusesEntities.add(oDelivered);
        orderStatusesRepository.saveAll(orderStatusesEntities);

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

        SellersEntity sellersEntity = new SellersEntity(rogok.getId());
        sellersRepository.save(sellersEntity);

        PricePatternsEntity pricePatternsEntity = new PricePatternsEntity("magnit", "Магнит",
                null, "", sellersEntity.getId());
        pricePatternsRepository.save(pricePatternsEntity);

        BuyersEntity buyer = new BuyersEntity(mag.getId(), pricePatternsEntity.getId());
        buyersRepository.save(buyer);

        ProductsTypesEntity productsTypesEntity = new ProductsTypesEntity("code", "code");
        productsTypesRepository.save(productsTypesEntity);

        UnitsEntity unitsEntity = new UnitsEntity("code", "code");
        unitsRepository.save(unitsEntity);

        List<ProductsEntity> productsEntities = new ArrayList<>();

        ProductsEntity p1 = new ProductsEntity("1", "Молоко", BigDecimal.valueOf(5000), "",
                unitsEntity.getId(),
                productsTypesEntity.getId(),
                sellersEntity.getId());
        ProductsEntity p2 = new ProductsEntity("2", "Хлеб", BigDecimal.valueOf(230), "",
                unitsEntity.getId(),
                productsTypesEntity.getId(),
                sellersEntity.getId());
        ProductsEntity p3 = new ProductsEntity("3", "Кефир", BigDecimal.valueOf(7600), "",
                unitsEntity.getId(),
                productsTypesEntity.getId(),
                sellersEntity.getId());
        ProductsEntity p4 = new ProductsEntity("4", "Кумыс", BigDecimal.valueOf(130), "",
                unitsEntity.getId(),
                productsTypesEntity.getId(),
                sellersEntity.getId());
        ProductsEntity p5 = new ProductsEntity("5", "Сметана", BigDecimal.valueOf(450), "",
                unitsEntity.getId(),
                productsTypesEntity.getId(),
                sellersEntity.getId());
        ProductsEntity p6 = new ProductsEntity("6", "Сыр", BigDecimal.valueOf(7890), "",
                unitsEntity.getId(),
                productsTypesEntity.getId(),
                sellersEntity.getId());
        ProductsEntity p7 = new ProductsEntity("7", "Ряженка", BigDecimal.valueOf(5660), "",
                unitsEntity.getId(),
                productsTypesEntity.getId(),
                sellersEntity.getId());
        ProductsEntity p8 = new ProductsEntity("8", "Катык", BigDecimal.valueOf(9900), "",
                unitsEntity.getId(),
                productsTypesEntity.getId(),
                sellersEntity.getId());

        productsEntities.add(p1);
        productsEntities.add(p2);
        productsEntities.add(p3);
        productsEntities.add(p4);
        productsEntities.add(p5);
        productsEntities.add(p6);
        productsEntities.add(p7);
        productsEntities.add(p8);
        productsRepository.saveAll(productsEntities);

        List<PricesEntity> pricesEntities = new ArrayList<>();
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(45), p1.getId(), pricePatternsEntity.getId()));
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(34), p2.getId(), pricePatternsEntity.getId()));
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(96), p3.getId(), pricePatternsEntity.getId()));
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(23), p4.getId(), pricePatternsEntity.getId()));
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(98), p5.getId(), pricePatternsEntity.getId()));
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(34), p6.getId(), pricePatternsEntity.getId()));
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(90), p7.getId(), pricePatternsEntity.getId()));
        pricesEntities.add(new PricesEntity(BigDecimal.valueOf(25), p8.getId(), pricePatternsEntity.getId()));
        pricesRepository.saveAll(pricesEntities);

        LogisticsPointsEntity logis = new LogisticsPointsEntity("point", "Точка обмена", "Бейкер стрит 221", mag.getId());
        logisticsPointsRepository.save(logis);

        OrdersEntity o1 = new OrdersEntity("", oNew, buyer, sellersEntity, supply.getId(), pricePatternsEntity.getId(), logis.getId(), logis.getId());
//        OrdersEntity o2 = new OrdersEntity("", oNew, buyer, sellersEntity, supply.getId(), pricePatternsEntity.getId(), logis.getId(), logis.getId());
//        OrdersEntity o3 = new OrdersEntity("", oNew, buyer, sellersEntity, supply.getId(), pricePatternsEntity.getId(), logis.getId(), logis.getId());
//        OrdersEntity o4 = new OrdersEntity("", oNew, buyer, sellersEntity, supply.getId(), pricePatternsEntity.getId(), logis.getId(), logis.getId());

//        ordersRepository.save(o1);
//        ordersRepository.save(o2);
//        ordersRepository.save(o3);
//        ordersRepository.save(o4);

    }

}
